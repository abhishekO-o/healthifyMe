package com.wolfie.checkingin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Result extends AppCompatActivity {
    DatabaseReference databaseReference;
    FirebaseAuth mAuth;
    ArrayList<String> mood_list;
    ArrayList<String> energy_level_list;
    ArrayList<String> activities_now_list;
    ArrayList<String> date_list;
    ArrayList<String> time_list;
    RecyclerView recyclerView;
    ImageView menu_icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        recyclerView = findViewById(R.id.recyclerViewResultActivity);
        menu_icon = findViewById(R.id.imageViewMenuIconResultActivity);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user;
        user = mAuth.getCurrentUser();
        String uid = user.getUid();
        mood_list = new ArrayList<>();
        energy_level_list = new ArrayList<>();
        activities_now_list = new ArrayList<>();
        date_list = new ArrayList<>();
        time_list = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Mood").child(uid);
        Log.d("SSSSS", "onCreate: "+uid);
        databaseReference.keepSynced(true);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mood_list.clear();
                energy_level_list.clear();
                activities_now_list.clear();
                date_list.clear();
                time_list.clear();
                for(DataSnapshot dates: dataSnapshot.getChildren()){
                    for(DataSnapshot times: dates.getChildren()){
                        String date = times.child("date_rv").getValue().toString();
                        String time = times.child("time_rv").getValue().toString();
                        String mood = times.child("mood").getValue().toString();
                        String energy_level = times.child("energy_level").getValue().toString();
                        String activities_now = times.child("activity_now").getValue().toString();
                        date_list.add(date);
                        time_list.add(time);
                        mood_list.add(mood);
                        energy_level_list.add(energy_level);
                        activities_now_list.add(activities_now);
                    }
                }

                String[] date_string = new String[date_list.size()];
                String[] time_string = new String[time_list.size()];
                String[] mood_string = new String[mood_list.size()];
                String[] energy_level_string = new String[energy_level_list.size()];
                String[] activities_now_string = new String[activities_now_list.size()];

                for (int j = 0; j < mood_list.size(); j++) {
                    mood_string[j] = mood_list.get(j);
                    energy_level_string[j] = energy_level_list.get(j);
                    activities_now_string[j] = activities_now_list.get(j);
                    date_string[j] = date_list.get(j);
                    time_string[j] = time_list.get(j);
                }

                MyAdapter myAdapter = new MyAdapter(Result.this, mood_string, energy_level_string, activities_now_string, date_string, time_string);
                recyclerView.setAdapter(myAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(Result.this));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        menu_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(Result.this, menu_icon);
                popup.getMenuInflater().inflate(R.menu.popup_menu2, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item)
                    {  int id = item.getItemId();
                        switch (id){
                            case R.id.graph:
                                    Intent intent = new Intent(Result.this, MoodGraph.class);
                                    startActivity(intent);
                                    break;
                            case R.id.manage_goals:
                                Intent intent1 = new Intent(Result.this, ManageGoals.class);
                                startActivity(intent1);
                                break;
                        }
                        return true;

                      }
                });
                popup.show();
            }
        });
    }
}
