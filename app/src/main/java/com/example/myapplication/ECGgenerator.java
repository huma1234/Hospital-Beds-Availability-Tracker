package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;

import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ECGgenerator extends AppCompatActivity {

    TextView uname;
    String st;
    int x_prev = -1;
    private LineChart mchart;
    String ACCESS_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1ODI5Mzc5MDQsImlhdCI6MTU4MjkzMDcwNCwidXNyIjoiQWJkdWxSZWhtYW4ifQ.O_XXK5Yz8lzlAtjVjfPIyUVCkmueDAQTae2t5U5zSyg";
    String UserName = "Mani";
    String PassWord = "password";

    int value;
    RequestQueue mRequestQueue;
    StringRequest mStringRequest;
    String url = "https://api.thinger.io/v2/users/AbdulRehman/devices/ECG/ECG";


    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ecg_generator);
        uname = findViewById(R.id.uname);
        st = getIntent().getExtras().getString("Value");
        uname.setText(st);
        mchart = (LineChart) findViewById(R.id.Linechart);
        mchart.setDragEnabled(true);
        mchart.setScaleEnabled(true);
        mchart.setTouchEnabled(true);
        final Runnable runnableCode = new Runnable() {
            @Override
            public void run() {
                // Do something here on the main thread
                Log.d("Handlers", "Called on main thread");

               drawECGgraph();

                // Repeat this the same runnable code block again another 2 seconds
                // 'this' is referencing the Runnable object
                handler.postDelayed(this, 10000);
            }
        };
        handler.post(runnableCode);


    }


    public void drawECGgraph() {

        mRequestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        Log.e("Rest Response", response.toString());
                        try {
                            value= ((int) response.get("out"));
                           // value =  response.getInt("out");
                            System.out.print("this is value"+value);
                            ArrayList<Entry> yValues = new ArrayList<>();
                            if (x_prev == -1) {
                                yValues.add(new Entry(0, value));
                                x_prev=0;
                                System.out.println("yes");
                            } else {
                                yValues.add(new Entry(x_prev + 1, value));
                                System.out.println("yes2");
                            }


                            LineDataSet set1 = new LineDataSet(yValues, "Data set 1");

                            set1.setFillAlpha(1250);
                            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
                            dataSets.add(set1);
                            LineData lineData = new LineData(dataSets);

                            mchart.setData(lineData);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

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
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(ECGgenerator.this, AppOptions.class);
        i.putExtra("Value",getIntent().getExtras().getString("Value"));
        startActivity(i);
    }
}
