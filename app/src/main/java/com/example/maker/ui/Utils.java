package com.example.maker.ui;


import android.content.Context;

import java.util.Random;


public class Utils {
    static Random random = new Random();

    public static float dipToPx(Context context, float dipValue) {
        float density = context.getResources().getDisplayMetrics().density;
        return dipValue * density;
    }


    //Generate random number(Prize)
    private static String generateCodePart(int min, int max) {
        int minNumber = 2;
        int maxNumber = 20;
        return String.valueOf((random.nextInt((maxNumber - minNumber) + 1) + minNumber) );
    }

    public static String generateNewCode() {
        String firstCodePart = generateCodePart(1000, 9999);

        return "You've Won\nRs." + firstCodePart ;
    }
}
