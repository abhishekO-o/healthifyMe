package com.wolfie.checkingin.mainapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.wolfie.checkingin.R;

import androidx.appcompat.app.AppCompatActivity;

public class welcometowq extends AppCompatActivity {

    TextView tv1 ,tv2,tv3,tv4;
    ImageView iv1,iv2;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcometowq);
        SharedPreferences sharedPreferences = getSharedPreferences("Name_info",0);
        String name = sharedPreferences.getString("Name","");
        tv2 = findViewById(R.id.Name);
        tv1 = findViewById(R.id.textView3);
        tv3 = findViewById(R.id.textView5);
        tv4 = findViewById(R.id.textView6);
        iv1 = findViewById(R.id.imageView3);
        iv2 = findViewById(R.id.imageView4);
        btn1 = findViewById(R.id.welcome_continue);
        tv2.setText(name+",");
        text1_text2_text3();
        text4();
        image1_image2();
        button1();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent i = new Intent(getApplicationContext(), whatbringsyoutowq.class);
              startActivity(i);
            }
        });
    }
    void text1_text2_text3()
    {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tv1.setVisibility(View.VISIBLE);
                tv2.setVisibility(View.VISIBLE);
                tv3.setVisibility(View.VISIBLE);
                Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
                tv1.startAnimation(animFadeIn);
                tv2.startAnimation(animFadeIn);
                tv3.startAnimation(animFadeIn);
            }
        },500);
    }
    void text4()
    {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tv4.setVisibility(View.VISIBLE);
                Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
                tv4.startAnimation(animFadeIn);
            }
        },900);
    }
    void image1_image2()
    {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iv1.setVisibility(View.VISIBLE);
                iv2.setVisibility(View.VISIBLE);
                Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
                iv1.startAnimation(animFadeIn);
                iv2.startAnimation(animFadeIn);

            }
        },1500);
    }
    void button1()
    {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                btn1.setVisibility(View.VISIBLE);
                Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
                btn1.startAnimation(animFadeIn);
            }
        },1800);
    }
}