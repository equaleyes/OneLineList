package com.equaleyes.onelinelist.binders;

import android.graphics.Color;
import android.widget.TextView;

import com.equaleyes.onelinelist.annotations.TextColor;

import java.lang.annotation.Annotation;

public class TextViewTextColorBinder extends Binder {

    @Override
    public Class<? extends Annotation> getAnnotationType() {
        return TextColor.class;
    }

    @Override
    protected void bindDataToView(Object data) {
        ((TextView)view).setTextColor(Color.parseColor((String)data));
    }
}
