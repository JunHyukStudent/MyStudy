package com.green.controller;

import com.green.controller.action.Action;
import com.green.controller.action.CourseDeleteAction;
import com.green.controller.action.CourseInsertAction;
import com.green.controller.action.CourseListAction;
import com.green.controller.action.CourseUpdateAction;
import com.green.controller.action.CourseViewAction;
import com.green.controller.action.MoveCourseInsertAction;
import com.green.controller.action.MoveCourseUpdateAction;

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
		}else if(command.equals("course_insert")) {	// 교과목 삽입
			action = new CourseInsertAction();
		}else if(command.equals("course_view")){
			action = new CourseViewAction();
		}else if(command.equals("moveCourse_update")) {
			action = new MoveCourseUpdateAction();
		}else if(command.equals("course_update")) {
			action = new CourseUpdateAction();
		}else if(command.equals("course_delete")) {
			action = new CourseDeleteAction();
		}
		
		return action;
	}
}
