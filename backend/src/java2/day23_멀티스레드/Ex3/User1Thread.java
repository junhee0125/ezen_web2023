package java2.day23_멀티스레드.Ex3;

public class User1Thread extends Thread {
	//필드
	private Calculator calculator;
	
	//생성자
	public User1Thread() {
		super.setName("user1");
	}
	//메소드

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	
	@Override
	public void run() {
		calculator.setMemory(100);
		calculator.setMemory2(200);
	}


}
