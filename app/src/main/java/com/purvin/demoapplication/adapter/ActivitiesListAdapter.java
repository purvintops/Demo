package com.purvin.demoapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.purvin.demoapplication.R;
import com.purvin.demoapplication.activity.ActivitiesDetailActivity;
import com.purvin.demoapplication.fragment.ActivitiesFragment;
import com.purvin.demoapplication.models.ActivitiesInfo;

import java.util.ArrayList;

public class ActivitiesListAdapter extends RecyclerView.Adapter<ActivitiesListAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<ActivitiesInfo> activitiesInfoArrayList = new ArrayList<>();
    private LayoutInflater inflater;
    ActivitiesFragment activitiesFragment;

    public ActivitiesListAdapter(Context mContext,
                                 ArrayList<ActivitiesInfo> activitiesInfoArrayList,
                                 ActivitiesFragment activitiesFragment) {
        this.mContext = mContext;
        this.activitiesInfoArrayList = activitiesInfoArrayList;
        inflater = LayoutInflater.from(mContext);
        this.activitiesFragment = activitiesFragment;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.adapter_activities_list_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final String activitiesDetail = activitiesInfoArrayList.get(position).getActivityDesc();
        final String activitiesTitle = activitiesInfoArrayList.get(position).getActivityTitle();

        holder.tvTitle.setText(activitiesTitle);

        holder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                activitiesFragment.ActivitiesDetailFragment(activtiesDesc);
                Intent intent = new Intent(mContext, ActivitiesDetailActivity.class);
                intent.putExtra("activitiesTitle",activitiesTitle);
                intent.putExtra("activitiesDetail",activitiesDetail);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return activitiesInfoArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle;

        public MyViewHolder(View view) {
            super(view);
            tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        }
    }

}
