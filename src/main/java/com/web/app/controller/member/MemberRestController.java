package com.web.app.controller.member;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.app.dto.member.MemberInfoResponseDTO;
import com.web.app.dto.member.MemberSignUpRequsetDTO;
import com.web.app.repository.member.MemberRepository;
import com.web.app.security.SecurityUser;
import com.web.app.service.member.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberRestController {
	private final MemberService memberService;
	private final MemberRepository memberRepository;
	
	@GetMapping("/member/signUp/validation/member_id={member_id}")
	public int getDuplicationMemberId(@PathVariable String member_id) {
		return memberRepository.DuplicationCheckMember_id(member_id);
	}
	
	@GetMapping("/member/signUp/validation/email={email}")
	public int getDuplicationEmail(@PathVariable String email) {
		return memberRepository.DuplicationCheckEmail(email);
	}
	
	@PostMapping("/member")
	public void postMemberSignUp(@RequestBody MemberSignUpRequsetDTO memberSignUpRequsetDTO) {
		memberService.postMemberSignUp(memberSignUpRequsetDTO);
	}
	
	@GetMapping("/member")
	public MemberInfoResponseDTO getLoginMember(@AuthenticationPrincipal SecurityUser securityUser) {			//securityUser.getAuthList().get(0)
		return new MemberInfoResponseDTO(securityUser.getMember_id(), securityUser.getEmail(), null); //접근제한 할 때 여기에 권한넣으면 됨 위와 같은 형식으로 하면 될 듯?
	}
	
	
}
