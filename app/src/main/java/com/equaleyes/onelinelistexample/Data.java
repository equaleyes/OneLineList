package com.equaleyes.onelinelistexample;

import com.equaleyes.onelinelist.annotations.BoldOnEven;
import com.equaleyes.onelinelist.annotations.CheckBox;
import com.equaleyes.onelinelist.annotations.Image;
import com.equaleyes.onelinelist.annotations.Text;
import com.equaleyes.onelinelist.annotations.TextColor;

public class Data {
    public int id;

    @Text
    public String content;

    @BoldOnEven
    @Text
    public String title;

    @Image(resourceName = "niceImage")
    public String url;

    @TextColor(resourceName = "textViewExtra")
    public String textColor = "#aa44ff";

    @CheckBox
    public Boolean checkBox = true;
}
