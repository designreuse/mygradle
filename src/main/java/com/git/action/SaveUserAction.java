package com.git.action;

import com.git.bean.User;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by lixueqin on 2017/9/19.
 */
public class SaveUserAction extends ActionSupport {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String execute() throws Exception {



        return super.execute();
    }
}
