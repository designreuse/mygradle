package com.git.action.users;

import com.git.bean.Users;
import com.git.service.UsersService;
import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;


public class UpdatepUsersAction extends ActionSupport {

@Resource
private UsersService usersService;

    private long id;


    private Users users;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Users getUsers() {

        return this.users;
     }

    public void setUsers(Users users) {
        this.users = users;
    }


    @Override
    public void validate() {

    }

    @Override
    public  String execute() throws Exception{

        users = usersService.getUsers(id);

        return SUCCESS;

    }


}