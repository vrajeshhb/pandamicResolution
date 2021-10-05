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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    //declaration
    Button submit;
    EditText email,pass;
    TextView signup,forgotpass;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //assign
        mFirebaseAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.editTextTextEmailAddress);
        pass = findViewById(R.id.editTextTextPassword);
        forgotpass =findViewById(R.id.textView);
        signup = findViewById(R.id.buttonSignup);
        submit = findViewById(R.id.button);


        //pasword Eye symbol




        //authListner
        mAuthStateListner = new FirebaseAuth.AuthStateListener() {
            FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(mFirebaseUser != null){
                    Snackbar.make(submit, "You are Logged In..", Snackbar.LENGTH_LONG).show();


                    Intent i =new Intent(MainActivity.this, hometwo.class);
                    startActivity(i);
                }else {
                    Snackbar.make(submit, "Please Login!", Snackbar.LENGTH_LONG).show();

                  }
            }
        };
//navigate to sigup
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,SignUp.class);
                startActivity(i);
            }
        });

//Actual login code after login button click
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name= email.getText().toString(), passtr= pass.getText().toString() ;
                if(name.isEmpty()){
                    email.setError("Please Enter Email here.");
                    email.requestFocus();
                }else if(passtr.isEmpty() ){
                    pass.setError("Please Enter Password.");
                    pass.requestFocus();
                }else if(name.isEmpty() && passtr.isEmpty()){
                    Snackbar.make(submit, "You Must Fill The Data First.", Snackbar.LENGTH_LONG).show();


                }else if(!(name.isEmpty() && passtr.isEmpty())){
                    mFirebaseAuth.signInWithEmailAndPassword(name,passtr).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()){
                                Snackbar.make(submit, "Login Error! Try Again.", Snackbar.LENGTH_LONG).show();

                            }else{
                                Intent home = new Intent(MainActivity.this, hometwo.class);
                                startActivity(home);
                                //Toast.makeText(login.this, "", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else {
                    Snackbar.make(submit, "Error Ocurred", Snackbar.LENGTH_LONG).show();


                }
            }
        });



//forgotPass clicked
        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,forgetPassword.class);
                startActivity(i);
                //Toast.makeText(login.this, "im clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    //tryed to hanldeed the state fpr firebaseAuth.
    @Override
    protected void onStart(){
        super.onStart();
        // mFirebaseAuth.addAuthStateListener(mAuthStateListner);
    }
}