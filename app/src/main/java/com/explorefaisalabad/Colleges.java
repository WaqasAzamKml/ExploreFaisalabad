package com.explorefaisalabad;

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

public class Colleges extends AppCompatActivity {

    EditText etSearch;
    ListView lvColleges;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<HashMap<String, String>> icArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colleges);

        String Colleges[] = { "Divisional Public School & College",
                "Divisional Model College",
                "Punjab Group Of Colleges",
                "Shiblee College",
                "Superior Group Of Colleges",
                "Abdul Salam College",
                "Madina College & University",
                "Tips College",
                "UAF Community College",
                "Government College Of Technology",
                "Government Post Graduate College Of Commerce",
                "The ACE School & College",
                "Government College University",
                "Punjab Law College",
                "Chenab College",
                "Madina College of Science & Commerce",
                "Madina College for Women",
                "GM College Faisalabad",
                "Government College of Technology",
        };
        lvColleges = (ListView) findViewById(R.id.lvColleges);
        etSearch = (EditText) findViewById(R.id.etSearch);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.tvItemName, Colleges);
        lvColleges.setAdapter(arrayAdapter);

        lvColleges.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Colleges.this.arrayAdapter.getFilter().filter(s);
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
