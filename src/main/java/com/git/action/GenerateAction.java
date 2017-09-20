package com.git.action;

import com.git.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.InputStream;

/**
 * Created by lihao on 17/9/20.
 */
@Controller
public class GenerateAction extends ActionSupport {

    @Resource
    UserService userService;


    @Override
    public String execute() throws Exception {

        return "success";
    }


    public InputStream getDownloadFile() {

        return userService.getInputStram();
    }


}
