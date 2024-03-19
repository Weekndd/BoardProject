package com.web.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.app.dto.BoardDTO;
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
	public BoardDTO getBoard(Long board_id) {
		BoardDTO boardDTO = boardRepository.getBoard(board_id);
		return boardDTO;
	}

	@Override
	public void register(BoardDTO boardDTO, SecurityUser securityUser) {
		setWriterInfo(boardDTO, securityUser);
		boardRepository.register(boardDTO);
		
	}
	private static void setWriterInfo(BoardDTO boardDTO, SecurityUser securityUser) {
		boardDTO.setWriter(securityUser.getMember_id());
		boardDTO.setEmail(securityUser.getEmail());
	}

	@Override
	public void deletePosting(Long board_id) {
		boardRepository.deletePosting(board_id);
	}
	

	


	
}
