package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class select_hospital extends AppCompatActivity {
    ArrayList<JSONObject> elements;
    TextView name, num , loc;
    String[] contactNumber1 = {"(021) 111 456 456","(021) 36648237","(021) 111 911 911",
            "+9221-111-456-456","(021) 111 174 174","(021) 99260400","(021) 34402207","(021) 99201300","(021) 34992706"};
    String[] hospitalsName ={"Liaquat National Hospital","Ziauddin Hospital","Agha Khan Hospital","Sindh Hospital","Patel Hospital"
            ,"Abbasi Shaheed Hospital","Atiya Hospital","Jinnah Hospital","Ibne Sina Hospital"};
    String[] location ={"National Stadium Rd, Liaquat National Hospital, Karachi",
            "Block-B North Nazimabad Town, Karachi, Karachi City, Sindh 74700",
            " National Stadium Rd, Aga Khan University Hospital, Karachi, Sindh 74800",
            " Sharifabad Block 1 Gulberg Town, Karachi, Karachi City, Sindh"
            ," ST-18، Block 4 Gulshan-e-Iqbal, Karachi, Karachi City, Sindh 75300",
            "Tabish Dehlavi Road, Block 3 Nazimabad, Karachi, Karachi City, Sindh 74600",
            " Darakhshan Society Darakhshan Cooperative Housing Society Kala Board, Karachi, Karachi City, Sindh",
            "JPMC Hospital Rd, Karachi Cantonment Karachi, Karachi City, Sindh",
            "St-22، B University Rd, Block 6 Gulshan-e-Iqbal, Karachi, Karachi City, Sindh"};
    int[] images = {R.drawable.liaquat,R.drawable.ziauddin,R.drawable.aghakhan,R.drawable.sindh,R.drawable.patel,R.drawable.abbasi,R.drawable.atiya,
        R.drawable.jinnah,R.drawable.ibnesina};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_hospital);
        ListView lV = (ListView)findViewById(R.id.hospitalList);
        elements = new ArrayList<>();
        for (int i=0;i<hospitalsName.length;i++){
            JSONObject jOb = new JSONObject();
            try {
                jOb.put("hospitalName",hospitalsName[i]);
                jOb.put("contactNumber",contactNumber1[i]);
                jOb.put("address",location[i]);
                jOb.put("image",images[i]);
                elements.add(jOb);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        listViewAdapter adapter = new listViewAdapter(elements);
        lV.setAdapter(adapter);
    }
    public class listViewAdapter extends BaseAdapter {
        ArrayList<JSONObject> hospitals;
        listViewAdapter(ArrayList<JSONObject> hospital){
            this.hospitals = hospital;
        }
        @Override
        public int getCount() {
            return  this.hospitals.size();
        }

        @Override
        public Object getItem(int position) {
            return this.hospitals.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.single_element_view,null);
             name = (TextView)convertView.findViewById(R.id.hospitalName);
             num = (TextView)convertView.findViewById(R.id.hospitalContactNum);
             loc = (TextView)convertView.findViewById(R.id.hospitalLocation);
            CircleImageView imageView = (CircleImageView) convertView.findViewById(R.id.image) ;
            JSONObject hospital = (JSONObject)getItem(position);
            try {
                name.setText(hospital.getString("hospitalName"));
                num.setText(hospital.getString("contactNumber"));
                loc.setText(hospital.getString("address"));
                imageView.setImageResource(hospital.getInt("image"));
                name.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try{
                        JSONObject hospital = (JSONObject)getItem(position);
                        SpannableString content1 = new SpannableString(hospital.getString("hospitalName"));
                        content1.setSpan(new UnderlineSpan(), 0, content1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        name.setText(content1);
                        Intent i = new Intent(select_hospital.this, BedAvalability.class);
                        i.putExtra("Value", getIntent().getExtras().getString("Value"));
                        i.putExtra("Value2",hospital.getString("hospitalName"));
                        startActivity(i);
                        finish();}
                        catch (JSONException je){
                            je.printStackTrace();
                        }
                    }
                });
                num.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try{
                        JSONObject hospital = (JSONObject)getItem(position);
                        SpannableString ContactNo1 = new SpannableString(hospital.getString("contactNumber"));
                        ContactNo1.setSpan(new UnderlineSpan(), 0, ContactNo1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        num.setText(ContactNo1);
                        Intent inent=new Intent(Intent.ACTION_DIAL);
                        inent.setData(Uri.parse("tel:"+hospital.getString("contactNumber")));
                        startActivity(inent);}
                        catch (JSONException je){
                            je.printStackTrace();
                        }
                    }
                });
                loc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try{
                        JSONObject hospital = (JSONObject)getItem(position);
                        SpannableString Location1 = new SpannableString(hospital.getString("address"));
                        Location1.setSpan(new UnderlineSpan(), 0, Location1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        loc.setText(Location1);
                        Intent inent=new Intent(Intent.ACTION_VIEW);
                        inent.setData(Uri.parse("geo:"+hospital.getString("address")));
                        startActivity(inent);}
                        catch (JSONException je){
                            je.printStackTrace();
                        }
                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return convertView;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(select_hospital.this, AppOptions.class);
        i.putExtra("Value",getIntent().getExtras().getString("Value"));
        startActivity(i);
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
            preferneceUtils.saveIsLogedIn(null,select_hospital.this);
            preferneceUtils.saveUserName(null,select_hospital.this);
            return true;
        }

        else{
            return super.onOptionsItemSelected(item);
        }

    }
}
