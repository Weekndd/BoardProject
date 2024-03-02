package com.web.app.service;

import java.util.List;

import com.web.app.dto.BoardDTO;

public interface BoardService {

	BoardDTO getBoard(Long board_id);

	void register(BoardDTO boardDTO);

	List<BoardDTO> getBaordList();

}
