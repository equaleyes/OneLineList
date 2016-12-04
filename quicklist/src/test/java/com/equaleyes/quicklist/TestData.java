package com.equaleyes.quicklist;

import com.equaleyes.quicklist.annotations.BoldOnEven;
import com.equaleyes.quicklist.annotations.Text;

public class TestData {
    @Text
    public String testTitle = "Title";

    @BoldOnEven
    @Text
    public String twoAnnotations = "Two Annotations";
}
