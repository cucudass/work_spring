package com.lgy.board_jdbc_mysql.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lgy.board_jdbc_mysql.dao.BoardDAO;
import com.lgy.board_jdbc_mysql.dto.BoardDTO;

public class BoardContentService implements BoardService {

	@Override
	public void execute(Model model) {
		//dao 호출단
		BoardDAO dao = new BoardDAO();
		Map<String, Object> map = model.asMap();
		
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String boardNo = request.getParameter("boardNo");
		//게시글 하나의 내용을 BoardDTO 객체로 받음  
		BoardDTO dto = dao.contentView(boardNo);
		model.addAttribute("content_view", dto);
	}
}