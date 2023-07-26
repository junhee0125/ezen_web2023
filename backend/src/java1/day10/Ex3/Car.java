package java1.day10.Ex3;

public class Car {
	
	//필드
	private int gas ; //현재 객체의 gas데이터를 저장하는 곳
	//생성자
	
	//메소드
	/*
	 	* 관례적으로 메소드명은
	 	*  1. 필드에 저장하는 용도의 함수는 set필드명() -- setGas()
	 	*  2. 필드의 값을 호출하는 용도의 함수느 get필드명 =>> setter / getter  함수라고 getGas()
	 	*  3. 필드에 값을 존재여부(boolean) 확인하는 함수명은 is필드명  isGas()
	 	*  
	 	*  
	 	*  
	 	*  
	 	*  
	 	*  
	 	*  
	 	*  0
	 */
	
	//1. 리턴값이 없고, 매개변수 1개를 받아서  필드 gas에 저장하는 함수
	void setGas( int gas) {
		this.gas = gas;
	}
	
	
	

	//현재 필드의 gas가 0이면 false리턴하고, 아니면 true를 리턴하는 함수
	boolean isLeftGas() {
		if (gas ==0) {
			System.out.println("gas가 없습니다.");
			return false;
		}
		System.out.println("gas가 있습니다.");
		return true;
	}
	
	//3 .리턴도 없고, 매개변수도 없은 경우
	void run() {
		while(true) {
			if(this.gas > 0) {
				System.out.println("달립니다. 가스잔량 : " + this.gas);
				this.gas--;
			} else {
				System.out.println("멈춥니다. 가스잔량 : " + this.gas);
				return;
			}
		}
	}
}
