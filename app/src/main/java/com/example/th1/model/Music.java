package com.example.th1.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestOptions;

import java.io.Serializable;

public class Music implements Serializable {
    private String path;
    private String title;
    private String duration;
    private String avatar;
    private String artist;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Music(String path, String title, String duration,String artist, String avatarPath) {
        this.path = path;
        this.title = title;
        this.duration = duration;
        this.avatar = avatarPath;
        this.artist = artist;
    }

    public Music() {
    }

    public Music(String path, String title, String duration) {
        this.path = path;
        this.title = title;
        this.duration = duration;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Music(String path, String title, String duration, String artist) {
        this.path = path;
        this.title = title;
        this.duration = duration;
        this.artist = artist;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @BindingAdapter({ "avatar" })
    public static void loadImage(ImageView imageView, String imageURL) {
        RequestOptions requestOptions = new RequestOptions()
                .transform(new GranularRoundedCorners(20f,20f,20f,20f));

        Glide.with(imageView.getContext())
                .setDefaultRequestOptions(new RequestOptions()
                        .circleCrop())
                .load(imageURL)
                .into(imageView);
    }
}
