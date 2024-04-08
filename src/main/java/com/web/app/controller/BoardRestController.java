package com.web.app.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import com.web.app.dto.BoardDTO;
import com.web.app.dto.PageDTO;
import com.web.app.security.SecurityUser;
import com.web.app.service.BoardService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RestController
@RequiredArgsConstructor
public class BoardRestController {
	
	private final BoardService boardService;
	
	//게시글 리스트
	@GetMapping("/boardListWithPaging")
	public List<BoardDTO> getBoardListWithPaging(@RequestParam int pageNum, String type, String keyword) {
		List<BoardDTO> boardList = boardService.getBaordListWithPaging(pageNum, type, keyword);
		return boardList;
	}
	@GetMapping("/pageInfo")
	public PageDTO getPageInfo(@RequestParam int pageNum, String type, String keyword) {
		PageDTO pageDTO = boardService.getPageInfo(pageNum, type, keyword);
		return pageDTO;
	}
	
	//상세 게시물
	@GetMapping("/board/{board_id}")
	public BoardDTO getPosting(@PathVariable Long board_id) {
		BoardDTO boardDTO = boardService.getBoard(board_id);
		return boardDTO;
	}
	
	@Transactional
	@PostMapping("/board/register")
	public void postBoard(@AuthenticationPrincipal SecurityUser securityUser,
			@RequestBody BoardDTO boardDTO) {
		boardService.register(boardDTO, securityUser);
	}
	
	@Transactional
	@DeleteMapping("/board/{board_id}")
	public void deletePosting(@PathVariable Long board_id) {
		boardService.deletePosting(board_id);
	}
	
	@Transactional
	@PutMapping("/board/{board_id}")
	public void modifiyPosting(@RequestBody BoardDTO boardDTO) {
		boardService.modifyPosting(boardDTO);
	}
	
}
