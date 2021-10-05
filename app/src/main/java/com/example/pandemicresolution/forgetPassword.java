package com.example.pandemicresolution;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

public class forgetPassword extends AppCompatActivity {

    FirebaseAuth auth ;
    EditText email;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);


        auth = FirebaseAuth.getInstance();
        email = findViewById(R.id.editTextTextEmailAddress2);
        submit = findViewById(R.id.buttonSend);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String tempEmail = email.getText().toString();


                auth.sendPasswordResetEmail(tempEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Snackbar.make(submit, "Password Sent To Your Email : "+tempEmail, Snackbar.LENGTH_LONG).show();

                          }
                        else{
                            Snackbar.make(submit, "Error Ocurred"+task.getException().getMessage(), Snackbar.LENGTH_LONG).show();


                        }
                    }
                });

                //Toast.makeText(forgetPass.this, ""+tempEmail, Toast.LENGTH_SHORT).show();
            }
        });

    }
}