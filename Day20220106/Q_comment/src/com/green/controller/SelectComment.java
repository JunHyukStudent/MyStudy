package com.green.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.green.dao.CommentDAO;
import com.green.vo.CommentVO;


@WebServlet("/selectComment")
public class SelectComment extends HttpServlet {

	// 댓글 목록 불러오기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		CommentDAO dao = CommentDAO.getInstance();
		List<CommentVO> list = dao.selectAllComment();
		
		Gson gson = new Gson();
		String jsonList = gson.toJson(list);

		PrintWriter out = response.getWriter();
		out.println(jsonList);
	}
}
