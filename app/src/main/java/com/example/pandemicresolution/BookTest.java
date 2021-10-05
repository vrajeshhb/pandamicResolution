package com.example.pandemicresolution;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class BookTest {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Boolean status ;
    public Boolean getStatus() {
        return status;
    }




    public BookTest(String fname,String lname,String city,String date){

        Map<String, Object> user = new HashMap<>();
        user.put("first", fname);
        user.put("last", lname);
        user.put("city", city);
        user.put("date", date);

// Add a new document with a generated ID
        db.collection("id_user")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                       status= true;
                        // Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        status= false;
                        // Log.w(TAG, "Error adding document", e);
                    }
                });
    }


}
