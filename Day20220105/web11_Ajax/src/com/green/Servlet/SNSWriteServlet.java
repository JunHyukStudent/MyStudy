package com.green.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@WebServlet("/SNSWrite")
public class SNSWriteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		try {
			SNSBoardVO sVo = new SNSBoardVO();
			String SNSInfo = request.getParameter("SNSInfo");
			
			JsonParser parser = new JsonParser();
			JsonElement data = parser.parse(SNSInfo);
			
			String stitle = data.getAsJsonObject().get("stitle").getAsString();
			String scontent = data.getAsJsonObject().get("scontent").getAsString();
			
			sVo.setStitle(stitle);
			sVo.setScontent(scontent);
			SNSBoardDAO dao = SNSBoardDAO.getInstance();
			sVo = dao.insertSNS(sVo);
			
			Gson gson = new Gson();
			String sVoJson = gson.toJson(sVo);
			PrintWriter out = response.getWriter();
			out.println(sVoJson);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
}
