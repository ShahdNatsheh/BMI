package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {
    Spinner spr;
    public static final String NAME ="NAME";
    public static final String HEIGHT ="HEIGHT";
    public static final String WEIGHT ="WEIGHT";
    public static final String GENDER ="GENDER";
    public static final String FLAG ="FLAG";




    public  EditText edtText;
    public  EditText edtText1;
    public  EditText edtText2;
    public  TextView bmi3;
    public Button save;
    public Button active2;
     private SharedPreferences prefs;
     private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupView();
        setupSharedPrefs();
        checkPrefs();
    }

    private void setupView() {
        spr=(Spinner) findViewById(R.id.sp);
        List<String> list=new ArrayList<>();
        list.add("Female");
        list.add("Male");
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spr.setAdapter(adapter);
        edtText=findViewById(R.id.name);
        edtText1=findViewById(R.id.height);
        edtText2=findViewById(R.id.weight);
        bmi3=findViewById(R.id.bmi);
        save=findViewById(R.id.btnSave);
        active2=findViewById(R.id.button2);
        active2.setVisibility(View.INVISIBLE);

    }

    private void setupSharedPrefs() {
        prefs= PreferenceManager.getDefaultSharedPreferences(this);
        editor=prefs.edit();

    }

    private void checkPrefs() {
        boolean flag =prefs.getBoolean(FLAG,false);
        if(flag){
            String name=prefs.getString(NAME,"");
            String height=prefs.getString(HEIGHT,"");
            String weight=prefs.getString(WEIGHT,"");
            String gender=prefs.getString(GENDER,"");
            edtText.setText(name);
            edtText1.setText(height);
            edtText2.setText(weight);
            save.setClickable(true);


        }



    }

    public void btnSave_onClick(View view) {
         String name=edtText.getText().toString();
        String gender=edtText.getText().toString();
        String height=edtText1.getText().toString() ;
        String weight=edtText2.getText().toString() ;
        double h=Double.parseDouble(height)/100;
        double w=Double.parseDouble(weight);
         double bmi=(w / (h*h));


        String res="";
        res = " " + bmi;

        bmi3.setText(res);
        active2.setVisibility(View.VISIBLE);
        editor.putString(NAME,name);
        editor.putString(HEIGHT,height);
        editor.putString(WEIGHT,weight);
        editor.putString(GENDER,gender);
        editor.commit();
        active2.setVisibility(View.VISIBLE);
    }

    public void A_onClick(View view) {
        openActivity2();
    }
    public void openActivity2(){
        Intent intent =new Intent(this,MainActivity2.class);
        startActivity(intent);
    }
}
