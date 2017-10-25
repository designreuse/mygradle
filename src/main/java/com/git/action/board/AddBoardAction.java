package com.git.action.board;

import com.git.bean.Board;
import com.git.service.BoardService;
import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;
import java.util.Set;


public class AddBoardAction extends ActionSupport {

    @Resource
    private BoardService boardService;


    private Long id;

    private String name;
    private String description;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void validate() {

    }

    @Override
    public String execute() throws Exception {

        Board bean = new Board();

        bean.setId(id);
        bean.setName(name);
        bean.setDescription(description);

        this.boardService.saveBoard(bean);


        return SUCCESS;

    }


}