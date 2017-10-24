package com.git.dao;

import com.git.bean.Board;

import java.util.List;
import java.util.Map;

public interface BoardDAO
{
//save
public void saveBoard (Board bean);

//saves
public void saveBoard(List<Board> beans);
//remove
public void removeBoard(Long id);

public void removeBoard(Board bean);

public void removeBoards(List<Long> ids);

public void updateBoard(Board bean);

public void updateBoards(List<Board> beans);

public long getBoardCount(String queryString) ;

public long getBoardCount(String queryString, Map<String, Object> params)	;

public long  getBoardCount(String queryString, String key, Object value);

//search
public  List<Board> searchBoards(String queryString);
public  List<Board> searchBoards(String queryString, String key, Object value);
public  List<Board> searchBoards(String queryString, Map<String, Object> params);

public Board searchBoard(String queryString, Map<String, Object> params);

public Board searchBoard(String queryString);

public Board searchBoard(String queryString, String key, Object value);


public Board getId(long id) ;

public  List<Board> searchBoards(String queryString, Map<String, Object> params, int start, int number) ;
}