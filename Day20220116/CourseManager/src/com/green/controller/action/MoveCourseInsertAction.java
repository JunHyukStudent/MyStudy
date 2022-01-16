package com.green.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.CourseDAO;
import com.green.vo.LecturerVO;

public class MoveCourseInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/course/insertCourse.jsp";
		
		CourseDAO dao = CourseDAO.getInstance();
		List<LecturerVO> lecList = dao.selectAllLec();
		
		request.setAttribute("lecList", lecList);
		
		request.getRequestDispatcher(url).forward(request, response);	
	}
}
