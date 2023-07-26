package 과제.과제10.생활클래스;

public class 게임 {

	public static void main(String[] args) {
		
		캐릭터생성  용상 = new 캐릭터생성("용상짱구", "M", "전사");
		
		캐릭터생성  규리  = new 캐릭터생성("우주최강미녀","F","마법사");
		
		//Hunt();
		용상.hunt("개미");
		용상.hunt("공벌레");
		용상.hunt("모기");
	
		용상.attack(규리);
		
	}
	
}
