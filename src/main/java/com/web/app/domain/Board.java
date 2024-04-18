package com.web.app.domain;

import org.springframework.data.annotation.TypeAlias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@TypeAlias("Board")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	private int board_id;
	private String title;
	private String content;
	private String writer;
	private String email;
	private String 	create_at;
	private String modified_at;
	
	public static Board of(String title, String content, String writer, String email) {
		return Board.builder()
				.title(title)
				.content(content)
				.writer(writer)
				.email(email)
				.build();
	}
}
