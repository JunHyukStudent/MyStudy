package com.green.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/AjaxTest02")
public class AjaxTest02Servlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		MemberVO mVo = new MemberVO();
		
		mVo.setUserId("zxcv");
		mVo.setUserName("노길동");
		mVo.setUserPwd("1357");
		
		Gson gson = new Gson();
		String mVoJson = gson.toJson(mVo);
		
		PrintWriter out = response.getWriter();
		out.println(mVoJson);
			
	}

}
