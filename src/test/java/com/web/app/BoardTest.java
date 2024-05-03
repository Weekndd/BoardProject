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

import com.web.app.domain.Board;
import com.web.app.dto.board.BoardRequestDTO;
import com.web.app.dto.member.MemberSignUpRequsetDTO;
import com.web.app.dto.pagination.Criteria;
import com.web.app.dto.pagination.PageDTO;
import com.web.app.repository.board.BoardRepository;
import com.web.app.repository.member.MemberRepository;
import com.web.app.security.SecurityUser;
import com.web.app.service.board.BoardService;
import com.web.app.service.member.MemberService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class BoardTest {
	@Autowired
	private BoardService boardService;
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
		List<Board> list = boardRepository.getBoardListWithPaging(criteria);
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
		
		List<Board> list = boardRepository.searchTest("searchTest",outer);
		list.forEach(b -> log.info(b.toString()));
	}
	
	@Test
	@DisplayName("검색 및 페이징 테스트")
	public void testSearchPaging() {
		Criteria criteria = new Criteria();
		criteria.setType("T");
		criteria.setKeyword("테스트");
		List<Board> list = boardRepository.getBoardListWithPaging(criteria);
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
	    log.info(thrown.getMessage());
//	    assertThat(thrown.getMessage()).isEqualTo("아이디 혹은 이메일이 사용중입니다.\n다른 아이디, 이메일로 재시도해주세요.");
	}
	
	@Test
	@DisplayName("더미데이터 입력")
	public void insertTest() {
		for(int i=1; i<= 253; i++) {
			boardRepository.register(Board.of("더미데이터 "+i, "더미데이터 내용"+i, "sss", "hsch19@naver.com"));
		}
	}
	
}
