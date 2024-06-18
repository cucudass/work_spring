package com.lgy.member_oracle.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lgy.member_oracle.dao.MemDAO;

public class MemLoginService implements MemService {

	@Override
	public Boolean excute(Model model) {
		MemDAO dao = new MemDAO();
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String id = request.getParameter("mem_uid");
		String pwd = request.getParameter("mem_pwd");
		
		return dao.Userchk(id, pwd);
	}
}