package com.purvin.demoapplication.webservice;

import android.app.Activity;
import android.app.ProgressDialog;
import android.util.Base64;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.purvin.demoapplication.R;
import com.purvin.demoapplication.common.ConnectionDetector;
import com.purvin.demoapplication.common.Utils;

import java.util.HashMap;
import java.util.Map;

public class Webservices_Volley {

    ConnectionDetector cd;
    ProgressDialog dialog;
    WebServicesCallback callback;
    final String TAG="Webservices_Volley";
    /*public void callWS(final Activity activity, String url, final WebServicesCallback callback,final Map<String, String> params,final String TAG){

    }*/

    public void callWS(final Activity activity, String url, final WebServicesCallback callback,final Map<String, String> params,final String TAG) {
        cd = new ConnectionDetector(activity);
        dialog = new ProgressDialog(activity);
        dialog.setMessage("Please wait");
        dialog.setCancelable(false);
        this.callback=callback;
        Utils.putinlog(TAG,""+params.toString());

        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        dialog.dismiss();
                        Utils.putinlog(TAG,"responce: "+response);
                        callback.onSuccess(TAG,response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        dialog.dismiss();
                        error.printStackTrace();
                        Utils.showToast(activity,activity.getResources().getString(R.string.server_connection_error));
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                String creds = String.format("%s:%s","admin","1234");
                String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                params.put("Authorization", auth);
                return params;
            }
        };

        if (cd.isConnectingToInternet()) {
            dialog.show();

            postRequest.setRetryPolicy(new DefaultRetryPolicy(50000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            Volley.newRequestQueue(activity).add(postRequest);
        } else {
            Utils.showToast(activity, activity.getResources().getString(R.string.internet_connection_error));
        }
    }

    public void callWSwithoutDialog(final Activity activity, String url, final WebServicesCallback callback,final Map<String, String> params,final String TAG) {
        cd = new ConnectionDetector(activity);
        dialog = new ProgressDialog(activity);
        dialog.setMessage("Please wait");
        dialog.setCancelable(false);
        this.callback=callback;

        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //dialog.dismiss();
                        Utils.putinlog(TAG,"responce: "+response);
                        callback.onSuccess(TAG,response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //dialog.dismiss();
                        error.printStackTrace();

                        //Utils.showToast(activity,activity.getResources().getString(R.string.server_connection_error));
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                String creds = String.format("%s:%s","admin","1234");
                String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                params.put("Authorization", auth);
                return params;
            }
        };

        if (cd.isConnectingToInternet()) {
            //dialog.show();

            postRequest.setRetryPolicy(new DefaultRetryPolicy(50000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            Volley.newRequestQueue(activity).add(postRequest);
        } else {
            Utils.putinlog(TAG, activity.getResources().getString(R.string.internet_connection_error));
        }
    }

    public void callWS(final Activity activity, String url, final WebServicesCallback callback,final String TAG) {
        cd = new ConnectionDetector(activity);
        dialog = new ProgressDialog(activity);
        dialog.setMessage("Please wait");
        dialog.setCancelable(false);
        this.callback=callback;

        StringRequest postRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        dialog.dismiss();
                        Utils.putinlog(TAG,"response: "+response);
                        callback.onSuccess(TAG,response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        dialog.dismiss();
                        error.printStackTrace();
                        Utils.showToast(activity,activity.getResources().getString(R.string.server_connection_error));
                    }
                }
        ); /*{
           *//* @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                String creds = String.format("%s:%s","admin","1234");
                String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                params.put("Authorization", auth);
                return params;
            }*//*
        };*/

        if (cd.isConnectingToInternet()) {
            dialog.show();

            postRequest.setRetryPolicy(new DefaultRetryPolicy(50000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            Volley.newRequestQueue(activity).add(postRequest);
        } else {
            Utils.showToast(activity, activity.getResources().getString(R.string.internet_connection_error));
        }
    }

    public void callWSwithoutDialog(final Activity activity, String url, final WebServicesCallback callback,final String TAG) {
        cd = new ConnectionDetector(activity);
        dialog = new ProgressDialog(activity);
        dialog.setMessage("Please wait");
        dialog.setCancelable(false);
        this.callback=callback;

        StringRequest postRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //dialog.dismiss();
                        Utils.putinlog(TAG,"responce: "+response);
                        callback.onSuccess(TAG,response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //dialog.dismiss();
                        error.printStackTrace();

                        //Utils.showToast(activity,activity.getResources().getString(R.string.server_connection_error));
                    }
                }
        ); /*{
           *//* @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                String creds = String.format("%s:%s","admin","1234");
                String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                params.put("Authorization", auth);
                return params;
            }*//*
        };*/

        if (cd.isConnectingToInternet()) {
            //dialog.show();

            postRequest.setRetryPolicy(new DefaultRetryPolicy(50000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            Volley.newRequestQueue(activity).add(postRequest);
        } else {
            Utils.showToast(activity, activity.getResources().getString(R.string.internet_connection_error));
        }
    }

    public interface WebServicesCallback {
        public void onSuccess(String TAG, String response);
    }

    public void callWSnoAuthorization(final Activity activity, String url, final WebServicesCallback callback,final Map<String, String> params,final String TAG) {
        cd = new ConnectionDetector(activity);
        dialog = new ProgressDialog(activity);
        dialog.setMessage("Please wait");
        dialog.setCancelable(false);
        this.callback=callback;
        Utils.putinlog(TAG,""+params.toString());

        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        dialog.dismiss();
                        Utils.putinlog(TAG,"responce: "+response);
                        callback.onSuccess(TAG,response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        dialog.dismiss();
                        error.printStackTrace();
                        Utils.showToast(activity,activity.getResources().getString(R.string.server_connection_error));
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                /*String creds = String.format("%s:%s","admin","1234");
                String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                params.put("Authorization", auth);*/
                return params;
            }
        };

        if (cd.isConnectingToInternet()) {
            dialog.show();

            postRequest.setRetryPolicy(new DefaultRetryPolicy(50000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            Volley.newRequestQueue(activity).add(postRequest);
        } else {
            Utils.showToast(activity, activity.getResources().getString(R.string.internet_connection_error));
        }
    }

}
