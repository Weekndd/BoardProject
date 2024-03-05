package com.web.app.service;

import com.web.app.dto.MemberDTO;
import com.web.app.util.JwtToken;

public interface MemberService {

	void postMemberSignUp(MemberDTO memberDTO);

	JwtToken postLoginData(String username, String password);

	MemberDTO postMemberSignUpValidation(String member_id, String email);

}
