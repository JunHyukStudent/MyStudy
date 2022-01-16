package com.green.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.LecturerDAO;

public class MoveLecturerInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/lecturer/insertLecturer.jsp";
		
		LecturerDAO dao = LecturerDAO.getInstance();
		
		int l_idx = dao.countAllLecturer() + 1;	// 강사 번호 미리 지정
		
		request.setAttribute("l_idx", l_idx);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
