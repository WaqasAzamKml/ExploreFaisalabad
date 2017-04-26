package com.explorefaisalabad;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    EditText etSearch;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inflater = getLayoutInflater();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        etSearch = (EditText) findViewById(R.id.etSearch);

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvLocations);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                if(groupPosition == 0 && childPosition == 0){
                    Intent i = new Intent(MainActivity.this, MCB.class);
                    i.putExtra("location_parent","Banks");
                    i.putExtra("location_child","MCB");
                    startActivity(i);
                }
                else if (groupPosition == 0 && childPosition == 1){
                    Intent i = new Intent(MainActivity.this, UBL.class);
                    i.putExtra("location_parent","Banks");
                    i.putExtra("location_child","UBL");
                    startActivity(i);
                }
                else if (groupPosition == 0 && childPosition == 2){
                    Intent i = new Intent(MainActivity.this, HBL.class);
                    startActivity(i);
                }
                else if (groupPosition == 0 && childPosition == 3){
                    Intent i = new Intent(MainActivity.this, MicroFinance.class);
                    startActivity(i);
                }
                else if (groupPosition == 0 && childPosition == 4){
                    Intent i = new Intent(MainActivity.this, Samba.class);
                    startActivity(i);
                }
                else if(groupPosition == 1 && childPosition == 0){
                    Intent i = new Intent(MainActivity.this, InsuranceCompanies.class);
                    startActivity(i);
                }
                else if(groupPosition == 1 && childPosition == 1){
                    Intent i = new Intent(MainActivity.this, CnL.class);
                    startActivity(i);
                }
                else if(groupPosition == 2 && childPosition == 0){
                    Intent i = new Intent(MainActivity.this, Schools.class);
                    startActivity(i);
                }
                else if(groupPosition == 2 && childPosition == 1){
                    Intent i = new Intent(MainActivity.this, Colleges.class);
                    startActivity(i);
                }
                // TODO Auto-generated method stub
//                Toast.makeText(
//                        getApplicationContext(),
//                        listDataHeader.get(groupPosition)
//                                + " : "
//                                + listDataChild.get(
//                                listDataHeader.get(groupPosition)).get(
//                                childPosition), Toast.LENGTH_SHORT)
//                        .show();
//                Toast.makeText(MainActivity.this, groupPosition + " " + childPosition, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Banks");
        listDataHeader.add("Corporate Offices");
        listDataHeader.add("Education");
        listDataHeader.add("Electronics & Maintenance");
        listDataHeader.add("Entertainment");
        listDataHeader.add("Food & Restaurants");
        listDataHeader.add("Health & Medical");
        listDataHeader.add("Hotel & Residence");
        listDataHeader.add("Industries");
        listDataHeader.add("Religion");
        listDataHeader.add("Shopping");
        listDataHeader.add("Telecommunication");
        listDataHeader.add("Travel & Tours");

        // Adding child data

        List<String> banks = new ArrayList<String>();
        banks.add("MCB");
        banks.add("UBL");
        banks.add("HBL");
        banks.add("Finca");
        banks.add("Samba");
        banks.add("Al-Barka");
        banks.add("Standard Chartered");
        banks.add("NBP");
        banks.add("Allied Bank");
        banks.add("Al-Falah");
        banks.add("Meezan");

        listDataChild.put(listDataHeader.get(0), banks); // Header, Child data

        List<String> corporateOffices = new ArrayList<String>();
        corporateOffices.add("Insurance Companies");
        corporateOffices.add("Courier & Logistics");
        corporateOffices.add("Utility");


        listDataChild.put(listDataHeader.get(1), corporateOffices); // Header, Child data


        List<String> Education = new ArrayList<String>();
        Education.add("Schools");
        Education.add("Colleges");
        Education.add("Universities");
        Education.add("Academies");


        listDataChild.put(listDataHeader.get(2),Education); // Header, Child data

        List<String> Electronics = new ArrayList<String>();
        Electronics.add("Electronic Outlets");
        Electronics.add("Company Outlets");
        Electronics.add("Warranty Centers");


        listDataChild.put(listDataHeader.get(3),Electronics); // Header, Child data

        List<String> Entertainment = new ArrayList<String>();
        Entertainment.add("Cinemas");
        Entertainment.add("Play Lands");
        Entertainment.add("Parks");


        listDataChild.put(listDataHeader.get(4),Entertainment); // Header, Child data

        List<String> Food = new ArrayList<String>();
        Food.add("Restaurants");
        Food.add("Cafe");
        Food.add("Fast Food");
        Food.add("Ice Cream Parlor");
        Food.add("Shakes & Juices");
        Food.add("Caterers");
        Food.add("Marquees");
        Food.add("Marriage Halls");


        listDataChild.put(listDataHeader.get(5),Food); // Header, Child data

        List<String> Health = new ArrayList<String>();
        Health.add("Hospitals");
        Health.add("Laboratories");
        Health.add("Medical Stores");
        Health.add("Clinics");
        Health.add("Ambulance");


        listDataChild.put(listDataHeader.get(6),Health); // Header, Child data

        List<String> Hotel = new ArrayList<String>();
        Hotel.add("Hotels");
        Hotel.add("Apartments");
        Hotel.add("House For Rent");
        Hotel.add("House For Purchase");


        listDataChild.put(listDataHeader.get(7),Hotel); // Header, Child data

        List<String> Industries = new ArrayList<String>();
        Industries.add("Cotton");
        Industries.add("Chemical");
        Industries.add("Paint");
        Industries.add("DyeStuff");
        Industries.add("Textile");
        Industries.add("Pharmaceutical");
        Industries.add("Food");
        Industries.add("Weaving");
        Industries.add("Weaving");


        listDataChild.put(listDataHeader.get(8),Industries); // Header, Child data

        List<String> Religion = new ArrayList<String>();
        Religion.add("Mosques");
        Religion.add("Graveyards");
        Religion.add("Islamic Centers");


        listDataChild.put(listDataHeader.get(9),Religion); // Header, Child data

        List<String> Shopping = new ArrayList<String>();
        Shopping.add("Shopping Malls");
        Shopping.add("Clothing Brands");
        Shopping.add("Departmental Stores");


        listDataChild.put(listDataHeader.get(10),Shopping); // Header, Child data

        List<String> Tele = new ArrayList<String>();
        Tele.add("Telephone & Broadband");
        Tele.add("Mobile Networks");


        listDataChild.put(listDataHeader.get(11),Tele); // Header, Child data

        List<String> Travel = new ArrayList<String>();
        Travel.add("Airport");
        Travel.add("Airline Offices");
        Travel.add("Travel Agency");
        Travel.add("Bus Stations");
        Travel.add("Bus Stops");
        Travel.add("Train Station");


        listDataChild.put(listDataHeader.get(12),Travel); // Header, Child data

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
