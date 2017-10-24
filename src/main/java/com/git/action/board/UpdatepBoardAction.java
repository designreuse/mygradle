package com.git.action.board;

import com.git.bean.Board;
import com.git.service.BoardService;
import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;


public class UpdatepBoardAction extends ActionSupport {

@Resource
private BoardService boardService;

    private long id;


    private Board board;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Board getBoard() {

        return this.board;
     }

    public void setBoard(Board board) {
        this.board = board;
    }


    @Override
    public void validate() {

    }

    @Override
    public  String execute() throws Exception{

        board = boardService.getBoard(id);

        return SUCCESS;

    }


}