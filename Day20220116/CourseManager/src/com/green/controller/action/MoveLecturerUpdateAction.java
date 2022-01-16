package com.green.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.LecturerDAO;
import com.green.vo.LecturerVO;

public class MoveLecturerUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/lecturer/updateLecturer.jsp";
		
		int l_idx = Integer.parseInt(request.getParameter("l_idx"));
		
		LecturerDAO dao = LecturerDAO.getInstance();
		
		LecturerVO lVo = dao.lecturerView(l_idx);
		List<String> lecturerCourseList = dao.lecturerCourse(l_idx);
		
		request.setAttribute("lecturer", lVo);
		request.setAttribute("lecturerCourseList", lecturerCourseList);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
