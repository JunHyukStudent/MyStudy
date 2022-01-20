package spring.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.dao.MemberDao;
import spring.printer.MemberInfoPrinter;
import spring.printer.MemberListPrinter;
import spring.service.ChangePasswordService;
import spring.service.MemberRegisterService;
import spring.vo.RegisterRequest;


public class Main01 {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appCTX.xml");
		
		MemberDao dao = ctx.getBean("dao",MemberDao.class);

		MemberListPrinter listPrt = ctx.getBean("listPrinter",MemberListPrinter.class);
		
		//listPrt.printAll();

		MemberInfoPrinter infoPrt = ctx.getBean("infoPrinter",MemberInfoPrinter.class);
		//infoPrt.printMemberInfo("lee@naver.com");
		
		MemberRegisterService regSvc = ctx.getBean("regSvc",MemberRegisterService.class);
		
		insert(regSvc);
		
		ChangePasswordService changePwdSvc = ctx.getBean("changePwdSvc",ChangePasswordService.class);
		
		update(changePwdSvc,dao);
		
	}

	private static void update(ChangePasswordService changePwdSvc,MemberDao dao) {
		
		String email = "park@naver.com";
		
		String oldPwd=dao.selectByEmail(email).getPassword();
		String newPwd="";
		
		if(oldPwd.equals("1234")) {
			newPwd = "4321";
		}else if(oldPwd.equals("4321")){
			newPwd = "1234";
		}else {
			newPwd = "1234";
		}
		
		changePwdSvc.changepassword(email, oldPwd, newPwd);
	}

	private static void insert(MemberRegisterService regSvc) {
		RegisterRequest rr = new RegisterRequest();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMdd-HHmmss");
		String str = dateFormat.format(new Date());
		
		rr.setEmail(str+"@naver.com");
		rr.setPassword("1234");
		rr.setName(str);
		rr.setConfirmPassword("1234");
		
		regSvc.regist(rr); //데이터 입력
	}

}
