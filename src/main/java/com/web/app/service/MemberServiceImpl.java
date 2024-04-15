package com.web.app.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.app.domain.Member;
import com.web.app.dto.MemberDTO;
import com.web.app.dto.MemberSignUpRequsetDTO;
import com.web.app.repository.MemberRepository;
import com.web.app.util.JwtToken;
import com.web.app.util.JwtTokenProvider;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
	
	private final MemberRepository memberRepository;
	private final AuthenticationManagerBuilder authenticationManagerBuilder;
	private final JwtTokenProvider jwtTokenProvider;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	@Transactional
	public void postMemberSignUp(MemberSignUpRequsetDTO memberSignUpRequsetDTO) {
		Member member = createNewMemberAndEncodePassword(memberSignUpRequsetDTO);
		memberRepository.postMemberSignUp(member);
	}
	
	private Member createNewMemberAndEncodePassword(MemberSignUpRequsetDTO memberSignUpRequsetDTO) {
		String encodingPasswd = passwordEncoder.encode(memberSignUpRequsetDTO.getPasswd());
		Member newMember = new Member(memberSignUpRequsetDTO.getMember_id(),
				encodingPasswd,
				memberSignUpRequsetDTO.getEmail(),
				memberSignUpRequsetDTO.getRole());
		return newMember;
	}
	
	@Override
	public JwtToken postLoginData(String member_id, String passwd) {
		
		//1. username + password를 기반으로 Authentication 객체 생성
		//이때 authentication은 인증여부를 확인하는 authenticated값이 false이다.
		UsernamePasswordAuthenticationToken authenticationToken 
			= new UsernamePasswordAuthenticationToken(member_id, passwd);
		
		//2. 실제검증 - authenticate()메서드를 통해 요청된 Member에 대한 검증진행
		//authenticate()메서드가 실행될 때 CustomUserDetailService에서 만든 loadUserByUsername 메서드 실행
		Authentication authentication = 
				authenticationManagerBuilder.getObject().authenticate(authenticationToken);
		
		//3. 인증 정보를 기반으로 JWT토큰 생성
		JwtToken jwtToken = jwtTokenProvider.generateToken(authentication);
		return jwtToken;
	}
}
