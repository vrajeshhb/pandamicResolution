package com.example.pandemicresolution;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class donatenew extends Fragment {

        View view;
        EditText editTextPhone2;
        EditText editTextTextMultiLine2;
        Button button15;
        FirebaseFirestore db;
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment donation fragment
        view = inflater.inflate(R.layout.donatenew, container, false);
        db = FirebaseFirestore.getInstance();
        //button login clam free mask
        button15 = (Button) view.findViewById(R.id.button15);
        button15.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        editTextPhone2 = view.findViewById(R.id.editTextPhone2);
                        editTextTextMultiLine2 = view.findViewById(R.id.editTextTextMultiLine2);
                        String contact= editTextPhone2.getText().toString(), address= editTextTextMultiLine2.getText().toString();
                        //validation
                        if(contact.isEmpty()){
                                editTextPhone2.setError("Please Enter Contact here.");
                                editTextPhone2.requestFocus();
                        }
                        else if(contact.length() != 10){
                                editTextPhone2.setError("Contact number Must Have 10 digit.");
                                editTextPhone2.requestFocus();
                        }
                        else if(address.isEmpty()){
                                editTextTextMultiLine2.setError("Add Address.");
                                editTextTextMultiLine2.requestFocus();
                        }
                        else {
                                //all things are good we come here
                                //this code will store the entered  vlaue in firestore
                                //WSTFLn7Bxy26DlUEdbnE
                                Map<String, Object> user = new HashMap<>();
                                user.put("address", editTextPhone2.getText().toString());
                                user.put("contact", editTextTextMultiLine2.getText().toString());


                                // Add a new document with a generated ID
                                db.collection("WSTFLn7Bxy26DlUEdbnE")
                                        .add(user)
                                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                                @Override
                                                public void onSuccess(DocumentReference documentReference) {
                                                        Snackbar.make(button15, "Your Face Mask Is Booked. " + editTextTextMultiLine2.getText().toString(), Snackbar.LENGTH_LONG).show();
                                                        // Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                                                }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {
                                                        Snackbar.make(button15, "Error Try Again! later" + e, Snackbar.LENGTH_LONG).show();
                                                        // Log.w(TAG, "Error adding document", e);
                                                }
                                        });


                                editTextTextMultiLine2.setText("");
                                editTextPhone2.setText("");

                        }
                }
        });

        return view;
        }

}
