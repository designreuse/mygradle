package com.git.service;

import com.git.bean.Board;

import java.util.List;

public interface BoardService {

    public List<Board> listBoards(int start, int range);
    public List<Board> listBoardDesc(int start, int range);
    public List<Board> listBoardAsc(int start, int range);
    public Long getBoardCount();

    public void saveBoard(Board bean);
    public void updateBoard(Board bean);
    public void deleteBoard(Long id);

    public Board getBoard(Long id);

}
