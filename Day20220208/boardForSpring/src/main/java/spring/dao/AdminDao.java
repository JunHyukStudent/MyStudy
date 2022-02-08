package spring.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import spring.vo.BoardAdminList;
import spring.vo.BoardInfo;
import spring.vo.Comment;
import spring.vo.MemberInfo;
import spring.vo.MemberList;

public class AdminDao {
	private JdbcTemplate jdbcTemplate;

	public AdminDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<MemberList> selectAllMember(){
		String sql = "SELECT memberNum,memberId,memberName "
				+ "FROM members "
				+ "ORDER BY memberNum";
		
		List<MemberList> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			MemberList memberList = new MemberList(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3));
			return memberList;
		});
		return list;
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
	
	public void updateMember(MemberInfo memberInfo) {
		String sql = "UPDATE members "
				+ "SET memberId=?, memberName=?, memberEmail=?, memberPhone=? "
				+ "WHERE memberNum=?";
		int cnt = jdbcTemplate.update(sql,
				memberInfo.getMemberId(),
				memberInfo.getMemberName(),
				memberInfo.getMemberEmail(),
				memberInfo.getMemberPhone(),
				memberInfo.getMemberNum());
		
		System.out.println("Admin Member UPDATE로 변경된 데이터의 개수 : " + cnt);
	}
	
	public void deleteMember(int memberNum) {

		String sql = "DELETE FROM members "
				+ "WHERE memberNum=?";
		
		int cnt = jdbcTemplate.update(sql,memberNum);
		
		System.out.println("Admin Member DELETE로 삭제된 데이터의 개수 : " + cnt);
	}

	public List<BoardAdminList> selectAllBoard() {
		String sql = "SELECT qnaBoardNum,qnaBoardTitle,memberName,qnaBoardRegdate,qnaBoardCount "
				+ "FROM boards b join members m on b.memberNum=m.memberNum "
				+ "ORDER BY qnaBoardNum DESC";
		
		List<BoardAdminList> blist = jdbcTemplate.query(sql, (rs, rowNum) -> {
			BoardAdminList boardList = new BoardAdminList(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getTimestamp(4),
					rs.getInt(5));
			return boardList;
		});
		
		List<Integer> clist = selectAllComment();
		for(int i = 0; i < blist.size(); i++) {
			for(int j = 0; j < clist.size(); j++) {
				if(blist.get(i).getQnaBoardNum() == clist.get(j)) {
					blist.get(i).setCommentYN(true);
				}
			}
		}
		
		return blist;
	}

	public List<Integer> selectAllComment() {
		String sql = "SELECT qnaBoardNum "
				+ "FROM comments";
		
		List<Integer> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			Integer commentList = new Integer(
					rs.getInt(1));
			return commentList;
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
	
	public void delete(int qnaBoardNum) {
		deleteComment(qnaBoardNum);
		
		String sql = "DELETE FROM boards "
				+ "WHERE qnaBoardNum=?";
		int cnt = jdbcTemplate.update(sql, qnaBoardNum);
		
		System.out.println("Admin Board DELETE로 삭제된 데이터의 개수 : " + cnt);
	}
	
	public void deleteComment(int qnaBoardNum) {
		String sql = "DELETE FROM comments "
				+ "WHERE qnaBoardNum=?";
		int cnt = jdbcTemplate.update(sql, qnaBoardNum);
		
		System.out.println("Admin Board DELETE로 삭제된 Comment의 개수 : " + cnt);
	}

	public void writeComment(Comment commentReq) {
		String sql = "INSERT INTO comments "
				+ "VALUES(comments_seq.NEXTVAL,?,?,default)";
		
		int cnt = jdbcTemplate.update(sql,
							commentReq.getQnaBoardNum(),
							commentReq.getCommentContent());
		
		System.out.println("Comment로 작성된 데이터의 개수 : " + cnt);
	}
}
