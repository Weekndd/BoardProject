package com.web.app.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.web.app.dto.board.BoardDTO;
import com.web.app.dto.board.BoardDetailsResponseDTO;
import com.web.app.dto.board.BoardListResponseDTO;
import com.web.app.dto.board.BoardRegisterRequestDTO;
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
	public BoardDetailsResponseDTO getBoard(@PathVariable Long board_id) {
		BoardDetailsResponseDTO boardDetailsResponseDTO = boardService.getBoard(board_id);
		return boardDetailsResponseDTO;
	}
	
	//게시글 등록
	@PostMapping("/board/register")
	public void postBoard(@AuthenticationPrincipal SecurityUser securityUser,
			@RequestBody BoardRegisterRequestDTO boardRegisterRequestDTO) {
		boardService.register(boardRegisterRequestDTO, securityUser);
	}
	
	@DeleteMapping("/board/{board_id}")
	public void deleteBoard(@PathVariable Long board_id) {
		boardService.deleteBoard(board_id);
	}
	
	@PutMapping("/board/{board_id}")
	public void modifiyBoard(@RequestBody BoardRegisterRequestDTO boardRegisterRequestDTO) {
		//지금까지는 DTO를 service에서 domain으로 변환해서 리포지토리에 넘겨줬는데, board를 수정할 때는....? 그냥 똑같나??
//		boardService.modifyBoard(boardRegisterRequestDTO);
	}
	
}
