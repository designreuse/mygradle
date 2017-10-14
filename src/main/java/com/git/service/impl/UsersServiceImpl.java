package com.git.service.impl;

import com.git.bean.Users;
import com.git.dao.UsersDAO;
import com.git.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service("usersService")
public class UsersServiceImpl implements UsersService {

    private String list_all_desc = "from Users bean order by bean.id desc";
    private String list_all_asc = "from Users bean order by bean.id asc";
    private String sql_count = "from Users ";

@Resource
UsersDAO usersDAO;

    @Transactional
    public List<Users> listUserss(int start, int range){

        return this.usersDAO.searchUserss(list_all_desc,null,start,range);
        }

    @Transactional
    public List<Users> listUsersDesc(int start, int range){
        return this.usersDAO.searchUserss(list_all_desc,null,start,range);
        }

    @Transactional
    public List<Users> listUsersAsc(int start, int range){
        return this.usersDAO.searchUserss(list_all_asc,null,start,range);

    }
    @Transactional
    public Long getUsersCount(){
        return this.usersDAO.getUsersCount(sql_count);
     }

    @Transactional
    public void saveUsers(Users bean){
         this.usersDAO.saveUsers(bean);
    }

    @Transactional
    public void updateUsers(Users bean){
         this.usersDAO.updateUsers(bean);
    }

    @Transactional
    public void deleteUsers(Long id){
        this.usersDAO.removeUsers(id);
   }

    @Transactional
    public Users getUsers(Long id){
       return this.usersDAO.getId(id);
      }

}
