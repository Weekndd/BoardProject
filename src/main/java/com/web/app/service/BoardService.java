package com.web.app.service;

import java.util.List;

import com.web.app.dto.BoardDTO;
import com.web.app.dto.Criteria;
import com.web.app.dto.PageDTO;
import com.web.app.security.SecurityUser;

public interface BoardService {

	BoardDTO getBoard(Long board_id);

	void register(BoardDTO boardDTO, SecurityUser securityUser);

	List<BoardDTO> getBaordList();
	
	List<BoardDTO> getBaordListWithPaging(int pageNum, String type, String keyword);

	void deletePosting(Long board_id);

	void modifyPosting(BoardDTO boardDTO);

	PageDTO getPageInfo(int pageNum, String type, String keyword);

	
}
