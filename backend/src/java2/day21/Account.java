package java2.day21;

public class Account {
	//필드
	private long balance;
	
	
	//생성자
	public Account() {
		// TODO Auto-generated constructor stub
	}
	//메소드\\
	public long getBalance() {
		return balance;		
	}
	
	public void deposit(int money) {
		balance += money;
	}
	
	public void withdraw(int money) throws Ex4_잔고부족예외  {
		if(this.balance < money) {
			throw new Ex4_잔고부족예외("잔고부족 : " + (money - this.balance)+"만큼 부족" );
			//Unhandled exception type Ex4_잔고부족예외
		}
		this.balance -= money; 
	}
}	
