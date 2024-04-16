package com.web.app.domain;

import org.springframework.data.annotation.TypeAlias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@TypeAlias("Board")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	String board_id;
	String title;
	String content;
	String writer;
	String email;
	String 	create_at;
	String modified_at;
}
