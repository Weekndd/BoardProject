package com.web.app.dto.member;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Alias("MemberDTO")
public class MemberDTO {
	String member_id;
	String passwd;
	String email;
	String role;
}
