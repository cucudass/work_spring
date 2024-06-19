package com.lgy.member_jdbc_oracle.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lgy.member_jdbc_oracle.dao.MemDAO;
import com.lgy.member_jdbc_oracle.dto.MemDTO;

public class MWriteService implements MemService {

	@Override
	public int excute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		MemDTO dto = new MemDTO();
		dto.setMem_uid(request.getParameter("id"));
		dto.setMem_pwd(request.getParameter("pw"));
		dto.setMem_name(request.getParameter("name"));
		
		MemDAO dao = new MemDAO();
		dao.register(dto);
		
		return 0;
	}
}