package com.equaleyes.quicklist.binders;

import android.graphics.Color;
import android.widget.TextView;

import com.equaleyes.quicklist.annotations.TextColor;

import java.lang.annotation.Annotation;

class TextViewTextColorBinder extends Binder<String> {

    @Override
    public Class<? extends Annotation> getAnnotationType() {
        return TextColor.class;
    }

    @Override
    protected void bindDataToView(String data) {
        ((TextView)view).setTextColor(Color.parseColor(data));
    }
}