package com.lgy.board_mybatis_mysql.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.board_mybatis_mysql.dao.BoardDAO;
import com.lgy.board_mybatis_mysql.dto.BoardDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardContoller {
	
	/*
	BoardService service;
	public JdbcTemplate template;
	
	//servlet-context.xml 에 있는 template 객체에 저장(this.template)
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	*/
	
	//servlet-context 에 있는 sqlSession 객체 연결
	@Autowired
	private SqlSession sqlSession;
	
	//게시판 목록 조회
	@RequestMapping("/list")
	public String list(Model model) {
		log.info("@# list");
		
		//service = new BoardListService();
		//service.execute(model);

		//getMappeㄱ : dao 연결
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		//서비스단에서 처리했던 것을 컨트롤러 단에서 처리
		model.addAttribute("list", dao.list());
		return "list";
	}
	
	@RequestMapping("/write")
	//request: 뷰에서 값을 받아옴
	public String write(HttpServletRequest request, Model model) {
		log.info("@# write");
		
		//해당 request에 boardName, boardTitle, boardContent 값들이 있음
		model.addAttribute("request", request);
		//service = new BoardWriteService();
		//service.execute(model);
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		String boardName = request.getParameter("boardName");
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		//서비스단에서 처리했던 것을 컨트롤러 단에서 처리
		dao.write(boardName, boardTitle, boardContent);
		
		return "redirect:list"; //redirect 없이 그냥 list만 하면 데이터 출력을 못함
	}
	
	@RequestMapping("/write_view")
	public String write_view() {
		log.info("@# write_view");
		
		return "write_view";
	}
	
	@RequestMapping("/content_view")
	public String contentview(HttpServletRequest request, Model model) {
		log.info("@# content_view");
		model.addAttribute("request", request);
		
		//service = new BoardContentService();
		//service.execute(model);
		String boardNo = request.getParameter("boardNo");
		
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.upHit(boardNo);
		//서비스단에서 처리했던 것을 컨트롤러 단에서 처리
		model.addAttribute("content_view", dao.contentView(boardNo));
		
		return "content_view";
	}

	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model) {
		log.info("@# modify");
		model.addAttribute("request", request);
		//service = new BoardModifyService();
		//service.execute(model);
		
		String boardNo = request.getParameter("boardNo");
		String boardName = request.getParameter("boardName");
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		BoardDTO dto = new BoardDTO();
		dto.setBoardNo(Integer.parseInt(boardNo));
		dto.setBoardName(boardName);
		dto.setBoardTitle(boardTitle);
		dto.setBoardContent(boardContent);
		
		//서비스단에서 처리했던 것을 컨트롤러 단에서 처리
		//dao.modify(boardNo, boardName, boardTitle, boardContent);
		dao.modify2(dto);
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		log.info("@# delete");
		//model.addAttribute("request", request);
		
		//service = new BoardDeleteService();
		//service.execute(model);
		String boardNo = request.getParameter("boardNo");
		
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		//서비스단에서 처리했던 것을 컨트롤러 단에서 처리
		dao.delete(boardNo);
		
		return "redirect:list";
	}
}