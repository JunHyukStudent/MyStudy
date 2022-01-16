package com.green.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.green.db.DBManager;
import com.green.vo.LecturerVO;

public class LecturerDAO {
	private LecturerDAO() {}
	private static LecturerDAO dao = new LecturerDAO();
	public static LecturerDAO getInstance() {
		return dao;
	}
	
	public List<LecturerVO> selectAllLecturer(){
		List<LecturerVO> list = new ArrayList<>();
		
		String sql = "SELECT idx, name, major FROM lecturer_tbl";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				LecturerVO lVo = new LecturerVO();
				
				lVo.setL_idx(rs.getInt(1));
				lVo.setL_name(rs.getString(2));
				lVo.setL_major(rs.getString(3));
				
				list.add(lVo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	public int countAllLecturer() {
		int count = 0;
		
		String sql = "SELECT COUNT(*) FROM lecturer_tbl";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return count;
	}
	
	public void insertLecturer(LecturerVO lVo) {
		String sql = "INSERT INTO lecturer_tbl VALUES (lecturer_seq.nextval, ?,?,?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, lVo.getL_name());
			psmt.setString(2, lVo.getL_major());
			psmt.setString(3, lVo.getField());
			
			psmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
	}
	
	public LecturerVO lecturerView(int l_idx) {
		LecturerVO lVo = new LecturerVO();
		
		String sql = "SELECT * FROM lecturer_tbl WHERE idx=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, l_idx);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				lVo.setL_idx(rs.getInt(1));
				lVo.setL_name(rs.getString(2));
				lVo.setL_major(rs.getString(3));
				lVo.setField(rs.getString(4));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}
		
		return lVo;
	}
	
	public List<String> lecturerCourse(int l_idx){
		List<String> list = new ArrayList<>();
		
		String sql = "SELECT c.name " + 
					 "FROM course_tbl c  join lecturer_tbl l on c.lecturer = l.idx " + 
					 "WHERE l.idx=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, l_idx);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}
		
		return list;
	}
	
	public void updateLecturer(LecturerVO lVo) {
		String sql = "UPDATE lecturer_tbl " +
					 "SET name=?, major=?, field=? " +
					 "WHERE idx=?";
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, lVo.getL_name());
			psmt.setString(2, lVo.getL_major());
			psmt.setString(3, lVo.getField());
			psmt.setInt(4, lVo.getL_idx());
			
			psmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
	}
}
