package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.prefs.PreferenceChangeEvent;

public class AppOptions extends AppCompatActivity {

    TextView uname;
    String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_options);
        uname=findViewById(R.id.uname);
        st=getIntent().getExtras().getString("Value");
        uname.setText(st);
        preferneceUtils.saveIsLogedIn("true",AppOptions.this);
        preferneceUtils.saveUserName(st,AppOptions.this);
    }

    public void showECG(View view)
    {
        Intent i=new Intent(AppOptions.this,ECGgenerator.class);

        i.putExtra("Value",st);
        startActivity(i);
        finish();
    }

    public void selectHospitals(View view)
    {
        Intent i=new Intent(AppOptions.this,select_hospital.class);

        i.putExtra("Value",st);
        startActivity(i);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
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
            preferneceUtils.saveIsLogedIn(null,AppOptions.this);
            preferneceUtils.saveUserName(null,AppOptions.this);

            return true;
        }

        else{
            return super.onOptionsItemSelected(item);
        }


    }
}
