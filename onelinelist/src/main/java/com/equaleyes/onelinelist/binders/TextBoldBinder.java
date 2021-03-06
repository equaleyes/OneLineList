package com.equaleyes.onelinelist.binders;

import android.graphics.Typeface;
import android.widget.TextView;

import com.equaleyes.onelinelist.annotations.TextBold;

import java.lang.annotation.Annotation;

public class TextBoldBinder extends Binder<Boolean> {

    @Override
    public Class<? extends Annotation> getAnnotationType() {
        return TextBold.class;
    }

    @Override
    protected void bindDataToView(Boolean data) {

        boolean bold = data;

        if (bold) {
        ((TextView)view).setTypeface(null, Typeface.BOLD);}
        else {
            ((TextView)view).setTypeface(null, Typeface.NORMAL);
        }


    }
}
