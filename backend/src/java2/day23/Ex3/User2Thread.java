package java2.day23.Ex3;

public class User2Thread extends Thread {
	//필드
	private Calculator calculator;
	
	//생성자
	public User2Thread() {
		super.setName("user2");
	}
	//메소드

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	
	@Override
	public void run() {
		calculator.setMemory(50);
		calculator.setMemory2(150);
	}


}

