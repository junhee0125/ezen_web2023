package 과제.과제10.생활클래스;

public class 캐릭터생성 {
	
	//필드

	private String nickName; 
	private String sex;
	private String job;
	private int level;
	private int exp;
	private int ip; //지성
	private int pow; //파워
	private int hp; //체력
	private int mp; //마력
	
	
	
	
	//생성자
	캐릭터생성(String nickname, String sex, String job){
		this.nickName= nickname;
		this.sex = sex ;
		this.job =job;
		level = 1;
		exp = 0;
		
		if(job.equals("전사")) {
		
			
			ip = 30; //지성
			pow =100; //파워
			hp = 300; //체력
			mp = 10; //마력
			
		} else if(job.equals("마법사")) {
			
			ip = 100; //지성
			pow = 30; //파워
			hp = 150; //체력
			mp = 30; //마력
		}
		
	}
	
	
	
	
	//메소드
	void hunt(String h) {
		if(h.equals("개미")) {
			exp += 1;
			System.out.println(nickName+"님의 현재경험치 : " + exp);
		} else if(h.equals("공벌레")) {
			exp += 5;
			System.out.println(nickName+"님의 현재경험치 : " + exp);

		} else if(h.equals("모기")) {
			exp += 100;
			ip += 1;
			System.out.println(nickName+"님의 현재경험치 : " + exp);
			System.out.println(nickName+"님의 현재지력 : " + exp);
		}
		
	}
	
	void attack(Object o) {
		
	}
	void levelUp() {
		
	}
	
	
	
	
}
