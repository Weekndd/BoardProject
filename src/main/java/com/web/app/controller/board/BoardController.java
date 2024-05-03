package com.web.app.controller.board;

import org.springframework.stereotype.Controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class BoardController {
	
	//게시글 목록
	@GetMapping("/boardList")
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
