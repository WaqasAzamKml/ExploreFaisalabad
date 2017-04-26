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

public class Universities extends AppCompatActivity {

    EditText etSearch;
    ListView lvUni;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<HashMap<String, String>> icArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universities);

        String Uni[] = { "University Of Agriculture Faisalabad (UAF)",
                "Government College University (GCUF)",
                "National University of Modern Languages (NUML)",
                "University of Engineering and Technology, Lahore-IEFR",
                "Riphah International University",
                "Punjab Medical College",
                "National Textile University",
                "University of Faisalabad",
                "Independent Medical College",
                "Allama Iqbal Open University",
                "Virtual University",
                "Institute of Cost and Management Accountants of Pakistan (ICMAP)",
                "Institute of Chartered Accountants of Pakistan (ICAP)",
                "University of Central Punjab (UCP)",
                "National University of Computer & Emerging Sciences Chiniot - Faisalabad Campus (FAST NU - NUCES)",
        };
        lvUni = (ListView) findViewById(R.id.lvUni);
        etSearch = (EditText) findViewById(R.id.etSearch);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.tvItemName, Uni);
        lvUni.setAdapter(arrayAdapter);
        lvUni.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Universities.this, SingleLocation.class);
                startActivity(i);
            }
        });

        lvUni.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Universities.this.arrayAdapter.getFilter().filter(s);
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
