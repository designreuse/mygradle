package com.git.action.post;

import com.git.bean.Post;
import com.git.bean.Topic;
import com.git.service.PostService;
import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;
import java.util.Date;


public class AddPostAction extends ActionSupport {

@Resource
private PostService postService;



	private Long id ;

	private Long authorId ;

	private String authorName ;

	private Date date ;

	private String content ;

	private Topic parent ;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Topic getParent() {
		return parent;
	}

	public void setParent(Topic parent) {
		this.parent = parent;
	}


    @Override
    public void validate() {

    }

    @Override
    public  String execute() throws Exception{

        Post bean = new Post();

		bean.setId(id) ;
		bean.setAuthorId(authorId) ;
		bean.setAuthorName(authorName) ;
		bean.setDate(date) ;
		bean.setContent(content) ;
		bean.setParent(parent) ;
		
	this.postService.savePost(bean);

    return SUCCESS;

    }


}