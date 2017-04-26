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

public class Samba extends AppCompatActivity {

    EditText etSearch;
    ListView lvSamba;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<HashMap<String, String>> icArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samba);

        String MFbranches[] = { "Liaqut Road Branch"
        };
        lvSamba = (ListView) findViewById(R.id.lvSamba);
        etSearch = (EditText) findViewById(R.id.etSearch);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.tvItemName, MFbranches);
        lvSamba.setAdapter(arrayAdapter);

        lvSamba.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Samba.this.arrayAdapter.getFilter().filter(s);
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
