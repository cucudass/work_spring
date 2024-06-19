package com.lgy.item_jdbc_oracle.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.item_jdbc_oracle.service.ItemContentService;
import com.lgy.item_jdbc_oracle.service.ItemService;
import com.lgy.item_jdbc_oracle.service.ItemWriteService;
import com.lgy.item_jdbc_oracle.util.Constant;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ItemController {
	ItemService service;
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	@RequestMapping("/item_write")
	public String write(Model model) {
		log.info("@# item_write");
		
		return "item_write";
	}
	
	@RequestMapping("/write_result")
	public String write(HttpServletRequest request, Model model) {
		log.info("@# write_result");
		model.addAttribute("request", request);
		service = new ItemWriteService();
		service.excute(model);
		
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
		service = new ItemContentService();
		service.excute(model);
		
		return "content_view";
	}
}