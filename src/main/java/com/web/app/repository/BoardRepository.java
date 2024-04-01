package com.web.app.repository;

import java.util.List;

import com.web.app.dto.BoardDTO;
import com.web.app.dto.Criteria;

public interface BoardRepository {

	BoardDTO getBoard(Long board_id);

	void register(BoardDTO boardDTO);

	List<BoardDTO> getBoardList();

	void deletePosting(Long board_id);

	void modifyPosting(BoardDTO boardDTO);

	List<BoardDTO> getBoardListWithPaging(Criteria criteria);

	long getTotalPostingCount();
	
}
