package com.web.app.security;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.web.app.dto.MemberDTO;
import com.web.app.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{
	private final MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			MemberDTO memberDTO = memberRepository.findMemberByMember_id(username);

			SecurityUser securityUser = SecurityUser.builder()
					.member_id(memberDTO.getMember_id())
					.passwd(memberDTO.getPasswd())
					.email(memberDTO.getEmail())
					.build();
			securityUser.getAuthList().add("USER");
//			System.out.println("loadUserByUsername : "+ securityUser.getEmail());
			return securityUser;
//			return createUserDetails(securityUser);  --> @AuthenticationPrincipal을 사용해서 커스텀된 사용자정보를 가져오기 위해 바꿔줬음
			
		} catch (UsernameNotFoundException usernameNotFoundException) {
			System.out.println(usernameNotFoundException);
			return null;
		}
		
	}
	
	private UserDetails createUserDetails(SecurityUser securityUser) {
		return User.builder()
				.username(securityUser.getUsername())
				.password(securityUser.getPassword())
				.roles(securityUser.getAuthList().toArray(new String[0]))
				.build();
	}

	
}
