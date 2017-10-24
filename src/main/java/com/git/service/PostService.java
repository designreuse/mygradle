package com.git.service;

import com.git.bean.Post;

import java.util.List;

public interface PostService {

    public List<Post> listPosts(int start, int range);
    public List<Post> listPostDesc(int start, int range);
    public List<Post> listPostAsc(int start, int range);
    public Long getPostCount();

    public void savePost(Post bean);
    public void updatePost(Post bean);
    public void deletePost(Long id);

    public Post getPost(Long id);

}
