package java2.day21;
/*
 	예외클래스 만들기
 		표준 라이브러리(미리 만들어서 제공된 클래스/인터페이스)에서 제공하지 않는 예외클래스를 만들기 가능
 */
public class Ex4_잔고부족예외  extends Exception{ // 또는 extends RuntimeException
	//기본생성자
	public Ex4_잔고부족예외() {
		// TODO Auto-generated constructor stub
	}
	
	public Ex4_잔고부족예외( String message) {super(message);}
	
	
}
