package com.git.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.File;

/**
 * Created by lixueqin on 2017/9/20.
 */
public class DeleteServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        //删除临时文件 后缀为.xls
        File file = new File(".");

        //todo 数组判断 listfiles   filefileter
    }
}
