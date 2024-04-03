package com.web.app.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.web.app.dto.BoardDTO;
import com.web.app.dto.Criteria;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepository{
	private final SqlSessionTemplate session;
	
	
	
	@Override
	public List<BoardDTO> getBoardList() {
		List<BoardDTO> boardList = session.selectList("getBoardList");
		return boardList;
	}
	@Override
	public List<BoardDTO> getBoardListWithPaging(Criteria criteria) {
		List<BoardDTO> list = session.selectList("getBoardListWithPaging",criteria);
		return list;
	}

	@Override
	public BoardDTO getBoard(Long board_id) {
		BoardDTO boardDTO = session.selectOne("getBoard",board_id);
		return boardDTO;
	}

	@Override
	public void register(BoardDTO boardDTO) {
		int res = session.insert("registerBoard",boardDTO);
	}


	@Override
	public void deletePosting(Long board_id) {
		int res = session.delete("deletePosting",board_id);
	}


	@Override
	public void modifyPosting(BoardDTO boardDTO) {
		int res = session.update("modifyPosting",boardDTO);
	}
	
	@Override
	public long getTotalPostingCount(Criteria criteria) {
		long total = session.selectOne("getTotalPostingCount",criteria);
		return total;
	}
	
	@Override
	public List<BoardDTO> searchTest(String string, Map<String, Map<String, String>> outer) {
		List<BoardDTO> list = session.selectList("searchTest", outer);
		return list;
	}
	
	
}
