package com.equaleyes.onelinelistexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.equaleyes.injector.Inject;
import com.equaleyes.injector.Injector;
import com.equaleyes.onelinelist.OneLineList;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Inject(id=R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Injector.inject(this);

        ArrayList<Data> datas = DataProvider.getData();
        OneLineList<Data> oneLineList = new OneLineList<>(Data.class, datas, recyclerView, R.layout.row, this);
    }
}
