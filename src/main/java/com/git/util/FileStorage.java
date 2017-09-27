package com.git.util;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by lixueqin on 2017/9/26.
 */
public class FileStorage {

    public static String FILE_STORAGE = "fileStorage";
    public static String DOCUMENT_ITEM_STORAGE = "documentItemStorage";

    public static String getFileStorage(HttpServletRequest request,String desc){
        return request.getSession().getServletContext().getRealPath(FILE_STORAGE+ File.separator+desc);
    }
    public static String getDocumentItemStorage(HttpServletRequest request){
        return getFileStorage(request,DOCUMENT_ITEM_STORAGE);
    }

}
