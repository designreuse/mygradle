package com.git.action.users;

import com.git.bean.Users;
import com.git.service.UsersService;
import com.git.util.Page;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.annotation.Resource;
import java.util.List;

public class ListUsersAction extends ActionSupport {

@Resource
private UsersService usersService;

    private int start;
    private int range;
    private String pageInfo;


    private List<Users> list;

    public void setList(List<Users> list) {
        this.list = list;

     }

     public List<Users> getList(){

        return this.list;
     }

     public void setStart(int start) {
         this.start = start;
     }

    public int getStart() {
         return this.start;

    }

    public void setRange(int range) {
        this.range = range;
        }


    public int getRange() {
        return this.range;
     }

    public String getPageInfo() {
        return this.pageInfo;

        }



    @Override
    public void validate() {

    }

    @Override
    public  String execute() throws Exception{

        if(0 == this.range) {
            this.range =10;
        }


        long count = this.usersService.getUsersCount();
        this.pageInfo = Page.getPage(ServletActionContext.getRequest(),"",start,range,count);
        this.list = this.usersService.listUserss(this.start,this.range);

        return SUCCESS;

    }


}