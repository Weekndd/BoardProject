package com.web.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.web.app.domain.Likes;
import com.web.app.repository.likes.LikesRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class LikesTest {
	@Autowired
	private LikesRepository likesRepository;
	
	@Test
	@DisplayName("좋아요 테스트")
	public void likeBoardTest() {
		likesRepository.likeBoard(new Likes(0,282,"sss"));
	}
}
