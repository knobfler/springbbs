package com.dongho.board.service;

import java.util.List;

import com.dongho.board.domain.BoardVO;

public interface BoardService {
	public List<BoardVO> GetAllBoardList();
	public void CreateBoard(BoardVO boardVO);
	public BoardVO ReadBoard(int bno);
	public void UpdateBoard(BoardVO boardVO);
	public void DeleteBoard(int bno);
}
