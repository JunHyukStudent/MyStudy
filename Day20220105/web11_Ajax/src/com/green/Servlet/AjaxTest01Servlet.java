package com.green.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


@WebServlet("/AjaxTest01")
public class AjaxTest01Servlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		System.out.println("읽어온 값 : " + userId);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("사용할수 있습니다.");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userInfo = request.getParameter("userInfo");
		System.out.println("얻어온 값 : " + userInfo);
		
		// JSON 객체로 넘어온 값을 '파싱' => 도구 gson.jar
		
		JsonParser parser = new JsonParser();
		JsonElement data = parser.parse(userInfo);
		
		String userId = data.getAsJsonObject().get("userId").getAsString();
		String userName = data.getAsJsonObject().get("userName").getAsString();
		String userPwd = data.getAsJsonObject().get("userPwd").getAsString();
		
		System.out.println("넘어온 아이디 : " + userId);
		System.out.println("넘어온 이름 : " + userName);
		System.out.println("넘어온 비밀번호 : " + userPwd);
		
		
	}

}
