package com.git.service.impl;

import com.git.bean.Topic;
import com.git.dao.TopicDAO;
import com.git.service.TopicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service("topicService")
public class  TopicServiceImpl implements TopicService {

    private String list_all_desc = "from Topic bean order by bean.id desc";
    private String list_all_asc = "from Topic bean order by bean.id asc";
    private String sql_count = "from Topic ";

@Resource
TopicDAO topicDAO;

    @Transactional
    public List<Topic> listTopics(int start,int range){

        return this.topicDAO.searchTopics(list_all_desc,null,start,range);
        }

    @Transactional
    public List<Topic> listTopicDesc(int start,int range){
        return this.topicDAO.searchTopics(list_all_desc,null,start,range);
        }

    @Transactional
    public List<Topic> listTopicAsc(int start,int range){
        return this.topicDAO.searchTopics(list_all_asc,null,start,range);

    }
    @Transactional
    public Long getTopicCount(){
        return this.topicDAO.getTopicCount(sql_count);
     }

    @Transactional
    public void saveTopic(Topic bean){
         this.topicDAO.saveTopic(bean);
    }

    @Transactional
    public void updateTopic(Topic bean){
         this.topicDAO.updateTopic(bean);
    }

    @Transactional
    public void deleteTopic(Long id){
        this.topicDAO.removeTopic(id);
   }

    @Transactional
    public Topic getTopic(Long id){
       return this.topicDAO.getId(id);
      }

}
