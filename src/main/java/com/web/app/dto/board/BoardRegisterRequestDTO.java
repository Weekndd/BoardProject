package com.web.app.dto.board;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class BoardRegisterRequestDTO {
	private final String title;
	private final String content;
}
