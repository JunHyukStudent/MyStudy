package com.green.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.CourseDAO;
import com.green.vo.CourseLecJoinVO;

public class CourseListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/index.jsp";
		
		CourseDAO dao = CourseDAO.getInstance();
		List<CourseLecJoinVO> courselist = dao.selectAllCourse();
		int courseCnt = dao.countAllCourse();
		
		request.setAttribute("courseList", courselist);
		request.setAttribute("courseCnt", courseCnt);
		request.setAttribute("flag", "1");
		
		request.getRequestDispatcher(url).forward(request, response);	
	}
}
