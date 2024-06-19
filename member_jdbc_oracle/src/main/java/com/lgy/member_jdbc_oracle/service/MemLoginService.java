package com.lgy.member_jdbc_oracle.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lgy.member_jdbc_oracle.dao.MemDAO;
import com.lgy.member_jdbc_oracle.dto.MemDTO;

public class MemLoginService implements MemService {

	@Override
	public int excute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		int re = 0;
		MemDAO dao = new MemDAO();
		
		ArrayList<MemDTO> dtos = dao.loginyn(id, pw);
		
		if(dtos.isEmpty())
			re = -1;
		else {
			if(pw.equals(dtos.get(0).getMem_pwd()))
				re = 1;
			else
				re = 0;
		}
		return re;
	}
}