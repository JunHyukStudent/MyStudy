package com.green.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.CourseDAO;
import com.green.vo.CourseVO;

public class CourseUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CourseVO cVo = new CourseVO();
		
		cVo.setC_id(request.getParameter("c_id"));
		cVo.setC_name(request.getParameter("c_name"));
		cVo.setCredit(Integer.parseInt(request.getParameter("credit")));
		cVo.setC_lecturer(Integer.parseInt(request.getParameter("c_lecturer")));
		cVo.setWeek(Integer.parseInt(request.getParameter("week")));
		cVo.setStart_hour(Integer.parseInt(request.getParameter("start_hour")));
		cVo.setEnd_hour(Integer.parseInt(request.getParameter("end_hour")));
		
		CourseDAO dao = CourseDAO.getInstance();
		dao.insertCourse(cVo);
		
		response.sendRedirect("CS?command=course_list");

	}

}
