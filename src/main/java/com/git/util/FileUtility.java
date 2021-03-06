package com.git.util;

import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * Created by lixueqin on 2017/9/26.
 */
public class FileUtility {


    /**
     * 获得文件的扩展名
     *
     * @param fileName
     * @return
     */
    public static String getExtName(String fileName) {

        if (-1 == fileName.lastIndexOf(".")) {
            return "";
        }

        return fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
    }

    public static String randomName(String fileName) {
        if (-1 == fileName.lastIndexOf(".")) {
            return CharacterUtils.getRandomString(5);
        }

        return CharacterUtils.getRandomString(5) + fileName.substring(fileName.lastIndexOf("."), fileName.length());
    }

    //删除指定目录下的所有文件，并同时删除该目录
    public static void deleteAll(File file) {
//        FileUtils.forceDelete();
        if (!file.exists()) {
            return;
        }

        if (!file.delete()) { //目录中有文件

            File[] subFiles = file.listFiles();
            for (int i = 0; i < subFiles.length; ++i) {
                if(subFiles[i].isDirectory()) {
                    deleteAll(subFiles[i]);
                } else {
                    subFiles[i].delete();
                }

            }

            //删除该目录本身
            file.delete();
        }



    }
}
