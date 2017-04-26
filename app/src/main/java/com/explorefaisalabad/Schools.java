package com.explorefaisalabad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class Schools extends AppCompatActivity {

    EditText etSearch;
    ListView lvSchools;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<HashMap<String, String>> icArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schools);

        String Schools[] = { "Divisional Public School & College",
                "Divisional Model College",
                "Sheri Public School",
                "LaSalle Grammer School",
                "Roots IVY",
                "Beaconhouse School",
                "City Grammar School",
                "Kohinoor Grammar School",
                "Allied School System",
                "Faisalabad Grammar School",
                "City Cadet School",
                "Lahore Lyceum",
                "Kids Valley School",
                "Lahore Grammar School",
                "Oxford Public High School",
                "Little Giants School",
                "Royal Grammar School",
                "The City School",
                "Al-Huda Public School",
                "The Educators School System",
                "Dar-E-Arqam School",
        };
        lvSchools = (ListView) findViewById(R.id.lvSchools);
        etSearch = (EditText) findViewById(R.id.etSearch);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.tvItemName, Schools);
        lvSchools.setAdapter(arrayAdapter);

        lvSchools.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Schools.this, SingleLocation.class);
                i.putExtra("location_child",String.valueOf(position));
                i.putExtra("location_parent", "Schools");
                i.putExtra("location_name", lvSchools.getItemAtPosition(position).toString());
                startActivity(i);
            }
        });

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Schools.this.arrayAdapter.getFilter().filter(s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
