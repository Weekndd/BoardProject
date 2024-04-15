package com.web.app.repository;

import com.web.app.domain.Member;
import com.web.app.dto.MemberDTO;

public interface MemberRepository {

	void postMemberSignUp(Member newMember);

	Member findMemberByMember_id(String member_id);
	
	int DuplicationCheckMember_id(String member_id);

	int DuplicationCheckEmail(String email);

}
