package com.equaleyes.onelinelist;

import com.equaleyes.onelinelist.annotations.BoldOnEven;
import com.equaleyes.onelinelist.annotations.Text;

public class TestData {
    @Text
    public String testTitle = "Title";

    @BoldOnEven
    @Text
    public String twoAnnotations = "Two Annotations";
}
