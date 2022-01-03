package com.green.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.green.vo.MemberVO;

public class MemberDAO {// 데이터베이스 연동을 위한 클래스
	// 싱글톤 구성
	private MemberDAO() {}
	private static MemberDAO dao = new MemberDAO();
	public static MemberDAO getInstance() {
		return dao;
	}
	//----------------------------------------------------------
	// 데이터베이스 연결 객체를 만드는 메서드
	public Connection getConnection() throws Exception {
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		Connection conn = ds.getConnection();
		
		return conn;
	}
	
	///------------------------------------------------------------
	// 사용자 인증 처리 메서드
	public int userCheck(String userid, String userpwd) {
		int result = -1;
		
		String sql = "SELECT userpwd FROM member WHERE userid=?";
		
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1,userid);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("userpwd")!=null && rs.getString("userpwd").equals(userpwd)) {
					result = 1; // 로그인 성공
				}else {
					result = 0; // 비밀번호가 null이거나, 비밀번호가 일치하지 않는 경우
				}
				
			}else { // 아이디를 찾을 수 없는 경우
				result = -1;
			}

		}catch(Exception e){
		}finally {
			try {
				if(rs!=null)rs.close();
				if(psmt!=null)psmt.close();
				if(con!=null)con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	//-----------------------------------------------------------------------
	// 아이디를 통해서 인증받는 회원 정보를 읽어오는 메서드
	public MemberVO getMember(String userid) {
		MemberVO mVo = null;
		String sql = "SELECT * FROM member WHERE userid=?";
		
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1, userid);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				mVo = new MemberVO();
				mVo.setName(rs.getString("name"));
				mVo.setUserid(rs.getString("userid"));
				mVo.setUserpwd(rs.getString("userpwd"));
				mVo.setEmail(rs.getString("email"));
				mVo.setPhone(rs.getString("phone"));
				mVo.setAdmin(rs.getInt("admin"));
			}	
		}catch(Exception e) {
			
		}finally {
			try {
				if(rs!=null)rs.close();
				if(psmt!=null)psmt.close();
				if(con!=null)con.close();
			}catch(Exception e) {}
		}
		return mVo;
	}
	//--------------------------------------------------------------------------
	// 회원 정보를 업데이트 하기 위한 쿼리를 작동시킬 메서드
	public int updateMember(MemberVO mVo) {
		int result =-1;
		
		String sql = "UPDATE member SET userpwd=?, email=?, phone=?, admin=? WHERE userid=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, mVo.getUserpwd());
			psmt.setString(2, mVo.getEmail());
			psmt.setString(3, mVo.getPhone());
			psmt.setInt(4, mVo.getAdmin());
			psmt.setString(5, mVo.getUserid());
			
			result = psmt.executeUpdate();
			
		}catch(Exception e) {
		}finally {
			try {
				if(psmt!=null)psmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		
		return result;
	}
	//------------------------------------------------------------------
	// 입력받은 회원 정보로 회원 가입 처리를 할 메서드
	public int insertMember(MemberVO mVo) {
		int result = -1;
		
		String sql="INSERT INTO member VALUES(?,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, mVo.getName());
			psmt.setString(2, mVo.getUserid());
			psmt.setString(3, mVo.getUserpwd());
			psmt.setString(4, mVo.getEmail());
			psmt.setString(5, mVo.getPhone());
			psmt.setInt(6, mVo.getAdmin());
			
			result = psmt.executeUpdate();
			
		}catch(Exception e) {
			
		}finally {
			try {
				if(psmt!=null)psmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		return result;
	}
	// -------------------------------------------------------------
	//아이디를 중복 체크하기 위한 메서드
	public int confirmID(String userid) {
		int result =-1;
		
		String sql = "SELECT userid FROM member WHERE userid=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userid);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				result = 1; // 아이디가 존재=> 클라이언트가 사용하려던 아이디는 사용불가
			}else{
				result = -1;// 아이디가 부존재=> 클라이언트가 사용하려던 아이디는 사용가능
			}

		}catch(Exception e) {
			
		}finally {
			try {
				if(rs!=null)rs.close();
				if(psmt!=null)psmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		
		return result;
	}
	
	
}





