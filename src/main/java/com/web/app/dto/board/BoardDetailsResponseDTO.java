package com.web.app.dto.board;

import com.web.app.domain.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class BoardDetailsResponseDTO {
	private final int board_id;
	private final String title;
	private final String content;
	private final String writer;
	private final String email;
	
	public static BoardDetailsResponseDTO of(Board board) {
		return BoardDetailsResponseDTO.builder()
				.board_id(board.getBoard_id())
				.title(board.getTitle())
				.content(board.getContent())
				.writer(board.getWriter())
				.email(board.getEmail())
				.build();
	}
}
