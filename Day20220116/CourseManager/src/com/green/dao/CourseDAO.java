package com.green.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.green.db.DBManager;
import com.green.vo.CourseLecJoinVO;
import com.green.vo.CourseVO;
import com.green.vo.LecturerVO;

public class CourseDAO {
	final static String[] weekKR = {"일", "월", "화", "수", "목", "금", "토"};
	
	private CourseDAO() {}
	private static CourseDAO dao = new CourseDAO();
	public static CourseDAO getInstance() {
		return dao;
	}
	
	// 모든 교과목 조회
	public List<CourseLecJoinVO> selectAllCourse(){
		List<CourseLecJoinVO> list= new ArrayList<>();

		String sql = "SELECT c.id,c.name,c.credit,l.name,c.week " + 
				"FROM course_tbl c join lecturer_tbl l on c.lecturer = l.idx " +
				"ORDER BY c.id DESC";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				CourseLecJoinVO cVo = new CourseLecJoinVO();
				cVo.setC_id(rs.getString(1));
				cVo.setC_name(rs.getString(2));
				cVo.setCredit(rs.getInt(3));
				cVo.setL_name(rs.getString(4));
				cVo.setWeek(rs.getInt(5));
				cVo.setWeekKR(weekKR[cVo.getWeek()]);
				
				list.add(cVo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	// 교과목 개수 조회
	public int countAllCourse() {
		int courseCnt = 0;
		
		String sql = "SELECT COUNT(*) FROM course_tbl";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				courseCnt = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		return courseCnt;
	}
	
	// 모든 강사 이름 조회
	public List<LecturerVO> selectAllLec(){
		List<LecturerVO> list = new ArrayList<>();
		
		String sql = "SELECT idx, name FROM lecturer_tbl ORDER BY name";
		
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

				list.add(lVo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return list;
	}
	
	// 교과목 삽입
	public void insertCourse(CourseVO cVo) {
		String sql = "INSERT INTO course_tbl VALUES(?,?,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, cVo.getC_id());
			psmt.setString(2, cVo.getC_name());
			psmt.setInt(3, cVo.getCredit());
			psmt.setInt(4, cVo.getC_lecturer());
			psmt.setInt(5, cVo.getWeek());
			psmt.setInt(6, cVo.getStart_hour());
			psmt.setInt(7, cVo.getEnd_hour());
			
			psmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
	}
	
	// 교과목 상세보기(교과목 수정 페이지 정보 넘기기)
	public CourseVO courseView(String c_id){
		CourseVO cVo = new CourseVO();
		
		String sql = "SELECT c.id, c.name, c.credit, c.lecturer, c.week, c.start_hour, c.end_hour, l.name as lname " +
					 "FROM course_tbl c join lecturer_tbl l on c.lecturer = l.idx " +
					 "WHERE id=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, c_id);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				cVo.setC_id(rs.getString(1));
				cVo.setC_name(rs.getString(2));
				cVo.setCredit(rs.getInt(3));
				cVo.setC_lecturer(rs.getInt(4));
				cVo.setWeek(rs.getInt(5));
				cVo.setStart_hour(rs.getInt(6));
				cVo.setEnd_hour(rs.getInt(7));
				cVo.setC_lecturerKR(rs.getString(8));
				cVo.setWeekKR(weekKR[cVo.getWeek()]);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}
		
		return cVo;
	}
	
	// 교과목 수정
	public void updateCourse(CourseVO cVo) {
		String sql = "UPDATE course_tbl "
				+ "SET name=?, credit=?, lecturer=?, week=?, start_hour=?, end_hour=? "
				+ "WHERE id=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, cVo.getC_name());
			psmt.setInt(2, cVo.getCredit());
			psmt.setInt(3, cVo.getC_lecturer());
			psmt.setInt(4, cVo.getWeek());
			psmt.setInt(5, cVo.getStart_hour());
			psmt.setInt(6, cVo.getEnd_hour());
			psmt.setString(7, cVo.getC_id());
			
			psmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
	}
	
	// 교과목 삭제
	public void deleteCourse(String c_id) {
		String sql = "DELETE course_tbl WHERE id=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, c_id);
			
			psmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
	}
}
