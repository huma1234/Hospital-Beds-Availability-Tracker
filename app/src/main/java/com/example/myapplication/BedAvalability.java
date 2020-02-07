package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bed_avalability);
        uname=findViewById(R.id.uname);
        HospitalName=findViewById(R.id.HospitalName);
        st=getIntent().getExtras().getString("Value");
       st2=getIntent().getExtras().getString("Value2");
        uname.setText(st);
        HospitalName.setText(st2);
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

