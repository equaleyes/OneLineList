package com.equaleyes.onelinelistexample;

import com.equaleyes.onelinelist.annotations.BoldOnEven;
import com.equaleyes.onelinelist.annotations.Image;
import com.equaleyes.onelinelist.annotations.Text;

public class Data {
    public int id;

    @Text
    public String content;

    @BoldOnEven
    @Text
    public String title;

    @Image(resourceName = "niceImage")
    public String url;

    //@TextColor(resourceName = "branch") public String textColor = "#aa44ff";
    public boolean unread = true;
}
