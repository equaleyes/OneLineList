package com.equaleyes.quicklist.binders;

import android.widget.TextView;
import com.equaleyes.quicklist.annotations.Text;
import java.lang.annotation.Annotation;

class TextViewBinder extends Binder<String> {

    @Override
    public Class<? extends Annotation> getAnnotationType() {
        return Text.class;
    }

    @Override
    public void bindDataToView(String data) {
        ((TextView)view).setText(data);
    }
}