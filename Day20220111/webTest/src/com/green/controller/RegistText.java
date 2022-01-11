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
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.green.dao.TextDAO;
import com.green.vo.TextVO;


@WebServlet("/registText")
public class RegistText extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		TextDAO dao = TextDAO.getInstance();
		List<TextVO> list = dao.selectAllText();
		
		Gson gson = new Gson();
		String jsonList = gson.toJson(list);

		PrintWriter out = response.getWriter();
		
		out.println(jsonList);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String wordData = request.getParameter("wordData");
		System.out.println("얻어온 값 : "+wordData);
		
		JsonParser parser = new JsonParser();
		JsonElement data = parser.parse(wordData);
		
		String title = data.getAsJsonObject().get("title").getAsString();
		String contents = data.getAsJsonObject().get("contents").getAsString();
		
		TextDAO dao = TextDAO.getInstance();
		dao.insertText(title,contents);
		
		List<TextVO> list = dao.selectAllText();
		
		Gson gson = new Gson();
		String jsonList = gson.toJson(list);

		PrintWriter out = response.getWriter();
		
		out.println(jsonList);
		
	}

}
