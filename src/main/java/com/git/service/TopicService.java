package com.git.service;

import com.git.bean.Topic;

import java.util.List;

public interface TopicService {

    public List<Topic> listTopics(int start, int range);
    public List<Topic> listTopicDesc(int start, int range);
    public List<Topic> listTopicAsc(int start, int range);
    public Long getTopicCount();

    public void saveTopic(Topic bean);
    public void updateTopic(Topic bean);
    public void deleteTopic(Long id);

    public Topic getTopic(Long id);

}
