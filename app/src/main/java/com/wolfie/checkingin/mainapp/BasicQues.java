package com.wolfie.checkingin.mainapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.shawnlin.numberpicker.NumberPicker;
import com.wolfie.checkingin.R;

import androidx.appcompat.app.AppCompatActivity;
import me.rorschach.library.ShaderSeekArc;


public class BasicQues extends AppCompatActivity {
    SharedPreferences mSharedPreferences;
    ShaderSeekArc seekArc;
    NumberPicker height,weight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_ques);
        mSharedPreferences=getSharedPreferences("Basic_Info",0);
        seekArc = findViewById(R.id.seek_arc);
        height = findViewById(R.id.number_picker);
        weight = findViewById(R.id.number_picker2);
        final SharedPreferences.Editor editor = mSharedPreferences.edit();
        findViewById(R.id.maleB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.maleB).setBackgroundResource(R.drawable.femalebutton);
                findViewById(R.id.FemaleB).setBackgroundResource(R.drawable.round_button_grey);
                editor.putString("Gender","Male");
                editor.commit();
            }
        });
        findViewById(R.id.FemaleB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.maleB).setBackgroundResource(R.drawable.round_button_grey);
                findViewById(R.id.FemaleB).setBackgroundResource(R.drawable.femalebutton);
                editor.putString("Gender","Female");
                editor.commit();
            }
        });
        seekArc.setOnSeekArcChangeListener(new ShaderSeekArc.OnSeekArcChangeListener() {

            @Override
            public void onProgressChanged(ShaderSeekArc seekArc, float progress) {
              editor.putFloat("Age",progress);
              editor.commit();
            }

            @Override
            public void onStartTrackingTouch(ShaderSeekArc seekArc) {
            }

            @Override
            public void onStopTrackingTouch(ShaderSeekArc seekArc) {

            }
        });

        height.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
              editor.putInt("Height",newVal);
              editor.commit();
            }
        });
        weight.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                editor.putInt("Weight",newVal);
                editor.commit();

            }
        });
        findViewById(R.id.Next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String g = mSharedPreferences.getString("Gender","a");

                if(g.length()==1)
                {
                    Toast.makeText(getApplicationContext(),"Please choose the gender",Toast.LENGTH_LONG).show();
                }
                else {
                    Float age = mSharedPreferences.getFloat("Age",0);
                    int weight =mSharedPreferences.getInt("Weight",0);
                    float t1 = (float) (weight/30);
                    SharedPreferences pref1 = getApplicationContext().getSharedPreferences("WaterCap", 0); // 0 - for private mode
                    final SharedPreferences.Editor editor = pref1.edit();
                    editor.putFloat("totalwater",t1*1000);
                    editor.commit();
                    //adddwater
                    final SharedPreferences addwater = getApplicationContext().getSharedPreferences("AddWater",0);
                    final SharedPreferences.Editor editor1 = addwater.edit();
                    editor1.putFloat("waterQty",0);
                    editor1.commit();
                    startActivity(new Intent(getApplicationContext(), register.class));
                }
            }
        });
    }

}
