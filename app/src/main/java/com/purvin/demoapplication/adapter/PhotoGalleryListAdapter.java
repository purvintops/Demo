package com.purvin.demoapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.purvin.demoapplication.R;
import com.purvin.demoapplication.activity.PhotoGalleryViewActivity;
import com.purvin.demoapplication.models.Gallery;
import com.purvin.demoapplication.models.PhotoGalleryInfo;

import java.util.ArrayList;
import java.util.List;

public class PhotoGalleryListAdapter extends RecyclerView.Adapter<PhotoGalleryListAdapter.MyViewHolder> {

    private Context mContext;
//    private ArrayList<PhotoInfo> photoInfoArrayList = new ArrayList<>();
    private List<PhotoGalleryInfo> photoInfoArrayList = new ArrayList<>();
//    private ArrayList<GalleryInfo> galleryInfoArrayList = new ArrayList<>();
    private LayoutInflater inflater;

//    public PhotoGalleryListAdapter(Context mContext, ArrayList<PhotoInfo> photoInfoArrayList,ArrayList<GalleryInfo> galleryInfoArrayList) {
//        this.mContext = mContext;
////        this.photoInfoArrayList = photoInfoArrayList;
//        this.galleryInfoArrayList = galleryInfoArrayList;
//        inflater = LayoutInflater.from(mContext);
//    }

    public PhotoGalleryListAdapter(Context mContext, List<PhotoGalleryInfo> photoInfoArrayList) {
        this.mContext = mContext;
        this.photoInfoArrayList = photoInfoArrayList;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.adapter_activities_list_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

//        PhotoInfo photoInfo = photoInfoArrayList.get(position);
        final PhotoGalleryInfo photoInfo = photoInfoArrayList.get(position);
        String Name = photoInfo.getName();
        holder.tvTitle.setText(Name);
//        galleryInfoArrayList = photoInfo.getGalleryInfoArrayList();

        final ArrayList<Gallery> galleries = (ArrayList<Gallery>) photoInfo.getGallery();

        holder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PhotoGalleryViewActivity.class);
                intent.putParcelableArrayListExtra("gallery",galleries);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return photoInfoArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle;

        public MyViewHolder(View view) {
            super(view);
            tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        }
    }
}
