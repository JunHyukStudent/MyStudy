package spring.survey;

import java.util.List;

public class Question {
	private String title;
	private List<String> option;
	
	public Question(String title) {
		super();
		this.title = title;
	}
	
	public Question(String title, List<String> option) {
		super();
		this.title = title;
		this.option = option;
	}
	
	public boolean isChoice() {	// boolean타입 메서드이름 isChoice() => get메서드와 같다. => choice필드가 있는것처럼 작동
		return option != null && !option.isEmpty();	// choice가 true라면 옵션 답안이 없다.
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getOption() {
		return option;
	}
	public void setOption(List<String> option) {
		this.option = option;
	}
	
}
