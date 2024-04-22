package com.web.app.dto.board;


import com.web.app.domain.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class BoardListResponseDTO {
	private final Long board_id;
	private final String title;
	private final String writer;
	private final String email;
	private final String create_at;
	private final String modified_at;
	
	public static BoardListResponseDTO of(Board board) {
		return BoardListResponseDTO.builder()
				.board_id(board.getBoard_id())
				.title(board.getTitle())
				.writer(board.getWriter())
				.email(board.getEmail())
				.modified_at(board.getModified_at())
				.create_at(board.getCreate_at())
				.build();
	}
}
