package com.web.app.repository;

import java.util.List;

import com.web.app.dto.BoardDTO;

public interface BoardRepository {

	void test();

	BoardDTO getBoard(Long board_id);

	void register(BoardDTO boardDTO);

	List<BoardDTO> getBoardList();

	void deletePosting(Long board_id);
	
}
