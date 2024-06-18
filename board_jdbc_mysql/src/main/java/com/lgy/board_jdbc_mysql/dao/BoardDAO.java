package com.lgy.board_jdbc_mysql.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.lgy.board_jdbc_mysql.dto.BoardDTO;
import com.lgy.board_jdbc_mysql.util.Constant;

//DB SQL 처리
public class BoardDAO {
	JdbcTemplate template = null;
	
	public BoardDAO() {
//		try {
//			Context ctx = new InitialContext();
//			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/mysql");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		//Constant.template : 컨트롤러에서 설정됨
		template = Constant.template;
	}
	
	/**
	 * 게시판의 목록 조회(type parameter : 게시글 객체)
	 * @return ArrayList<BoardDTO>
	 */
	public ArrayList<BoardDTO> list() {
		//return (ArrayList<BoardDTO>) template.query(" select boardNo, boardName, boardTitle, boardContent, boardDate, boardHit from tbl_board ", new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
		
		
		//2번 방법
		String sql = " select boardNo, boardName, boardTitle, boardContent, boardDate, boardHit " + 
			 	 	 " from tbl_board ";
		return (ArrayList<BoardDTO>) template.query(sql, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
		
		/*
		//1번 방법
		ArrayList<BoardDTO> dtos = null;
		String sql = " select boardNo, boardName, boardTitle, boardContent, boardDate, boardHit " + 
				 	 " from tbl_board ";
		
		//query : jdbc template 쿼리 처리
		dtos = (ArrayList<BoardDTO>) template.query(sql, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
		
		return dtos;
		*/
		/*
		ArrayList<BoardDTO> dtos = new ArrayList<>();
		BoardDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select boardNo, boardName, boardTitle, boardContent, boardDate, boardHit " + 
					 " from tbl_board ";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int boardNo = rs.getInt("boardNo");
				String boardName = rs.getString("boardName");
				String boardTitle = rs.getString("boardTitle");
				String boardContent = rs.getString("boardContent");
				Timestamp boardDate = rs.getTimestamp("boardDate");
				int boardHit = rs.getInt("boardHit");
				
				dto = new BoardDTO(boardNo, boardName, boardTitle, boardContent, boardDate, boardHit);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
		return dtos;
		*/
	}
	/** 글쓰기
	 * 
	 * @param boardName
	 * @param boardTitle
	 * @param boardContent
	 * @return 
	 */
	public void write(final String boardName, final String boardTitle, final String boardContent) {
		//update : jdbc template 으로 insert (PreparedStatementCreator 객체 사용)
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = " insert into tbl_board(boardName, boardTitle, boardContent, boardHit) " +
						 	 " values(?, ?, ?, 0) ";
				//con : 메소드 매개변수와 이름 일치
				PreparedStatement pstmt = con.prepareStatement(sql);
				//파라미터 등은 final로 구성
				pstmt.setString(1, boardName);
				pstmt.setString(2, boardTitle);
				pstmt.setString(3, boardContent);
				
				return pstmt;
			}
		});
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		
//		String sql = " insert into tbl_board(boardName, boardTitle, boardContent, boardHit) " +
//				     " values(?, ?, ?, 0) ";
//		try {
//			conn = dataSource.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, boardName);
//			pstmt.setString(2, boardTitle);
//			pstmt.setString(3, boardContent);
//			
//			pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(pstmt != null) pstmt.close();
//				if(conn != null) conn.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
	}
	
	/**
	 * 글 목록 출력
	 */
	// 게시글 하나를 리턴하기 위해서 BoardDTO 사용(strID: 글번호)
	public BoardDTO contentView(String strID) {
		String sql = " select boardNo, boardName, boardTitle, boardContent, boardDate, boardHit " + 
					 " from tbl_board " +
					 " where boardNo = " + strID;
		
		return (BoardDTO) template.queryForObject(sql, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
		
		//게시글 조회수 올리기
		//upHit(strID);
//		BoardDTO dto = null;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		String sql = " select boardNo, boardName, boardTitle, boardContent, boardDate, boardHit " + 
//					 " from tbl_board " +
//					 " where boardNo = ? ";
//		
//		try {
//			conn = dataSource.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, Integer.parseInt(strID));
//
//			rs = pstmt.executeQuery();
//			if(rs.next()) {
//				int boardNo = rs.getInt("boardNo");
//				String boardName = rs.getString("boardName");
//				String boardTitle = rs.getString("boardTitle");
//				String boardContent = rs.getString("boardContent");
//				Timestamp boardDate = rs.getTimestamp("boardDate");
//				int boardHit = rs.getInt("boardHit");
//				
//				dto = new BoardDTO(boardNo, boardName, boardTitle, boardContent, boardDate, boardHit);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(rs != null) rs.close();
//				if(pstmt != null) pstmt.close();
//				if(conn != null) conn.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}		
//		return dto;
	}
	
	/**
	 * 게시글 조회수 1 증가
	 * @param boardNo
	 *//*
	public void upHit(String boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = " update tbl_board set boardHit = boardHit + 1 " +
					 " where boardNo = ? ";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(boardNo));

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
	}
	
	/**
	 * 게시글 수정
	 * @param boardNo
	 */
	public void modify(String boardNo, String boardName, String boardTitle, String boardContent) {
		//update : jdbc template 으로 insert (PreparedStatementCreator 객체 사용)
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = " update tbl_board set boardName = ?, boardTitle = ?, boardContent = ? " +
						 	 " where boardNo = ? ";
				//con : 메소드 매개변수와 이름 일치
				PreparedStatement pstmt = con.prepareStatement(sql);
				//파라미터 등은 final로 구성
				pstmt.setString(1, boardName);
				pstmt.setString(2, boardTitle);
				pstmt.setString(3, boardContent);
				pstmt.setInt(4, Integer.parseInt(boardNo));
				
				return pstmt;
			}
		});
		/*
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = " update tbl_board set boardName = ?, boardTitle = ?, boardContent = ? " +
					 " where boardNo = ? ";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardName);
			pstmt.setString(2, boardTitle);
			pstmt.setString(3, boardContent);
			pstmt.setInt(4, Integer.parseInt(boardNo));
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		*/	
	}
	
	/**
	 * 게시글 삭제
	 * @param boardNo
	 *//*
	public void delete(String boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = " delete from tbl_board " +
					 " where boardNo = ? ";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(boardNo));
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
	}
	*/
}