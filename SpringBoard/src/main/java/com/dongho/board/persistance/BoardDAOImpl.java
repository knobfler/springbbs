package com.dongho.board.persistance;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dongho.board.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAOInterface {

	@Inject
	SqlSession sqlSession;
	
	private static final String NAME_SPACE = "com.dongho.mapper.BoardMapper";
	
	@Override
	public List<BoardVO> GetAllBoardList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAME_SPACE + ".selectBoardListAll");
	}

	@Override
	public void CreateBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		sqlSession.insert(NAME_SPACE + ".createBoard", boardVO);
	}	

	@Override
	public BoardVO ReadBoard(int bno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAME_SPACE +  ".selectBoard", bno);
	}

	@Override
	public void UpdateBoard(int bno) {
		// TODO Auto-generated method stub
		sqlSession.update(NAME_SPACE + ".updateBoard", bno);
	}

	@Override
	public void DeleteBoard(int bno) {
		// TODO Auto-generated method stub
		sqlSession.delete(NAME_SPACE + ".deleteBoard", bno);
	}

}
