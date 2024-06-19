package com.lgy.member_jdbc_oracle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.lgy.member_jdbc_oracle.dto.MemDTO;
import com.lgy.member_jdbc_oracle.util.Constant;

public class MemDAO {
JdbcTemplate template = null;
	
	public MemDAO() {
		template = Constant.template;
	}
	
	public boolean loginchk(MemDTO dto) {
		boolean flag = false;
		
		String sql = " select mem_pwd " +
					 " from mvc_member " + 
					 " where mem_uid = '" + dto.getMem_uid() + "' ";
		
		try {
			MemDTO getdto = template.queryForObject(sql, new BeanPropertyRowMapper<MemDTO>(MemDTO.class));
			if(dto.getMem_pwd().equals(getdto.getMem_pwd()))
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
	
	public ArrayList<MemDTO> loginyn(String id, String pw) {
		String sql = " select mem_pwd " +
					 " from mvc_member " + 
					 " where mem_uid = '" + id + "' ";
		return (ArrayList<MemDTO>) template.query(sql, new BeanPropertyRowMapper<MemDTO>(MemDTO.class));
	}
	
	public void register(final MemDTO dto) {
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = " insert into mvc_member values(?,?,?) ";
				
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, dto.getMem_uid());
				pstmt.setString(2, dto.getMem_pwd());
				pstmt.setString(3, dto.getMem_name());
				
				return pstmt;
			}
		});
	}
}