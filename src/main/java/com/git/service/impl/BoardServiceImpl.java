package com.git.service.impl;

import com.git.bean.Board;
import com.git.dao.BoardDAO;
import com.git.service.BoardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

    private String list_all_desc = "from Board bean order by bean.id desc";
    private String list_all_asc = "from Board bean order by bean.id asc";
    private String sql_count = "from Board ";

@Resource
BoardDAO boardDAO;

    @Transactional
    public List<Board> listBoards(int start, int range){

        return this.boardDAO.searchBoards(list_all_desc,null,start,range);
        }

    @Transactional
    public List<Board> listBoardDesc(int start, int range){
        return this.boardDAO.searchBoards(list_all_desc,null,start,range);
        }

    @Transactional
    public List<Board> listBoardAsc(int start, int range){
        return this.boardDAO.searchBoards(list_all_asc,null,start,range);

    }
    @Transactional
    public Long getBoardCount(){
        return this.boardDAO.getBoardCount(sql_count);
     }

    @Transactional
    public void saveBoard(Board bean){
         this.boardDAO.saveBoard(bean);
    }

    @Transactional
    public void updateBoard(Board bean){
         this.boardDAO.updateBoard(bean);
    }

    @Transactional
    public void deleteBoard(Long id){
        this.boardDAO.removeBoard(id);
   }

    @Transactional
    public Board getBoard(Long id){
       return this.boardDAO.getId(id);
      }

}
