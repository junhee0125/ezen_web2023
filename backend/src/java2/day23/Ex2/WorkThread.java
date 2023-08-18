package java2.day23.Ex2;

public class WorkThread extends Thread{
	//필드
	public boolean work = true;
	//생성자
	public WorkThread(String name) {
		super.setName(name);
		// TODO Auto-generated constructor stub
	}
	//메소드
	@Override
	public void run() {
		while(true) {
			if(work) {
				System.out.println("WorkThread의 부모스레드 : "+super.getName());
			} else {
				Thread.yield(); //현재 스레드를 양보함[대기상태로]
			}
		}// 해당  스레드는 무한루프
	}
}
