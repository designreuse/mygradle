package com.git.dao;

import com.git.bean.Users;

import java.util.List;
import java.util.Map;

public interface UsersDAO
{
//save
public void saveUsers (Users bean);

//saves
public void saveUsers(List<Users> beans);
//remove
public void removeUsers(Long id);

public void removeUsers(Users bean);

public void removeUserss(List<Long> ids);

public void updateUsers(Users bean);

public void updateUserss(List<Users> beans);

public long getUsersCount(String queryString) ;

public long getUsersCount(String queryString, Map<String, Object> params)	;

public long  getUsersCount(String queryString, String key, Object value);

//search
public  List<Users> searchUserss(String queryString);
public  List<Users> searchUserss(String queryString, String key, Object value);
public  List<Users> searchUserss(String queryString, Map<String, Object> params);

public Users searchUsers(String queryString, Map<String, Object> params);

public Users searchUsers(String queryString);

public Users searchUsers(String queryString, String key, Object value);


public Users getId(long id) ;

public  List<Users> searchUserss(String queryString, Map<String, Object> params, int start, int number) ;
}