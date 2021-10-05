package com.example.pandemicresolution;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class testResult extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    TextView textView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_result);

        textView4 = findViewById(R.id.textView4);
        db.collection("lVro2qvqIZJSBlpnDWYM")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                textView4.setText(" FULL Name " + document.getString("fname") +" "+ document.getString("lname")+ " \n City " + document.getString("City") + " \n Date : " + document.getString("Date") + " \n Result "  + document.getString("result") +" \n");
                                textView4.setText(" \n" + document.getData()+" \n");

                                // Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                          //  Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });


    }
}