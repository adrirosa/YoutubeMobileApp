package com.example.adriana.rosa_td6;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoViewHolder>{
    private List<VideoItem.ItemsBean> itemsBeen;
    private OnVideoSelectedListener onVideoSelectedListener;

    public VideoAdapter(List<VideoItem.ItemsBean> itemsBeen) {
        this.itemsBeen = itemsBeen;
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {
        holder.setOnVideoSelectedListener(onVideoSelectedListener);
        holder.bind(itemsBeen.get(position));
    }

    @Override
    public int getItemCount() {
        return itemsBeen != null ? itemsBeen.size() : 0;
    }

    public void setOnVideoSelectedListener(OnVideoSelectedListener onVideoSelectedListener) {
        this.onVideoSelectedListener = onVideoSelectedListener;
    }
}
