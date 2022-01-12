package com.green.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.CourseDAO;
import com.green.vo.CourseVO;
import com.green.vo.LecturerVO;

public class MoveCourseUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/course/updateCourse.jsp";
		
		CourseDAO dao = CourseDAO.getInstance();
		CourseVO courseInfo = dao.courseView(request.getParameter("c_id"));
		List<LecturerVO> lecList = dao.selectAllLec();
		
		request.setAttribute("courseInfo", courseInfo);
		request.setAttribute("lecList", lecList);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
