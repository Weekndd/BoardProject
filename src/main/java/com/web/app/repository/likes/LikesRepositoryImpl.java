package com.web.app.repository.likes;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.web.app.domain.Likes;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class LikesRepositoryImpl implements LikesRepository{
	private final SqlSessionTemplate session;
	
	@Override
	public void likeBoard(Likes likes) {
		int res = session.insert("likeBoard",likes);
		
	}

}
