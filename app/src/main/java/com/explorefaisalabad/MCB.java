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

public class MCB extends AppCompatActivity {

    EditText etSearch;
    ListView lvMCB;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<HashMap<String, String>> icArrayList;
    Bundle bundle;
    String location_parent = "", location_child = "";
    ArrayList<String> addressList = new ArrayList<>();
    ArrayList<String> contactsList = new ArrayList<>();
    ArrayList<Double> latsList = new ArrayList<>();
    ArrayList<Double> longsList = new ArrayList<>();
    private String[] mcbBranches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcb);

        bundle = getIntent().getExtras();
        if(bundle!=null){
            location_child = bundle.getString("location_child");
            location_parent = bundle.getString("location_parent");
        }

        addressList.add("Madina Town, Susan Road, Faisalabad");
        addressList.add("People's Colony No 1\n" +
                "Faisalabad, Pakistan");
        addressList.add("Plot No.777, West Canal Road, Chowk Abdullahpur, Faisalabad");
        addressList.add("Sargodha Road, Sui Gas Office, Faisalabad");
        addressList.add("Chak No.212/RB, Jail Road, Faialabad");
        addressList.add("Rafhan Mills, East Canal Road, Faisalabad");
        addressList.add("Aminpura Rd, Saddar Bazar, Ghulam Mohammadabad, Faisalabad");
        addressList.add("Satiana Road Faisalabad ");
        mcbBranches = new String[]{ "Madina Town Branch",
                "Islamic Bank Limited, Peoples Colony Branch",
                "Abdullahpur Faisalabad Branch",
                "Sargodha Road Branch",
                "Jail Road Branch",
                "Rafhan Mills Branch",
                "GM Abad Branch",
                "Satiana Road Branch"};
        contactsList.add("041-8544223");
        contactsList.add("041-8556601");
        contactsList.add("041-8733870");
        contactsList.add("041-8780915");
        contactsList.add("041-2641502");
        contactsList.add("041-8557348");
        contactsList.add("041-2590874");
        contactsList.add("041-8728730");
        latsList.add(31.420691);
        longsList.add(73.1141529);
        latsList.add(31.4120768);
        longsList.add(73.0353681);
        latsList.add(31.4216696);
        longsList.add(73.0378809);
        latsList.add(31.4642014);
        longsList.add(73.0106602);
        latsList.add(31.4417956);
        longsList.add(73.081611);
        latsList.add(31.4555203);
        longsList.add(73.1514114);
        latsList.add(31.4369871);
        longsList.add(72.9802173);
        latsList.add(31.2074999);
        longsList.add(73.1016477);

        lvMCB = (ListView) findViewById(R.id.lvMCB);
        etSearch = (EditText) findViewById(R.id.etSearch);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.tvItemName, mcbBranches);
        lvMCB.setAdapter(arrayAdapter);

        lvMCB.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MCB.this, SingleLocation.class);
                if(bundle!=null){
                    i.putExtra("location_parent",location_parent);
                    i.putExtra("location_child",location_child);
                }
                i.putExtra("location_name",mcbBranches[position]);
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
                MCB.this.arrayAdapter.getFilter().filter(s);
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
