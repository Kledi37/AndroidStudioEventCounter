package com.example.c390a1.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.c390a1.Controller.SharedPreferenceHelper;
import com.example.c390a1.R;

import java.util.ArrayList;

public class DataActivity extends AppCompatActivity {
    public SharedPreferenceHelper sharedPreferenceHelper;

    String eventData;
    ListView listView;
    ArrayAdapter adapter;
    int countEventA,countEventB,countEventC;

    public class row{
        String numberOfEvent,nameOfEvent;
        public row(String x1,String y1){
            numberOfEvent=x1;
            nameOfEvent=y1;
        }
    }
    ArrayList<row> rowList= new ArrayList<>();
    ArrayList<String> stringArrList= new ArrayList<>();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        sharedPreferenceHelper = new SharedPreferenceHelper(DataActivity.this);
        listView = (ListView) findViewById(R.id.lv_items);


        eventData=sharedPreferenceHelper.getCountList();
        char[] eventDataArray = new char[eventData.length()];
        for (int i = 0; i < eventData.length(); i++) {
            eventDataArray[i] = eventData.charAt(i);
        }

        for (int i = 0; i < eventData.length(); i++) {
            String j="";
            String k="";
            j= String.valueOf(eventDataArray[i]);
            if (j.equals("1"))
            {
                countEventA++;
               k=sharedPreferenceHelper.getEventName1();
            }
            else if(j.equals("2"))
            {
                countEventB++;
                k=sharedPreferenceHelper.getEventName2();
            }
            else if(j.equals("3")){
                countEventC++;
                k=sharedPreferenceHelper.getEventName3();}

            row newRow =new row(j,k);
            rowList.add(newRow);
            stringArrList.add(k);
        }

        TextView textView1 = findViewById(R.id.textView5);
        TextView textView2 = findViewById(R.id.textView8);
        TextView textView3 = findViewById(R.id.textView9);
        TextView textView4 = findViewById(R.id.textView17);
        TextView textView5 = findViewById(R.id.textView11);
        TextView textView6 = findViewById(R.id.textView15);
        TextView textView7 = findViewById(R.id.textView16);

        textView1.setText(sharedPreferenceHelper.getEventName1());
        textView2.setText(sharedPreferenceHelper.getEventName2());
        textView3.setText(sharedPreferenceHelper.getEventName3());
        textView4.setText(sharedPreferenceHelper.returnCount());
        textView5.setText(Integer.toString(countEventA));
        textView6.setText(Integer.toString(countEventB));
        textView7.setText(Integer.toString(countEventC));

        adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,stringArrList);
        listView.setAdapter(adapter);

    }


}