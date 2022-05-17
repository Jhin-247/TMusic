package com.example.th1.helper;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class ImageHelper {

    public static void setImage(Context context, ImageView view, String resource){
        Glide.with(context).load(resource).centerCrop().into(view);
    }

    public static void setRoundImage(Context context, ImageView imageView, String resource){
        Glide.with(context).load(resource).apply(RequestOptions.circleCropTransform()).into(imageView);
    }

}
