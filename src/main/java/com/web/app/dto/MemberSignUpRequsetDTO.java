package com.web.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
//@Setter //컨트롤러 단에서 setter를 열 필요가 없기 때문에 RequestDTO를 만드는거라는데..? Spring은 setter로 값을 저장시켜주는게 아닌가?
public class MemberSignUpRequsetDTO {
	private String member_id;
	private String passwd;
	private String email;
	private String role;
	//여기서부터 회원가입에 필요한 DTO를 구성해서 넘겨주면 될 듯함
	//컨트롤러에서 RequstDTO로 받고 서비스에서 Member객체로 바꿔주면 될 듯
	//그러면 MemberDTO를 따로 둔 상태로 Member 도메인을 두는건가,,?
	//그러면 계층간 데이터 전송을 할 때는 MemberDTO를 쓰고 비즈니스 로직에서는 Member 도메인 객체인건가??
	
	//후딱 수정하고 피드백 받으면서 물어볼 것
	
	//이후 동시성 제어도 해야하고  JPA공부도 해야함
}
