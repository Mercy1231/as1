package com.example.mercywoldmariam.mercy_fueltrack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;


public class FuelTracking extends Activity {

    public final static String EXTRA_ENTRY = "com.example.mercywoldmariam.mercy_FuelTrack";

    private static final String FILENAME = "file.sav";
    private EditText fuelDate;
    private EditText fuelStation;
    private EditText fuelOdometer;
    private EditText fuelGrade;
    private EditText fuelAmount;
    private EditText fuelUnitCost;
    private ListView pastFuelEntries;

    private ArrayList<FuelEntry> entries = new ArrayList<FuelEntry>();
    private ArrayAdapter<FuelEntry> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_tracking);

        fuelDate = (EditText) findViewById(R.id.edit_date);
        fuelStation = (EditText) findViewById(R.id.edit_station);
        fuelOdometer = (EditText) findViewById(R.id.edit_odometer);
        fuelGrade = (EditText) findViewById(R.id.edit_odometer);
        fuelAmount = (EditText) findViewById(R.id.edit_amount);
        fuelUnitCost = (EditText) findViewById(R.id.edit_cost);

        Button saveButton = (Button) findViewById(R.id.save);
        Button viewButton = (Button) findViewById(R.id.view);
        pastFuelEntries = (ListView) findViewById(R.id.pastFuelEntries);

/*Attempt at building the save button
          saveButton.setOnClickListener(new View.OnClickListener() {

              public void onClick(View v) {
                  setResult(RESULT_OK);
                  String Date = fuelDate.getText().toString();
                  String Station = fuelStation.getText().toString();
                  String Odometer = fuelOdometer.getText().toString();
                  String Grade = fuelGrade.getText().toString();
                  String Amount = fuelAmount.getText().toString();
                  String UnitCost = fuelUnitCost.getText().toString();

                  FuelEntry newestEntry = new FuelNewEntry(Date, Station, Odometer, Grade, Amount, UnitCost);

                  entries.add(newestEntry);
                  adapter.notifyDataSetChanged();
                  saveInFile();
                //finish();

              }

         }); */

        viewButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);

                String Date = fuelDate.getText().toString();
                String Station = fuelStation.getText().toString();
                String Odometer = fuelOdometer.getText().toString();
                String Grade = fuelGrade.getText().toString();
                String Amount = fuelAmount.getText().toString();
                String UnitCost = fuelUnitCost.getText().toString();



                Intent intent = new Intent(FuelTracking.this, DisplayEntriesActivity.class);
                intent.putExtra(EXTRA_ENTRY, Station);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadFromFile();
//        adapter = new ArrayAdapter<>(this, R.layout.list_item, entries);
//        pastFuelEntries.setAdapter(adapter);

    }

    /* This section is very similar to code seen in lonelytwitter lab. I followed the same guidleines to create mine*/
    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();
// Took from https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html Jan/20/2016
            Type listType = new TypeToken<ArrayList<FuelNewEntry>>() {}.getType();
            entries = gson.fromJson(in, listType);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            entries = new ArrayList<>();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }

    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    0);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(entries, out);
            out.flush();

            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }

}
