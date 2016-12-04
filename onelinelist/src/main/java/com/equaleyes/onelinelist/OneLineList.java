package com.equaleyes.onelinelist;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.equaleyes.onelinelist.binders.Binder;
import com.equaleyes.onelinelist.binders.BinderFinder;
import com.equaleyes.onelinelist.listeners.OnItemClickListener;

import java.util.ArrayList;

public class OneLineList<T> {

    ArrayList<T> dataList;
    RecyclerView recyclerView;
    Context context;
    Class<T> classType;
    int layoutId;
    BinderFinder binderFinder = new BinderFinder();

    OneLineListAdapter<T> oneLineListAdapter;

    public OneLineList(Class<T> classType, ArrayList<T> dataList, RecyclerView recyclerView, int layoutId, Context context) {
        this.dataList = dataList;
        this.recyclerView = recyclerView;
        this.context = context;
        this.classType = classType;
        this.layoutId = layoutId;

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        this.oneLineListAdapter = new OneLineListAdapter<>(classType, dataList, layoutId, binderFinder, context);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context.getApplicationContext());
        this.recyclerView.setLayoutManager(mLayoutManager);
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.recyclerView.setAdapter(this.oneLineListAdapter);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        oneLineListAdapter.setOnItemClickListener(onItemClickListener);
    }

    public void removeOnItemClickListener(OnItemClickListener onItemClickListener) {
        oneLineListAdapter.removeOnItemClickListener(onItemClickListener);
    }

    public void addBinder(Binder binder) {
        this.binderFinder.addBinder(binder);
    }

    public void dataHasChanged() {
        this.oneLineListAdapter.notifyDataSetChanged();
    }
}
