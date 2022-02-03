package spring.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.dao.BoardDao;
import spring.vo.BoardList;

@Controller
public class BoardListController {
	private BoardDao dao;

	public BoardListController(BoardDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/board/list")
	public String list(Model model) {
		
		List<BoardList> list = dao.selectAll();
		model.addAttribute("boardList",list);

		return "board/boardList";
	}
}
