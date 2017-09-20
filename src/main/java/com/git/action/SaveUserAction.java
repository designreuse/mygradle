package com.git.action;

import com.git.bean.User;
import com.git.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by lixueqin on 2017/9/19.
 */
@Controller
@Scope("prototype")
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

    public void validateSave() {
        if(StringUtils.isBlank(user.getFirstname())) {
            addFieldError("first","请填写姓");
        }
        if(StringUtils.isBlank(user.getLastname())) {
            addFieldError("last","请填写名");
        }
        if(Objects.isNull(user.getAge()) || user.getAge() <1 || user.getAge()>150) {
            addFieldError("age","请填正确的年龄 1- 150岁");
        }
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
