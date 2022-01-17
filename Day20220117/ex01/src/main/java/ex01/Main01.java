package ex01;

public class Main01 {
	public static void main(String[] args) {
		Greeter gt = new Greeter();
		gt.setFormat("%s님 안녕하세요!");
		String msg = gt.greet("박준혁");
		
		System.out.println(msg);
	}
}
