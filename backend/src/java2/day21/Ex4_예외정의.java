package java2.day21;

public class Ex4_예외정의 {
	public static void main(String[] args) {
		Account account = new Account();
		account.deposit(10000);
		System.out.println(account.getBalance());
		
		try {
			account.withdraw(5000); //Unhandled exception type Ex4_잔고부족예외
		} catch (Ex4_잔고부족예외 e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			account.withdraw(20000); //Unhandled exception type Ex4_잔고부족예외
		} catch (Ex4_잔고부족예외 e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//java2.day21.Ex4_잔고부족예외: 잔고부족 : 15000만큼 부족

		}
	}
}
