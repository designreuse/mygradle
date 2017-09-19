package com.git.action;

import com.git.bean.User;
import com.git.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by lixueqin on 2017/9/19.
 */
@Controller
public class SaveUserAction extends ActionSupport {

    @Resource
    UserService userService;

    private User user;
    private List<User> userlist;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


//    @Override
//    public String execute() throws Exception {
//            System.out.println("----------------");
//            System.out.println(user);
//
//        return super.execute();
//    }

    public String save() {
        System.out.println("----------------");
        System.out.println(user);

        userService.save(user);

        return "success";

    }


    public String list() {
        ActionContext actionContext = ActionContext.getContext();
        Map<String,Object> request = (Map<String, Object>) actionContext.get("request");
        userlist = userService.findAll();
        request.put("userlist",userlist);
        return "list";
    }


    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
