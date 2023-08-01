package java1.day14.Ex2;

public class ComputerExample {
	public static void main(String[] args) {
		
		
		int r = 10;
		Calculator calculator = new Calculator();
		System.out.println( "부모출력- 원면적 : "+calculator.areaCircle(r));
		
		//자식꺼?
		
		Computer computer = new Computer();
		System.out.println("자식출력 - 원면적"+ computer.areaCircle(r));
	}

}
