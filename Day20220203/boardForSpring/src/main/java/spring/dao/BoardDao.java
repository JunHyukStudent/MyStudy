package spring.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import spring.vo.Board;
import spring.vo.BoardList;

public class BoardDao {
	private JdbcTemplate jdbcTemplate;
	
	public BoardDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void insert(Board board) {
		
	}
	
	public void update(Board board) {
		
	}

	public List<BoardList> selectAll(){
		String sql = "SELECT qnaBoardNum,qnaBoardTitle,memberName,qnaBoardRegdate,qnaBoardCount "
				+ "FROM boards b join members m on b.memberNum = m.memberNum "
				+ "ORDER BY qnaBoardNum DESC";
		List<BoardList> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			BoardList boardList = new BoardList(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getTimestamp(4),
					rs.getInt(5));
			return boardList;
		});
		return list;
	}
}
