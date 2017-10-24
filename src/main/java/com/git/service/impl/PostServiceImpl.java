package com.git.service.impl;

import com.git.bean.Post;
import com.git.dao.PostDAO;
import com.git.service.PostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service("postService")
public class  PostServiceImpl implements PostService {

    private String list_all_desc = "from Post bean order by bean.id desc";
    private String list_all_asc = "from Post bean order by bean.id asc";
    private String sql_count = "from Post ";

@Resource
PostDAO postDAO;

    @Transactional
    public List<Post> listPosts(int start, int range){

        return this.postDAO.searchPosts(list_all_desc,null,start,range);
        }

    @Transactional
    public List<Post> listPostDesc(int start, int range){
        return this.postDAO.searchPosts(list_all_desc,null,start,range);
        }

    @Transactional
    public List<Post> listPostAsc(int start, int range){
        return this.postDAO.searchPosts(list_all_asc,null,start,range);

    }
    @Transactional
    public Long getPostCount(){
        return this.postDAO.getPostCount(sql_count);
     }

    @Transactional
    public void savePost(Post bean){
         this.postDAO.savePost(bean);
    }

    @Transactional
    public void updatePost(Post bean){
         this.postDAO.updatePost(bean);
    }

    @Transactional
    public void deletePost(Long id){
        this.postDAO.removePost(id);
   }

    @Transactional
    public Post getPost(Long id){
       return this.postDAO.getId(id);
      }

}
