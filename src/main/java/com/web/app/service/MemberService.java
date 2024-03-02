package com.web.app.service;

import com.web.app.dto.MemberDTO;
import com.web.app.util.JwtToken;

public interface MemberService {

	void postMemberJoin(MemberDTO memberDTO);

	JwtToken postLoginData(String username, String password);

}
