package com.example.adriana.rosa_td6;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *  Java class Video for the listview
 */

public class Video {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("publishedAt")
    @Expose
    private String publishedAt;
    @SerializedName("channelTitle")
    @Expose
    private String channelTitle;
    @SerializedName("thumbnails")
    @Expose
    private String thumbnails;


    public Video(String title, String description, String publishedAt, String channelTitle, String thumbnails) {
        this.title = title;
        this.description = description;
        this.publishedAt = publishedAt;
        this.channelTitle = channelTitle;
        this.thumbnails = thumbnails;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAd) {
        this.publishedAt = publishedAd;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public String getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(String thumbnails) {
        this.thumbnails = thumbnails;
    }
}