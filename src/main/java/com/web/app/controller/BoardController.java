package com.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.web.app.dto.BoardDTO;
import com.web.app.service.BoardService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequiredArgsConstructor
public class BoardController {
	
	//게시글 목록
	@GetMapping("/boardList/{pageNum}")
	public String mappingBoardList(HttpServletRequest request) {
		return "Board_list";
	}
	
	//게시글 상세조회 페이지
	@GetMapping("/board/details/{board_id}")
	public String mappingBoardDetails() {
		return "Board_details";
	}
	
	//게시글 등록 페이지
	@GetMapping("/board/register")
	public String mappingBoardRegister() {
		return "Board_register";
	}
	
	//게시글 수정 페이지
	@GetMapping("/board/modify/{board_id}")
	public String mappingBoardModify() {
		return "Board_modify";
	}
	
}
