package com.git.action.board;

import com.git.bean.Board;
import com.git.service.BoardService;
import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;
import java.util.Set;


public class AddBoardAction extends ActionSupport {

@Resource
private BoardService boardService;



	private Long id ;

	private String name ;

	private Long topicCount ;

	private Long postCount ;

	private Set children ;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getTopicCount() {
		return topicCount;
	}

	public void setTopicCount(Long topicCount) {
		this.topicCount = topicCount;
	}

	public Long getPostCount() {
		return postCount;
	}

	public void setPostCount(Long postCount) {
		this.postCount = postCount;
	}

	public Set getChildren() {
		return children;
	}

	public void setChildren(Set children) {
		this.children = children;
	}


    @Override
    public void validate() {

    }

    @Override
    public  String execute() throws Exception{

        Board bean = new Board();

		bean.setId(id) ;
		bean.setName(name) ;
		bean.setTopicCount(topicCount) ;
		bean.setPostCount(postCount) ;
		bean.setChildren(children) ;
		
	this.boardService.saveBoard(bean);

    return SUCCESS;

    }


}