package java1.day18.Ex1;

public class Audio implements RemoteControl {
	//(인스턴스)필드
	private int volume; 
	
	@Override
	public void turnOn() {
		System.out.println("오디오를 켭니다");
	}
	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("오디오를 끕니다.");
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
if(volume >RemoteControl.MAX_VOLIME) {
			
			this.volume = RemoteControl.MAX_VOLIME; //this 해당 메소드를 호출한 객체
	
		} else if( volume < RemoteControl.MIN_VOLUME) {
				
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		
		System.out.println("현재 Audio볼륨 : "+ volume);
		
	}
}
