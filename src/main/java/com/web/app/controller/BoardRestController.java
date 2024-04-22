package com.web.app.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.web.app.dto.board.BoardResponseDTO;
import com.web.app.dto.board.BoardListResponseDTO;
import com.web.app.dto.board.BoardRequestDTO;
import com.web.app.dto.pagination.PageDTO;
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
	public List<BoardListResponseDTO> getBoardListWithPaging(@RequestParam int pageNum, String type, String keyword) {
		List<BoardListResponseDTO> boardList = boardService.getBaordListWithPaging(pageNum, type, keyword);
		return boardList;
	}
	
	//페이지 정보
	@GetMapping("/pageInfo")
	public PageDTO getPageInfo(@RequestParam int pageNum, String type, String keyword) {
		PageDTO pageDTO = boardService.getPageInfo(pageNum, type, keyword);
		return pageDTO;
	}
	
	//상세 게시물
	@GetMapping("/board/{board_id}")
	public BoardResponseDTO getBoard(@PathVariable Long board_id) {
		BoardResponseDTO boardResponseDTO = boardService.getBoard(board_id);
		return boardResponseDTO;
	}
	
	//게시글 등록
	@PostMapping("/board/register")
	public void postBoard(@AuthenticationPrincipal SecurityUser securityUser,
			@RequestBody BoardRequestDTO boardRequestDTO) {
		boardService.register(boardRequestDTO, securityUser);
	}
	
	//게시글 삭제
	@DeleteMapping("/board/{board_id}")
	public void deleteBoard(@PathVariable Long board_id) {
		boardService.deleteBoard(board_id);
	}
	
	//게시글 수정
	@PutMapping("/board/{board_id}")
	public void modifiyBoard(@RequestBody BoardRequestDTO boardRequestDTO,
			@PathVariable Long board_id) {
		boardService.modifyBoard(boardRequestDTO, board_id);
	}
	
}
