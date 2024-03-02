package com.web.app.repository;

import com.web.app.dto.MemberDTO;

public interface MemberRepository {

	void postMemberJoin(MemberDTO memberDTO);

	MemberDTO findMemberByMember_id(String member_id);

}
