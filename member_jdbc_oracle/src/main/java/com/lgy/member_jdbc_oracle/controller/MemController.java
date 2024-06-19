package com.lgy.member_jdbc_oracle.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.member_jdbc_oracle.service.MWriteService;
import com.lgy.member_jdbc_oracle.service.MemLoginService;
import com.lgy.member_jdbc_oracle.service.MemService;
import com.lgy.member_jdbc_oracle.util.Constant;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemController {
	MemService service;
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	@RequestMapping("/login")
	public String login() {
		log.info("@# login");
		
		return "login";
	}
	
	@RequestMapping("/login_ck")
	public String login_ok(HttpServletRequest request, Model model) {
		log.info("@# login_ck");
		
		model.addAttribute("request", request);
		service = new MemLoginService();
		int re = service.excute(model);
		
		if(re == 1)
			return "redirect:login_ok";
		else
			return "redirect:login";
	}
	
	@RequestMapping("/login_ok")
	public String login_ok() {
		return "login_ok";
	}
	
	@RequestMapping("/register")
	public String register() {
		log.info("@# register");
		return "register";
	}
	
	@RequestMapping("/register_ok")
	public String register_ok(HttpServletRequest request, Model model) {
		log.info("@# register_ok");
		model.addAttribute("request", request);
		service = new MWriteService();
		service.excute(model);
		
		return "redirect:login"; 
	}
}