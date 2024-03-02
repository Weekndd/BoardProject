package com.web.app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.app.dto.MemberDTO;
import com.web.app.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberRestController {
	private final MemberService memberService;
	private final BoardController boardController;
	
	@PostMapping("/postMemberJoin")
	public void postMemberJoin(MemberDTO memberDTO) {
		memberService.postMemberJoin(memberDTO);
	}
	
}
