package com.web.app.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.web.app.domain.Board;
import com.web.app.dto.board.BoardListResponseDTO;
import com.web.app.dto.pagination.Criteria;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepository{
	private final SqlSessionTemplate session;
	
	@Override
	public List<Board> getBoardListWithPaging(Criteria criteria) {
		List<Board> list = session.selectList("getBoardListWithPaging",criteria);
		return list;
	}

	@Override
	public Board getBoard(Long board_id) {
		Board board = session.selectOne("getBoard",board_id);
		return board;
	}

	@Override
	public void register(Board board) {
		int res = session.insert("registerBoard",board);
	}


	@Override
	public void deleteBoard(Long board_id) {
		int res = session.delete("deletePosting",board_id);
	}


	@Override
	public void modifyBoard(Board board) {
		int res = session.update("modifyPosting",board);
	}
	
	@Override
	public long getTotalPostingCount(Criteria criteria) {
		long total = session.selectOne("getTotalPostingCount",criteria);
		return total;
	}
	
	@Override
	public List<Board> searchTest(String string, Map<String, Map<String, String>> outer) {
		List<Board> list = session.selectList("searchTest", outer);
		return list;
	}
	
	
}
