package com.web.app.domain;

import org.springframework.data.annotation.TypeAlias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@TypeAlias("Member")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	String member_id;
	String passwd;
	String email;
	String role;
}
