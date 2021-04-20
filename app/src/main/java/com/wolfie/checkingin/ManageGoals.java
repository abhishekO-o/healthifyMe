package com.wolfie.checkingin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class ManageGoals extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    CardView cardView, cardView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_goals);
        sharedPreferences = getSharedPreferences("com.example.moodtracker", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        cardView = findViewById(R.id.cardView2);
        cardView2 = findViewById(R.id.cardView3);

        final String goals_selected = sharedPreferences.getString("goals_selected", "");

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManageGoals.this, Goals.class);
                intent.putExtra("goals", goals_selected);
                startActivity(intent);
            }
        });

    }
}
