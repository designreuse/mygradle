package com.git.dao;

import com.git.bean.Topic;

import java.util.List;
import java.util.Map;

public interface TopicDAO
{
//save
public void saveTopic(Topic bean);

//saves
public void saveTopic(List<Topic> beans);
//remove
public void removeTopic(Long id);

public void removeTopic(Topic bean);

public void removeTopics(List<Long> ids);

public void updateTopic(Topic bean);

public void updateTopics(List<Topic> beans);

public long getTopicCount(String queryString) ;

public long getTopicCount(String queryString, Map<String, Object> params)	;

public long  getTopicCount(String queryString, String key, Object value);

//search
public  List<Topic> searchTopics(String queryString);
public  List<Topic> searchTopics(String queryString, String key, Object value);
public  List<Topic> searchTopics(String queryString, Map<String, Object> params);

public	Topic	searchTopic(String queryString, Map<String, Object> params);

public	Topic	searchTopic(String queryString);

public	Topic	searchTopic(String queryString, String key, Object value);


public Topic getId(long id) ;

public  List<Topic> searchTopics(String queryString, Map<String, Object> params, int start, int number) ;
}