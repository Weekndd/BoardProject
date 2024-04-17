package com.web.app.domain;

import org.springframework.data.annotation.TypeAlias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@TypeAlias("Board")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	private String board_id;
	private String title;
	private String content;
	private String writer;
	private String email;
	private String 	create_at;
	private String modified_at;
	
	public static Board of(String title, String content, String writer, String email) {
		Board board = new Board(
				null,
				title,
				content,
				writer,
				email,
				null,
				null);
		return board;
	}
}
