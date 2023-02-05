package com.example.morldapp_demo01.posedetector;

import java.util.ArrayList;
import java.util.List;

public class PosePKResult {

    static boolean showPKResult ;

    PosePKResult(boolean showPKResult)
    {
        this.showPKResult=showPKResult;
    }

    public static boolean getPKTimeResult()
    {
        return showPKResult;
    }


}
