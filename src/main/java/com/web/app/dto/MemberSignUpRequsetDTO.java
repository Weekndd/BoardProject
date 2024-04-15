package com.web.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberSignUpRequsetDTO {
	private final String member_id;
	private final String passwd;
	private final String email;
	private final String role;
	//그러면 MemberDTO를 따로 둔 상태로 Member 도메인을 두는건가,,?
	//그러면 계층간 데이터 전송을 할 때는 MemberDTO를 쓰고 비즈니스 로직에서는 Member 도메인 객체인건가??
}
