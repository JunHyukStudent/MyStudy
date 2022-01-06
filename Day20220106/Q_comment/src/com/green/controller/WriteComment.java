package com.green.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.green.dao.CommentDAO;


@WebServlet("/writeComment")
public class WriteComment extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String commentData = request.getParameter("commentData");
		System.out.println("삽입_얻어온 값 : " + commentData);
		
		JsonParser parser = new JsonParser();
		JsonElement data = parser.parse(commentData);
		String C_user = data.getAsJsonObject().get("C_user").getAsString();
		String C_comment = data.getAsJsonObject().get("C_comment").getAsString();
		String C_password = data.getAsJsonObject().get("C_password").getAsString();
		
		CommentDAO dao = CommentDAO.getInstance();
		int result = dao.insertComment(C_user, C_comment, C_password);

		PrintWriter out = response.getWriter();
		out.println(result);
	}

}
