package com.wolfie.checkingin.mainapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.wolfie.checkingin.R;

import androidx.appcompat.app.AppCompatActivity;

public class whatsyourname extends AppCompatActivity {
    EditText editText;
    Button button;
    @Override
    protected void onResume() {

        findViewById(R.id.editText).postDelayed(
                new Runnable() {
                    public void run() {
                        editText.requestFocus();
                        InputMethodManager inputMethodManager =  (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                        inputMethodManager.showSoftInput(editText,InputMethodManager.SHOW_IMPLICIT);
                    }
                },100);
        super.onResume();
    }
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whatsyourname);
        button=findViewById(R.id.button);
        editText=findViewById(R.id.editText);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if(s.toString().trim().length()==0){
                    button.setEnabled(false);
                    editText.setError("Required");
                    button.setBackground(getDrawable(R.drawable.round_button_grey));
                } else {
                    if(s.toString().trim().length()>30)
                    {   button.setEnabled(false);
                        editText.setError("Name should be less than 30 letters");
                        button.setBackground(getDrawable(R.drawable.round_button_grey));
                    }
                    else{
                        button.setEnabled(true);
                        button.setBackground(getDrawable(R.drawable.round_button));
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), welcometowq.class);
                startActivity(i);
                String name = editText.getText().toString();
                SharedPreferences sharedPreferences = getSharedPreferences("Name_info",0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Name",name);
                editor.commit();

            }
        });
    }
}