package com.example.pandemicresolution;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class newstate extends Fragment {

    View view;
    // Create the object of TextView
    TextView tvCases, tvRecovered,
            tvCritical, tvActive,
            tvTodayCases, tvTotalDeaths,
            tvTodayDeaths,
            tvAffectedCountries;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment newstate with rest api
        view = inflater.inflate(R.layout.newstate, container, false);

        // firstButton = (Button) view.findViewById(R.id.firstButton);
        tvCases =  view.findViewById(R.id.tvCases);
        tvRecovered =  view.findViewById(R.id.tvRecovered);
        tvCritical =  view.findViewById(R.id.tvCritical);
        tvActive =  view.findViewById(R.id.tvActive);
        tvTodayCases =  view.findViewById(R.id.tvTodayCases);
        tvTotalDeaths =  view.findViewById(R.id.tvTotalDeaths);
        tvTodayDeaths =  view.findViewById(R.id.tvTodayDeaths);
        tvAffectedCountries = view. findViewById(R.id.tvAffectedCountries);


        // Creating a method fetchdata()
        fetchdata();

        return view;
    }


    private void fetchdata()
    {

        // Create a String request
        // using Volley Library
        String url = "https://corona.lmao.ninja/v2/all";

        StringRequest request
                = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {

                        // Handle the JSON object and
                        // handle it inside try and catch
                        try {

                            // Creating object of JSONObject
                            JSONObject jsonObject
                                    = new JSONObject(
                                    response.toString());

                            // Set the data in text view
                            // which are available in JSON format
                            // Note that the parameter inside
                            // the getString() must match
                            // with the name given in JSON format
                            tvCases.setText(
                                    jsonObject.getString(
                                            "cases"));
                            tvRecovered.setText(
                                    jsonObject.getString(
                                            "recovered"));
                            tvCritical.setText(
                                    jsonObject.getString(
                                            "critical"));
                            tvActive.setText(
                                    jsonObject.getString(
                                            "active"));
                            tvTodayCases.setText(
                                    jsonObject.getString(
                                            "todayCases"));
                            tvTotalDeaths.setText(
                                    jsonObject.getString(
                                            "deaths"));
                            tvTodayDeaths.setText(
                                    jsonObject.getString(
                                            "todayDeaths"));
                            tvAffectedCountries.setText(
                                    jsonObject.getString(
                                            "affectedCountries"));
                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(
                                newstate.this.getActivity(),
                                error.getMessage(),
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(newstate.this.getActivity());
        requestQueue.add(request);
    }

}
