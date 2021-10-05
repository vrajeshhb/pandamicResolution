package com.example.pandemicresolution;
/*
AUTHOR : VRAJESH BHIMAJIANI
 */
import androidx.appcompat.app.AppCompatActivity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class hometwo extends AppCompatActivity {

    Button home,donate,stat,info;

    /* */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hometwo);

        home= (Button) findViewById(R.id.button3);
        donate= (Button) findViewById(R.id.button8);
        stat= (Button) findViewById(R.id.button9);
        info= (Button) findViewById(R.id.button10);
                //,donate,stat,info;
        //homeN calls
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        // load book test Fragment
                loadFragment(new homeN());
            }
        });

        //donatenew calls
        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // load donate Fragment
                loadFragmentdonate(new donatenew());
            }
        });

        //state calls
        // (which i need to fecth RESTapi, pending....)
        stat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // load state Fragment
                loadFragmentstate(new newstate());
            }
        });


        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // load state Fragment
                loadFragmentinfo(new newinfo());
            }
        });

        //defatul fragment as home test book screen set call.
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, new homeN());
        fragmentTransaction.commit();
    }

    //FUNCTIONS TO LOAD FRAGMENTS AS FOLLOW:
    //LOADS HOME FRAGMENT
    private void loadFragment(homeN fragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
    //LOADS DONATE FRAGMENT
    private void loadFragmentdonate(donatenew fragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
    //LOADS STATE FRAGMENT
    private void loadFragmentstate(newstate fragment) {
       FragmentManager fm = getFragmentManager();
       FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
    //LOADS INFO FRAGMENT
    private void loadFragmentinfo(newinfo fragment) {
         FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }



}






//try code with bugs...
//stored for refference
//VRAJESH BHINAJIANI
 /*th =findViewById(R.id.in_date);
        select=(Button)findViewById(R.id.btn_date);


        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(hometwo.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                th.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });*/



        /*book = findViewById(R.id.button3);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(hometwo.this, "Covid19 Test Booked Succefully!", Toast.LENGTH_SHORT).show();
            }
        });*/

        /*view = findViewById(R.id.button4);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewhis = new Intent(hometwo.this,testResult.class);
                startActivity(viewhis);
            }
        });
*/







       /* donation=findViewById(R.id.donation);
        donation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewdono = new Intent(hometwo.this, donation.class);
                startActivity(viewdono);
            }
        });


        stat=findViewById(R.id.viewstat);
        stat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewdono = new Intent(hometwo.this, info.class);
                startActivity(viewdono);
            }
        });*/