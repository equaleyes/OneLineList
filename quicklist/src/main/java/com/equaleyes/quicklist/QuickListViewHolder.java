package com.equaleyes.quicklist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.equaleyes.quicklist.binders.Binder;
import com.equaleyes.quicklist.binders.BinderFinder;
import com.equaleyes.quicklist.utils.ResourceIdFinder;

import java.lang.reflect.Field;
import java.util.ArrayList;

class QuickListViewHolder<T> extends RecyclerView.ViewHolder {

    private View view;
    private ArrayList<Binder> binders = new ArrayList<>();

    QuickListViewHolder(View view, Class classType, Context context, BinderFinder binderFinder) {
        super(view);
        this.view = view;
        Field[] fields = classType.getDeclaredFields();

        for (Field annotatedField : fields) {
            ArrayList<Binder> bindersForField = binderFinder.findBindersForField(annotatedField);

            for (Binder binder : bindersForField) {
                int resourceId = ResourceIdFinder.getResourceId(annotatedField, binder.getAnnotationType(), context);
                binder.set(view.findViewById(resourceId), annotatedField, annotatedField.getType(), context);
                binders.add(binder);
            }
        }
    }

    void bind(T dataObject, int position) {
        for (Binder binder : binders) {
            binder.bind(dataObject, position);
        }
    }

    void setTagToView(Object object) {
        this.view.setTag(object);
    }
}
