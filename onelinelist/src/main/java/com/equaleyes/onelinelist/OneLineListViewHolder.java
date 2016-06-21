package com.equaleyes.onelinelist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.equaleyes.onelinelist.binders.Binder;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class OneLineListViewHolder<T> extends RecyclerView.ViewHolder {

    private View view;
    private ArrayList<Binder> binders = new ArrayList<>();

    public OneLineListViewHolder(View view, Class classType, Context context, BinderFinder binderFinder) {
        super(view);
        this.view = view;
        Field[] fields = classType.getDeclaredFields();

        for(Field annotatedField : fields) {
            ArrayList<Binder> bindersForField = binderFinder.findBindersForField(annotatedField);

            for (Binder binder : bindersForField) {
                int resourceId = ResourceIdFinder.getResourceId(annotatedField, binder.getAnnotationType(), context);
                binder.set(view.findViewById(resourceId), annotatedField, annotatedField.getType(), context);
                binders.add(binder);
            }
        }
    }

    public void bind(T dataObject, int position) {
        for (Binder binder : binders) {
            binder.bind(dataObject, position);
        }
    }

    public void setTagToView(Object object) {
        this.view.setTag(object);
    }
}
