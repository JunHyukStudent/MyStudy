package spring.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import spring.vo.Member;

public class MemberDao { // 가상의 DB와 연결을 위한 클래스 (Map을 이용해서 데이터를 저장)
	private static long nextId = 0;  // 역할 : 시퀀스
	
	private Map<String, Member> map = new HashMap<>();  // 가상의 DB
	
	public Member selectByEmail(String email) {
		return map.get(email);
	}
	
	public void insert(Member member) {
		member.setId(++nextId);
		map.put(member.getEmail(), member);
	}
	
	public void update(Member member) {
		map.put(member.getEmail(), member);
	}
	
	public Collection<Member> selectAll() {
		return map.values();
	}
}
