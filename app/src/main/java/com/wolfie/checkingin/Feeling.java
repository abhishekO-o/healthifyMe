package com.wolfie.checkingin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TimePicker;



import java.util.Calendar;

public class Feeling extends AppCompatActivity {
    EditText date_picker, time_picker;
    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;
    ImageView menu_icon, rad, good, meh, bad;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    String activity_number, mood;
    String date, time;
    int rad_counter, good_counter, meh_counter, bad_counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeling);
        sharedPreferences = this.getSharedPreferences("com.example.moodtracker", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        date_picker = findViewById(R.id.editTextSelectDate);
        time_picker = findViewById(R.id.editTextSelectTime);
        menu_icon = findViewById(R.id.imageViewMenuIcon);
        rad = findViewById(R.id.imageViewRad);
        good = findViewById(R.id.imageViewGood);
        meh = findViewById(R.id.imageViewMeh);
        bad = findViewById(R.id.imageViewBad);
        rad_counter = sharedPreferences.getInt("rad_counter", 0);
        good_counter = sharedPreferences.getInt("good_counter", 0);
        meh_counter = sharedPreferences.getInt("meh_counter", 0);
        bad_counter = sharedPreferences.getInt("bad_counter", 0);
        editor.putString("activity_number", "3");
        editor.commit();
        activity_number = sharedPreferences.getString("activity_number", "1");
        Log.i("num_shared", activity_number);

        date_picker.setInputType(InputType.TYPE_NULL);
        time_picker.setInputType(InputType.TYPE_NULL);

        Calendar calendar = Calendar.getInstance();
        int this_day = calendar.get(Calendar.DAY_OF_MONTH);
        int this_month = calendar.get(Calendar.MONTH)+1;
        int this_year = calendar.get(Calendar.YEAR);
        int this_hour = calendar.get(Calendar.HOUR_OF_DAY);
        int this_minute = calendar.get(Calendar.MINUTE);

        date_picker.setText(Integer.toString(this_day)+"-"+Integer.toString(this_month)+"-"+Integer.toString(this_year));
        time_picker.setText(Integer.toString(this_hour)+":"+Integer.toString(this_minute));
        date_picker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);

                datePickerDialog = new DatePickerDialog(Feeling.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                date_picker.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            }
                        }, year, month, day);
                datePickerDialog.show();
            }
        });

        time_picker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int hour = cldr.get(Calendar.HOUR_OF_DAY);
                int minutes = cldr.get(Calendar.MINUTE);

                timePickerDialog =  new TimePickerDialog(Feeling.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                time_picker.setText(sHour + ":" + sMinute);
                            }
                        }, hour, minutes, true);
                timePickerDialog.show();
            }
        });

        menu_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(Feeling.this, menu_icon);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        switch (id){
                            case R.id.logout:
                                editor.putString("activity_number", "2");
                                editor.commit();
                               // FirebaseAuth.getInstance().signOut();
                               // Intent intent = new Intent(Feeling.this, Signup.class);
                               // startActivity(intent);
                               // finish();
                                break;
                            case R.id.see_history:
                                Intent intent1 = new Intent(Feeling.this, Result.class);
                                startActivity(intent1);
                                break;
                            case R.id.manage_goals:
                                Intent intent2 = new Intent(Feeling.this, ManageGoals.class);
                                startActivity(intent2);
                                break;
                            case R.id.donation:
                               // Intent intent3 = new Intent(Feeling.this, Donation.class);
                                //startActivity(intent3);
                               break;

                        }
                        return true;
                    }
                });
                popup.show();
            }
        });

        rad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mood = "rad";
                date = date_picker.getText().toString();
                time = time_picker.getText().toString();
                editor.putString("date", date);
                editor.commit();
                editor.putString("time", time);
                editor.commit();
                editor.putString("mood", mood);
                editor.commit();
                rad_counter += 1;
                editor.putInt("rad_counter",rad_counter);
                editor.commit();
                Intent i = new Intent(Feeling.this, Energy.class);
                startActivity(i);
                finish();
            }
        });

        good.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mood = "good";
                date = date_picker.getText().toString();
                time = time_picker.getText().toString();
                editor.putString("date", date);
                editor.commit();
                editor.putString("time", time);
                editor.commit();
                editor.putString("mood", mood);
                editor.commit();
                good_counter += 1;
                editor.putInt("good_counter", good_counter);
                editor.commit();
                Intent i = new Intent(Feeling.this, Energy.class);
                startActivity(i);
                finish();
            }
        });

        meh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mood = "meh";
                date = date_picker.getText().toString();
                time = time_picker.getText().toString();
                editor.putString("date", date);
                editor.commit();
                editor.putString("time", time);
                editor.commit();
                editor.putString("mood", mood);
                editor.commit();
                meh_counter += 1;
                editor.putInt("meh_counter", meh_counter);
                editor.commit();
                Intent i = new Intent(Feeling.this, Energy.class);
                startActivity(i);
                finish();
            }
        });

        bad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mood = "bad";
                date = date_picker.getText().toString();
                time = time_picker.getText().toString();
                editor.putString("date", date);
                editor.commit();
                editor.putString("time", time);
                editor.commit();
                editor.putString("mood", mood);
                editor.commit();
                bad_counter += 1;
                editor.putInt("bad_counter", bad_counter);
                editor.commit();
                Intent i = new Intent(Feeling.this, Energy.class);
                startActivity(i);
                finish();
            }
        });
    }
}
