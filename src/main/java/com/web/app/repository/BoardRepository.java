package com.web.app.repository;

import java.util.List;
import java.util.Map;

import com.web.app.domain.Board;
import com.web.app.dto.pagination.Criteria;

public interface BoardRepository {

	Board getBoard(Long board_id);

	void register(Board board);

	void deleteBoard(Long board_id);

	void modifyBoard(Board board);

	List<Board> getBoardListWithPaging(Criteria criteria);

	long getTotalPostingCount(Criteria criteria);

	List<Board> searchTest(String string, Map<String, Map<String, String>> outer);
	
}
