package com.lgy.item_mybatis_oracle.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.item_mybatis_oracle.dao.ItemDAO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ItemController {
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/item_write")
	public String write(Model model) {
		log.info("@# item_write");
		
		return "item_write";
	}
	
	@RequestMapping("/write_result")
	public String write(HttpServletRequest request, Model model) {
		log.info("@# write_result");
		model.addAttribute("request", request);
		
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String description = request.getParameter("description");
		
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		dao.insert(name, price, description);
		
		return "write_result";
	}
	
	@RequestMapping("/content")
	public String content() {
		log.info("@# content");
		return "redirect:content_view";
	}
	
	@RequestMapping("/content_view")
	public String content_view(Model model) {
		log.info("@# content_view");
		
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		model.addAttribute("list", dao.list());
		
		return "content_view";
	}
}