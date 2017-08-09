package com.example.cr.audioplayer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    List<Audio> lsit = Collections.emptyList();
    Context context;

    public RecyclerAdapter(List<Audio> lsit, Context context)
    {
        this.lsit = lsit;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {

    }

    @Override
    public int getItemCount()
    {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView;
        ImageView imageView;

        public ViewHolder(View itemView)
        {
            super(itemView);
            //textView = itemView.findViewById(R.id.t)

        }
    }
}
