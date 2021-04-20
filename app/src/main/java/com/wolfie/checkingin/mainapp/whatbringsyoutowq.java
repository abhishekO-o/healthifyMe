package com.wolfie.checkingin.mainapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wolfie.checkingin.R;

import androidx.appcompat.app.AppCompatActivity;

public class whatbringsyoutowq extends AppCompatActivity {
    TextView select_campus, school_info;
    ImageView kandoli, bidholi;
    Button button_continue;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whatbringsyoutowq);
        select_campus = findViewById(R.id.select_campus);
        school_info = findViewById(R.id.school_info);
        kandoli = findViewById(R.id.kandoli);
        bidholi = findViewById(R.id.bidholi);
        button_continue = findViewById(R.id.button_continue);

        select_campus.animate().alpha(1f).setDuration(800);
        bidholi.animate().alpha(1f).setDuration(800).setStartDelay(800);
        kandoli.animate().alpha(1f).setDuration(800).setStartDelay(1600);
        button_continue.animate().alpha(1f).setDuration(800).setStartDelay(2400);
        button_continue.setEnabled(false);
        if(!button_continue.isEnabled())
        {
            button_continue.setBackground(getDrawable(R.drawable.round_button_grey));
        }
        button_continue.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   SharedPreferences sharedPreferences = getSharedPreferences("Name_info",0);
                                                   int campus = sharedPreferences.getInt("campus",0);
                                                   Toast.makeText(getApplicationContext(),""+campus,Toast.LENGTH_SHORT).show();
                                                   Intent i = new Intent(getApplicationContext(), BasicQues.class);
                                                   startActivity(i);

                                               }
                                           }
        );
        bidholi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bidholi.setImageResource(R.drawable.bid2);
                kandoli.setImageResource(R.drawable.kid1);
                button_continue.setBackgroundResource(R.drawable.round_button);
                school_info.setText("School of Computer Science, School of Engineering, School of Design");
                SharedPreferences sharedPreferences = getSharedPreferences("Name_info",0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("campus",1);
                editor.commit();
                button_continue.setEnabled(true);

            }
        });

        kandoli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bidholi.setImageResource(R.drawable.bid1);
                kandoli.setImageResource(R.drawable.kid2);
                button_continue.setBackgroundResource(R.drawable.round_button);
                school_info.setText("School of Law, School of Management");
                SharedPreferences sharedPreferences = getSharedPreferences("Name_info",0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("campus",2);
                editor.commit();
                button_continue.setEnabled(true);
            }
        });

    }
}
