package com.git.util;

import java.util.Random;

/**
 * Created by lixueqin on 2017/9/20.
 */
public class CharacterUtils {

    public static String getRandomString (int length) {

        String str= "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIGKLMNPQUVWXVZ";
        Random random =  new Random();
        StringBuffer result = new StringBuffer();
        for(int i=0;i<length;i++) {
            result.append(str.charAt(random.nextInt(str.length())));

        }
        return result.toString();
    }

    public static void main(String ...str) {
       String data = CharacterUtils.getRandomString(10);
       System.out.println(data);


    }


}
