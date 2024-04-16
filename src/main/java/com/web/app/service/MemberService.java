package com.web.app.service;

import com.web.app.dto.member.MemberSignUpRequsetDTO;
import com.web.app.util.JwtToken;

public interface MemberService {

	void postMemberSignUp(MemberSignUpRequsetDTO memberSignUpRequsetDTO);

	JwtToken postLoginData(String username, String password);

}
