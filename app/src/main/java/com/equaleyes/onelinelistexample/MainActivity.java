package com.equaleyes.onelinelistexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.equaleyes.injector.Inject;
import com.equaleyes.injector.Injector;
import com.equaleyes.onelinelist.OneLineList;
import com.equaleyes.onelinelist.listeners.OnItemClickListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    @Inject(id=R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Injector.inject(this);

        ArrayList<Data> datas = DataProvider.getData();
        OneLineList<Data> oneLineList = new OneLineList<>(Data.class, datas, recyclerView, R.layout.row, this);
        oneLineList.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClickListener(int position) {

            }
        });
    }

    @Override
    public void onItemClickListener(int position) {

    }
}
