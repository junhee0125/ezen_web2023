package java1.day18.Ex1;

public class Television implements RemoteControl {
	
	//(인스턴스)필드
	private int volume; 
	//클래스명 implements 인터페이스명
	//=> 인터페이스가 선언한 추상메소드를 해당클래스가 대신 구현하기
	//추상메소드를 구현하기 전까지 오류가 발생
	// implements키워드를 사용했으면 추상메소드를 구현해야함.!!! must!!!
	@Override
	public void turnOn() {

		System.out.println("Tv를 켭니다.");
		
	}
	
	@Override
	public void turnOff() {
		System.out.println("Tv를 끕니다.");
		
	}
	
	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		volume++;
	}
	
	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		volume--;
	}
	
	@Override
	public void setVolume(int volume) {
		System.out.println("시작 볼룸 : " + volume);
		// TODO Auto-generated method stub
		if(volume >RemoteControl.MAX_VOLIME) {
			
			this.volume = RemoteControl.MAX_VOLIME; //this 해당 메소드를 호출한 객체
	
		} else if( volume < RemoteControl.MIN_VOLUME) {
				
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		
		System.out.println("현재 Tv볼륨 : "+ volume);
	}
	
}
