package com.equaleyes.quicklist;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.equaleyes.quicklist.binders.Binder;
import com.equaleyes.quicklist.binders.BinderFinder;
import com.equaleyes.quicklist.listeners.OnItemClickListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class QuickList<T> {

    ArrayList<T> dataList = new ArrayList<>();
    RecyclerView recyclerView;
    Context context;
    ArrayList<Class<? extends T>> classTypes = new ArrayList<>();

    ArrayList<Integer> layoutIds = new ArrayList<>();

    BinderFinder binderFinder = new BinderFinder();

    QuickListAdapter<T> quickListAdapter;

    public QuickList(Class<? extends T> classType, RecyclerView recyclerView, int layoutId, Context context) {
        this.recyclerView = recyclerView;
        this.context = context;
        this.classTypes.add(classType);
        this.layoutIds.add(layoutId);

        setupRecyclerView();
    }

    public QuickList(RecyclerView recyclerView, Context context) {
        this.recyclerView = recyclerView;
        this.context = context;
        setupRecyclerView();
    }

    public void addClassType(Class<? extends T> classType) {
        //this.classTypes.add(classType);
        quickListAdapter.classTypes.add(classType);
    }

    public void addLayout(int layout) {
        //this.layoutIds.add(layout);
        quickListAdapter.layoutIds.add(layout);
    }

    public void setupRecyclerView() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context.getApplicationContext());
        this.recyclerView.setLayoutManager(mLayoutManager);
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());

        this.quickListAdapter = new QuickListAdapter<>(classTypes, dataList, layoutIds, binderFinder, context);
        this.recyclerView.setAdapter(this.quickListAdapter);
    }

    public void reload(ArrayList<T> dataList) {
        this.dataList = dataList;
        this.quickListAdapter.reload(dataList);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        quickListAdapter.setOnItemClickListener(onItemClickListener);
    }

    public void removeOnItemClickListener(OnItemClickListener onItemClickListener) {
        quickListAdapter.removeOnItemClickListener(onItemClickListener);
    }

    public void addBinder(Binder binder) {
        this.binderFinder.addBinder(binder);
    }

    public void dataHasChanged() {
        this.quickListAdapter.notifyDataSetChanged();
    }
}
