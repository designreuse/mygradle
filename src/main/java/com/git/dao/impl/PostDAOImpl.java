package com.git.dao.impl;

import com.git.bean.Post;
import com.git.dao.PostDAO;
import com.git.util.BaseDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

// import com.git.util.*;

@Repository("postDAO")
public class PostDAOImpl extends BaseDAO<Post> implements PostDAO
{

	//save
	public void savePost (Post bean){
		storeObj(bean);
	}

	//saves
	public void savePost(List<Post> beans){
		storeObjs(beans);
	}

	//remove
	public void removePost(Long id){
		removeObj(Post.class,id);
	}

	public void removePost(Post bean){
		removePost(bean.getId());
	}


    public void removePosts(List<Long> ids) {
        removeObjs(Post.class,ids);
    }

     public void updatePost(Post bean) {
        updateObj(bean);
     }

     public void updatePosts(List<Post> beans) {
        updateObjs(beans);
     }

	public long getPostCount(String queryString) {

		return retrieveObjsCount(queryString);
	}

	public long getPostCount(String queryString, Map<String, Object> params)	{
		return retrieveObjsCount(queryString,params);
	}

	public long  getPostCount(String queryString, String key, Object value){
		return retrieveObjsCount(queryString,key,value);
	}


	//search
	public  List<Post> searchPosts(String queryString) {
		return retrieveObjs(queryString);
	}

	public  List<Post> searchPosts(String queryString, String key, Object value){

		return retrieveObjs(queryString,key,value);
	}
	public  List<Post> searchPosts(String queryString, Map<String, Object> params){

		return retrieveObjs(queryString,params);
	}

	public Post searchPost(String queryString, Map<String, Object> params){
		return retrieveObj(queryString,params);
    }

    public Post searchPost(String queryString){
		return retrieveObj(queryString);
    }

    public Post searchPost(String queryString, String key, Object value){
		return retrieveObj(queryString,key,value);
    }

    public Post getId(long id) {
         return retrieveObj( Post.class ,id);
    }

    public  List<Post> searchPosts(String queryString, Map<String, Object> params, int start, int number) {
         return retrievePageObjs(queryString,params,start,number);
    }



}