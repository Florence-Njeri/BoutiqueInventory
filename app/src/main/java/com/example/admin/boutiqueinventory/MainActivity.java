package com.example.admin.boutiqueinventory;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout mdrawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Set the toolbar as the action bar
        mdrawerLayout = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (getSupportActionBar() != null) {
            assert actionBar != null;
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }

        /**
         * Handling click event for the items in the navigation drawer
         * ie what should happen when an item in the list is selected
         * @function replace() takes as input the id of the container and  pass the fragment itself
         **/
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Content to display when the app gets launched ie first item on navigation view
        getSupportFragmentManager().beginTransaction().replace
                (R.id.content_frame, new BoutiqueFragment()).commit();
        MainActivity.this.setTitle(R.string.braids);
        navigationView.setCheckedItem(R.id.braids);

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        /*Define what should happen on clicking each item ie open fragment and display it in the frame layout

         */
        switch (menuItem.getItemId()) {
            case R.id.braids:
                getSupportFragmentManager().beginTransaction().replace
                        (R.id.content_frame, new BoutiqueFragment()).commit();

                break;
            case R.id.weaves:
                getSupportFragmentManager().beginTransaction().replace
                        (R.id.content_frame, new BoutiqueFragment()).commit();
                break;
            case R.id.oil:
                getSupportFragmentManager().beginTransaction().replace
                        (R.id.content_frame, new BoutiqueFragment()).commit();
                break;
            default:
                Toast.makeText(MainActivity.this, "Other inventory is shown here!!", Toast.LENGTH_SHORT).show();
                break;
        }
        // set item as selected to persist highlight
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());

        // close drawer when item is tapped
        mdrawerLayout.closeDrawer(GravityCompat.START);

        // Add code here to update the UI based on the item selected
        // For example, swap UI fragments here


        return true;
    }

    /*
     * Open drawer when the button is tapped
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mdrawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.search:

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Find the search bar to get Inflated on the toolbar
        getMenuInflater().inflate(R.menu.search_bar, menu);
        //return true to display your menu item
        return true;
    }
}
