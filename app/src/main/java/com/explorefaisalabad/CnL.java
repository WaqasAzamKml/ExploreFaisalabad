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

public class CnL extends AppCompatActivity {
    EditText etSearch;
    ListView lvCnL;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<HashMap<String, String>> icArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cn_l);

        String iCompanies[] = { "TCS",
                "Leopards Courier",
                "Government Post Office",
                "M&P",
                "Stallion Courier",
                "BlueEx",
                "DHL",
                "Fed Ex",
        };
        lvCnL = (ListView) findViewById(R.id.lvCnL);
        etSearch = (EditText) findViewById(R.id.etSearch);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.tvItemName, iCompanies);
        lvCnL.setAdapter(arrayAdapter);

        lvCnL.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(CnL.this, SingleLocation.class);
                i.putExtra("location_child",String.valueOf(position));
                i.putExtra("location_parent", "Courier & Logistics");
                i.putExtra("location_name", lvCnL.getItemAtPosition(position).toString());
                startActivity(i);
            }
        });

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                CnL.this.arrayAdapter.getFilter().filter(s);
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
