package com.lgy.board_mysql.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lgy.board_mysql.dao.BoardDAO;

//게시글 저장
public class BoardWriteService implements BoardService {

	@Override
	public void execute(Model model) {
		//dao에 있는 String boardName, String boardTitle, String boardContent 값들이 필요
		Map<String, Object> map = model.asMap();
		//request: 컨트롤러단에서 보내주는 이름
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String boardName = request.getParameter("boardName");
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		
		//dao 호출단
		BoardDAO dao = new BoardDAO();
		dao.write(boardName, boardTitle, boardContent);
	}
}
