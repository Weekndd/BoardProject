package com.web.app.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.web.app.dto.MemberDTO;
import com.web.app.security.SecurityUser;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository{
	
	private final SqlSessionTemplate session;

	@Override
	public void postMemberSignUp(MemberDTO memberDTO) {
		session.insert("joinMember",memberDTO);
	}

	@Override
	public MemberDTO findMemberByMember_id(String member_id) {
		MemberDTO memberDTO = session.selectOne("findMemberByMember_id",member_id);
		return memberDTO;
	}
	@Override
	public MemberDTO findMemberByEmail(String email) {
		MemberDTO memberDTO = session.selectOne("findMemberByEmail",email);
		
		return memberDTO;
	}

}
