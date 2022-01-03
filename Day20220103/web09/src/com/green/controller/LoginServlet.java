package com.green.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.green.dao.MemberDAO;
import com.green.vo.MemberVO;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get 방식으로 요청이 오면 로그인 홈페이지로 이동
		String url = "member/login.jsp";
		
		// 현재 세션에 로그인한 사용자가 있다면 main.jsp로 이동
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") != null) {
			url = "main.jsp";
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 아이디, 비밀번호를 전달 받아서 처리할 메서드
		String url = "member/login.jsp";	// 로그인 실패시 돌아갈 페이지
		
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		
		// 로그인 인증 처리
		MemberDAO dao = MemberDAO.getInstance();
		
		int result = dao.userCheck(userid, userpwd);
		
		if(result == 1) { // 로그인 성공 => 회원 정보를 세션에 기록
			MemberVO mVo = dao.getMember(userid);
			HttpSession session = request.getSession(); // 서블릿은 session객체가 내장객체가 아님
			
			session.setAttribute("loginUser", mVo);
			
			url = "main.jsp";
		}else if(result == 0) { // 비밀번호가 틀린경우
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");
		}else if(result == -1) { // 아이디가 없는 경우
			request.setAttribute("message", "존재하지 않는 회원입니다.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
