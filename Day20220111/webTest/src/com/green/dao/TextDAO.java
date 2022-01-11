package com.green.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.green.db.DBConnect;
import com.green.vo.TextVO;

public class TextDAO {
	private TextDAO() {}
	private static TextDAO dao = new TextDAO();
	public static TextDAO getInstance() {
		return dao;
	}
	
	//----------------------------------
	public void insertText(String title, String contents) {
		
		String sql = "INSERT INTO texttbl VALUES(text_seq.nextval,?,?,sysdate)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBConnect.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, title);
			psmt.setNString(2, contents);
			
			psmt.executeUpdate();
			
		}catch(Exception e) {
			
		}finally {
			DBConnect.close(conn,psmt);
		}
		
	}

	//----------------------------------------------
	public List<TextVO> selectAllText(){
		List<TextVO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM texttbl";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnect.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				TextVO tVo = new TextVO();
				tVo.setCode(rs.getInt("code"));
				tVo.setTitle(rs.getString("title"));
				tVo.setContents(rs.getString("contents"));
				tVo.setRegDate(rs.getTimestamp("regdate"));
				
				list.add(tVo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnect.close(conn, stmt, rs);
		}
		return list;
	}

}
