package com.web.app.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.app.dto.MemberDTO;
import com.web.app.repository.MemberRepository;
import com.web.app.security.SecurityUser;
import com.web.app.service.MemberService;
import com.web.app.util.JwtToken;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberRestController {
	private final MemberService memberService;
	private final MemberRepository memberRepository;
	
	@GetMapping("/member/signUp/validation/member_id={member_id}")
	public MemberDTO getDuplicationMemberId(@PathVariable String member_id) {
		return memberRepository.findMemberByMember_id(member_id);
	}
	
	@GetMapping("/member/signUp/validation/email={email}")
	public MemberDTO getDuplicationEmail(@PathVariable String email) {
		return memberRepository.findMemberByEmail(email);
	}
	
	@PostMapping("/member")
	public void postMemberSignUp(@RequestBody MemberDTO memberDTO) {
		memberService.postMemberSignUp(memberDTO);
	}
	
	@GetMapping("/member")
	public MemberDTO getLoginMember(@AuthenticationPrincipal SecurityUser securityUser) {			//securityUser.getAuthList().get(0)
		return new MemberDTO(securityUser.getMember_id(), null, securityUser.getEmail(), null); //접근제한 할 때 여기에 권한넣으면 됨 위와 같은 형식으로 하면 될 듯?
	}
	
	
}
