package com.web.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.web.app.dto.BoardDTO;
import com.web.app.dto.Criteria;
import com.web.app.dto.PageDTO;
import com.web.app.repository.BoardRepository;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.clio.annotations.Trace;

@SpringBootTest
@Slf4j
public class BoardTest {
	@Autowired
	private BoardRepository boardRepository;
	
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
	public void testSearchPaging() {
		Criteria criteria = new Criteria();
		criteria.setType("T");
		criteria.setKeyword("테스트");
		List<BoardDTO> list = boardRepository.getBoardListWithPaging(criteria);
		list.forEach(board -> log.info(board.toString()));
	}
}
