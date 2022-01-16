package com.green.controller;

import com.green.controller.action.Action;
import com.green.controller.action.CourseDeleteAction;
import com.green.controller.action.CourseInsertAction;
import com.green.controller.action.CourseListAction;
import com.green.controller.action.CourseUpdateAction;
import com.green.controller.action.CourseViewAction;
import com.green.controller.action.LecturerInsertAction;
import com.green.controller.action.LecturerListAction;
import com.green.controller.action.LecturerUpdateAction;
import com.green.controller.action.MoveCourseInsertAction;
import com.green.controller.action.MoveCourseUpdateAction;
import com.green.controller.action.MoveLecturerInsertAction;
import com.green.controller.action.MoveLecturerUpdateAction;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory af = new ActionFactory();
	public static ActionFactory getInstance() {
		return af;
	}
	
	public Action getAction(String command){
		Action action = null;
		
		if(command.equals("course_list")) {
			action = new CourseListAction(); // 교과목 전체 보기
		}else if(command.equals("moveCourse_insert")){	// 강사 목록 불러오기(교과목 삽입 페이지)
			action = new MoveCourseInsertAction();
		}else if(command.equals("course_insert")) {	// 교과목 등록
			action = new CourseInsertAction();
		}else if(command.equals("course_view")){	// 교과목 상세보기
			action = new CourseViewAction();
		}else if(command.equals("moveCourse_update")) {	// 교과목 수정 페이지
			action = new MoveCourseUpdateAction();
		}else if(command.equals("course_update")) {	// 교과목 수정
			action = new CourseUpdateAction();
		}else if(command.equals("course_delete")) {	// 교과목 삭제
			action = new CourseDeleteAction();
		}else if(command.equals("moveLecturer_list")) {	// 강사 전체 보기
			action = new LecturerListAction();
		}else if(command.equals("moveLecturer_insert")) {	// 강사 등록
			action = new MoveLecturerInsertAction();
		}else if(command.equals("lecturer_insert")) {
			action = new LecturerInsertAction();
		}else if(command.equals("moveLecturer_update")) {
			action = new MoveLecturerUpdateAction();
		}else if(command.equals("lecturer_update")) {
			action = new LecturerUpdateAction();
		}
		
		return action;
	}
}
