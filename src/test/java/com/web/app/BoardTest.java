package com.web.app;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.web.app.dto.BoardDTO;
import com.web.app.dto.Criteria;
import com.web.app.dto.PageDTO;
import com.web.app.repository.BoardRepository;

import lombok.extern.slf4j.Slf4j;

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
		long total = boardRepository.getTotalPostingCount();
		log.info("=============총 포스팅 개수 : {total}"+total);
	}
	
}
