package com.web.app.service;

import com.web.app.dto.MemberDTO;
import com.web.app.dto.MemberSignUpRequsetDTO;
import com.web.app.util.JwtToken;

public interface MemberService {

	void postMemberSignUp(MemberSignUpRequsetDTO memberSignUpRequsetDTO);

	JwtToken postLoginData(String username, String password);

}
