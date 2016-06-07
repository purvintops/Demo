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

import com.google.gson.Gson;
import com.purvin.demoapplication.BuildConfig;
import com.purvin.demoapplication.R;
import com.purvin.demoapplication.adapter.PhotoGalleryListAdapter;
import com.purvin.demoapplication.models.PhotoGalleryInfo;
import com.purvin.demoapplication.models.PhotoInfo;
import com.purvin.demoapplication.webservice.RestApi;
import com.purvin.demoapplication.webservice.Webservices_Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PhotoGalleryFragment extends Fragment {

    private static final String TAG = "ActivitiesFragment";
    Context mContext;
    Gson gson;

    private RecyclerView rcvPhotoGallery;
    ArrayList<PhotoInfo> photoInfoArrayList = new ArrayList<>();
    List<PhotoGalleryInfo> photoGalleryInfoArrayList = new ArrayList<>();
    private PhotoGalleryListAdapter photoGalleryListAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_photo_gallery, container, false);
        mContext = getActivity();

        rcvPhotoGallery = (RecyclerView) view.findViewById(R.id.rcvPhotoGallery);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        assert rcvPhotoGallery != null;
        rcvPhotoGallery.setLayoutManager(mLayoutManager);
        rcvPhotoGallery.setItemAnimator(new DefaultItemAnimator());
        gson = new Gson();

        getPhotoList();

        return view;
    }


    private void getPhotoList() {
        // Tag used to cancel the request
        String tag_string_req = "string_req";

        RestApi restApi = new RestApi();
        String url = restApi.getPhoto();
        if (BuildConfig.DEBUG)
            Log.e(TAG, "URL>> " + url);

        Webservices_Volley webservices_volley = new Webservices_Volley();

        webservices_volley.callWS(getActivity(), url, new Webservices_Volley.WebServicesCallback() {
            @Override
            public void onSuccess(String TAG, String response) {

                try {
                    JSONArray jsonArray = new JSONArray(response);
                    // clear data for second time calling the webservice
                    photoInfoArrayList.clear();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject mainJsonObject = jsonArray.getJSONObject(i);
                        PhotoGalleryInfo photoGalleryInfo = gson.fromJson(mainJsonObject.toString(), PhotoGalleryInfo.class);
                        photoGalleryInfoArrayList.add(photoGalleryInfo);
                    }

                    // Set Data in adapter
                    photoGalleryListAdapter = new PhotoGalleryListAdapter(mContext, photoGalleryInfoArrayList);
                    rcvPhotoGallery.setAdapter(photoGalleryListAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, tag_string_req);
    }

//    private void getPhotoList2() {
//        // Tag used to cancel the request
//        String tag_string_req = "string_req";
//
//        RestApi restApi = new RestApi();
//        String url = restApi.getPhoto();
//        if (BuildConfig.DEBUG)
//            Log.e(TAG, "URL>> " + url);
//
//        Webservices_Volley webservices_volley = new Webservices_Volley();
//
//        webservices_volley.callWS(getActivity(), url, new Webservices_Volley.WebServicesCallback() {
//            @Override
//            public void onSuccess(String TAG, String response) {
//                try {
//                    JSONArray jsonArray = new JSONArray(response);
//                    if (jsonArray != null) {
//                        // clear data for second time calling the webservice
//                        photoInfoArrayList.clear();
//                        for (int i = 0; i < jsonArray.length(); i++) {
//                            JSONObject mainJsonObject = jsonArray.getJSONObject(i);
//
//
//                            JSONArray galleryJsonArray = mainJsonObject.getJSONArray("gallery");
//                            galleryInfoArrayList.clear();
//                            if (galleryJsonArray != null) {
//                                for (int j = 0; j < galleryJsonArray.length(); j++) {
//                                    JSONObject galleryJsonObject = galleryJsonArray.getJSONObject(j);
//                                    galleryInfoArrayList.add(new GalleryInfo(galleryJsonObject));
//                                }
//                            }
//                            photoInfoArrayList.add(new PhotoInfo(mainJsonObject, galleryInfoArrayList));
//                        }
//                        // Set Data in adapter
//                        photoGalleryListAdapter = new PhotoGalleryListAdapter(mContext, photoInfoArrayList);
//                        rcvPhotoGallery.setAdapter(photoGalleryListAdapter);
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, tag_string_req);
//    }
}