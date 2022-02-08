package spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.dao.BoardDao;
import spring.vo.AuthInfo;
import spring.vo.BoardInfo;
import spring.vo.BoardList;
import spring.vo.Comment;
import spring.vo.InsertBoard;
import spring.vo.UpdateBoard;

@Controller
@RequestMapping("/board")
public class BoardController {
	private BoardDao dao;

	public BoardController(BoardDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/list")
	public String list(Model model) {
		
		List<BoardList> list = dao.selectAll();
		model.addAttribute("boardList",list);

		return "board/boardList";
	}
	
	@RequestMapping(value="/info/{qnaBoardNum}", method=RequestMethod.GET)
	public String info(@PathVariable("qnaBoardNum") int qnaBoardNum, Model model) {
	
		BoardInfo boardInfo = dao.selectByNum(qnaBoardNum);
		Comment comment = dao.selectByComment(qnaBoardNum);
		model.addAttribute("boardInfo",boardInfo);
		model.addAttribute("comment",comment);
		return "board/boardInfo";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert() {
		return "board/boardInsert";
	}
	
	@RequestMapping(value="/insertSubmit", method=RequestMethod.POST)
	public String insertSubmit(InsertBoard insertBoard,HttpSession session, Model model) {
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		insertBoard.setMemberNum(authInfo.getMemberNum());
		
		dao.insert(insertBoard);
		
		List<BoardList> list = dao.selectAll();
		model.addAttribute("boardList",list);
		
		return "board/boardList";
	}
	
	@RequestMapping(value="/update/{qnaBoardNum}", method=RequestMethod.GET)
	public String update(@PathVariable("qnaBoardNum") int qnaBoardNum, Model model) {
		
		BoardInfo boardInfo = dao.selectByNum(qnaBoardNum);
		
		model.addAttribute("boardInfo",boardInfo);
		return "board/boardUpdate";
	}
	
	@RequestMapping(value="/updateSubmit", method=RequestMethod.POST)
	public String updateSubmit(UpdateBoard updateBoard, Model model) {
		
		dao.update(updateBoard);
		
		List<BoardList> list = dao.selectAll();
		model.addAttribute("boardList",list);
		
		return "board/boardList";
	}
	
	@RequestMapping(value="/delete/{qnaBoardNum}", method=RequestMethod.GET)
	public String delete(@PathVariable("qnaBoardNum") int qnaBoardNum, Model model) {
		
		dao.delete(qnaBoardNum);
		
		List<BoardList> list = dao.selectAll();
		model.addAttribute("boardList",list);
		
		return "board/boardList";
	}
}
