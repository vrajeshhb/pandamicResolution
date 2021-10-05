package com.example.pandemicresolution;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    Button submit;
    EditText email,pass,pass1,editTextPhone,editTextTextPersonName;
    TextView signup;
    FirebaseAuth mFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        mFirebaseAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.editTextTextEmailAddress2);
        pass = findViewById(R.id.editTextTextPassword2);
        pass1 = findViewById(R.id.editTextTextPassword3);




        editTextPhone = findViewById(R.id.editTextPhone);
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        Toast.makeText(SignUp.this, "here", Toast.LENGTH_LONG).show();

       // signup = findViewById(R.id.returnLogin);
        submit = findViewById(R.id.buttonSignup);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                String name= email.getText().toString(), passtr= pass.getText().toString(),pass2 =pass1.getText().toString(), mobile=editTextPhone.getText().toString(),city =editTextTextPersonName.getText().toString() ;

                if(name.isEmpty()){
                    email.setError("Please Enter Email here.");
                    email.requestFocus();
                }
                else if(passtr.isEmpty()){
                    pass.setError("Please Enter Password.");
                    pass.requestFocus();
                }
                else if(passtr.length() < 8){
                    pass.setError("Password MUST Be 8 Char.");
                    pass.requestFocus();
                }
                else if(name.isEmpty() && passtr.isEmpty() && passtr.length() < 8){
                    pass.setError("You Must Fill The Data First.");
                    pass.requestFocus();
                }

                else if(!passtr.equals(pass2)){
                    pass1.setError("Password and Conform Password Does Not match");
                    pass1.requestFocus();
                }
                else if(mobile.isEmpty()){
                    editTextPhone.setError("please Enter you contact.");
                    editTextPhone.requestFocus();

                }

                else if(mobile.length() != 10){
                    editTextPhone.setError("contact must have 10 digit");
                    editTextPhone.requestFocus();
                }

                else if(city.isEmpty()){
                    editTextTextPersonName.setError("city can not be empty.");
                    editTextTextPersonName.requestFocus();
                }
                else if(city.length() >= 50){
                    editTextTextPersonName.setError("city is too big to read.");
                    editTextTextPersonName.requestFocus();
                }
                else if(!(name.isEmpty() && passtr.isEmpty() && passtr.length() < 8)){
                    mFirebaseAuth.createUserWithEmailAndPassword(name,passtr).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(!task.isSuccessful()){
                                Snackbar.make(submit, "Sigup Unsuccessfull! Try Once Again.", Snackbar.LENGTH_SHORT).show();
                            }else{
                                Snackbar.make(submit, "Sig Up Successfull ! GO TO LOGIN.", Snackbar.LENGTH_SHORT).show();

                            }
                            email.setText("");
                            pass.setText("");
                            pass1.setText("");
                            editTextPhone.setText("");
                            editTextTextPersonName.setText("");

                        }

                    });
                }else {
                    Snackbar.make(submit, "Error Ocurred!", Snackbar.LENGTH_SHORT).show();

                }



            }
        });

    }
}