package com.git.action.post;

import com.git.bean.Post;
import com.git.service.PostService;
import com.git.util.Page;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.annotation.Resource;
import java.util.List;

public class ListPostAction extends ActionSupport {

@Resource
private PostService postService;

    private int start;
    private int range;
    private String pageInfo;


    private List<Post> list;

    public void setList(List<Post> list) {
        this.list = list;

     }

     public List<Post> getList(){

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


        long count = this.postService.getPostCount();
        this.pageInfo = Page.getPage(ServletActionContext.getRequest(),"",start,range,count);
        this.list = this.postService.listPosts(this.start,this.range);

        return SUCCESS;

    }


}