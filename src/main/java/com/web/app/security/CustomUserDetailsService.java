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
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			MemberDTO memberDTO = memberRepository.findMemberByMember_id(username);
			SecurityUser securityUser = SecurityUser.builder()
					.member_id(memberDTO.getMember_id())
					.passwd(memberDTO.getPasswd())
					.build();
			securityUser.getAuthList().add("USER");
			return createUserDetails(securityUser);
			
		} catch (UsernameNotFoundException usernameNotFoundException) {
			System.out.println(usernameNotFoundException);
			return null;
		}
		
	}
	
	private UserDetails createUserDetails(SecurityUser securityUser) {
		return User.builder()
				.username(securityUser.getUsername())
				.password(passwordEncoder.encode(securityUser.getPassword()))
				.roles(securityUser.getAuthList().toArray(new String[0]))
				.build();
	}

	
}
