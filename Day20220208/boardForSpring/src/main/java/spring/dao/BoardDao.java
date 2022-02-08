package spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import spring.vo.BoardInfo;
import spring.vo.BoardList;
import spring.vo.Comment;
import spring.vo.InsertBoard;
import spring.vo.UpdateBoard;

public class BoardDao {
	private JdbcTemplate jdbcTemplate;
	
	public BoardDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void insert(InsertBoard insertBoard) {
		String sql = "INSERT INTO boards "
				+ "VALUES(boards_seq.NEXTVAL,?,?,?,default,default)";
		int cnt = jdbcTemplate.update(sql,
									insertBoard.getMemberNum(),
									insertBoard.getQnaBoardTitle(),
									insertBoard.getQnaBoardContent());

		System.out.println("Board INSERT로 삽입된 데이터의 개수 : " + cnt);
	}
	
	public void update(UpdateBoard updateBoard) {
		String sql = "UPDATE boards "
				+ "SET qnaBoardTitle=?, qnaBoardContent=? "
				+ "WHERE qnaBoardNum=?";
		int cnt = jdbcTemplate.update(sql, updateBoard.getQnaBoardTitle(),updateBoard.getQnaBoardContent(),updateBoard.getQnaBoardNum());
		
		System.out.println("Board UPDATE로 변경된 데이터의 개수 : " + cnt);
	}
	
	public void delete(int qnaBoardNum) {
		deleteComment(qnaBoardNum);
		String sql = "DELETE FROM boards "
				+ "WHERE qnaBoardNum=?";
		int cnt = jdbcTemplate.update(sql, qnaBoardNum);
		
		System.out.println("DELETE로 삭제된 데이터의 개수 : " + cnt);
	}

	public void deleteComment(int qnaBoardNum) {
		String sql = "DELETE FROM comments "
				+ "WHERE qnaBoardNum=?";
		int cnt = jdbcTemplate.update(sql, qnaBoardNum);
		
		System.out.println("DELETE로 삭제된 Comment의 개수 : " + cnt);
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
	
	public BoardInfo selectByNum(int qnaBoardNum) {
		String sql = "SELECT qnaBoardNum,m.memberNum,memberName,qnaBoardTitle,qnaBoardContent,qnaBoardRegdate,qnaBoardCount "
				+ "FROM members m join boards b on m.memberNum=b.memberNum "
				+ "WHERE qnaBoardNum=?";
		
		List<BoardInfo> infoList = jdbcTemplate.query(sql, (rs, rowNum) -> {
			BoardInfo boardInfo = new BoardInfo(
					rs.getInt(1),
					rs.getInt(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getTimestamp(6),
					rs.getInt(7));
			return boardInfo;
		},qnaBoardNum);
		
		return infoList.isEmpty()?null:infoList.get(0);
	}
	
	public Comment selectByComment(int qnaBoardNum) {
		String sql = "SELECT * "
				+ "FROM comments "
				+ "WHERE qnaBoardNum=?";
		
		List<Comment> commentList = jdbcTemplate.query(sql, (rs, rowNum) -> {
			Comment comment = new Comment(
					rs.getInt(1),
					rs.getInt(2),
					rs.getString(3),
					rs.getTimestamp(4));
			return comment;
		},qnaBoardNum);
		
		return commentList.isEmpty()?null:commentList.get(0);
	}
}
