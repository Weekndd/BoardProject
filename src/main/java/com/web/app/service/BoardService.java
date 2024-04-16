package com.web.app.service;

import java.util.List;

import com.web.app.dto.Criteria;
import com.web.app.dto.PageDTO;
import com.web.app.dto.board.BoardDTO;
import com.web.app.dto.board.BoardRegisterRequestDTO;
import com.web.app.security.SecurityUser;

public interface BoardService {

	BoardDTO getBoard(Long board_id);

	void register(BoardRegisterRequestDTO boardRegisterRequestDTO, SecurityUser securityUser);

	List<BoardDTO> getBaordList();
	
	List<BoardDTO> getBaordListWithPaging(int pageNum, String type, String keyword);

	void deletePosting(Long board_id);

	void modifyPosting(BoardDTO boardDTO);

	PageDTO getPageInfo(int pageNum, String type, String keyword);

	
}
