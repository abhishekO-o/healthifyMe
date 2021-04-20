package com.wolfie.checkingin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Activities extends AppCompatActivity {
    TextView t7, t8, t9, t10, t11, t12, t13, t14, t15;
    Boolean set_t7=false, set_t8=false, set_t9=false, set_t10=false, set_t11=false, set_t12=false, set_t13=false, set_t14=false, set_t15=false;
    ArrayList<String> activities;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth firebaseAuth;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);
        sharedPreferences = this.getSharedPreferences("com.example.moodtracker", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        t7 = findViewById(R.id.textViewReadingBook);
        t8 = findViewById(R.id.textViewWatchingMovie);
        t9 = findViewById(R.id.textViewCooking);
        t10 = findViewById(R.id.textViewShopping);
        t11 = findViewById(R.id.textViewNetflixAndChill);
        t12 = findViewById(R.id.textViewWishingFor);
        t13 = findViewById(R.id.textViewTravelling);
        t14 = findViewById(R.id.textViewRelaxing);
        t15 = findViewById(R.id.textViewSports);
        save = findViewById(R.id.buttonContinueFromActivities);
        firebaseDatabase = FirebaseDatabase.getInstance();
        activities = new ArrayList<>();
        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(set_t7 == false) {
                    activities.add(t7.getText().toString());
                    t7.setAlpha(0.2f);
                    set_t7 = true;
                }
                else{
                    t7.setAlpha(1f);
                    activities.remove(t7.getText().toString());
                    set_t7 = false;
                }

            }
        });

        t8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(set_t8 == false) {
                    activities.add(t8.getText().toString());
                    t8.setAlpha(0.2f);
                    set_t8 = true;
                }
                else{
                    t8.setAlpha(1f);
                    activities.remove(t8.getText().toString());
                    set_t8 = false;
                }

            }
        });

        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(set_t9 == false) {
                    activities.add(t9.getText().toString());
                    t9.setAlpha(0.2f);
                    set_t9 = true;
                }
                else{
                    t9.setAlpha(1f);
                    activities.remove(t9.getText().toString());
                    set_t9 = false;
                }

            }
        });

        t10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(set_t10 == false) {
                    activities.add(t10.getText().toString());
                    t10.setAlpha(0.2f);
                    set_t10 = true;
                }
                else{
                    t10.setAlpha(1f);
                    activities.remove(t10.getText().toString());
                    set_t10 = false;
                }
            }
        });

        t11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(set_t11 == false) {
                    activities.add(t11.getText().toString());
                    t11.setAlpha(0.2f);
                    set_t11 = true;
                }
                else{
                    t11.setAlpha(1f);
                    activities.remove(t11.getText().toString());
                    set_t11 = false;
                }
            }
        });

        t12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(set_t12 == false) {
                    activities.add(t12.getText().toString());
                    t12.setAlpha(0.2f);
                    set_t12 = true;
                }
                else{
                    t12.setAlpha(1f);
                    activities.remove(t12.getText().toString());
                    set_t12 = false;
                }
            }
        });

        t13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(set_t13 == false) {
                    activities.add(t13.getText().toString());
                    t13.setAlpha(0.2f);
                    set_t13 = true;
                }
                else{
                    t13.setAlpha(1f);
                    activities.remove(t13.getText().toString());
                    set_t13 = false;
                }
            }
        });

        t14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(set_t14 == false) {
                    activities.add(t14.getText().toString());
                    t14.setAlpha(0.2f);
                    set_t14 = true;
                }
                else{
                    t14.setAlpha(1f);
                    activities.remove(t14.getText().toString());
                    set_t14 = false;
                }
            }
        });

        t15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(set_t15 == false) {
                    activities.add(t15.getText().toString());
                    t15.setAlpha(0.2f);
                    set_t15 = true;
                }
                else{
                    t15.setAlpha(1f);
                    activities.remove(t15.getText().toString());
                    set_t15 = false;
                }

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer stringBuffer = new StringBuffer();
                for(String s: activities){
                    stringBuffer.append(s);
                    stringBuffer.append(" ");
                }
                String activity = stringBuffer.toString();
                Log.d("ACTIVITY", activity);
                editor.putString("activity_now", activity);
                editor.commit();
                String goals_set = sharedPreferences.getString("goals_set", "not_set");
                if(goals_set == "not_set") {
                    collectDataForDatabase();
                    Intent intent = new Intent(Activities.this, Goals.class);
                    startActivity(intent);
                    finish();

                }
                else{
                    collectDataForDatabase();
                    Intent intent = new Intent(Activities.this, Result.class);
                    startActivity(intent);
                    finish();
                }
            }
        });


    }
    private void collectDataForDatabase() {
        String mood = sharedPreferences.getString("mood", "none");
        String date = sharedPreferences.getString("date", "01-01-2020");
        String time = sharedPreferences.getString("time", "00:00");
        String energy_level = sharedPreferences.getString("energy_level", "0");
        String activity_now = sharedPreferences.getString("activity_now", "none");
        writeToDataBase(mood, date, time, energy_level, activity_now);
    }
    private void writeToDataBase(String mood, String date, String time, String energy_level, String activity_now) {
        DatabaseReference reference = firebaseDatabase.getReference().child("Mood").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(date).child(time);
        reference.child("date_rv").setValue(date);
        reference.child("time_rv").setValue(time);
        reference.child("mood").setValue(mood);
        reference.child("energy_level").setValue(energy_level);
        reference.child("activity_now").setValue(activity_now);
    }
}
