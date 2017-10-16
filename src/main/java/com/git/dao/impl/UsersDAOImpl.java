package com.git.dao.impl;

import com.git.bean.Users;
import com.git.dao.UsersDAO;
import com.git.util.BaseDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("usersDAO")
public class UsersDAOImpl extends BaseDAO<Users> implements UsersDAO
{

	//save
	public void saveUsers (Users bean){
		storeObj(bean);
	}

	//saves
	public void saveUsers(List<Users> beans){
		storeObjs(beans);
	}

	//remove
	public void removeUsers(Long id){
		removeObj(Users.class,id);
	}

	public void removeUsers(Users bean){
		removeUsers(bean.getId());
	}


    public void removeUserss(List<Long> ids) {
        removeObjs(Users.class,ids);
    }

     public void updateUsers(Users bean) {
        updateObj(bean);
     }

     public void updateUserss(List<Users> beans) {
        updateObjs(beans);
     }

	public long getUsersCount(String queryString) {

		return retrieveObjsCount(queryString);
	}

	public long getUsersCount(String queryString, Map<String, Object> params)	{
		return retrieveObjsCount(queryString,params);
	}

	public long  getUsersCount(String queryString, String key, Object value){
		return retrieveObjsCount(queryString,key,value);
	}


	//search
	public  List<Users> searchUserss(String queryString) {
		return retrieveObjs(queryString);
	}

	public  List<Users> searchUserss(String queryString, String key, Object value){

		return retrieveObjs(queryString,key,value);
	}
	public  List<Users> searchUserss(String queryString, Map<String, Object> params){

		return retrieveObjs(queryString,params);
	}

	public Users searchUsers(String queryString, Map<String, Object> params){
		return retrieveObj(queryString,params);
    }

    public Users searchUsers(String queryString){
		return retrieveObj(queryString);
    }

    public Users searchUsers(String queryString, String key, Object value){
		return retrieveObj(queryString,key,value);
    }

    public Users getId(long id) {
         return retrieveObj( Users.class ,id);
    }

    public  List<Users> searchUserss(String queryString, Map<String, Object> params, int start, int number) {
         return retrievePageObjs(queryString,params,start,number);
    }



}