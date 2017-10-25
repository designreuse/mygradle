package com.git.dao.impl;

import com.git.bean.Topic;
import com.git.dao.TopicDAO;
import com.git.util.BaseDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

// import com.git.util.*;

@Repository("topicDAO")
public class TopicDAOImpl extends BaseDAO<Topic> implements TopicDAO
{

	//save
	public void saveTopic (Topic bean){
		storeObj(bean);
	}

	//saves
	public void saveTopic(List<Topic> beans){
		storeObjs(beans);
	}

	//remove
	public void removeTopic(Long id){
		removeObj(Topic.class,id);
	}

	public void removeTopic(Topic bean){
		removeTopic(bean.getId());
	}


    public void removeTopics(List<Long> ids) {
        removeObjs(Topic.class,ids);
    }

     public void updateTopic(Topic bean) {
        updateObj(bean);
     }

     public void updateTopics(List<Topic> beans) {
        updateObjs(beans);
     }

	public long getTopicCount(String queryString) {

		return retrieveObjsCount(queryString);
	}

	public long getTopicCount(String queryString, Map<String, Object> params)	{
		return retrieveObjsCount(queryString,params);
	}

	public long  getTopicCount(String queryString, String key, Object value){
		return retrieveObjsCount(queryString,key,value);
	}


	//search
	public  List<Topic> searchTopics(String queryString) {
		return retrieveObjs(queryString);
	}

	public  List<Topic> searchTopics(String queryString, String key, Object value){

		return retrieveObjs(queryString,key,value);
	}
	public  List<Topic> searchTopics(String queryString, Map<String, Object> params){

		return retrieveObjs(queryString,params);
	}

	public Topic searchTopic(String queryString, Map<String, Object> params){
		return retrieveObj(queryString,params);
    }

    public Topic searchTopic(String queryString){
		return retrieveObj(queryString);
    }

    public Topic searchTopic(String queryString, String key, Object value){
		return retrieveObj(queryString,key,value);
    }

    public Topic getId(long id) {
         return retrieveObj( Topic.class ,id);
    }

    public  List<Topic> searchTopics(String queryString, Map<String, Object> params, int start, int number) {
         return retrievePageObjs(queryString,params,start,number);
    }



}