package com.example.pandemicresolution;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class homeN extends Fragment {
    FirebaseFirestore db;
    View view;
    EditText editTextTextPersonName2, editTextTextPersonName3, editTextTextPersonName4, in_date;
    Button book, select, res;
    private int mYear, mMonth, mDay, mHour, mMinute;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.home, container, false);

        //opening result activity
        res = (Button) view.findViewById(R.id.button4);
        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(homeN.this.getActivity(), testResult.class);
                startActivity(i);
            }
        });


        //select date time button code.
        in_date = view.findViewById(R.id.in_date);
        select = (Button) view.findViewById(R.id.btn_date);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(homeN.this.getActivity(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                in_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        //storing the dtailes from form

        book = (Button) view.findViewById(R.id.button3);
        book.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        editTextTextPersonName2 = view.findViewById(R.id.editTextTextPersonName2);
                                        ;
                                        editTextTextPersonName3 = view.findViewById(R.id.editTextTextPersonName3);
                                        ;
                                        editTextTextPersonName4 = view.findViewById(R.id.editTextTextPersonName4);
                                        ;
                                        in_date = view.findViewById(R.id.in_date);
                                        db = FirebaseFirestore.getInstance();

                                        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
                                        String currentDateandTime;
                                        currentDateandTime = sdf.format(new Date());*/

                                        if (editTextTextPersonName2.getText().toString().isEmpty()) {
                                            editTextTextPersonName2.setError("Please Enter Name here.");
                                            editTextTextPersonName2.requestFocus();
                                        } else if (editTextTextPersonName3.getText().toString().isEmpty()) {
                                            editTextTextPersonName3.setError("Please Enter Last name here.");
                                            editTextTextPersonName3.requestFocus();
                                        } else if (editTextTextPersonName4.getText().toString().isEmpty()) {
                                            editTextTextPersonName4.setError("Please Enter location here here.");
                                            editTextTextPersonName4.requestFocus();
                                        } else if (in_date.getText().toString().isEmpty()) {
                                            in_date.setError("Please select date here.");
                                            in_date.requestFocus();
                                        } else {
                                            // BookTest bk = new BookTest(,,,i);
                                            Map<String, Object> user = new HashMap<>();
                                            user.put("first", editTextTextPersonName2.getText().toString());
                                            user.put("last", editTextTextPersonName3.getText().toString());
                                            user.put("city", editTextTextPersonName4.getText().toString());
                                            user.put("date", in_date.getText().toString());
                                            user.put("result", "Negative");

                                            // Add a new document with a generated ID
                                            db.collection("lVro2qvqIZJSBlpnDWYM")
                                                    .add(user)
                                                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                                        @Override
                                                        public void onSuccess(DocumentReference documentReference) {
                                                            Snackbar.make(book, "Your COVID-19 Test Booked on " + in_date.getText().toString(), Snackbar.LENGTH_LONG).show();
                                                            // Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                                                        }
                                                    })
                                                    .addOnFailureListener(new OnFailureListener() {
                                                        @Override
                                                        public void onFailure(@NonNull Exception e) {
                                                            Snackbar.make(book, "Error Try Again! later" + e, Snackbar.LENGTH_LONG).show();
                                                            // Log.w(TAG, "Error adding document", e);
                                                        }
                                                    });


                                            editTextTextPersonName2.setText("");
                                            editTextTextPersonName3.setText("");
                                            editTextTextPersonName4.setText("");
                                            in_date.setText("");
                                        }



                                    }
        });




                //returning the view after every login is done,,
                //returing to the view to  fragment.
        return view;
    }


}

