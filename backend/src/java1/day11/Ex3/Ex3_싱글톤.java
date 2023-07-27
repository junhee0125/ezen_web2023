package java1.day11.Ex3;

public class Ex3_싱글톤 {

	public static void main(String[] args) {
		//1.Member 객체생성
		// 오루 : 생성자를 private 되어있는 클래스는 외부에서 객체생성 불가능
		//Member member = new Member()

		//2. Member객체 호출 [아래 두객체는 같다.]
		Member member1 = Member.getInstance();
		Member member2 = Member.getInstance();
		
		System.out.println(member1 == member2);
	}
		
}
