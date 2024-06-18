package com.lgy.member_oracle.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lgy.member_oracle.service.MemLoginService;
import com.lgy.member_oracle.service.MemService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemController {
	MemService service;
	
	@RequestMapping("/login")
	public String login(@RequestParam(required = false) String msg, Model model) {
		log.info("@# login");
		if("T".equals(msg)) {
			model.addAttribute("msg", "show");
		}
		return "login";
	}

	@RequestMapping("/login_ok")
	public String login_ok(HttpServletRequest request, Model model) {
		log.info("@# login_ok");
		model.addAttribute("request", request);
		service = new MemLoginService();

		if(service.excute(model)) {
			return "login_ok";
		} else {
			model.addAttribute("msg", "T");
			return "redirect:login";
		}
	}
}