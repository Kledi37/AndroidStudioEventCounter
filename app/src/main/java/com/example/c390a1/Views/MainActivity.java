package com.example.c390a1.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.c390a1.Controller.SharedPreferenceHelper;
import com.example.c390a1.R;

public class MainActivity extends AppCompatActivity {
public SharedPreferenceHelper sharedPreferenceHelper;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button buttonCount = (Button) findViewById(R.id.buttonCount);
        Button EventA = (Button) findViewById(R.id.buttonEventA);
        Button EventB = (Button) findViewById(R.id.buttonEventB);
        Button EventC = (Button) findViewById(R.id.buttonEventC);
        Button buttonSettings = (Button) findViewById(R.id.buttonSettings);

        TextView textViewCount = findViewById(R.id.textView2);


        sharedPreferenceHelper = new SharedPreferenceHelper(MainActivity.this);


        EventA.setText(sharedPreferenceHelper.getEventName1());
        EventB.setText(sharedPreferenceHelper.getEventName2());
        EventC.setText(sharedPreferenceHelper.getEventName3());
        textViewCount.setText(sharedPreferenceHelper.returnCount());


        buttonCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DataActivity.class));
            }
        });



        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SetActivity.class));
            }
        });



        EventA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                sharedPreferenceHelper.addToCountList("1");
                sharedPreferenceHelper.incrementCount();
                textViewCount.setText(sharedPreferenceHelper.returnCount());
                System.out.println(sharedPreferenceHelper.getCountList());


            }
        });

        EventB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                sharedPreferenceHelper.addToCountList("2");
                sharedPreferenceHelper.incrementCount();
                textViewCount.setText(sharedPreferenceHelper.returnCount());
                System.out.println(sharedPreferenceHelper.getCountList());

            }
        });

        EventC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                sharedPreferenceHelper.addToCountList("3");
                sharedPreferenceHelper.incrementCount();
                textViewCount.setText(sharedPreferenceHelper.returnCount());
                System.out.println(sharedPreferenceHelper.getCountList());
            }
        });
    }
}