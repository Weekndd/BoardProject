package com.web.app.domain;

import org.springframework.data.annotation.TypeAlias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@TypeAlias("Member")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	private String member_id;
	private String passwd;
	private String email;
	private String role;
	
	public static Member of(String member_id, String passwd, String email, String role) {
		return new Member(member_id, passwd, email, role);
	}
	
}
