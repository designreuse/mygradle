package com.git.action.post;

import com.git.bean.Post;
import com.git.service.PostService;
import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;


public class UpdatepPostAction extends ActionSupport {

@Resource
private PostService postService;

    private long id;


    private Post post;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Post getPost() {

        return this.post;
     }

    public void setPost(Post post) {
        this.post = post;
    }


    @Override
    public void validate() {

    }

    @Override
    public  String execute() throws Exception{

        post = postService.getPost(id);

        return SUCCESS;

    }


}