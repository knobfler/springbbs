package com.dongho.board.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dongho.board.domain.BoardVO;
import com.dongho.board.persistance.BoardDAOImpl;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDAOImpl dao;
	
	
	@Override
	public List<BoardVO> GetAllBoardList() {
		// TODO Auto-generated method stub
		return dao.GetAllBoardList();
	}

	@Override
	public void CreateBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		dao.CreateBoard(boardVO);
		
	}

	@Override
	public BoardVO ReadBoard(int bno) {
		// TODO Auto-generated method stub
		return dao.ReadBoard(bno);
	}

	@Override
	public void UpdateBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		dao.UpdateBoard(boardVO);
	}

	@Override
	public void DeleteBoard(int bno) {
		// TODO Auto-generated method stub
		dao.DeleteBoard(bno);
	}
	
}
