package com.equaleyes.onelinelist;

import com.equaleyes.onelinelist.binders.Binder;

import java.lang.annotation.Annotation;

public class CorruptedBinder extends Binder<String> {

    @Override
    public Class<? extends Annotation> getAnnotationType() {
        return null;
    }

    @Override
    protected void bindDataToView(String data) {

    }
}
