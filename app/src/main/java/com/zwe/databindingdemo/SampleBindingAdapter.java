package com.zwe.databindingdemo;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Asus on 2017/7/23.
 */

public class SampleBindingAdapter {
    @BindingAdapter({"imageUrl","placeholder"})
    public static void loadImageFormUrl(ImageView imageView, String url, Drawable drawable){
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(drawable)
                .into(imageView);
    }
}
