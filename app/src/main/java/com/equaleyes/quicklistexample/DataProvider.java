package com.equaleyes.quicklistexample;

import java.util.ArrayList;

public class DataProvider {

    public static ArrayList<Data> getData() {

        ArrayList<Data> datas = new ArrayList<>();

        Data data = new Data();
        data.title = "One";
        data.subtitle = "First message";
      //  data.image = "https://pixabay.com/static/uploads/photo/2012/04/24/12/13/letter-39694_960_720.png";
        datas.add(data);

        DifferentData differentData = new DifferentData();
        differentData.title = "One";
        differentData.subtitle = "First message";
        differentData.image = "https://pixabay.com/static/uploads/photo/2012/04/24/12/13/letter-39694_960_720.png";
        datas.add(differentData);

        return datas;
    }
}
