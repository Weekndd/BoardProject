package com.web.app.dto;

import lombok.Getter;

@Getter
public class MemberSignUpRequsetDTO {
	private String member_id;
	private String passwd;
	private String email;
	private String role;
	//그러면 MemberDTO를 따로 둔 상태로 Member 도메인을 두는건가,,?
	//그러면 계층간 데이터 전송을 할 때는 MemberDTO를 쓰고 비즈니스 로직에서는 Member 도메인 객체인건가??
}
