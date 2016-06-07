package com.purvin.demoapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.purvin.demoapplication.R;
import com.purvin.demoapplication.common.Utils;
import com.purvin.demoapplication.models.Gallery;

import java.util.ArrayList;

public class PhotoGalleryViewActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    public Toolbar toolbar;
    public ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_gallery_view);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.

        Intent intent = getIntent(); // Comes from < PhotoGalleryFragment > => < PhotoGalleryListAdapter >
//        ArrayList<GalleryInfo> galleryInfoArrayList = intent.getParcelableArrayListExtra("gallery");
        ArrayList<Gallery> galleryInfoArrayList = intent.getParcelableArrayListExtra("gallery");

        actionBar = getSupportActionBar();
        if (actionBar!=null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        if (galleryInfoArrayList.size() > 0){
            actionBar.setTitle(galleryInfoArrayList.get(0).getName());
            mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(),galleryInfoArrayList);
        }else {
            actionBar.setTitle("No Data");
            Utils.showToast(PhotoGalleryViewActivity.this,"There is no Photos in this category.");
        }


        // Set up the ViewPager with the sections adapter.
        /*
      The {@link ViewPager} that will host the section contents.
     */
        ViewPager mViewPager = (ViewPager) findViewById(R.id.container);
        assert mViewPager != null;
        mViewPager.setAdapter(mSectionsPagerAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_photo_gallery_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        private Gallery galleryInfo;

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber,Gallery galleryInfo) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            args.putParcelable("galleryinfo",galleryInfo);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle bundle= getArguments();
            galleryInfo = bundle.getParcelable("galleryinfo");
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_photo_gallery_view, container, false);
            ImageView ivGallery = (ImageView) rootView.findViewById(R.id.ivGallery);

            ((PhotoGalleryViewActivity) getActivity()).actionBar.setTitle(galleryInfo.getName());

            /*Picasso.with(getActivity())
                    .load(galleryInfo.getPath()).fit()
                    .placeholder(getResources().getDrawable(R.drawable.placeholder)).into(ivGallery);*/

            Glide.with(getActivity())
                    .load(galleryInfo.getPath()).crossFade(200)
                    .placeholder(getResources().getDrawable(R.drawable.placeholder)).into(ivGallery);

            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        ArrayList<Gallery> galleryInfoArrayList = new ArrayList<>();
        public SectionsPagerAdapter(FragmentManager fm, ArrayList<Gallery> galleryInfoArrayList) {
            super(fm);
            this.galleryInfoArrayList = galleryInfoArrayList;
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1,galleryInfoArrayList.get(position));
        }

        @Override
        public int getCount() {
            return galleryInfoArrayList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }
    }
}
