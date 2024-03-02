package com.web.app.security.exception;

import java.util.Date;
import java.util.Map;

import org.springframework.http.MediaType;

import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

//사용자 정의 예외
public class AccessTokenException extends RuntimeException{
	
	TOKEN_ERROR token_error;
	
	@Getter
	@AllArgsConstructor
	public enum TOKEN_ERROR { //ENUM(열거형)은 특정 값들의 집합을 나타내는 자료형
        UNACCEPT(401, "Token is null or too short"),
        BADTYPE(401, "Token Type Bearer"),
        MALFORM(403, "Malformed Token"),
        BADSIGN(403, "BadSignatured Token"),
        EXPIRED(403, "Expired Token");
		
		//위의 ENUM값들 중 하나로 아래에 status와 message가 정의된다.
		private int status;
        private String message;
	}
	
	//사용자 정의 예외 생성자
	public AccessTokenException(TOKEN_ERROR token_error) {
		super(token_error.name());
		this.token_error = token_error;
	}
	
	public void sendResponseError(HttpServletResponse response) {
		response.setStatus(token_error.getStatus());
		//HTTP 응답의 컨텐츠 타입을 JSON으로 설정합니다
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		
		Gson gson = new Gson(); //google에서 제공하는 JSON라이브러리(객체를 JSON문자열로 변환)
		
		//Map.of()는 불변한 Map객체를 생성하기 위한 간단한 방법
		//Map.of()를 통해서 에러메시지와 현재시간을 담은 맵을 생성
		String jsonStr = gson.toJson(Map.of(
				"message",token_error.getMessage(),
				"time",new Date()
				));
		
		try {
			//getWriter를 통해 출력스트림을 얻고 println으로 JSON 문자열을 클라이언트에게 전송
			response.getWriter().println(jsonStr);
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
		
	}
}
