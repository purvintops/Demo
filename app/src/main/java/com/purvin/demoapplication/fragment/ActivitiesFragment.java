package com.purvin.demoapplication.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.purvin.demoapplication.R;
import com.purvin.demoapplication.adapter.ActivitiesListAdapter;
import com.purvin.demoapplication.models.ActivitiesInfo;
import com.purvin.demoapplication.webservice.RestApi;
import com.purvin.demoapplication.webservice.Webservices_Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ActivitiesFragment extends Fragment {

    private static final String TAG = "ActivitiesFragment";
    Context mContext;

    private ArrayList<ActivitiesInfo> activitiesInfoArrayList = new ArrayList<>();
    private RecyclerView rcvActivities;

   //    FragmentManager fragmentManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_activities,container,false);
        mContext = getActivity();

        rcvActivities = (RecyclerView) view.findViewById(R.id.rcvActivities);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        assert rcvActivities != null;
        rcvActivities.setLayoutManager(mLayoutManager);
        rcvActivities.setItemAnimator(new DefaultItemAnimator());

//        getActivities();
        getData();

        return view;
    }

    private void getData(){
        // Tag used to cancel the request
        String  tag_string_req = "string_req";

        RestApi restApi = new RestApi();
        String url = restApi.getActivities();
        Log.e(TAG,"URL>>"+url);
        Webservices_Volley webservices_volley= new Webservices_Volley();
        webservices_volley.callWS(getActivity(), url, new Webservices_Volley.WebServicesCallback() {
            @Override
            public void onSuccess(String TAG, String response) {

                try {
                    JSONArray jsonArray = new JSONArray(response);
                    activitiesInfoArrayList.clear();
                    for (int i = 0; i < jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        activitiesInfoArrayList.add(new ActivitiesInfo(jsonObject));
                    }
                    ActivitiesListAdapter activitiesListAdapter = new ActivitiesListAdapter(
                                        mContext,activitiesInfoArrayList,ActivitiesFragment.this);
                    rcvActivities.setAdapter(activitiesListAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },tag_string_req);
    }

//    public void ActivitiesDetailFragment(String activitiesDetail){
//
//        ActivitiesDetailFragment fragment = new ActivitiesDetailFragment();
//        Bundle args = new Bundle();
//        args.putString("activitiesDetail",activitiesDetail); // send to < ActivitiesDetailFragment >
//        fragment.setArguments(args);
//
////        fragmentManager = getParentFragment().getChildFragmentManager(); // initialise fragmentManager
//        fragmentManager = getActivity().getSupportFragmentManager();
//        fragmentManager.beginTransaction()
//                .replace(R.id.content_frame, fragment)
//                .addToBackStack(null)
//                .commit();
//    }

//    private void getActivities(){
//
//        // Tag used to cancel the request
//        String  tag_string_req = "string_req";
//
//        String url = "http://aadarshamdavad.org/api/GetActivity.php";
//
//        final ProgressDialog pDialog = new ProgressDialog(mContext);
//        pDialog.setMessage("Loading...");
//        pDialog.show();
//
//        StringRequest strReq = new StringRequest(Request.Method.GET,url, new Response.Listener<String>() {
//
//            @Override
//            public void onResponse(String response) {
//                Log.d(TAG, response.toString());
//                pDialog.hide();
//
//                try {
//                    JSONArray jsonArray = new JSONArray(response);
//                    for (int i = 0; i < jsonArray.length(); i++){
//                        JSONObject jsonObject = jsonArray.getJSONObject(i);
//                        activitiesInfoArrayList.add(new ActivitiesInfo(jsonObject));
//                    }
//                    ActivitiesListAdapter activitiesListAdapter = new ActivitiesListAdapter ( mContext,
//                                                                            activitiesInfoArrayList,
//                                                                            ActivitiesFragment.this);
//                    rcvActivities.setAdapter(activitiesListAdapter);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                VolleyLog.d(TAG, "Error: " + error.getMessage());
//                pDialog.hide();
//            }
//        });
//        // Adding request to request queue
//        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
//    }
//    private void ActivitiesList(String Name){
//        Intent intent = new Intent(getActivity(), ActivitiesListActivity.class);
//        intent.putExtra("Name",Name);
//        startActivity(intent);
//    }
}
