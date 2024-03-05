package com.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.app.security.SecurityUser;
import com.web.app.service.MemberService;
import com.web.app.util.JwtToken;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {
	private final MemberService memberService;
	
	@GetMapping("/member/signUp")
	public String mappingMemberSignUp() {
		return "Member_signUp";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@PostMapping("/postLoginData")
	public String postLoginData(SecurityUser user, HttpServletResponse response) {
		String member_id = user.getUsername();
		String passwd = user.getPassword();
		System.out.println(member_id+" "+passwd+"=======================================================");
		JwtToken jwtToken = memberService.postLoginData(member_id, passwd);
		
		log.info("request username = {}, password = {}", member_id, passwd);
        log.info("jwtToken accessToken = {}, refreshToken = {}", jwtToken.getAccessToken(),
        		jwtToken.getRefreshToken());
        System.out.println("ACCESS_TOKEN: "+jwtToken.getAccessToken()+"============================================");
        System.out.println("REFRESH_TOKEN: "+jwtToken.getRefreshToken()+"============================================");
        
        Cookie accessTokenCookie = new Cookie("accessToken", jwtToken.getAccessToken());
        accessTokenCookie.setMaxAge(7 * 24 * 60 * 60); // 7일 동안 유효
        accessTokenCookie.setPath("/");
        accessTokenCookie.setDomain("localhost");
        accessTokenCookie.setSecure(false);

        response.addCookie(accessTokenCookie);
        return "redirect:/board";  //로그인 된 이후 주소 바꾸고싶어서...redirect로 해봤음
	}
}
