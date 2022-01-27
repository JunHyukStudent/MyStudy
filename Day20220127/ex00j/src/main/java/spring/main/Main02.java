package spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.config.DbNestedConfig;
import spring.dao.MemberDao;
import spring.vo.Member;

public class Main02 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=
				new AnnotationConfigApplicationContext();
		
		ctx.getEnvironment().setActiveProfiles("real");
		ctx.register(DbNestedConfig.class);
		
		ctx.refresh();
		
		MemberDao dao = ctx.getBean("dao",MemberDao.class);
		
		for(Member m :dao.selectAll()) {
			System.out.println("이름 : "+m.getName());
		}
		ctx.close();

	}

}
