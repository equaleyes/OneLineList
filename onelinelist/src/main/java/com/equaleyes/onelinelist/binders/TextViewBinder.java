package com.equaleyes.onelinelist.binders;

import android.widget.TextView;
import com.equaleyes.onelinelist.annotations.Text;
import java.lang.annotation.Annotation;

public class TextViewBinder extends Binder<String> {

    @Override
    public Class<? extends Annotation> getAnnotationType() {
        return Text.class;
    }

    @Override
    public void bindDataToView(String data) {
        ((TextView)view).setText(data);
    }
}