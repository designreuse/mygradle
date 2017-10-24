package com.git.action.topic;

import com.cagf.tool.util.*;
import com.git.bean.Topic;
import com.git.service.TopicService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.annotation.Resource;
import java.util.List;

public class ListTopicAction extends ActionSupport {

@Resource
private TopicService topicService;

    private int start;
    private int range;
    private String pageInfo;


    private List<Topic> list;

    public void setList(List<Topic> list) {
        this.list = list;

     }

     public List<Topic> getList(){

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


        long count = this.topicService.getTopicCount();
        this.pageInfo = Page.getPage(ServletActionContext.getRequest(),"",start,range,count);
        this.list = this.topicService.listTopics(this.start,this.range);

        return SUCCESS;

    }


}