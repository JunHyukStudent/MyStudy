package com.green.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.LecturerDAO;
import com.green.vo.LecturerVO;

public class LecturerListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/lecturer/listLecturer.jsp";
		
		LecturerDAO dao = LecturerDAO.getInstance();
		List<LecturerVO> list = dao.selectAllLecturer();
		int count = dao.countAllLecturer();
		
		request.setAttribute("lecturerList", list);
		request.setAttribute("lecturerCnt", count);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
