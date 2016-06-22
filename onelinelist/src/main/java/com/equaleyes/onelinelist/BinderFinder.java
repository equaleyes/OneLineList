package com.equaleyes.onelinelist;

import com.equaleyes.onelinelist.binders.Binder;
import com.equaleyes.onelinelist.binders.BoldOnEvenBinder;
import com.equaleyes.onelinelist.binders.CheckBoxBinder;
import com.equaleyes.onelinelist.binders.ImageViewBinder;
import com.equaleyes.onelinelist.binders.TextViewBinder;
import com.equaleyes.onelinelist.binders.TextViewTextColorBinder;
import com.equaleyes.onelinelist.utils.ArrayListUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class BinderFinder {

    ArrayList<Binder> binders = new ArrayList<>();

    public BinderFinder() {
        binders.add(new TextViewBinder());
        binders.add(new TextViewTextColorBinder());
        binders.add(new BoldOnEvenBinder());
        binders.add(new ImageViewBinder());
        binders.add(new CheckBoxBinder());
        binders.add(new TextViewTextColorBinder());
    }

    public ArrayList<Binder> findBindersForField(Field field) {
        ArrayList<Binder> bindersForField = new ArrayList<>();

        for (Binder binder : binders) {

            Class<? extends Annotation> annotationTypeForBinder = binder.getAnnotationType();

            if (annotationTypeForBinder != null) {
                if (field.isAnnotationPresent(annotationTypeForBinder)) {
                    try {
                        bindersForField.add(binder.getClass().newInstance());
                    } catch (InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return bindersForField;
    }

    public void addBinder(Binder binder) {
        ArrayListUtils.insertIfNotYetInList(binders, binder);
    }
}
