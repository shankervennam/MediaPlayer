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

public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder>
{
    List<Audio> lsit = Collections.emptyList();
    Context context;

    public RecyclerAdapter(List<Audio> lsit, Context context)
    {
        this.lsit = lsit;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(lsit.get(position).getTitle());
    }

    @Override
    public int getItemCount()
    {
        return lsit.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
class ViewHolder extends RecyclerView.ViewHolder
{
    TextView textView;
    ImageView imageView;

    public ViewHolder(View itemView)
    {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.title);
        imageView = (ImageView) itemView.findViewById(R.id.play_pause);
    }
}