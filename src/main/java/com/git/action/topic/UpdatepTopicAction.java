package com.git.action.topic;

import com.git.bean.Topic;
import com.git.service.TopicService;
import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;


public class UpdatepTopicAction extends ActionSupport {

@Resource
private TopicService topicService;

    private long id;


    private Topic topic;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Topic getTopic() {

        return this.topic;
     }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }


    @Override
    public void validate() {

    }

    @Override
    public  String execute() throws Exception{

        topic = topicService.getTopic(id);

        return SUCCESS;

    }


}