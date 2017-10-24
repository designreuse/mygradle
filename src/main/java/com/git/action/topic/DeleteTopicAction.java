package com.git.action.topic;

import com.git.service.TopicService;
import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;


public class DeleteTopicAction extends ActionSupport {

@Resource
private TopicService topicService;

    private long id;
    private int start;
    private int range;



    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
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


    @Override
    public void validate() {

    }


    @Override
    public  String execute() throws Exception{

       topicService.deleteTopic(id);

        return SUCCESS;

    }


}