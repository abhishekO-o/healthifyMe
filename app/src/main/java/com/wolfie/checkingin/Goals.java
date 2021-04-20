package com.wolfie.checkingin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Goals extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    ListView l1;
    Button save;
    Boolean l_1 = false, l_2 = false, l_3 = false, l_4=false, l_5=false, l_6=false, l_7=false, l_8=false, l_9=false, l_10=false;
    ArrayList<String> goals_selected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);
        sharedPreferences = this.getSharedPreferences("com.example.moodtracker", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("goals_act", "true");
        editor.commit();
        save = findViewById(R.id.buttonContinueFromGoals);
        l1 = (ListView)findViewById(R.id.listView);
        goals_selected = new ArrayList<>();
        final ArrayList<String> goals = new ArrayList<String>();
        goals.add("Learn Instrument");
        goals.add("Wake up early");
        goals.add("Quit Drinking");
        goals.add("Quit Smoking");
        goals.add("Drink Water");
        goals.add("Meditation");
        goals.add("Exercise");
        goals.add("Detox");
        goals.add("Paint");
        goals.add("Read");

        ArrayAdapter adr = new ArrayAdapter(this, android.R.layout.simple_list_item_1, goals){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                final TextView tv = (TextView) view.findViewById(android.R.id.text1);
                tv.setTextColor(Color.WHITE);
                if(position == 0){
                    view.setBackgroundColor(Color.parseColor("#DE9F5AF8"));
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(l_1 == false) {
                                tv.setTextColor(Color.BLACK);
                                v.setBackgroundColor(Color.parseColor("#E1E1E1"));
                                l_1 = true;
                                goals_selected.add("Learn Instrument");
                            }
                            else{
                                tv.setTextColor(Color.WHITE);
                                v.setBackgroundColor(Color.parseColor("#DE9F5AF8"));
                                l_1 = false;
                                goals_selected.remove("Learn Instrument");
                            }
                        }
                    });
                }
                else if(position == 1){
                    view.setBackgroundColor(Color.parseColor("#C49F5AF8"));
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(l_2 == false) {
                                goals_selected.add("Wake up Early");
                                tv.setTextColor(Color.BLACK);
                                v.setBackgroundColor(Color.parseColor("#E1E1E1"));
                                l_2 = true;
                            }
                            else{
                                tv.setTextColor(Color.WHITE);
                                v.setBackgroundColor(Color.parseColor("#C49F5AF8"));
                                l_2 = false;
                                goals_selected.remove("Wake up Early");
                            }
                        }
                    });
                }
                else if(position == 2){
                    view.setBackgroundColor(Color.parseColor("#AB9F5AF8"));
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(l_3 == false) {
                                goals_selected.add("Quit Drinking");
                                tv.setTextColor(Color.BLACK);
                                v.setBackgroundColor(Color.parseColor("#E1E1E1"));
                                l_3 = true;
                            }
                            else{
                                goals_selected.remove("Quit Drinking");
                                tv.setTextColor(Color.WHITE);
                                v.setBackgroundColor(Color.parseColor("#AB9F5AF8"));
                                l_3 = false;
                            }
                        }
                    });
                }
                else if(position == 3){
                    view.setBackgroundColor(Color.parseColor("#919F5AF8"));
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(l_4 == false) {
                                goals_selected.add("Quit Smoking");
                                tv.setTextColor(Color.BLACK);
                                v.setBackgroundColor(Color.parseColor("#E1E1E1"));
                                l_4 = true;
                            }
                            else{
                                goals_selected.remove("Quit Smoking");
                                tv.setTextColor(Color.WHITE);
                                v.setBackgroundColor(Color.parseColor("#919F5AF8"));
                                l_4 = false;
                            }
                        }
                    });
                }
                else if(position == 4){
                    view.setBackgroundColor(Color.parseColor("#789F5AF8"));
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(l_5 == false) {
                                goals_selected.add("Drink Water");
                                tv.setTextColor(Color.BLACK);
                                v.setBackgroundColor(Color.parseColor("#E1E1E1"));
                                l_5 = true;
                            }
                            else{
                                goals_selected.remove("Drink Water");
                                tv.setTextColor(Color.WHITE);
                                v.setBackgroundColor(Color.parseColor("#789F5AF8"));
                                l_5 = false;
                            }
                        }
                    });
                }
                else if(position == 5){
                    view.setBackgroundColor(Color.parseColor("#5E9F5AF8"));
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(l_6 == false) {
                                goals_selected.add("Meditation");
                                tv.setTextColor(Color.BLACK);
                                v.setBackgroundColor(Color.parseColor("#E1E1E1"));
                                l_6 = true;
                            }
                            else{
                                goals_selected.remove("Meditation");
                                tv.setTextColor(Color.WHITE);
                                v.setBackgroundColor(Color.parseColor("#5E9F5AF8"));
                                l_6 = false;
                            }
                        }
                    });
                }
                else if(position == 6){
                    view.setBackgroundColor(Color.parseColor("#459F5AF8"));
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(l_7 == false) {
                                goals_selected.add("Exercise");
                                tv.setTextColor(Color.BLACK);
                                v.setBackgroundColor(Color.parseColor("#E1E1E1"));
                                l_7 = true;
                            }
                            else{
                                goals_selected.remove("Exercise");
                                tv.setTextColor(Color.WHITE);
                                v.setBackgroundColor(Color.parseColor("#459F5AF8"));
                                l_7 = false;
                            }
                        }
                    });
                }
                else if(position == 7){
                    view.setBackgroundColor(Color.parseColor("#409F5AF8"));
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(l_8 == false) {
                                goals_selected.add("Detox");
                                tv.setTextColor(Color.BLACK);
                                v.setBackgroundColor(Color.parseColor("#E1E1E1"));
                                l_8 = true;
                            }
                            else{
                                goals_selected.remove("Detox");
                                tv.setTextColor(Color.WHITE);
                                v.setBackgroundColor(Color.parseColor("#409F5AF8"));
                                l_8 = false;
                            }
                        }
                    });
                }
                else if(position == 8){
                    view.setBackgroundColor(Color.parseColor("#3B9F5AF8"));
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(l_9 == false) {
                                goals_selected.add("Paint");
                                tv.setTextColor(Color.BLACK);
                                v.setBackgroundColor(Color.parseColor("#E1E1E1"));
                                l_9 = true;
                            }
                            else{
                                goals_selected.remove("Paint");
                                tv.setTextColor(Color.WHITE);
                                v.setBackgroundColor(Color.parseColor("#3B9F5AF8"));
                                l_9 = false;
                            }
                        }
                    });
                }
                else if(position == 9){
                    view.setBackgroundColor(Color.parseColor("#369F5AF8"));
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(l_10 == false) {
                                goals_selected.add("Read");
                                tv.setTextColor(Color.BLACK);
                                v.setBackgroundColor(Color.parseColor("#E1E1E1"));
                                l_10 = true;
                            }
                            else{
                                goals_selected.remove("Read");
                                tv.setTextColor(Color.WHITE);
                                v.setBackgroundColor(Color.parseColor("#369F5AF8"));
                                l_10 = false;
                            }
                        }
                    });
                }
                return view;
            }
        };
        l1.setAdapter(adr);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("goals_set", "set");
                editor.commit();
                StringBuffer stringBuffer = new StringBuffer();
                for(String s: goals_selected){
                    stringBuffer.append(s);
                    stringBuffer.append(",");
                }
                String str_goals = stringBuffer.toString();
                Log.d("GOALS_SELECTED", str_goals);

                editor.putString("goals_selected", str_goals);
                editor.commit();
                Intent intent = new Intent(Goals.this, Result.class);
                startActivity(intent);
            }
        });
    }
}
