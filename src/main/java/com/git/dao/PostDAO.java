package com.git.dao;

import com.git.bean.Post;

import java.util.List;
import java.util.Map;

public interface PostDAO
{
//save
public void savePost(Post bean);

//saves
public void savePost(List<Post> beans);
//remove
public void removePost(Long id);

public void removePost(Post bean);

public void removePosts(List<Long> ids);

public void updatePost(Post bean);

public void updatePosts(List<Post> beans);

public long getPostCount(String queryString) ;

public long getPostCount(String queryString, Map<String, Object> params)	;

public long  getPostCount(String queryString, String key, Object value);

//search
public  List<Post> searchPosts(String queryString);
public  List<Post> searchPosts(String queryString, String key, Object value);
public  List<Post> searchPosts(String queryString, Map<String, Object> params);

public	Post	searchPost(String queryString, Map<String, Object> params);

public	Post	searchPost(String queryString);

public	Post	searchPost(String queryString, String key, Object value);


public Post getId(long id) ;

public  List<Post> searchPosts(String queryString, Map<String, Object> params, int start, int number) ;
}