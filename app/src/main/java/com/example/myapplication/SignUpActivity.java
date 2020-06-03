package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.UnsupportedEncodingException;

public class SignUpActivity extends AppCompatActivity {
    DatabaseHelper db;

    private EditText fname, uname, email, cpassword, password;
    private RadioButton malebtn,femalebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void Registered(View view) throws UnsupportedEncodingException {
        db = new DatabaseHelper(this);

        uname = (EditText) findViewById(R.id.uname);
        fname = (EditText) findViewById(R.id.fname);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        cpassword = (EditText) findViewById(R.id.cpassword);
       malebtn=(RadioButton)findViewById(R.id.malebtn);
        femalebtn=(RadioButton)findViewById(R.id.femalebtn);
        String user = uname.getText().toString().trim();
        String pwd = password.getText().toString().trim();
        String cnf_pwd = cpassword.getText().toString().trim();
        boolean checku,checkp=false;
        boolean excep=false;
/*if(malebtn.isSelected()==false || femalebtn.isSelected()==false)
{
    malebtn.setError("Select Gender");
    excep=true;
}*/
if(uname.length()==0)
{
    excep=true;
    uname.setError("This Field is required");
}
        if(fname.length()==0)
        {
            excep=true;
            fname.setError("This Field is required");
        }
        if(email.length()==0)
        {
            excep=true;
            email.setError("This Field is required");
        }
        if(password.length()==0)
        {
            excep=true;
            password.setError("This Field is required");
        }
        if(cpassword.length()==0)
        {
            excep=true;
            cpassword.setError("This Field is required");
        }


        if (pwd.equals(cnf_pwd)) {

        }else{
            cpassword.setError("Password is not matching");
            cpassword.setText(null);

            excep=true;
        }
        checku = db.checkUsername(user);
        checkp=db.checkPassword(pwd)         ;
        if (checku == true) {

                Toast.makeText(SignUpActivity.this, "Already Registered with this username", Toast.LENGTH_SHORT).show();
                uname.setText(null);
                excep = true;


            }
            if (checkp == true) {
                Toast.makeText(SignUpActivity.this, "Already Registered with this password", Toast.LENGTH_SHORT).show();
                password.setText(null);
                excep = true;


            }


if(excep==false)
{
                long val = db.addUser(user, pwd);
                if (val > 0) {
                    Toast.makeText(SignUpActivity.this, "You have registered", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                } else {
                    Toast.makeText(SignUpActivity.this, "Registeration Error", Toast.LENGTH_SHORT).show();
                    uname.setText(null);
                    fname.setText(null);
                    email.setText(null);
                    password.setText(null);
                    cpassword.setText(null);
                }
            }

        }


    }




