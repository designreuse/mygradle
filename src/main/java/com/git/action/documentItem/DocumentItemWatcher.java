package com.git.action.documentItem;

import com.git.bean.DocumentItemUploadInfo;
import org.directwebremoting.WebContextFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by lixueqin on 2017/9/28.
 */
public class DocumentItemWatcher {

    //该方法是被dwr远程调用的方法
    public DocumentItemUploadInfo getUploadInfo() {
        HttpServletRequest request = WebContextFactory.get().getHttpServletRequest();

       HttpSession session = request.getSession();
       if(null != session.getAttribute("uploadInfo")) {
           return (DocumentItemUploadInfo) session.getAttribute("uploadInfo");
       } else{
           return new DocumentItemUploadInfo();
       }


    }
}
