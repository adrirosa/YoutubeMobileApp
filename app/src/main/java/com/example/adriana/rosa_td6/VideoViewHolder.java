package com.example.adriana.rosa_td6;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


public class VideoViewHolder extends RecyclerView.ViewHolder {

    private TextView title;
    private TextView description;
    private TextView publishedAt;
    private TextView channelTitle;
    private TextView thumbnails;
    private OnVideoSelectedListener onVideoSelectedListener;

    public VideoViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.titleTextView);
        description = (TextView) itemView.findViewById(R.id.descriptionTextView);
        publishedAt = (TextView) itemView.findViewById(R.id.publishedAtTextView);
        channelTitle = (TextView) itemView.findViewById(R.id.channelTitleTextView);
        thumbnails = (TextView) itemView.findViewById(R.id.thumbnailsTextView);
    }

    public void bind(final Video video) {
        title.setText(video.getTitle());
        description.setText(video.getDescription());
        publishedAt.setText(video.getPublishedAt());
        channelTitle.setText(video.getChannelTitle());
        thumbnails.setText(video.getThumbnails());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onVideoSelectedListener == null) {
                    return;
                }
                onVideoSelectedListener.onVideoSelected(video);
            }
        });
    }

    public void setOnVideoSelectedListener(OnVideoSelectedListener onVideoSelectedListener) {
        this.onVideoSelectedListener = onVideoSelectedListener;
    }
}
