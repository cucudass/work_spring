package com.lgy.board_std_mysql.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgy.board_std_mysql.dao.BoardDAO;
import com.lgy.board_std_mysql.dto.BoardDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("BoardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ArrayList<BoardDTO> list() {
		log.info("@# BoardServiceImpl list");
		
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		//model.addAttribute("list", dao.list());
		ArrayList<BoardDTO> list = dao.list();
		
		return list;
	}

	@Override
	//public void write(String boardName, String boardTitle, String boardContent) {
	public void write(HashMap<String, String> param) {
		log.info("@# BoardServiceImpl write");
		
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.write(param);
	}

	@Override
	public BoardDTO contentView(HashMap<String, String> param) {
		log.info("@# BoardServiceImpl content_view");
		
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.upHit(param);
		BoardDTO dto = dao.contentView(param);
		
		return dto;
	}

	@Override
	public void upHit(HashMap<String, String> param) {
		log.info("@# BoardServiceImpl upHit");
		
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.upHit(param);
	}

	@Override
	public void modify(HashMap<String, String> param) {
		log.info("@# BoardServiceImpl modify");
		
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.modify(param);
	}

	@Override
	public void delete(HashMap<String, String> param) {
		log.info("@# BoardServiceImpl delete");
		
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.delete(param);
	}
}