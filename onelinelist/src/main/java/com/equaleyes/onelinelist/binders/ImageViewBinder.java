package com.equaleyes.onelinelist.binders;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.equaleyes.onelinelist.annotations.Image;

import java.lang.annotation.Annotation;

public class ImageViewBinder extends Binder<String> {

    @Override
    public Class<? extends Annotation> getAnnotationType() {
        return Image.class;
    }

    @Override
    protected void bindDataToView(String data) {
        Glide.with(context)
                .load(data)
                .into((ImageView) view);
    }
}
