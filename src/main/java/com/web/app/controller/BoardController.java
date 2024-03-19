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


@Controller
@RequiredArgsConstructor
public class BoardController {
	
	//홈화면
	@GetMapping("/board")
	public String mappingBoardList(HttpServletRequest request) {
		System.out.println("보드 컨트롤러 ======================================");
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
	
	
}
