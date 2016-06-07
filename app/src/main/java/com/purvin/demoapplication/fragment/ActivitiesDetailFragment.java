package com.purvin.demoapplication.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.purvin.demoapplication.R;

public class ActivitiesDetailFragment extends Fragment {

    private Context mContext;
    private WebView webView_activities;

    @SuppressLint("SetJavaScriptEnabled")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_activities_detail,container,false);

        mContext = getActivity();
        webView_activities = (WebView) view.findViewById(R.id.webView_activities);
        webView_activities.getSettings().setJavaScriptEnabled(true);

        Bundle bundle = getArguments(); // Comes from < ActivitiesFragment >
        String activities_detail = bundle.getString("activitiesDetail");

        webView_activities.loadDataWithBaseURL("", activities_detail, "text/html","UTF-8", "");
        return view;
    }
}
