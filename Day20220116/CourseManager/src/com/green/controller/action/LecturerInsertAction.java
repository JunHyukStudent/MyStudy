package com.green.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.LecturerDAO;
import com.green.vo.LecturerVO;

public class LecturerInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "LS?command=moveLecturer_list";
		
		LecturerVO lVo = new LecturerVO();
		
		lVo.setL_name(request.getParameter("l_name"));
		lVo.setL_major(request.getParameter("l_major"));
		lVo.setField(request.getParameter("field"));
		
		LecturerDAO dao = LecturerDAO.getInstance();
		dao.insertLecturer(lVo);
		
		response.sendRedirect(url);
	}

}
