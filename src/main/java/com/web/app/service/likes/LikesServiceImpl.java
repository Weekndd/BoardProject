package com.web.app.service.likes;

import org.springframework.stereotype.Service;

import com.web.app.domain.Likes;
import com.web.app.dto.likes.LikesRequestDTO;
import com.web.app.repository.likes.LikesRepository;
import com.web.app.security.SecurityUser;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LikesServiceImpl implements LikesService{
	private final LikesRepository likesRepository;

	@Override
	public void likeBoard(SecurityUser securityUser, LikesRequestDTO likesRequestDTO) {
		Likes likes = Likes.of(securityUser, likesRequestDTO);
		likesRepository.likeBoard(likes);
	}
	
	
}
