package com.web.app.repository;

import com.web.app.domain.Member;
import com.web.app.dto.MemberDTO;

public interface MemberRepository {

	void postMemberSignUp(Member newMember);

	MemberDTO findMemberByMember_id(String member_id);

	MemberDTO findMemberByEmail(String email);

}
