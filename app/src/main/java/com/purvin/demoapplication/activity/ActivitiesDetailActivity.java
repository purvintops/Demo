package com.purvin.demoapplication.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;

import com.purvin.demoapplication.R;

public class ActivitiesDetailActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent(); // Comes from < ActivitiesFragment > => < ActivitiesListAdapter >
        assert intent != null;
        String activities_detail = intent.getStringExtra("activitiesDetail");
        String activitiesTitle = intent.getStringExtra("activitiesTitle");

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle(activitiesTitle);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        WebView webView_activities = (WebView) findViewById(R.id.webView_activities);
        assert webView_activities != null;
        webView_activities.getSettings().setJavaScriptEnabled(true);
        webView_activities.loadDataWithBaseURL("", activities_detail, "text/html","UTF-8", "");
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
