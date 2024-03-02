package com.web.app.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.web.app.dto.BoardDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepository{
	private final SqlSessionTemplate session;
	
	public void test() {
		BoardDTO boardDto = new BoardDTO();
		boardDto.setTitle("Testing");
		boardDto.setContent("TestContents");
		boardDto.setWriter("hsch");
		boardDto.setEmail("hsch19@naver.com");
		int res = session.insert("TestInsert",boardDto);
		System.out.println("결과 : "+ res);
	}	
	
	
	@Override
	public List<BoardDTO> getBoardList() {
		List<BoardDTO> boardList = session.selectList("getBoardList");
		return boardList;
	}


	@Override
	public BoardDTO getBoard(Long board_id) {
		BoardDTO boardDTO = session.selectOne("getBoard",board_id);
		return boardDTO;
	}

	@Override
	public void register(BoardDTO boardDTO) {
		int res = session.insert("registerBoard",boardDTO);
		System.out.println("결과 : "+ res);
	}


}
