package com.web.app.service;

import java.util.List;

import com.web.app.dto.board.BoardDTO;
import com.web.app.dto.board.BoardDetailsResponseDTO;
import com.web.app.dto.board.BoardListResponseDTO;
import com.web.app.dto.board.BoardRegisterRequestDTO;
import com.web.app.dto.pagination.Criteria;
import com.web.app.dto.pagination.PageDTO;
import com.web.app.security.SecurityUser;

public interface BoardService {

	BoardDetailsResponseDTO getBoard(Long board_id);

	void register(BoardRegisterRequestDTO boardRegisterRequestDTO, SecurityUser securityUser);

	List<BoardListResponseDTO> getBaordListWithPaging(int pageNum, String type, String keyword);

	void deleteBoard(Long board_id);

	void modifyBoard(BoardDTO boardDTO);

	PageDTO getPageInfo(int pageNum, String type, String keyword);

	
}
