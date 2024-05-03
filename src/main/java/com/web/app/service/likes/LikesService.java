package com.web.app.service.likes;

import com.web.app.dto.likes.LikesRequestDTO;
import com.web.app.security.SecurityUser;

public interface LikesService {

	void likeBoard(SecurityUser securityUser, LikesRequestDTO likesRequestDTO);

}
