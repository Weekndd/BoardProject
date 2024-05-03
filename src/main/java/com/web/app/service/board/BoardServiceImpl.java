package com.web.app.service.board;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.app.domain.Board;
import com.web.app.dto.board.BoardResponseDTO;
import com.web.app.dto.board.BoardListResponseDTO;
import com.web.app.dto.board.BoardRequestDTO;
import com.web.app.dto.pagination.Criteria;
import com.web.app.dto.pagination.PageDTO;
import com.web.app.repository.board.BoardRepository;
import com.web.app.security.SecurityUser;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl  implements BoardService {
	private final BoardRepository boardRepository;
	
	@Override
	public List<BoardListResponseDTO> getBaordListWithPaging(int pageNum, String type, String keyword) {
		Criteria criteria = getCriteria(pageNum, type, keyword);
		List<Board> boardList = boardRepository.getBoardListWithPaging(criteria);
		
		return boardList.stream()
				.map(board -> BoardListResponseDTO.of(board))
				.collect(Collectors.toList());
	}
	
	private static Criteria getCriteria(int pageNum, String type, String keyword) {
		Criteria criteria = new Criteria(pageNum, 10);
		criteria.setType(type);
		criteria.setKeyword(keyword);
		return criteria;
	}
	
	@Override
	public BoardResponseDTO getBoard(Long board_id) {
		Board board = boardRepository.getBoard(board_id);
		return BoardResponseDTO.of(board);
	}

	@Transactional
	@Override
	public void register(BoardRequestDTO boardRegisterRequestDTO, SecurityUser securityUser) {
		Board newBoard = createNewBoard(boardRegisterRequestDTO, securityUser);
		boardRepository.register(newBoard);
	}
	private static Board createNewBoard(BoardRequestDTO boardRegisterRequestDTO, SecurityUser securityUser) {		
		String title = boardRegisterRequestDTO.getTitle();
		String content = boardRegisterRequestDTO.getContent();
		String writer = securityUser.getUsername();
		String email = securityUser.getEmail();
		return Board.of(title, content, writer, email);
	}

	@Transactional
	@Override
	public void deleteBoard(Long board_id) {
		boardRepository.deleteBoard(board_id);
	}

	@Transactional
	@Override
	public void modifyBoard(BoardRequestDTO boardRequestDTO, Long board_id) {
		Board board = boardRepository.getBoard(board_id);
		board.change(boardRequestDTO.getTitle(), boardRequestDTO.getContent());
		boardRepository.modifyBoard(board);
		
	}
	
	@Override
	public PageDTO getPageInfo(int pageNum, String type, String keyword) {
		Criteria criteria = getCriteria(pageNum, type, keyword);
		long totalPosting = boardRepository.getTotalPostingCount(criteria);
		PageDTO pageDTO = new PageDTO(criteria, totalPosting);
		return pageDTO;
	}

	

	


	
}
