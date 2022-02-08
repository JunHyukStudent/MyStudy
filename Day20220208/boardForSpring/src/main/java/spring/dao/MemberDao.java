package spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import spring.vo.Board;
import spring.vo.BoardList;
import spring.vo.RegisterRequest;

public class MemberDao {
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void insert(RegisterRequest regReq) {
		int cnt = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement psmt = con.prepareStatement("INSERT INTO members VALUES(members_seq.NEXTVAL,?,?,?,?,?)");

				psmt.setString(1, regReq.getMemberId());
				psmt.setString(2, regReq.getMemberPassword());
				psmt.setString(3, regReq.getMemberName());
				psmt.setString(4, regReq.getMemberEmail());
				psmt.setString(5, regReq.getMemberPhone());

				return psmt;
			}
		});

		System.out.println("INSERT로 삽입된 데이터의 개수 : " + cnt);
	}	
}
