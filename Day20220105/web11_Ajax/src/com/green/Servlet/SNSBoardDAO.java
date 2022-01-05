package com.green.Servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class SNSBoardDAO {
	private SNSBoardDAO() {}
	private static SNSBoardDAO dao = new SNSBoardDAO();
	
	public static SNSBoardDAO getInstance() {
		return dao;
	}
	
	// 연결 객체를 얻어오기 위한 메서드
	public Connection getConnection() {
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public void close(Connection conn, Statement stmt, Statement stmt2, ResultSet rs) {
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(stmt2!=null)stmt2.close();
			if(conn!=null)conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public SNSBoardVO insertSNS(SNSBoardVO sVo) {
		String sql = "INSERT INTO snstbl VALUES(SNS_SEQ.nextval,?,?,SYSDATE)";
		String sql2 = "SELECT * FROM snstbl WHERE stitle=? AND scontent=?";
		Connection conn = null;
		PreparedStatement psmt = null;
		PreparedStatement psmt2 = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, sVo.getStitle());
			psmt.setString(2, sVo.getScontent());
			
			psmt.executeUpdate();
			
			psmt2 = conn.prepareStatement(sql2);
			psmt2.setString(1, sVo.getStitle());
			psmt2.setString(2, sVo.getScontent());
			rs = psmt2.executeQuery();
			while(rs.next()) {
				sVo.setSno(rs.getInt("sno"));
				sVo.setSdate(rs.getDate("sdate").toString());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,psmt,psmt2,rs);
		}
		
		return sVo;
	}
}
