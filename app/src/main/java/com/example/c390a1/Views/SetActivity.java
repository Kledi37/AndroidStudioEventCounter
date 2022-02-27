package com.example.c390a1.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.c390a1.Controller.SharedPreferenceHelper;
import com.example.c390a1.R;

public class SetActivity extends AppCompatActivity {
    public SharedPreferenceHelper sharedPreferenceHelper;

    EditText counter1, counter2, counter3, maxCounter;
    Button save, reset;
    String c1, c2, c3;
    String maxCountString;
    int maxCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);

        sharedPreferenceHelper = new SharedPreferenceHelper(SetActivity.this);

        counter1=findViewById(R.id.editTextC1);
        counter2=findViewById(R.id.editTextC2);
        counter3=findViewById(R.id.editTextC3);
        maxCounter=findViewById((R.id.editTextNumber));
        save=findViewById((R.id.buttonSave));
        reset=findViewById((R.id.buttonReset1));



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c1=counter1.getText().toString();
                c2=counter2.getText().toString();
                c3=counter3.getText().toString();
                maxCountString=maxCounter.getText().toString();
                maxCount=Integer.parseInt(maxCountString);
                Toast.makeText(SetActivity.this,"Saved",Toast.LENGTH_SHORT).show();

                sharedPreferenceHelper.saveEventName1(c1);
                sharedPreferenceHelper.saveEventName2(c2);
                sharedPreferenceHelper.saveEventName3(c3);
                sharedPreferenceHelper.saveMaxCount(maxCount);

                startActivity(new Intent(SetActivity.this, MainActivity.class));
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferenceHelper.clearSharedPreferences();
                startActivity(new Intent(SetActivity.this, MainActivity.class));
            }
        });

    }
}