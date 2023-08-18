package java2.day23.Ex3;

public class Calculator {
	//필드
	private int memory;

	
	//생성자
	public Calculator() {
		// TODO Auto-generated constructor stub
	}
	//메소드
	
	public int getMemory() {
		return memory;
	}
	
	//메소드에 동기화하는 방법 [많이 사용되는 방법]
	public synchronized void setMemory(int memory) {
		//매개변수로 들어온 값을 필드에 저장
		this.memory = memory;
		
		//현재 스레드를 2초가 정지
		try {
			Thread.sleep(2000); //현재 스레드 2초간 일시정지
		} catch (Exception e) {
			System.out.println();
		}
		
		//2초후 memory 필드 확인
		System.out.println(Thread.currentThread().getName()+
				"  : 2초후 저장된 메모리 : "+ this.memory);;
	}
	
	//메소드 내 특정 블록에 동기화하는 방법
	public void setMemory2(int memory) {
		
		System.out.println("비동기화구역");
		System.out.println(Thread.currentThread().getName()+" : 접근");
		synchronized (this) { //mutex 동기화구역
			/*
			 1. 뮤텍스(Mutex): 뮤텍스는 상호 배제를 위한 동기화 메커니즘
			 	한 번에 하나의 스레드만이 임계 영역(Critical Section)에 접근할 수 있도록
			 	스레드가 임계 영역에 진입하기 위해 뮤텍스를 획득하고, 
			 	사용이 끝나면 뮤텍스를 반환하여 다른 스레드가 접근할 수 있게 함. 
			 */
			//매개변수로 들어온 값을 필드에 저장
			this.memory = memory;
			
			//현재 스레드를 2초가 정지
			try {
				Thread.sleep(2000); //현재 스레드 2초간 일시정지
			} catch (Exception e) {
				System.out.println();
			}
			
			//2초후 memory 필드 확인
			System.out.println(Thread.currentThread().getName()+
					"  : 2초후 저장된 메모리 : "+ this.memory);;
		}
		
	
		
	}
	
}
