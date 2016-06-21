package com.equaleyes.onelinelist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.equaleyes.onelinelist.listeners.OnItemClickListener;
import com.equaleyes.onelinelist.utils.ArrayListUtils;

import java.util.ArrayList;

public class OneListAdapter<T> extends RecyclerView.Adapter<OneLineListViewHolder<T>> implements View.OnClickListener {

    int layoutId;
    Class classType;
    Context context;
    ArrayList<T> dataList;
    ArrayList<OnItemClickListener> onItemClickListeners = new ArrayList<>();
    BinderFinder binderFinder;

    public OneListAdapter(Class classType, ArrayList<T> dataList, int layoutId, BinderFinder binderFinder, Context context) {
        this.layoutId = layoutId;
        this.dataList = dataList;
        this.classType = classType;
        this.context = context;
        this.binderFinder = binderFinder;
    }

    @Override
    public OneLineListViewHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(layoutId, parent, false);
        view.setOnClickListener(this);

        return new OneLineListViewHolder<>(view, classType, context, binderFinder);
    }

    @Override
    public void onBindViewHolder(OneLineListViewHolder<T> holder, int position) {
        holder.setTagToView(position);
        holder.bind(dataList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public void onClick(View v) {
        for (OnItemClickListener onItemClickedListener : onItemClickListeners) {
            int index = (int) v.getTag();
            onItemClickedListener.onItemClickListener(index);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        ArrayListUtils.insertIfNotYetInList(onItemClickListeners, onItemClickListener);
    }

    public void removeOnItemClickListener(OnItemClickListener onItemClickListener) {
        ArrayListUtils.removeFromList(onItemClickListeners, onItemClickListener);
    }
}