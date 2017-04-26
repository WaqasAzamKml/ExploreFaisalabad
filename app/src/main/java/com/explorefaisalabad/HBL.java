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

public class HBL extends AppCompatActivity {

    EditText etSearch;
    ListView lvHBL;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<HashMap<String, String>> icArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hbl);

        String HBLbranches[] = { "Susan Road Branch",
                "Railway Road Branch",
                "Agriculture University Branch",
                "Circular Road Branch",
                "Chiniot Bazar Branch",
                "Jhang Bazar Branch",
                "Satyana Road Branch",
                "Gole Cloth Market Branch",
                "Millat Road Branch",
                "GM Abad Branch",
                "Sitara Tower Branch",
                "Bhawana Bazar Branch",
                "Mantgomery Bazar Branch",
                "Gulfishan Colony Jhang Rd. Branch",
                "Layallpur Regency Plaza Branch",
                "Samanabad Branch",
                "Ali Town Sargodha Road Branch",
                "Jaranwala Road Branch",
                "Chak 202RB Gatti Branch",
                "Narwala Road Branch",
                "D-type Colony Branch",
                "Muhammadabad Chak 224RB Branch",
                "Nazimabad Branch",
                "Gulberg Colony Branch",
                "Dijkot Road Branch",
                "Abdullah Pur Branch",
                "Punjab Medical College (PMC) Branch",
                "Hajiabad Branch",
                "Raza Abad Branch",
                "Peoples Colony Branch",
                "D-Ground Branch",
                "PTCL Building Branch",
                "Akbar Chowk Branch",
                "West Canal Road Branch",
                "Factory Area Branch",
                "Sargodha Road Bilal Gunj Branch",
                "Ismail Road Branch",
                "Batala Colony Branch",
                "IBB Nalka Kohala Branch"
        };
        lvHBL = (ListView) findViewById(R.id.lvHBL);
        etSearch = (EditText) findViewById(R.id.etSearch);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.tvItemName, HBLbranches);
        lvHBL.setAdapter(arrayAdapter);

        lvHBL.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                HBL.this.arrayAdapter.getFilter().filter(s);
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
