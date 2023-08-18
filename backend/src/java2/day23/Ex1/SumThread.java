package java2.day23.Ex1;

public class SumThread extends Thread{
	//필드
	private long sum;
	
	
	//생성자
	
	public long getSum() {
		return sum;
	}

	public void setSum(long sum) {
		this.sum = sum;
	}
	
	//메소드
	@Override
	public void run() {
		for(int i= 0; i<=100 ; i++ ) {sum +=i;}
	}
	
	
}
