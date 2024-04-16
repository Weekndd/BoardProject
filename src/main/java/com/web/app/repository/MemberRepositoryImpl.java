package com.web.app.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.web.app.domain.Member;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository{
	
	private final SqlSessionTemplate session;

	@Override
	public void postMemberSignUp(Member member) {
		session.insert("signUpMember", member);
	}

	@Override
	public Member findMemberByMember_id(String member_id) {
		Member member = session.selectOne("findMemberByMember_id",member_id);
		return member;
	}
	
	@Override
	public int DuplicationCheckMember_id(String member_id) {
		int result = session.selectOne("DuplicationCheckMember_id",member_id);
		return result;
	}
	@Override
	public int DuplicationCheckEmail(String email) {
		int result = session.selectOne("DuplicationCheckEmail",email);
		return result;
	}

}
