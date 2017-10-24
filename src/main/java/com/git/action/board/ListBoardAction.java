package com.git.action.board;

import com.cagf.tool.util.*;
import com.git.bean.Board;
import com.git.service.BoardService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.annotation.Resource;
import java.util.List;

public class ListBoardAction extends ActionSupport {

@Resource
private BoardService boardService;

    private int start;
    private int range;
    private String pageInfo;


    private List<Board> list;

    public void setList(List<Board> list) {
        this.list = list;

     }

     public List<Board> getList(){

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


        long count = this.boardService.getBoardCount();
        this.pageInfo = Page.getPage(ServletActionContext.getRequest(),"",start,range,count);
        this.list = this.boardService.listBoards(this.start,this.range);

        return SUCCESS;

    }


}