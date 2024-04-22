package com.web.app.service;

import java.util.List;

import com.web.app.dto.board.BoardResponseDTO;
import com.web.app.dto.board.BoardListResponseDTO;
import com.web.app.dto.board.BoardRequestDTO;
import com.web.app.dto.pagination.PageDTO;
import com.web.app.security.SecurityUser;

public interface BoardService {

	BoardResponseDTO getBoard(Long board_id);

	void register(BoardRequestDTO boardRegisterRequestDTO, SecurityUser securityUser);

	List<BoardListResponseDTO> getBaordListWithPaging(int pageNum, String type, String keyword);

	void deleteBoard(Long board_id);

	void modifyBoard(BoardRequestDTO boardRequestDTO, Long board_id);

	PageDTO getPageInfo(int pageNum, String type, String keyword);

	
}
