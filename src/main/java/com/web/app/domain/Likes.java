package com.web.app.domain;

import org.springframework.data.annotation.TypeAlias;

import com.web.app.dto.likes.LikesRequestDTO;
import com.web.app.security.SecurityUser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@TypeAlias("Likes")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Likes {
	private long likes_id;
	private long board_id;
	private String member_id;
	
	public static Likes of(SecurityUser securityUser, LikesRequestDTO likesRequestDTO) {
		return Likes.builder()
				.board_id(likesRequestDTO.getBoard_id())
				.member_id(securityUser.getUsername())
				.build();
	}
}
