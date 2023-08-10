package 과제.과제11.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 	각종 Dao클래스를 대표하는 부모클래스
 */
public class Dao { 
	
	//필드 
	//[import java.sql - "확인해야"]
	public Connection conn; 		//DB연동 객체
	public PreparedStatement ps ;	// 연동된 DB조작객체 (SQL매개변수 
	public ResultSet rs; 			//SQL 조작 결과를 가져오는 객체

	//생성자 : 객체 생성시 초기화를 담당
		//기본생성자에 DB연동 코드 작성 * DAO객체 생성시 바로DB연동
	public Dao() {
		
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb4web", "root", "1234");
			
		//	System.out.println("디비 연동성공");
		
		} catch (Exception e) {
			
			System.out.println(" 디비연동 실패" + conn);
		}
		
	}
	
	
}
