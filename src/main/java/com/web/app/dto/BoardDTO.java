package com.web.app.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Alias("boardDTO")
public class BoardDTO {
		int board_id;
		String title;
		String content;
		String writer;
		String email;
		String create_at;
		String modified_at;
		
}

