package com.web.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import com.web.app.dto.BoardDTO;
import com.web.app.service.BoardService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RestController
@RequiredArgsConstructor
public class BoardRestController {
	
	private final BoardService boardService;
	
	//게시글 리스트
	@GetMapping("/getBoardList")
	public List<BoardDTO> getBoardList () {
		List<BoardDTO> boardList = boardService.getBaordList();
		System.out.println("가져옴");
		return boardList;
	}
	
	//상세 게시물
	@GetMapping("/getBoardDetails/{board_id}")
	public BoardDTO getPosting(@PathVariable Long board_id) {
		BoardDTO boardDTO = boardService.getBoard(board_id);
		return boardDTO;
	}
	
	
	//게시글 등록 페이지  를 만드려면 멤버 테이블을 만들고, 로그인 후 로그인 정보를 가져와서 같이 넘겨줘야한다!!!
	@Transactional
	@PostMapping("/board")
	public void postBoard(@RequestBody BoardDTO boardDTO) {
		boardService.register(boardDTO);
	}
}