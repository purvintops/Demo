package com.purvin.demoapplication.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.purvin.demoapplication.R;
import com.purvin.demoapplication.fragment.ActivitiesFragment;
import com.purvin.demoapplication.fragment.HomeFragment;
import com.purvin.demoapplication.fragment.PhotoGalleryFragment;

public class NavigationMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public Toolbar toolbar;
    FragmentManager fragmentManager;
    private boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Home");

        fragmentManager = getSupportFragmentManager(); // initialise fragmentManager

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        assert drawer != null;
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        assert navigationView != null;
        navigationView.setNavigationItemSelectedListener(this);
        /*HomeFragment homeFragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString("title","Home"); // send to < HomeFragment > or < ActivitiesFragment >
        homeFragment.setArguments(args);

        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, homeFragment)
                .commit();*/

        // TO SELECT FIRST ITEM AS DEFAULT ITEM OF NAVIGATION VIEW
        onNavigationItemSelected(navigationView.getMenu().getItem(0));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        assert drawer != null;
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

//            if (fragmentManager.getBackStackEntryCount() > 0) {
//                fragmentManager.popBackStack();
//                return;
//            }else {
                if (doubleBackToExitPressedOnce) {
                    super.onBackPressed();
                }

                this.doubleBackToExitPressedOnce = true;
                Toast.makeText(this, "Touch again to exit", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        doubleBackToExitPressedOnce = false;
                    }
                }, 2000);
//            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.navigation_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // FRAGMENT TRANSACTION
        Fragment fragment = new HomeFragment();
        String title = "";

        if (id == R.id.nav_home) {
            title = "Home";
            fragment = new HomeFragment();
        } else if (id == R.id.nav_photo_gallery) {
            title = "Photo Gallery";
            fragment = new PhotoGalleryFragment();
        } else if (id == R.id.nav_activities) {
            title = "Activities";
            fragment = new ActivitiesFragment();
        } else if (id == R.id.nav_appeal) {
            title = "Appeal";
        } else if (id == R.id.nav_registration) {
            title = "Registration";
        } else if (id == R.id.nav_about_us) {
            title = "About Us";
        } else if (id == R.id.nav_contact) {
            title = "Contact";
        } else if (id == R.id.nav_feedback) {
            title = "Feedback";
        }

        toolbar.setTitle(title);
        Bundle args = new Bundle();
        args.putString("title",title); // send to < HomeFragment > or < ActivitiesFragment >
        fragment.setArguments(args);

        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
/*.addToBackStack(null)*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        assert drawer != null;
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
