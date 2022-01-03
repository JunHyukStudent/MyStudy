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


@WebServlet("/memberUpdate.do")
public class MemberUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원 정보 수정 폼으로 이동 => 기존의 정보 전달(세션)
		String url = "member/memberUpdate.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String name = request.getParameter("name");
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		if(userpwd == null || userpwd.equals("")) {
			userpwd = ((MemberVO)session.getAttribute("loginUser")).getUserpwd();
		}
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String admin = request.getParameter("admin");
		
		MemberVO mVo = new MemberVO();
		mVo.setUserid(userid);
		mVo.setName(name);
		mVo.setUserpwd(userpwd);
		mVo.setEmail(email);
		mVo.setPhone(phone);
		mVo.setAdmin(Integer.parseInt(admin));
		
		MemberDAO dao = MemberDAO.getInstance();
		dao.updateMember(mVo);
	
		response.sendRedirect("login.do");// 로그인 서블릿을 통해서 메인페이지로 이동
	}

}
