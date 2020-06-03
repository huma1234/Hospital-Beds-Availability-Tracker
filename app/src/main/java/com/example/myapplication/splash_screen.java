package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class splash_screen extends AppCompatActivity {
Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(preferneceUtils.getIsLogedIn(splash_screen.this)!=null){
                    if(preferneceUtils.getIsLogedIn(splash_screen.this).equals("true")){
                        Intent mainIntent = new Intent(splash_screen.this, AppOptions.class);
                        mainIntent.putExtra("Value",preferneceUtils.getUserName(splash_screen.this));
                        startActivity(mainIntent);
                }
                }
                else { Toast.makeText(splash_screen.this,"error",Toast.LENGTH_LONG);
                Intent mainIntent = new Intent(splash_screen.this, MainActivity.class);
                startActivity(mainIntent); }
            }
        },1000);
            }
    }
