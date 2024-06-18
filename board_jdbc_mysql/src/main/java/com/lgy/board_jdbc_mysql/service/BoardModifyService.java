package com.lgy.board_jdbc_mysql.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lgy.board_jdbc_mysql.dao.BoardDAO;

public class BoardModifyService implements BoardService {

	@Override
	public void execute(Model model) {
		//dao 호출단
		BoardDAO dao = new BoardDAO();
		Map<String, Object> map = model.asMap();
		
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String boardNo = request.getParameter("boardNo");
		String boardName = request.getParameter("boardName");
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		
		dao.modify(boardNo, boardName, boardTitle, boardContent);
	}
}
