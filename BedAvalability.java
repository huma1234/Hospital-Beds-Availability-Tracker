package com.example.myapplication;

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

    String ACCESS_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1ODE5ODgzMDgsImlhdCI6MTU4MTk4MTEwOCwidXNyIjoiQWJkdWxSZWhtYW4ifQ.Cvi5T9hD8hQawb3BYFqEPE-3KHI4PT9DUfihdPmZdr4";  //String PassWord="mani1823";
    String UserName = "Mani";
    String PassWord = "password";
    String value;
    RequestQueue mRequestQueue;
    StringRequest mStringRequest;
    //String url = "https://api.thinger.io/v2/users/AbdulRehman/devices/ECG/ECG";

    String url = "https://api.thinger.io/v2/users/AbdulRehman/devices/ECG/BED";
    //String url="https://api.myjson.com/bins/j5f6b";
    Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bed_avalability);
        uname=findViewById(R.id.uname);
        bedb1chk=findViewById(R.id.bedb1chk) ;
        HospitalName=findViewById(R.id.HospitalName);
        st=getIntent().getExtras().getString("Value");
       st2=getIntent().getExtras().getString("Value2");
        uname.setText(st);
        HospitalName.setText(st2);
        Runnable runnableCode = new Runnable() {
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

            }
        }
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json;");
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
            return true;
        }

        else{
            return super.onOptionsItemSelected(item);
        }


    }
    }

