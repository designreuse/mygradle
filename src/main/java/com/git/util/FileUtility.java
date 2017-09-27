package com.git.util;

/**
 * Created by lixueqin on 2017/9/26.
 */
public class FileUtility {


    /**
     * 获得文件的扩展名
     * @param fileName
     * @return
     */
    public static String getExtName(String fileName){

        if(-1 == fileName.lastIndexOf(".")) {
            return "";
        }

        return fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
    }

    public static String randomName(String fileName) {
        if(-1 == fileName.lastIndexOf(".")) {
            return CharacterUtils.getRandomString(5);
        }

        return CharacterUtils.getRandomString(5)+fileName.substring(fileName.lastIndexOf("."),fileName.length());
    }
}
