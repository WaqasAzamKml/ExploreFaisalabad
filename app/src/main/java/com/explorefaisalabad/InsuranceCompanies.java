package com.explorefaisalabad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by arslan shahid on 1/5/2017.
 */

public class InsuranceCompanies extends AppCompatActivity {
    EditText etSearch;
    ListView lvICompanies;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<HashMap<String, String>> icArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insurance_companies);

        String iCompanies[] = { "IGI Insurance Ltd.",
                                "Efu Life Takaful",
                                "Efu Group Life & Ind Assurance",
                                "EFU Life Bancassurance",
                                "Jubilee General Insurance Company Ltd.",
                                "AIG Pakistan",
                                "National Insurance Company Ltd.",
                                "Shaheen Insurance Company Limited",
                                "Freight Systems Company Ltd."
                                };
        lvICompanies = (ListView) findViewById(R.id.lvICompanies);
        etSearch = (EditText) findViewById(R.id.etSearch);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.tvItemName, iCompanies);
        lvICompanies.setAdapter(arrayAdapter);

        lvICompanies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(InsuranceCompanies.this, SingleLocation.class);
                i.putExtra("location_child",String.valueOf(position));
                i.putExtra("location_parent", "Insurance Companies");
                i.putExtra("location_name", lvICompanies.getItemAtPosition(position).toString());
                startActivity(i);
            }
        });

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                InsuranceCompanies.this.arrayAdapter.getFilter().filter(s);
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
