package com.web.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderConfig {
	//Security.Config에서 등록시 순환참조가 발생해서 따로 뺐음.
	@Bean
	public PasswordEncoder passwordEncoder() {
		//BCrypt Encoder 사용
		return new BCryptPasswordEncoder();
		
	}
}
