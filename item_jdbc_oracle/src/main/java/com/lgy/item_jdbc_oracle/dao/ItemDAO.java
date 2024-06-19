package com.lgy.item_jdbc_oracle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.lgy.item_jdbc_oracle.dto.ItemDTO;
import com.lgy.item_jdbc_oracle.util.Constant;

public class ItemDAO {
	JdbcTemplate template = null;
	public ItemDAO() {
		template = Constant.template;
	}
	
	/**
	 * 상품 정보 등록
	 */
	public void insert(final ItemDTO itemDTO) {
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = " insert into item(name, price, description) " +
				     	 	 " values(?, ?, ?) ";
				
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, itemDTO.getName());
				pstmt.setInt(2, itemDTO.getPrice());
				pstmt.setString(3, itemDTO.getDescription());
				return pstmt;
			}
		});
	}
	
	/**
	 * 상품의 목록 조회(type parameter : 게시글 객체)
	 * @return ArrayList<ItemDTO>
	 */
	public ArrayList<ItemDTO> list() {
		String sql = " select name, price, description " + 
					 " from item " + 
					 " order by name ";
		
		return (ArrayList<ItemDTO>) template.query(sql, new BeanPropertyRowMapper<ItemDTO>(ItemDTO.class));
	}
}