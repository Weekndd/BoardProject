package com.web.app;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import com.web.app.dto.Criteria;
import com.web.app.dto.PageDTO;
import com.web.app.dto.board.BoardDTO;
import com.web.app.dto.member.MemberSignUpRequsetDTO;
import com.web.app.repository.BoardRepository;
import com.web.app.repository.MemberRepository;
import com.web.app.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class BoardTest {
	@Autowired
	private BoardRepository boardRepository;
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	public void testPaging() {
		//1-10
		Criteria criteria = new Criteria();
		List<BoardDTO> list = boardRepository.getBoardListWithPaging(criteria);
		list.forEach(board -> log.info(board.toString()));
	}
	
	@Test
	public void testPageDTO() {
		Criteria criteria = new Criteria();
		criteria.setPageNum(12);
		PageDTO pageDTO = new PageDTO(criteria, 140);
		log.info(pageDTO.toString());
	}
	
	@Test
	public void testTotalPosting() {
		long total = boardRepository.getTotalPostingCount(new Criteria(1,10));
		log.info("=============총 포스팅 개수 : "+total);
	}
	
	@Test
	public void searchTest() {
		Map<String, String> map = new HashMap<>();
		map.put("T", "더미");
		map.put("C", "더미");
		Map<String, Map<String,String>> outer = new HashMap<>();
		outer.put("map", map);
		
		List<BoardDTO> list = boardRepository.searchTest("searchTest",outer);
		list.forEach(b -> log.info(b.toString()));
	}
	
	@Test
	@DisplayName("검색 및 페이징 테스트")
	public void testSearchPaging() {
		Criteria criteria = new Criteria();
		criteria.setType("T");
		criteria.setKeyword("테스트");
		List<BoardDTO> list = boardRepository.getBoardListWithPaging(criteria);
		list.forEach(board -> log.info(board.toString()));
	}
	
	@Test
	@DisplayName("회원가입 실패 - 아이디/이메일 중복")
	public void duplicationTest() {
	    //Given
	    MemberSignUpRequsetDTO dto = new MemberSignUpRequsetDTO("test", "1234", "test@naver.com", "user");
	    //When
	    Throwable thrown = assertThrows(DataIntegrityViolationException.class, () -> memberService.postMemberSignUp(dto));
	    //Then
	    assertThat(thrown.getMessage()).isEqualTo("아이디 혹은 이메일이 사용중입니다.");
	}
}
