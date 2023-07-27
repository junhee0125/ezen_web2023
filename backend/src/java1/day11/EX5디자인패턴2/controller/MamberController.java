package java1.day11.EX5디자인패턴2.controller;

import java.util.Random;

import java1.day11.EX5디자인패턴2.model.dao.MemberDao;
import java1.day11.EX5디자인패턴2.model.dto.MemberDto;

public class MamberController {
	
	
	//1 싱글톤 생성 [private static]
	private static MamberController memController = new MamberController();
	
	//2 외부로부터 싱글톤 호출할 수 있도록 getter 
	public static MamberController getInstance() {return memController;}
	
	//3.외부에서 객체 생성차단을 위해 생성자 잠금
	private MamberController() {}
	
	static int loginIndex = -1;
	
	
	public boolean signUpLogic(String id,String pw, String name, String phone, int age) {
		
		MemberDto m = new MemberDto(id, pw, name, phone, age);
		
		for(int i = 0; i < MemberDao.memberList.length; i++) {
			
			if( MemberDao. memberList[i] == null) {
				
				MemberDao.memberList[i] = m;
				
				return true;
			}
			
		} 
		return false;
		
		
	}
	
	/*로그인
	 * */
	public boolean loginLogic(String inputId,String inputPw) {
		
		
		
		for(int i = 0; i <MemberDao. memberList.length; i++) {
			
			if( MemberDao.memberList[i] != null && MemberDao. memberList[i].getId().equals(inputId)&& MemberDao.memberList[i].getPw().equals(inputPw)) {
				
				return true;
			}			
		}		return false;
		//System.out.println(Arrays.toString(memberList));
		
		
		
	}
	public String findIdLogic(String name, String phone) {
		
		for (int i = 0; i < MemberDao.memberList.length; i++) {
			
			if(MemberDao.memberList[i] != null && MemberDao.memberList[i].getName().equals(name) &&  MemberDao.memberList[i].getPhone().equals(phone)) {
				
			//System.out.println(inputName +"님의 아이디는 :: " +memberList[i].id+"입니다");
				String id = MemberDao.memberList[i].getId();
				
				return id;				
			} 			
			
		} return null;	
		
	}
	
	
	
	public String findPwLogic(String id, String phone) {
		
		
		for (int i = 0; i < MemberDao.memberList.length; i++) {
			
			if(MemberDao.memberList[i] != null && MemberDao.memberList[i].getId().equals(id) &&  MemberDao.memberList[i].getPhone().equals(phone)) {
				System.out.println(id +"님의 비밀번호를 재설정합니다.");
				
				//난수만들기
				Random random = new Random();
				
				String newPw = ""; //난수로 새롭게 설정될 비밀번호
				
				for(int j =0 ; j < 6; j++) {
					
					String r = Integer.toString(random.nextInt(10)); //0~9에 사이의 난수
					
					newPw += r ;
				}
				
				//
				
				MemberDao.memberList[i].setPw(newPw);
				
				return newPw;
				
			} 
		} return null;
	}

}
