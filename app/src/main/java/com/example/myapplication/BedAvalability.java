package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class BedAvalability extends AppCompatActivity {
    ImageView iv;
    LinearLayout linear;
    String st;
    String st2;
    TextView uname;
    TextView HospitalName;
    ImageView imageB1;
    ImageView imageB2;
    ImageView imageB3;
    ImageView imageB4;
    ImageView imageB5;
    CheckBox bedb1chk;
    String RefreshToken;
    String ACCESS_TOKEN =  "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1ODI5NDUxMTEsImlhdCI6MTU4MjkzNzkxMSwidXNyIjoiQWJkdWxSZWhtYW4ifQ.YYUAmAwqsPWAvWW0lyH0SqUsGRpninqIiTUSiZVW9LI";
    String UserName = "Mani";
    String PassWord = "password";
    String value;
    RequestQueue mRequestQueue;
    RequestQueue queue;
    StringRequest mStringRequest;
    //String url = "https://api.thinger.io/v2/users/AbdulRehman/devices/ECG/ECG";
    String tokenUrl = "https://api.thinger.io/oauth/token";

    String url = "https://api.thinger.io/v2/users/AbdulRehman/devices/ECG/BED";

    //String url="https://api.myjson.com/bins/j5f6b";
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bed_avalability);
        // fetchBlogs("${your original access token here}");
        bedb1chk=findViewById(R.id.bedb1chk) ;
        HospitalName=findViewById(R.id.HospitalName);
        st=getIntent().getExtras().getString("Value");
        st2=getIntent().getExtras().getString("Value2");
        HospitalName.setText(st2);
        queue = Volley.newRequestQueue(getApplicationContext());
        getAccessAndRefreshToken();



        final Runnable runnableCode = new Runnable() {
            @Override
            public void run() {
                // Do something here on the main thread
                Log.d("Handlers", "Called on main thread");

                getdatafromApi();
                // Repeat this the same runnable code block again another 2 seconds
                // 'this' is referencing the Runnable object
                handler.postDelayed(this, 10000);
            }
        };
        handler.post(runnableCode);





    }

    void getAccessAndRefreshToken() {
        mRequestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest AccessRefreshTokenRequest = new JsonObjectRequest(Request.Method.POST, tokenUrl, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try {


                            ACCESS_TOKEN = (String)response.get("access_token");
                            RefreshToken=(String)response.get("refresh_token");

                        } catch (JSONException e) {
                            // this will never happen but if so, show error to user.
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // show error to user. refresh failed.
                Log.e("Error on getting token ", new String(error.networkResponse.data));
            }
        })
        {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                //  params.put("Content-Type", "application/x-www-form-urlencoded");


                return params;

            }

            //Pass Your Parameters here
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();

                params.put("UserName", UserName);
                params.put("PassWord", PassWord);
                return params;
            }
        };


        queue.add( AccessRefreshTokenRequest);}

    public void getdatafromApi()
    {
        mRequestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        Log.e("Rest Response", response.toString());
                        try {
                            value = response.get("out").toString();
                            if(value.equals("1")){
                                bedb1chk.setText("Bed is Available");
                                bedb1chk.setChecked(true);
                            }
                            else
                            if(value.equals("0"))
                            {
                                bedb1chk.setText("Bed is not Available");
                                bedb1chk.setChecked(false );
                            }
                            Log.e("Value", value);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                        Toast.makeText(getApplicationContext(), "Response :" + response.toString(), Toast.LENGTH_LONG).show();//display the response on screen



                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Rest Response", error.toString());
                if (error.networkResponse.statusCode == 401) {
                    refreshAccessToken();

                }
            }
        }
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                //   params.put("Content-Type", "application/json;");
                params.put("Authorization", "Bearer " + ACCESS_TOKEN);

                return params;

            }

            //Pass Your Parameters here
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();

                params.put("UserName", UserName);
                params.put("PassWord", PassWord);
                return params;
            }
        };



        mRequestQueue.add(objectRequest);



    }


    void refreshAccessToken() {
        JSONObject params = new JSONObject();
        try {
            // params.put("client_id", "${your client id here}");
            //  params.put("client_secret", "${your client secret here}");
            // params.put("refresh_token", "${your refresh token here}");
            params.put("refresh_token",RefreshToken);
            params.put("grant_type",RefreshToken);
            //    params.put("Content-Type", "application/x-www-form-urlencoded");
        } catch (JSONException ignored) {
            // never thrown in this case
        }

        JsonObjectRequest refreshTokenRequest = new JsonObjectRequest(Request.Method.POST, tokenUrl, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    ACCESS_TOKEN = (String)response.get("access_token");

                    getdatafromApi();

                } catch (JSONException e) {
                    // this will never happen but if so, show error to user.
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // show error to user. refresh failed.
                Log.e("Error on token refresh", new String(error.networkResponse.data));

            }
        });
        queue.add(refreshTokenRequest);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.commonmenus, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        if(id==R.id.logout) {

            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            preferneceUtils.saveIsLogedIn(null,BedAvalability.this);
            preferneceUtils.saveUserName(null,BedAvalability.this);
            return true;
        }

        else{
            return super.onOptionsItemSelected(item);
        }


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(BedAvalability.this, AppOptions.class);
        i.putExtra("Value",getIntent().getExtras().getString("Value"));
        startActivity(i);
    }
}

