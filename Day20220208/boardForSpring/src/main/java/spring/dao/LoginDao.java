package spring.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import spring.vo.AuthInfo;
import spring.vo.MemberInfo;

public class LoginDao {

	private JdbcTemplate jdbcTemplate;

	public LoginDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public AuthInfo login(String loginId, String loginPwd) {
		String sql = "SELECT memberNum,memberName FROM members WHERE memberId=? AND memberPassword=?";
		List<AuthInfo> authList = jdbcTemplate.query(sql, (rs, rowNum) -> {

			AuthInfo auth = new AuthInfo(
					rs.getInt(1),
					rs.getString(2));
			return auth;
		}, loginId, loginPwd);
		
		return authList.isEmpty() ? null : authList.get(0);
	}
	
	public MemberInfo selectByMemberNum(int memberNum) {
		String sql = "SELECT memberNum,memberId,memberName,memberEmail,memberPhone "
				+ "FROM members "
				+ "WHERE memberNum=?";
		
		List<MemberInfo> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			MemberInfo memberInfo = new MemberInfo(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5));
			return memberInfo;
		},memberNum);
		
		
		return list.get(0);
	}

}
