package com.web.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.app.domain.Board;
import com.web.app.dto.Criteria;
import com.web.app.dto.PageDTO;
import com.web.app.dto.board.BoardDTO;
import com.web.app.dto.board.BoardRegisterRequestDTO;
import com.web.app.repository.BoardRepository;
import com.web.app.security.SecurityUser;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl  implements BoardService {
	private final BoardRepository boardRepository;
	
	@Override
	public List<BoardDTO> getBaordList() {
		List<BoardDTO> boardList = boardRepository.getBoardList();
		return boardList;
	}
	@Override
	public List<BoardDTO> getBaordListWithPaging(int pageNum, String type, String keyword) {
		Criteria criteria = getCriteria(pageNum, type, keyword);
		List<BoardDTO> boardList = boardRepository.getBoardListWithPaging(criteria);
		return boardList;
	}
	private static Criteria getCriteria(int pageNum, String type, String keyword) {
		Criteria criteria = new Criteria(pageNum, 10);
		criteria.setType(type);
		criteria.setKeyword(keyword);
		return criteria;
	}
	
	@Override
	public BoardDTO getBoard(Long board_id) {
		BoardDTO boardDTO = boardRepository.getBoard(board_id);
		return boardDTO;
	}

	@Transactional
	@Override
	public void register(BoardRegisterRequestDTO boardRegisterRequestDTO, SecurityUser securityUser) {
		Board newBoard = setWriterInfo(boardRegisterRequestDTO, securityUser);
		boardRepository.register(newBoard);
	}
	private static Board setWriterInfo(BoardRegisterRequestDTO boardRegisterRequestDTO, SecurityUser securityUser) {
		Board newBoard = new Board();
		newBoard.setTitle(boardRegisterRequestDTO.getTitle());
		newBoard.setContent(boardRegisterRequestDTO.getContent());
		newBoard.setWriter(securityUser.getMember_id());
		newBoard.setEmail(securityUser.getEmail());
		return newBoard;
	}

	@Transactional
	@Override
	public void deletePosting(Long board_id) {
		boardRepository.deletePosting(board_id);
	}

	@Transactional
	@Override
	public void modifyPosting(BoardDTO boardDTO) {
		boardRepository.modifyPosting(boardDTO);
		
	}
	
	@Override
	public PageDTO getPageInfo(int pageNum, String type, String keyword) {
		Criteria criteria = getCriteria(pageNum, type, keyword);
		long totalPosting = boardRepository.getTotalPostingCount(criteria);
		PageDTO pageDTO = new PageDTO(criteria, totalPosting);
		return pageDTO;
	}

	

	


	
}
