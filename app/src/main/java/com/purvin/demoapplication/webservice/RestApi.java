package com.purvin.demoapplication.webservice;

import android.net.Uri;

public class RestApi {

    public String getActivities(){
        String uri = Uri.parse(Webservices.BASE_URL+Webservices.GET_ACTIVITIES).buildUpon().build().toString();
        return uri;
    }

    public String getPhoto(){
        String uri = Uri.parse(Webservices.BASE_URL+Webservices.GET_PHOTOS).buildUpon().build().toString();
        return uri;
    }
}
