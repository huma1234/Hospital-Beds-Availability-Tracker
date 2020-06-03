package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {
    private EditText  uname, password;
    private CheckBox pwdcheck;
    DatabaseHelper db;
    String st;
    boolean excep=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button loggedIn =(Button)findViewById(R.id.login);
       pwdcheck = (CheckBox) findViewById(R.id.pwdcheck);
       password = (EditText) findViewById(R.id.password);
        pwdcheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    // show password
                 // password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {// hide password
                   // password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                password.setInputType((InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD));
                }
            }
        });
        loggedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = new DatabaseHelper(MainActivity.this);
                uname = (EditText) findViewById(R.id.username);

                password = (EditText) findViewById(R.id.password);
                String user = uname.getText().toString().trim();
                String pwd = password.getText().toString().trim();
                if (uname.length() == 0) {
                    uname.setError("This field is required");
                    uname.setText(null);
                    excep = true;

                }
                if (password.length() == 0) {
                    password.setError("This field is required");
                    password.setText(null);
                    excep = true;
                }

                Boolean res = db.checkUser(user, pwd);

                if (res == true) {
                    Toast.makeText(MainActivity.this, "Logged as " + user, Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(MainActivity.this,AppOptions.class);
                    st=uname.getText().toString();
                    i.putExtra("Value",st);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                    uname.setText(null);
                    password.setText(null);
                }

            }
        });
    }
    public void gotoregister(View view) {
        startActivity(new Intent(getApplicationContext(),SignUpActivity.class));
    }
    }







