package spring.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.dao.AdminDao;
import spring.vo.BoardAdminList;
import spring.vo.BoardInfo;
import spring.vo.Comment;
import spring.vo.MemberInfo;
import spring.vo.MemberList;

@Controller
@RequestMapping("/admin")
public class AdminController {
	AdminDao dao;
	public AdminController(AdminDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/memberAdminList")
	public String memberAdminList(Model model) {
		List<MemberList> list = dao.selectAllMember();
		model.addAttribute("memberAdminList",list);
		return "admin/memberAdminList";
	}

	@RequestMapping(value="/memberUpdate/{memberNum}", method=RequestMethod.GET)
	public String memberUpdate(@PathVariable("memberNum") int memberNum, Model model) {
		
		MemberInfo memberInfo = dao.selectByMemberNum(memberNum);
		
		model.addAttribute("memberInfo",memberInfo);
		return "/admin/memberUpdate";
	}
	
	@RequestMapping(value="/memberUpdate/submit", method=RequestMethod.POST)
	public String memberUpdateSubmit(MemberInfo memberInfo,Model model) {
		
		dao.updateMember(memberInfo);
		
		List<MemberList> list = dao.selectAllMember();
		model.addAttribute("memberAdminList",list);
		return "admin/memberAdminList";
	}
	
	@RequestMapping(value="/memberDelete/{memberNum}", method=RequestMethod.GET)
	public String memberDelete(@PathVariable("memberNum") int memberNum, Model model) {
		
		dao.deleteMember(memberNum);
		
		List<MemberList> list = dao.selectAllMember();
		model.addAttribute("memberAdminList",list);
		return "admin/memberAdminList";
	}
	
	@RequestMapping("/boardAdminList")
	public String boardAdminList(Model model) {
		
		List<BoardAdminList> blist = dao.selectAllBoard();
		model.addAttribute("boardAdminList",blist);
		return "admin/boardAdminList";
	}
	
	@RequestMapping(value="/boardInfo/{qnaBoardNum}", method=RequestMethod.GET)
	public String boardInfo(@PathVariable("qnaBoardNum") int qnaBoardNum, Model model) {
	
		BoardInfo boardInfo = dao.selectByNum(qnaBoardNum);
		Comment comment = dao.selectByComment(qnaBoardNum);
		model.addAttribute("boardInfo",boardInfo);
		model.addAttribute("comment",comment);
		return "admin/boardInfo";
	}

	@RequestMapping(value="/commentWrite", method=RequestMethod.POST)
	public String commentWrite(Comment commentReq, Model model) {
		dao.writeComment(commentReq);
		
		BoardInfo boardInfo = dao.selectByNum(commentReq.getQnaBoardNum());
		Comment comment = dao.selectByComment(commentReq.getQnaBoardNum());
		model.addAttribute("boardInfo",boardInfo);
		model.addAttribute("comment",comment);
		return "admin/boardInfo";
	}
	
	@RequestMapping(value="/boardDelete/{qnaBoardNum}", method=RequestMethod.GET)
	public String boardDelete(@PathVariable("qnaBoardNum") int qnaBoardNum, Model model) {
		
		dao.delete(qnaBoardNum);
		
		List<BoardAdminList> blist = dao.selectAllBoard();
		model.addAttribute("boardAdminList",blist);
		return "/admin/boardAdminList";
	}
	
	
}
