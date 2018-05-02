package com.dongho.board.persistance;

import java.util.List;

import com.dongho.board.domain.BoardVO;

public interface BoardDAOInterface {
	public List<BoardVO> GetAllBoardList();
	public void CreateBoard(BoardVO boardVO);
	public BoardVO ReadBoard(int bno);
	public void UpdateBoard(int bno);
	public void DeleteBoard(int bno);
}
