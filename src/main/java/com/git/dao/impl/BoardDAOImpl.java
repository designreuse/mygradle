package com.git.dao.impl;

import com.git.bean.Board;
import com.git.dao.BoardDAO;
import com.git.util.BaseDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

// import com.git.util.*;

@Repository("boardDAO")
public class BoardDAOImpl extends BaseDAO<Board> implements BoardDAO
{

	//save
	public void saveBoard (Board bean){
		storeObj(bean);
	}

	//saves
	public void saveBoard(List<Board> beans){
		storeObjs(beans);
	}

	//remove
	public void removeBoard(Long id){
		removeObj(Board.class,id);
	}

	public void removeBoard(Board bean){
		removeBoard(bean.getId());
	}


    public void removeBoards(List<Long> ids) {
        removeObjs(Board.class,ids);
    }

     public void updateBoard(Board bean) {
        updateObj(bean);
     }

     public void updateBoards(List<Board> beans) {
        updateObjs(beans);
     }

	public long getBoardCount(String queryString) {

		return retrieveObjsCount(queryString);
	}

	public long getBoardCount(String queryString, Map<String, Object> params)	{
		return retrieveObjsCount(queryString,params);
	}

	public long  getBoardCount(String queryString, String key, Object value){
		return retrieveObjsCount(queryString,key,value);
	}


	//search
	public  List<Board> searchBoards(String queryString) {
		return retrieveObjs(queryString);
	}

	public  List<Board> searchBoards(String queryString, String key, Object value){

		return retrieveObjs(queryString,key,value);
	}
	public  List<Board> searchBoards(String queryString, Map<String, Object> params){

		return retrieveObjs(queryString,params);
	}

	public Board searchBoard(String queryString, Map<String, Object> params){
		return retrieveObj(queryString,params);
    }

    public Board searchBoard(String queryString){
		return retrieveObj(queryString);
    }

    public Board searchBoard(String queryString, String key, Object value){
		return retrieveObj(queryString,key,value);
    }

    public Board getId(long id) {
         return retrieveObj( Board.class ,id);
    }

    public  List<Board> searchBoards(String queryString, Map<String, Object> params, int start, int number) {
         return retrievePageObjs(queryString,params,start,number);
    }



}