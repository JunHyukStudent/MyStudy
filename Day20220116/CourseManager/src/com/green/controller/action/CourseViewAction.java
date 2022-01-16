package com.green.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.CourseDAO;
import com.green.vo.CourseVO;

public class CourseViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/course/viewCourse.jsp";
		
		CourseDAO dao = CourseDAO.getInstance();
		CourseVO courseInfo = dao.courseView(request.getParameter("c_id"));
		
		request.setAttribute("courseInfo", courseInfo);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
