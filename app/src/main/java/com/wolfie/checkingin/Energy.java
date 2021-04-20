package com.wolfie.checkingin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;


public class Energy extends AppCompatActivity {
    TextView energy_level;
    Button continue_button;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_energy);
        sharedPreferences = this.getSharedPreferences("com.example.moodtracker", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        continue_button = findViewById(R.id.buttonContinueFromEnergyLevel);
       SeekBar croller = (SeekBar) findViewById(R.id.croller);

        energy_level = findViewById(R.id.textViewEnergyLevel);

       croller.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
               energy_level.setText(Integer.toString(progress));
           }

           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {

           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {

           }
       });

        continue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("energy_level", energy_level.getText().toString());
                editor.commit();
                Intent intent = new Intent(Energy.this, Activities.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
