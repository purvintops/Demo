package com.purvin.demoapplication.common;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.util.Patterns;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;


import com.purvin.demoapplication.R;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Pattern;

public class Utils implements ActivityCompat.OnRequestPermissionsResultCallback{

//    public static User_Detail ud;

    public static int CardViewFlag = 0;//0=hide close icon & 1=show close icon
    public static String GCM_token = "";

    public static ArrayList<Integer> list_sub_cat_id;

    int PERMISSION_REQUEST_CODE=0;

    public static boolean validEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public static void putinlog(String TAG, String message) {
        Log.w(TAG, message);
    }

    public String getparentPath(Context context)//for audio file storage
    {
        String path = Environment.getExternalStorageDirectory() + File.separator + "Rabbit Bike";
        File f = new File(path);
        if (!f.exists()) {
            f.mkdirs();
        }
        path += File.separator;
        return path;
    }

    public String getImagePath(Context context)
    {
        String path=getparentPath(context)+File.separator+"Images";
        File f=new File(path);
        if(!f.exists())
        {
            f.mkdirs();
        }
        path+=File.separator+System.currentTimeMillis()+".jpg";
        return path;
    }

    /**
     * Hides the soft keyboard
     */
    public static void hideSoftKeyboard(Activity activity) {
        if(activity.getCurrentFocus()!=null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
    }

    /**
     * Shows the soft keyboard
     */
    public static void showSoftKeyboard(View view,Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(activity.INPUT_METHOD_SERVICE);
        view.requestFocus();
        inputMethodManager.showSoftInput(view, 0);
    }

    public static int dp2px(Activity activity,int count){
        Resources r = activity.getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, count, r.getDisplayMetrics());
        int px1=(int)px;
        return px1;
    }

    public static String getDate(String server_date_format) {
        String date_time[] = server_date_format.split(" ");
        String date = date_time[0];

        String d[] = date.split("-");
        int datee = Integer.parseInt(d[2]);//date
        int monthh = Integer.parseInt(d[1]);//month
        int yearr = Integer.parseInt(d[0]);//year

        StringBuilder result = new StringBuilder();
        result.append("" + datee);
        switch (datee) {
            case 1:
                result.append("st");
                break;
            case 2:
                result.append("nd");
                break;
            case 3:
                result.append("rd");
                break;
            default:
                result.append("th");
                break;
        }
        result.append(" ");//9th

        switch (monthh) {
            case 1:
                result.append("January");
                break;
            case 2:
                result.append("February");
                break;
            case 3:
                result.append("March");
                break;
            case 4:
                result.append("April");
                break;
            case 5:
                result.append("May");
                break;
            case 6:
                result.append("June");
                break;
            case 7:
                result.append("July");
                break;
            case 8:
                result.append("August");
                break;
            case 9:
                result.append("September");
                break;
            case 10:
                result.append("October");
                break;
            case 11:
                result.append("November");
                break;
            case 12:
                result.append("December");
                break;
            default:
                result.append("");
                break;
        }

        result.append(", " + yearr);

        return result.toString();

    }

    public static String getTime(String server_date_format) {
        String date_time[] = server_date_format.split(" ");
        String time = date_time[1];
    //07:05:01

        String times[]=time.split(":");
        int hour=Integer.parseInt(times[0]);
        int min=Integer.parseInt(times[1]);
        int sec=Integer.parseInt(times[2]);
        StringBuilder sb=new StringBuilder();

        if(hour<13)
        sb.append(times[0]+":"+times[1]);
        else {
            if((hour-12)>9)
            sb.append((hour - 12) + ":" + times[1]);
            else
                sb.append("0"+(hour - 12) + ":" + times[1]);
        }

        if(hour<12)
            sb.append("am");
        else
            sb.append("pm");


        return sb.toString();

    }


    public static void checkPermission(Activity activity) {
        int permissionCheck = ContextCompat.checkSelfPermission(activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permissionCheck == PackageManager.PERMISSION_DENIED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {


                //Utils.putinlog(TAG,"permission not allowed");
                ActivityCompat.requestPermissions(activity,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                //return ;
            } else {
                Utils.putinlog("Permission","permission already allowed");
                //return ;
            }
        }
        //return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    Utils.putinlog("Permission","permission allowed done");
                    //allow();
                } else {

                    Utils.putinlog("Permission","permission denied");
                    //Utils.putinlog(TAG,"permission denied");
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

//    public static String getUserId(Activity activity){
//        SharedPreferences pref = activity.getSharedPreferences(PreferenceVariables.PREFNAME, activity.MODE_PRIVATE);
//
//        String user_id = pref.getString(PreferenceVariables.USER_ID, "0");
//        return user_id;
//    }

    public static String getDateDifference(String datee) {
        String date_time[] = datee.split(" ");
        String date = date_time[0];
        String time = date_time[1];

        String d[] = date.split("-");
        String t[] = time.split(":");
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt(d[0]), Integer.parseInt(d[1]) - 1, Integer.parseInt(d[2]), Integer.parseInt(t[0]), Integer.parseInt(t[1]) - 1, Integer.parseInt(t[2]));

        Calendar current_cal = Calendar.getInstance();

        long sec = ((current_cal.getTimeInMillis() - cal.getTimeInMillis()) / 1000);
        //Log.w("diff", "" + sec);
        //int day=(int) millis;
        String str = "";
        if (sec > (60 * 60 * 24 * 30)) {
            //Log.w("months ago",""+sec);
            long months = (sec / (60 * 60 * 24 * 30));

            if (months == 1)
                str = (sec / (60 * 60 * 24 * 30)) + " Month Ago";
            else
                str = (sec / (60 * 60 * 24 * 30)) + " Months Ago";

        } else if (sec > (86400)) {
            //Log.w("days ago",""+sec);
            long days = (sec / (86400));

            if (days == 1)
                str = (sec / (86400)) + " Day Ago";
            else
                str = (sec / (86400)) + " Days Ago";

        } /*else if (sec > (3600)) {
            //Log.w("hours ago",""+sec);
            long hours = (sec / (3600));

            if (hours == 1)
                str = (sec / (3600)) + " Hour Ago";
            else
                str = (sec / (3600)) + " Hours Ago";

        } else if (sec > (60)) {
            //Log.w("mins ago",""+sec);
            long mins = (sec / (60));

            if (mins == 1)
                str = (sec / (60)) + " Min Ago";
            else
                str = (sec / (60)) + " Mins Ago";

        }*/ else {

            str = "Today";

        }

        return "" + str;
    }

    public static void showAlert(final Activity activity,String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(activity);
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setTitle(""+activity.getResources().getString(R.string.app_name));
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
}
