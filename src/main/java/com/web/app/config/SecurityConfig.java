package com.web.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.web.app.filter.JwtAuthenticationFilter;
import com.web.app.security.CustomUserDetailsService;
import com.web.app.util.JwtTokenProvider;

import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	private final JwtTokenProvider jwtTokenProvider;
	private final CustomUserDetailsService customUserDetailsService;
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		//토큰을 사용하기 때문에 세션을 사용하지 않는다는 설정
		httpSecurity.sessionManagement(management ->management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		httpSecurity.authorizeHttpRequests(requests ->requests
				.requestMatchers("/script/**","css/**","/jquery/**","/favicon.*","/*/icon-*").permitAll()
				.requestMatchers(HttpMethod.GET, "/login").permitAll() //로그인 페이지 요청은 모두에게 허용
				.requestMatchers(HttpMethod.POST,"/postLoginData").permitAll() //로그인 요청은 모두에게 허용
				
				.requestMatchers(HttpMethod.GET, "/member/signUp").permitAll() //회원가입 페이지 요청은 모두에게 허용
				.requestMatchers(HttpMethod.POST, "/member/signUp").permitAll() //회원가입 요청은 모두에게 허용
				.requestMatchers(HttpMethod.GET,"/member/signUp/validation/*").permitAll() //회원가입 아이디 중복체크
				.requestMatchers("/member/test").hasRole("USER")//테스트를 위함
				.requestMatchers("/error").permitAll()//에러 났을 경우, 
				.anyRequest().authenticated()) //나머지 요청들은 인증 필요하도록 설정
		//RestAPI의 경우, csrf 와 basic auth를 설정이 필요없다고 함
		.csrf(csrf -> csrf.disable())
		.cors(cors -> cors.disable())
		.httpBasic(httpBasic -> httpBasic.disable())
		
		.addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), //UsernamePasswordAuthenticationFilter필터 실행전
				UsernamePasswordAuthenticationFilter.class)		//JwtAuthenticationFilter실행
		.userDetailsService(customUserDetailsService);//내가 커스텀한 UserDetailsService를 사용할꺼임!
		
		httpSecurity.formLogin(login -> login
				.loginPage("/login"));
			
		return httpSecurity.build();
	}
	
}
