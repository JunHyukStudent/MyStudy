package com.green.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.green.db.DBConnect;
import com.green.vo.CommentVO;

public class CommentDAO {
	private CommentDAO() {}
	private static CommentDAO dao = new CommentDAO();
	public static CommentDAO getInstance() {
		return dao;
	}
	//------------------------------------------
	
	public int insertComment(String C_user, String C_comment, String C_password) {
		String sql = "INSERT INTO commenttbl VALUES(comment_seq.nextval,1,?,?,?,SYSDATE)";
		int result = 1;
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBConnect.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, C_user);
			psmt.setString(2, C_comment);
			psmt.setString(3, C_password);
			
			int resultSql = psmt.executeUpdate();
			
			if(resultSql == 0) {
				result = -1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnect.close(conn, psmt);
		}
		
		return result;
	}
	
	
	public int updateComment(int C_code, String C_comment, String C_password) {
		int result = 1;
		String sql = "UPDATE commenttbl SET C_comment=? where C_code=? AND C_password=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBConnect.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, C_comment);
			psmt.setInt(2, C_code);
			psmt.setString(3, C_password);
			
			int resultSql = psmt.executeUpdate();
			
			if(resultSql == 0) {
				result = -1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnect.close(conn, psmt);
		}
		
		return result;
	}
	
	
	public int deleteComment(int C_code, String C_password) {
		int result = 1;
		String sql = "DELETE FROM commenttbl where C_code=? AND C_password=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBConnect.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, C_code);
			psmt.setString(2, C_password);
			
			int resultSql = psmt.executeUpdate();
			
			if(resultSql == 0) {
				result = -1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnect.close(conn, psmt);
		}
		
		return result;
	}
	
	
	public List<CommentVO> selectAllComment() {
		List<CommentVO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM commenttbl";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnect.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				CommentVO cVo = new CommentVO();
				cVo.setC_code(rs.getInt("c_code"));
				cVo.setB_code(rs.getInt("b_code"));
				cVo.setC_user(rs.getString("c_user"));
				cVo.setC_comment(rs.getString("c_comment"));
				cVo.setC_password(rs.getString("c_password"));
				cVo.setC_regDate(rs.getDate("c_regdate").toString());
				list.add(cVo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnect.close(conn, stmt, rs);
		}
		return list;
	}
}
