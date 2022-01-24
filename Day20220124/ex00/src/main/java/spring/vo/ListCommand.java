package spring.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ListCommand {
	// 뷰에서 from,to에 해당하는 데이터를 커맨드객체에 담아서 컨트롤러로 보내야 한다.
	// 기본타입의 경우  저장시 문자열로 변환 가능
	// 날짜 타입의 경우 저장시 문자열로 변환 불가능
	
	// 스프링이 문자열과 date 타입이 변환이 잘 되도록 설정을 해줄 필요가 있다.
	
	@DateTimeFormat(pattern="yyyyMMddHH") // "2021112711" => 2021.11.27 11시
	private Date from;
	@DateTimeFormat(pattern="yyyyMMddHH")	// "2021113015" => 2021.11.30 15시
	private Date to;
	
	public Date getFrom() {
		return from;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public Date getTo() {
		return to;
	}
	public void setTo(Date to) {
		this.to = to;
	}
	
	
}
