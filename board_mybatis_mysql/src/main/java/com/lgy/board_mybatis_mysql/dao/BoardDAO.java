package com.lgy.board_mybatis_mysql.dao;

import java.util.ArrayList;

import com.lgy.board_mybatis_mysql.dto.BoardDTO;

//DB SQL 처리
public interface BoardDAO {
	public ArrayList<BoardDTO> list();
	public void write(String boardName, String boardTitle, String boardContent);
	public BoardDTO contentView(final String strID);
	public void upHit(String boardNo);
	public void modify(String boardNo, String boardName, String boardTitle, String boardContent);
	public void modify2(BoardDTO boardDTO);
	public void delete(String boardNo);
	
	
//	JdbcTemplate template = null;
//	
//	public BoardDAO() {
//		template = Constant.template;
//	}
//	
//	/**
//	 * 게시판의 목록 조회(type parameter : 게시글 객체)
//	 * @return ArrayList<BoardDTO>
//	 *//*
//	public ArrayList<BoardDTO> list() {
//		//2번 방법
//		String sql = " select boardNo, boardName, boardTitle, boardContent, boardDate, boardHit " + 
//			 	 	 " from tbl_board ";
//		return (ArrayList<BoardDTO>) template.query(sql, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
//	}
//	/** 글쓰기
//	 * 
//	 * @param boardName
//	 * @param boardTitle
//	 * @param boardContent
//	 * @return 
//	 */
//	public void write(final String boardName, final String boardTitle, final String boardContent) {
//		template.update(new PreparedStatementCreator() {
//			
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				String sql = " insert into tbl_board(boardName, boardTitle, boardContent, boardHit) " +
//						 	 " values(?, ?, ?, 0) ";
//				PreparedStatement pstmt = con.prepareStatement(sql);
//				pstmt.setString(1, boardName);
//				pstmt.setString(2, boardTitle);
//				pstmt.setString(3, boardContent);
//				
//				return pstmt;
//			}
//		});
//	}
//	
//	/**
//	 * 글 목록 출력
//	 */
//	// 게시글 하나를 리턴하기 위해서 BoardDTO 사용(strID: 글번호)
//	public BoardDTO contentView(final String strID) {
//		upHit(strID);
//		String sql = " select boardNo, boardName, boardTitle, boardContent, boardDate, boardHit " + 
//					 " from tbl_board " +
//					 " where boardNo = " + strID;
//		
//		return (BoardDTO) template.queryForObject(sql, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
//	}
//	
//	/**
//	 * 게시글 조회수 1 증가
//	 * @param boardNo
//	 */
//	public void upHit(final String boardNo) {
//		String sql = " update tbl_board set boardHit = boardHit + 1 " +
//			 	 " where boardNo = ? ";
//		template.update(sql, new PreparedStatementSetter() {
//
//			@Override
//			public void setValues(PreparedStatement ps) throws SQLException {
//				ps.setInt(1, Integer.parseInt(boardNo));
//				
//			}
//		});
//	}
//	
//	/**
//	 * 게시글 수정
//	 * @param boardNo
//	 */
//	public void modify(final String boardNo, final String boardName, final String boardTitle, final String boardContent) {
//		String sql = " update tbl_board set boardName = ?, boardTitle = ?, boardContent = ? " +
//				 	 " where boardNo = ? ";
//		template.update(sql, new PreparedStatementSetter() {
//			
//			@Override
//			public void setValues(PreparedStatement ps) throws SQLException {
//				ps.setString(1, boardName);
//				ps.setString(2, boardTitle);
//				ps.setString(3, boardContent);
//				ps.setInt(4, Integer.parseInt(boardNo));
//			}
//		});
//	}
//	
//	/**
//	 * 게시글 삭제
//	 * @param boardNo
//	 */
//	public void delete(final String boardNo) {
//		String sql = " delete from tbl_board " +
//				 	 " where boardNo = ? ";
//		template.update(sql, new PreparedStatementSetter() {
//
//			@Override
//			public void setValues(PreparedStatement ps) throws SQLException {
//				ps.setInt(1, Integer.parseInt(boardNo));
//			}
//		});
//	}
}