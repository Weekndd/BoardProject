package com.web.app.controller.likes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.app.dto.likes.LikesRequestDTO;
import com.web.app.security.SecurityUser;
import com.web.app.service.likes.LikesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LikesRestController {
	private final LikesService likesService;
	
	@PostMapping("/likes")
	public ResponseEntity likeBoard(@AuthenticationPrincipal SecurityUser securityUser,
			LikesRequestDTO likesRequestDTO) {
		likesService.likeBoard(securityUser, likesRequestDTO);
		return new ResponseEntity("Liked"+likesRequestDTO.getBoard_id()+" board", HttpStatus.OK);
	}
}
