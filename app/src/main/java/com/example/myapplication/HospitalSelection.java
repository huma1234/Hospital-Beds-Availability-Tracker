package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class HospitalSelection extends AppCompatActivity {
   TextView uname;
   Spinner select;
   String st;
   String st2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_selection);
        uname=findViewById(R.id.uname);
      st=getIntent().getExtras().getString("Value");
      uname.setText(st);
    }

    public void SelectHospitalAction(View view)
    {
       // startActivity(new Intent(getApplicationContext(),BedAvalability.class));
        select=findViewById(R.id.selectHospitals);
        st2=select.getSelectedItem().toString();


        Intent i=new Intent(HospitalSelection.this,BedAvalability.class);


        i.putExtra("Value",st);
        i.putExtra("Value2",st2);

        startActivity(i);
        finish();
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
