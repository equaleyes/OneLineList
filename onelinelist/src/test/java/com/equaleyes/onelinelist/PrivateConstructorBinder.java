package com.equaleyes.onelinelist;

import com.equaleyes.onelinelist.annotations.Text;
import com.equaleyes.onelinelist.binders.Binder;

import java.lang.annotation.Annotation;

public class PrivateConstructorBinder extends Binder<String> {

    public static PrivateConstructorBinder getNewInstance() {
        return new PrivateConstructorBinder();
    }

    private PrivateConstructorBinder() {

    }

    @Override
    public Class<? extends Annotation> getAnnotationType() {
        return Text.class;
    }

    @Override
    protected void bindDataToView(String data) {

    }
}
