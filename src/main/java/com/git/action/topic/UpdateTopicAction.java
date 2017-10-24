package com.git.action.topic;

import com.git.bean.Board;
import com.git.bean.Topic;
import com.git.service.TopicService;
import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Set;


public class UpdateTopicAction extends ActionSupport {

@Resource
private TopicService topicService;



	private Long id ;

	private String title ;

	private Long content ;

	private Long authorId ;

	private String authorName ;

	private Date date ;

	private Long viewCount ;

	private Long postCount ;

	private Date lastDate ;

	private String lastAuthor ;

	private Set children ;

	private Board parent ;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getContent() {
		return content;
	}

	public void setContent(Long content) {
		this.content = content;
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

	public Long getViewCount() {
		return viewCount;
	}

	public void setViewCount(Long viewCount) {
		this.viewCount = viewCount;
	}

	public Long getPostCount() {
		return postCount;
	}

	public void setPostCount(Long postCount) {
		this.postCount = postCount;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public String getLastAuthor() {
		return lastAuthor;
	}

	public void setLastAuthor(String lastAuthor) {
		this.lastAuthor = lastAuthor;
	}

	public Set getChildren() {
		return children;
	}

	public void setChildren(Set children) {
		this.children = children;
	}

	public Board getParent() {
		return parent;
	}

	public void setParent(Board parent) {
		this.parent = parent;
	}


    @Override
    public void validate() {

    }

    @Override
    public  String execute() throws Exception{

        Topic bean = topicService.getTopic( id);

        bean.setId(id) ;
		bean.setTitle(title) ;
		bean.setContent(content) ;
		bean.setAuthorId(authorId) ;
		bean.setAuthorName(authorName) ;
		bean.setDate(date) ;
		bean.setViewCount(viewCount) ;
		bean.setPostCount(postCount) ;
		bean.setLastDate(lastDate) ;
		bean.setLastAuthor(lastAuthor) ;
		bean.setChildren(children) ;
		bean.setParent(parent) ;
		

        topicService.updateTopic(bean);

        return SUCCESS;

    }


}