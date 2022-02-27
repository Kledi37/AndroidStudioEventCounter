package com.example.c390a1.Controller;
import android.content.Context;
import android.content.SharedPreferences;


public class SharedPreferenceHelper {
    private SharedPreferences sharedPreferences;

    public SharedPreferenceHelper(Context context)
    {
        sharedPreferences = context.getSharedPreferences("ProfilePreference", Context.MODE_PRIVATE);
    }

    public void saveEventName1(String eventName1)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("EventName1",eventName1 );
        editor.commit();
    }
    public void saveEventName2(String eventName2)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("EventName2",eventName2 );
        editor.commit();
    }
    public void saveEventName3(String eventName3)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("EventName3",eventName3 );
        editor.commit();
    }
    public String getEventName1()
    {
        return sharedPreferences.getString("EventName1", "Event A");
    }
    public String getEventName2()
    {
        return sharedPreferences.getString("EventName2", "Event B");
    }
    public String getEventName3()
    {
        return sharedPreferences.getString("EventName3", "Event C");
    }

    public void saveMaxCount(int maxCount)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("MaxCount",maxCount );
        editor.commit();
    }
    public int getMaxCount()
    {
        return sharedPreferences.getInt("MaxCount", 0);
    }

    private int getCount() {
        return sharedPreferences.getInt("currentCount", 0);
    }

    public void incrementCount() {
        int currentCount = getCount();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("currentCount", currentCount+1);
        editor.commit();
    }

    public String returnCount(){
        String x="";
        int y=0;
        y=getCount();
        x=String.valueOf(new Integer(y));
        return x;
    }

    public String getCountList()
    {
        return sharedPreferences.getString("countList", "");
    }
    public void addToCountList(String num){
        String countList1=getCountList();
        countList1=countList1+num;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("countList",countList1 );
        editor.commit();

    }

    public void clearSharedPreferences()
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear().commit();
    }

}
