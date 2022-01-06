package com.green.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.green.dao.CommentDAO;


@WebServlet("/updateComment")
public class UpdateComment extends HttpServlet {
	
	// 댓글 수정
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String commentData = request.getParameter("commentData");
		System.out.println("수정_얻어온 값 : " + commentData);
		
		JsonParser parser = new JsonParser();
		JsonElement data = parser.parse(commentData);
		int C_code = Integer.parseInt(data.getAsJsonObject().get("C_code").getAsString());
		String C_comment = data.getAsJsonObject().get("C_comment").getAsString();
		String C_password = data.getAsJsonObject().get("C_password").getAsString();
		
		CommentDAO dao = CommentDAO.getInstance();
		int result = dao.updateComment(C_code, C_comment, C_password);

		PrintWriter out = response.getWriter();
		out.println(result);
	}
}
