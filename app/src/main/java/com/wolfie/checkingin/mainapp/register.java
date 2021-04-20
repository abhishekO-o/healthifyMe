package com.wolfie.checkingin.mainapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.wolfie.checkingin.R;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class register extends AppCompatActivity {
    public FirebaseAuth mAuth;
    EditText Email,Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        Email = findViewById(R.id.email);
        Password = findViewById(R.id.Cpassword);
        findViewById(R.id.regbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e = Email.getText().toString();
                String p = Password.getText().toString();
                reg(e,p);
            }
        });
    }
    void reg(String email, String password)
    {mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("Success", "createUserWithEmail:success");
                        startActivity( new Intent(getApplicationContext(), Onboard.class));
                        finish();

                        } else {
                        // If sign in fails, display a message to the user.
                        Log.w("Fail", "createUserWithEmail:failure", task.getException());
                        }

                        // ...
                            }
                        });

                        }
                        }
