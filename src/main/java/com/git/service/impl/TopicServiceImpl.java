package com.git.service.impl;

import com.git.bean.Topic;
import com.git.dao.TopicDAO;
import com.git.service.TopicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("topicService")
public class  TopicServiceImpl implements TopicService {

    private String list_all_desc = "from Topic bean order by bean.id desc";
    private String list_all_asc = "from Topic bean order by bean.id asc";
    private String sql_count = "from Topic ";
    private String sql_count_parentId = "from Topic bean where bean.parent.id=:parentId";

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

    @Override
    @Transactional
    public long getTopicCount(Long parentId) {
        Map<String,Object> params = new HashMap<>();
        params.put("parentId",parentId);
        return this.topicDAO.getTopicCount(sql_count_parentId,params);
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
