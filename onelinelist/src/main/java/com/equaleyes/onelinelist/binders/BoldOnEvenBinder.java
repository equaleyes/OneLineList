package com.equaleyes.onelinelist.binders;

import android.graphics.Typeface;
import android.widget.TextView;

import com.equaleyes.onelinelist.annotations.BoldOnEven;

import java.lang.annotation.Annotation;

public class BoldOnEvenBinder extends Binder {

    @Override
    public Class<? extends Annotation> getAnnotationType() {
        return BoldOnEven.class;
    }

    @Override
    protected void bindDataToView(Object data) {
        if (position % 2 == 0) {
            ((TextView)view).setTypeface(null, Typeface.BOLD);}
        else {
            ((TextView)view).setTypeface(null, Typeface.NORMAL);
        }
    }
}