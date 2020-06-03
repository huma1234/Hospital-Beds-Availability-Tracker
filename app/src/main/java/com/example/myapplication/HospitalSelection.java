package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.ArrayList;

public class HospitalSelection extends AppCompatActivity {


    TextView Liaquat;
    TextView Ziauddin;
    TextView AghaKhan;
    TextView Sindh;
    TextView  Patel;
    TextView Jinnah;
    TextView IbneSina;
    TextView Attiya;
    TextView Abbasi;

    TextView LiaquatContactNo;

    TextView ZiauddinContactNo;
    TextView AghaKhanContactNo;
    TextView SindhContactNo;
    TextView  PatelContactNo;
    TextView JinnahContactNo;
    TextView IbneSinaContactNo;
    TextView AttiyaContactNo;
    TextView AbbasiContactNo;

    TextView LiaquatLocation;

    TextView ZiauddinLocation;
    TextView AghaKhanLocation;
    TextView SindhLocation;
    TextView  PatelLocation;
    TextView JinnahLocation;
    TextView IbneSinaLocation;
    TextView AttiyaLocation;
    TextView AbbasiLocation;

    TextView uname;

    String st;
    String st2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_selection);
        uname = findViewById(R.id.uname);
        st = getIntent().getExtras().getString("Value");
        uname.setText(st);
        Liaquat = findViewById(R.id.Liaquat);
        Liaquat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpannableString content1 = new SpannableString(Liaquat.getText().toString());
                content1.setSpan(new UnderlineSpan(), 0, content1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                Liaquat.setText(content1);
                st2 = Liaquat.getText().toString();
                Intent i = new Intent(HospitalSelection.this, BedAvalability.class);
                i.putExtra("Value", st);
                i.putExtra("Value2", st2);

                startActivity(i);
                finish();

            }
        });

        LiaquatContactNo = findViewById(R.id.LiaquatContactNo);

        LiaquatContactNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SpannableString ContactNo1 = new SpannableString(LiaquatContactNo.getText().toString());
                ContactNo1.setSpan(new UnderlineSpan(), 0, ContactNo1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                LiaquatContactNo.setText(ContactNo1);
                Intent inent=new Intent(Intent.ACTION_DIAL);
                inent.setData(Uri.parse("tel:"+LiaquatContactNo.getText().toString()));
                startActivity(inent);
            }
        });

        LiaquatLocation = findViewById(R.id.LiaquatLocation);

        LiaquatLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpannableString Location1 = new SpannableString(LiaquatLocation.getText().toString());
                Location1.setSpan(new UnderlineSpan(), 0, Location1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                LiaquatLocation.setText(Location1);
                Intent inent=new Intent(Intent.ACTION_VIEW);
                inent.setData(Uri.parse("geo:"+LiaquatLocation.getText().toString()));
                startActivity(inent);
            }
        });



        Ziauddin = findViewById(R.id.Ziauddin);


        Ziauddin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpannableString content2 = new SpannableString(Ziauddin.getText().toString());
                content2.setSpan(new UnderlineSpan(), 0, content2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                Ziauddin.setText(content2);
                st2 = Ziauddin.getText().toString();
                Intent i = new Intent(HospitalSelection.this, BedAvalability.class);


                i.putExtra("Value", st);
                i.putExtra("Value2", st2);

                startActivity(i);
                finish();

            }
        });

        ZiauddinContactNo = findViewById(R.id.ZiauddinContactNo);

        ZiauddinContactNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpannableString ContactNo2 = new SpannableString(ZiauddinContactNo.getText().toString());
                ContactNo2.setSpan(new UnderlineSpan(), 0, ContactNo2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                ZiauddinContactNo.setText(ContactNo2);
                Intent inent=new Intent(Intent.ACTION_DIAL);
                inent.setData(Uri.parse("tel:"+ZiauddinContactNo.getText().toString()));
                startActivity(inent);
            }
        });

        ZiauddinLocation = findViewById(R.id.ZiauddinLocation);

        ZiauddinLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpannableString Location2 = new SpannableString(ZiauddinLocation.getText().toString());
                Location2.setSpan(new UnderlineSpan(), 0, Location2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                ZiauddinLocation.setText(Location2);

            }
        });

        AghaKhan = findViewById(R.id.AghaKhan);


        AghaKhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpannableString content3 = new SpannableString(AghaKhan.getText().toString());
                content3.setSpan(new UnderlineSpan(), 0, content3.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                AghaKhan.setText(content3);
                st2 = AghaKhan.getText().toString();
                Intent i = new Intent(HospitalSelection.this, BedAvalability.class);


                i.putExtra("Value", st);
                i.putExtra("Value2", st2);

                startActivity(i);
                finish();

            }
        });

        AghaKhanContactNo = findViewById(R.id.AghaKhanContactNo);


        AghaKhanContactNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SpannableString ContactNo3 = new SpannableString(AghaKhanContactNo.getText().toString());
                ContactNo3.setSpan(new UnderlineSpan(), 0, ContactNo3.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                AghaKhanContactNo.setText(ContactNo3);
                Intent inent=new Intent(Intent.ACTION_DIAL);
                inent.setData(Uri.parse("tel:"+AghaKhanContactNo.getText().toString()));
                startActivity(inent);

            }
        });

        AghaKhanLocation = findViewById(R.id.AghaKhanLocation);


        AghaKhanLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpannableString Location3 = new SpannableString(AghaKhanLocation.getText().toString());
                Location3.setSpan(new UnderlineSpan(), 0, Location3.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                AghaKhanLocation.setText(Location3);

            }
        });


        Sindh = findViewById(R.id.Sindh);

        Sindh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SpannableString content = new SpannableString(Sindh.getText().toString());
                content.setSpan(new UnderlineSpan(), 0, content.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                Sindh.setText(content);
                st2 = Sindh.getText().toString();
                Intent i = new Intent(HospitalSelection.this, BedAvalability.class);


                i.putExtra("Value", st);
                i.putExtra("Value2", st2);

                startActivity(i);
                finish();

            }
        });
        SindhContactNo = findViewById(R.id.SindhContactNo);

        SindhContactNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpannableString ContactNo4 = new SpannableString(SindhContactNo.getText().toString());
                ContactNo4.setSpan(new UnderlineSpan(), 0, ContactNo4.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                SindhContactNo.setText(ContactNo4);
                Intent inent=new Intent(Intent.ACTION_DIAL);
                inent.setData(Uri.parse("tel:"+SindhContactNo.getText().toString()));
                startActivity(inent);

            }
        });

        SindhLocation = findViewById(R.id.SindhLocation);

        SindhLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpannableString Location4 = new SpannableString(SindhLocation.getText().toString());
                Location4.setSpan(new UnderlineSpan(), 0,Location4.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                SindhLocation.setText(Location4);

            }
        });


        Patel = findViewById(R.id.Patel);

        Patel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpannableString content4 = new SpannableString(Patel.getText().toString());
                content4.setSpan(new UnderlineSpan(), 0, content4.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                Patel.setText(content4);
                st2 = Patel.getText().toString();
                Intent i = new Intent(HospitalSelection.this, BedAvalability.class);


                i.putExtra("Value", st);
                i.putExtra("Value2", st2);

                startActivity(i);
                finish();

            }
        });

        PatelContactNo = findViewById(R.id.PatelContactNo);

        PatelContactNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpannableString ContactNo5 = new SpannableString(PatelContactNo.getText().toString());
                ContactNo5.setSpan(new UnderlineSpan(), 0, ContactNo5.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                PatelContactNo.setText(ContactNo5);
                Intent inent=new Intent(Intent.ACTION_DIAL);
                inent.setData(Uri.parse("tel:"+PatelContactNo.getText().toString()));
                startActivity(inent);

            }
        });

        PatelLocation = findViewById(R.id.PatelLocation);

        PatelLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SpannableString Location5 = new SpannableString(PatelLocation.getText().toString());
                Location5.setSpan(new UnderlineSpan(), 0, Location5.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                PatelLocation.setText(Location5);
            }
        });

        Jinnah = findViewById(R.id.Jinnah);

        Jinnah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpannableString content5 = new SpannableString(Jinnah.getText().toString());
                content5.setSpan(new UnderlineSpan(), 0, content5.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                Jinnah.setText(content5);
                st2 = Jinnah.getText().toString();
                Intent i = new Intent(HospitalSelection.this, BedAvalability.class);


                i.putExtra("Value", st);
                i.putExtra("Value2", st2);

                startActivity(i);
                finish();

            }
        });

        JinnahContactNo = findViewById(R.id.JinnahContactNo);

        JinnahContactNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SpannableString ContactNo6 = new SpannableString(JinnahContactNo.getText().toString());
                ContactNo6.setSpan(new UnderlineSpan(), 0, ContactNo6.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                JinnahContactNo.setText(ContactNo6);
                Intent inent = new Intent(Intent.ACTION_DIAL);
                inent.setData(Uri.parse("tel:" + JinnahContactNo.getText().toString()));
                startActivity(inent);
            }
        });


        JinnahLocation = findViewById(R.id.JinnahLocation);

        JinnahLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SpannableString Location6 = new SpannableString(JinnahLocation.getText().toString());
                Location6.setSpan(new UnderlineSpan(), 0, Location6.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                JinnahLocation.setText(Location6);
            }
        });

        IbneSina = findViewById(R.id.IbneSina);

        IbneSina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpannableString Location6 = new SpannableString(JinnahLocation.getText().toString());
                Location6.setSpan(new UnderlineSpan(), 0, Location6.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                JinnahLocation.setText(Location6);
                st2 = IbneSina.getText().toString();
                Intent i = new Intent(HospitalSelection.this, BedAvalability.class);


                i.putExtra("Value", st);
                i.putExtra("Value2", st2);

                startActivity(i);
                finish();

            }
        });

        IbneSinaContactNo = findViewById(R.id.IbneSinaContactNo);

        IbneSinaContactNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SpannableString ContactNo7 = new SpannableString(IbneSinaContactNo.getText().toString());
                ContactNo7.setSpan(new UnderlineSpan(), 0, ContactNo7.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                IbneSinaContactNo.setText(ContactNo7);
                Intent inent=new Intent(Intent.ACTION_DIAL);
                inent.setData(Uri.parse("tel:"+IbneSinaContactNo.getText().toString()));
                startActivity(inent);
            }
        });

        IbneSinaLocation = findViewById(R.id.IbneSinaLocation);

        IbneSinaLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpannableString Location7 = new SpannableString(IbneSinaLocation.getText().toString());
                Location7.setSpan(new UnderlineSpan(), 0, Location7.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                IbneSinaLocation.setText(Location7);
            }
        });

        Attiya = findViewById(R.id.Atiya);

        Attiya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpannableString content7 = new SpannableString(Attiya.getText().toString());
                content7.setSpan(new UnderlineSpan(), 0, content7.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                Attiya.setText(content7);
                st2 = Attiya.getText().toString();
                Intent i = new Intent(HospitalSelection.this, BedAvalability.class);


                i.putExtra("Value", st);
                i.putExtra("Value2", st2);

                startActivity(i);
                finish();

            }
        });
        AttiyaContactNo = findViewById(R.id.AtiyaContactNo);

        AttiyaContactNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpannableString ContactNo8 = new SpannableString(AttiyaContactNo.getText().toString());
                ContactNo8.setSpan(new UnderlineSpan(), 0, ContactNo8.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                AttiyaContactNo.setText(ContactNo8);
                Intent inent=new Intent(Intent.ACTION_DIAL);
                inent.setData(Uri.parse("tel:"+AttiyaContactNo.getText().toString()));
                startActivity(inent);
            }
        });

        AttiyaLocation = findViewById(R.id.AtiyaLocation);

        AttiyaLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpannableString Location8 = new SpannableString(AttiyaLocation.getText().toString());
                Location8.setSpan(new UnderlineSpan(), 0, Location8.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                AttiyaLocation.setText(Location8);
            }
        });


        Abbasi = findViewById(R.id.Abbasi);

        Abbasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpannableString content8 = new SpannableString(Abbasi.getText().toString());
                content8.setSpan(new UnderlineSpan(), 0, content8.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                Abbasi.setText(content8);
                st2 = Abbasi.getText().toString();
                Intent i = new Intent(HospitalSelection.this, BedAvalability.class);


                i.putExtra("Value", st);
                i.putExtra("Value2", st2);

                startActivity(i);
                finish();

            }
        });

        AbbasiContactNo = findViewById(R.id.AbbasiContactNo);

        AbbasiContactNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpannableString ContactNo9 = new SpannableString(AbbasiContactNo.getText().toString());
                ContactNo9.setSpan(new UnderlineSpan(), 0, ContactNo9.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                AbbasiContactNo.setText(ContactNo9);
                Intent inent = new Intent(Intent.ACTION_DIAL);
                inent.setData(Uri.parse("tel:" + Abbasi.getText().toString()));
                startActivity(inent);
                        }


        });


        AbbasiLocation = findViewById(R.id.AbbasiLocation);
        AbbasiLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SpannableString Location9 = new SpannableString(AbbasiLocation.getText().toString());
                Location9.setSpan(new UnderlineSpan(), 0, Location9.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                AbbasiLocation.setText(Location9);
            }


        });
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
