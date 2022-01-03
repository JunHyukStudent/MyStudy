package com.green.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MemberDAO;


@WebServlet("/idCheck.do")
public class IdCheckServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//전달 받은 아이디가 DB에 존재하는 지 체크
		String userid = request.getParameter("userid");// 쿼리스트링
		
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.confirmID(userid);  
		
		request.setAttribute("userid", userid);
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("member/idCheck.jsp").forward(request, response);
		
		
	}

}
