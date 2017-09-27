package com.git.util;

import java.util.Random;

/**
 * Created by lixueqin on 2017/9/20.
 */
public class CharacterUtils {

    public static String getRandomString(int length) {

        String str = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIGKLMNPQUVWXVZ";
        Random random = new Random();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < length; i++) {
            result.append(str.charAt(random.nextInt(str.length())));

        }
        return result.toString();
    }

    /**
     * 获得文件的大小  mb kb b
     *
     * @param length
     * @return
     */
    public static String getSize(long length) {
        double floLength = 0;
        String unit = null;
        if (length >= 1024 * 1024) { //mb
            floLength = length / (1024 * 1024.0);
            unit = "MB";
        } else if (length >= 1024) { //kb
            floLength = length / 1024.0;
            unit = "KB";
        } else {
            unit = "B";
            return length + unit;
        }


        String strleng = String.valueOf(floLength);
        strleng = strleng.substring(0, strleng.lastIndexOf(".") + 2);
        return strleng + unit;


    }

    public static void main(String... str) {
        String data = CharacterUtils.getRandomString(10);
        System.out.println(data);


    }


}
