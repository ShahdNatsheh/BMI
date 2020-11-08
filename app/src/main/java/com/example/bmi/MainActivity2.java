package com.example.bmi;


import android.content.SharedPreferences;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {

    private int seconds = 0;
    private boolean running;
    private TextView txt1;
    private TextView txt2;
    private Button set;
    private Button start;
    private Button reset;
    private Button stop;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt1 = findViewById(R.id.txt);
        txt2 = findViewById(R.id.txtView);
        set=findViewById(R.id.set);
        start=findViewById(R.id.btnStart);
        reset=findViewById(R.id.btnReset);
        stop=findViewById(R.id.btnStop);


        runTimer();
        checkSavedInstance(savedInstanceState);

    }

    private void checkSavedInstance(Bundle savedInstanceState) {
        if(savedInstanceState !=null){
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("seconds", seconds);
        bundle.putBoolean("running", running);
    }
    public void onClickSet(View view) {
        String input = txt1.getText().toString();

        seconds=Integer.parseInt(input) * 6000;


        txt1.setText("");
    }


    public void onClickStart(View view) {

        running = true;
    }

    public void onClickStop(View view) {
        running = false;
    }

    public void onClickReset(View view) {
        seconds = 0;
        running = false;

    }
    private void runTimer(){

        final TextView txtView = (TextView) findViewById(R.id.txtView);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {

                int hours = (int) (seconds / 100) / 3600;
                int minutes = (int) ((seconds / 100) % 3600) / 60;
                int snds = (int) (seconds / 100) % 60;

                String time = String.format(Locale.getDefault(),
                        "%d:%02d:%02d", hours, minutes, snds);
                txt2.setText(time);

                if(running) {
                    if (seconds < 0) {
                        seconds = 0;
                        running=false;
                    } else {
                        --seconds;
                    }
                }
                handler.postDelayed(this, 1);
            }

        });
    }



}