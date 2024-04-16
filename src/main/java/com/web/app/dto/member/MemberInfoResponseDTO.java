package com.web.app.dto.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberInfoResponseDTO {
	private final String member_id;
	private final String email;
	private final String role;
}
