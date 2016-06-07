package com.purvin.demoapplication.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.purvin.demoapplication.R;
import com.purvin.demoapplication.adapter.ActivitiesListAdapter;

import java.util.ArrayList;

public class ActivitiesListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities_list);

        Context mContext = this;
        Intent intent = getIntent();        // come from < ActivitiesFragment >
        String Name = intent.getStringExtra("Name");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle(Name);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        ArrayList<String> stringArrayList = new ArrayList<>();
        for (int i=0; i<10; i++){
            stringArrayList.add(Name+" "+i);
        }

        RecyclerView rcvActivities = (RecyclerView) findViewById(R.id.rcvActivities);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        assert rcvActivities != null;
        rcvActivities.setLayoutManager(mLayoutManager);
        rcvActivities.setItemAnimator(new DefaultItemAnimator());

//        ActivitiesListAdapter activitiesListAdapter = new ActivitiesListAdapter(mContext, stringArrayList);
//        rcvActivities.setAdapter(activitiesListAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home :
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
