package com.git.action.users;

import com.git.bean.Users;
import com.git.service.UsersService;
import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;


public class UpdateUsersAction extends ActionSupport {

@Resource
private UsersService usersService;



	private Long id ;

	private String username ;

	private String password ;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


    @Override
    public void validate() {

    }

    @Override
    public  String execute() throws Exception{

        Users bean = usersService.getUsers( id);

        bean.setId(id) ;
		bean.setUsername(username) ;
		bean.setPassword(password) ;
		

        usersService.updateUsers(bean);

        return SUCCESS;

    }


}