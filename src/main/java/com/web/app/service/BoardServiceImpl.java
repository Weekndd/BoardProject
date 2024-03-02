package com.web.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.app.dto.BoardDTO;
import com.web.app.repository.BoardRepository;

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
	public void register(BoardDTO boardDTO) {
		boardRepository.register(boardDTO);
		
	}

	

	


	
}
