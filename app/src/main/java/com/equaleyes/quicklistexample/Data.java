package com.equaleyes.quicklistexample;

import com.equaleyes.quicklist.annotations.BoldOnEven;
import com.equaleyes.quicklist.annotations.CheckBox;
import com.equaleyes.quicklist.annotations.Image;
import com.equaleyes.quicklist.annotations.Text;
import com.equaleyes.quicklist.annotations.TextColor;

public class Data {
    public int id;

    @Text
    public String subtitle;

    @BoldOnEven
    @Text
    public String title;

    //@Image(resourceName = "niceImage"

    //@TextColor(resourceName = "textViewExtra")
    public String textColor = "#aa44ff";

    //@CheckBox
    public Boolean checkBox = true;
}
