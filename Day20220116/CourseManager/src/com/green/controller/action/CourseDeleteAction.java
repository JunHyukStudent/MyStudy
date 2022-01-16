package com.green.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.CourseDAO;

public class CourseDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CourseDAO dao = CourseDAO.getInstance();
		dao.deleteCourse(request.getParameter("c_id"));
		
		response.sendRedirect("CS?command=course_list");
	}

}
