package java1.day13.Ex2;

import java1.day13.Ex2.view.MainPage;

public class AppStart {

	public static void main(String[] args) {
		
		/*	다른 클래스의 객체의 메소드를 호출하는 방법
		  	1. 객체를 만들어서.	
		  		MainPage mainPage = new MainPage();
		  		mainPage.mainPage();
		  	2. 호출할 메소드가 정적static메소드이면 객체 없이 메소드 호출
		  		MainPage.mainPage();
		  	3. 호출할 메소드의 클래스가 싱글톤(객체)가 존재하면 싱글톤의 메소드를호출하면
		  		싱글톤객체를 반환해줌
		  		MainPage.getInstance().mainView();
		 */
		
		//MainPage의  getInstance()메소드를 호출해서 객체를 받아옴
		MainPage.getInstance().mainView();
		
	}
	
	
}
