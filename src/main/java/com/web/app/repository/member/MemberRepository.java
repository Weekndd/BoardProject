package com.web.app.repository.member;

import com.web.app.domain.Member;

public interface MemberRepository {

	void postMemberSignUp(Member newMember);

	Member findMemberByMember_id(String member_id);
	
	int DuplicationCheckMember_id(String member_id);

	int DuplicationCheckEmail(String email);

}
