package com.wolfie.checkingin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class waterReminderMain extends AppCompatActivity {
ProgressBar pb;
SharedPreferences add,show;
TextView t,v;
DatabaseReference mDatabaseReference;
FirebaseAuth mAuth;
LineChart mLineChart;
    TextView tv2,tv3,tv4;
ArrayList<Entry> X;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_reminder_main);
        mAuth = FirebaseAuth.getInstance();
        t = findViewById(R.id.total);
        v = findViewById(R.id.current);
        add = getSharedPreferences("addwater",0);
        show = getSharedPreferences("WaterCap",0);
         Float total = show.getFloat("totalwater",100);
         Float vol = add.getFloat("waterQty",0);
        //chart
        mLineChart = findViewById(R.id.chart);
        mLineChart.setTouchEnabled(true);
        mLineChart.setPinchZoom(true);
        tv2=findViewById(R.id.a);
        tv3=findViewById(R.id.ma);
        tv4=findViewById(R.id.min);
         t.setText(""+total);
         v.setText(""+vol);
        pb = findViewById(R.id.progressBar);
        pb.setMax(total.intValue());
        pb.setProgress(vol.intValue());
        final SharedPreferences.Editor editor = add.edit();
        FirebaseUser user;
        user = mAuth.getCurrentUser();
        String uid = user.getUid();
        mDatabaseReference= FirebaseDatabase.getInstance().getReference().child("WaterRecord").child(uid);
       //cardview avg max min
        Thread timer = new Thread() {
            @Override
            public void run() {
//do something
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        avg();

                    }
                });
            }
        };
        timer.start();


        findViewById(R.id.imageButton).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               float vol = add.getFloat("waterQty",0);
               v.setText(""+vol);
               editor.putFloat("waterQty",vol+200);
               editor.commit();

               int s = (int) vol;
               pb.setProgress(s);


           }
       });
findViewById(R.id.imageButton).setOnLongClickListener(new View.OnLongClickListener() {
    @Override
    public boolean onLongClick(View v) {
        String id = mDatabaseReference.push().getKey();
        SharedPreferences pref =getSharedPreferences("addwater",0);
        int a = (int) pref.getFloat("waterQty",0);
        HashMap usermap = new HashMap<>();
        usermap.put("Y",a);
        mDatabaseReference.child(id).setValue(usermap);
        SharedPreferences.Editor editor = pref.edit();
        editor.putFloat("waterQty",0);
        editor.apply();
        return false;
    }
});

retrivedata();

    }

    private void retrivedata() {
mDatabaseReference.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        X = new ArrayList<>();
        float i = 0;
        for(DataSnapshot ds : dataSnapshot.getChildren())
        {
            i=i+1;
            String va = ds.child("Y").getValue().toString();
            float XA = Float.parseFloat(va);
            X.add(new Entry(i,XA));
            final LineDataSet set1 = new LineDataSet(X,"WaterValue");
            LineData data = new LineData(set1);
            set1.setDrawIcons(false);
            set1.enableDashedLine(10f, 5f, 0f);
            set1.enableDashedHighlightLine(10f, 5f, 0f);
            set1.setColor(Color.DKGRAY);
            set1.setCircleColor(Color.DKGRAY);
            set1.setLineWidth(1f);
            set1.setCircleRadius(3f);
            set1.setDrawCircleHole(false);
            set1.setValueTextSize(9f);
            set1.setDrawFilled(true);
            set1.setFormLineWidth(1f);
            set1.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
            set1.setFormSize(15.f);
            mLineChart.setData(data);
            mLineChart.notifyDataSetChanged();
            mLineChart.invalidate();
        }
            }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});
    }

    private void avg() {
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                X = new ArrayList<>();
                float total = 0;
                List<Float> list = new ArrayList<>();
                long count = dataSnapshot.getChildrenCount();
                for(DataSnapshot ds : dataSnapshot.getChildren())
                {  String va = ds.child("Y").getValue().toString();
                    float XA = Float.parseFloat(va);
                    total+= XA;

                    list.add(XA);
                }
                Collections.sort(list);
                if(!list.isEmpty()) {
                    float max = list.get(0);
                    float min = list.get(list.size() - 1);
                    float ans = total / count;
                    tv2.setText("" + ans);
                    tv3.setText("" + min);
                    tv4.setText("" + max);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }




}
