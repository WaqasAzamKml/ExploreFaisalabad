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

public class UBL extends AppCompatActivity {

    EditText etSearch;
    ListView lvUBL;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<HashMap<String, String>> icArrayList;
    Bundle bundle;
    String location_parent = "", location_child = "";
    private String[] UBLBranches;
    ArrayList<String> addressList = new ArrayList<>();
    ArrayList<String> contactsList = new ArrayList<>();
    ArrayList<Double> latsList = new ArrayList<>();
    ArrayList<Double> longsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubl);

        bundle = getIntent().getExtras();
        if(bundle!=null){
            location_child = bundle.getString("location_child");
            location_parent = bundle.getString("location_parent");
        }

        UBLBranches = new String[]{ "Susan Road Branch",
                "Dijkot Road Branch",
        };
        addressList.add("Plot No. W-38-101 18-Chenab Market Medina Town Faisalabad");
        addressList.add("Corporate Center P-1036/2 UBL House Bank Square Circular Road Faisalabad.");
        contactsList.add("041-8503402");
        contactsList.add("041-9201445");
        latsList.add(31.4205722);
        longsList.add(73.0472214);
        latsList.add(31.4211091);
        longsList.add(73.0823038);
        lvUBL = (ListView) findViewById(R.id.lvUBL);
        etSearch = (EditText) findViewById(R.id.etSearch);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.tvItemName, UBLBranches);
        lvUBL.setAdapter(arrayAdapter);

        lvUBL.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(UBL.this, SingleLocation.class);
                if(bundle!=null){
                    i.putExtra("location_parent",location_parent);
                    i.putExtra("location_child",location_child);
                }
                i.putExtra("location_name",UBLBranches[position]);
                i.putExtra("location_address",addressList.get(position));
                i.putExtra("location_contact", contactsList.get(position));
                i.putExtra("latitude", latsList.get(position));
                i.putExtra("longitude",longsList.get(position));
                startActivity(i);
            }
        });

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                UBL.this.arrayAdapter.getFilter().filter(s);
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
