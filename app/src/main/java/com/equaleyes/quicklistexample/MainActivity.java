package com.equaleyes.quicklistexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.equaleyes.injector.Inject;
import com.equaleyes.injector.Injector;
import com.equaleyes.quicklist.QuickList;
import com.equaleyes.quicklist.listeners.OnItemClickListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnItemClickListener, View.OnClickListener {

    @Inject(id=R.id.recyclerView)
    RecyclerView recyclerView;
    ArrayList<Data> dataList = DataProvider.getData();
    QuickList<Data> quickList;
    Button buttonAddNewItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Injector.inject(this);

        buttonAddNewItem = (Button)findViewById(R.id.button);
        buttonAddNewItem.setOnClickListener(this);

        quickList = new QuickList<>(recyclerView, this);

        quickList.addClassType(Data.class);
        quickList.addClassType(DifferentData.class);

        quickList.addLayout(R.layout.row_title_subtitle);
        quickList.addLayout(R.layout.row_title_subtitle_image);

        quickList.setOnItemClickListener(this);
        //quickList.reload(dataList);
    }

    void appendData() {
        dataList.addAll(DataProvider.getData());
        quickList.reload(dataList);
    }

    @Override
    public void onItemClickListener(int position) {
        Toast.makeText(MainActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        appendData();
    }
}
