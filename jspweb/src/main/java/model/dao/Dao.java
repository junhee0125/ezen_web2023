package model.dao;

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
	public Connection conn; 		// DB에 연동된 객체
	public PreparedStatement ps ;	// 연동된 DB조작객체 (SQL매개변수
	public ResultSet rs; 			// SQL 조작 결과를 가져오는 객체

	//생성자 : 객체 생성시 초기화를 담당
		//기본생성자에 DB연동 코드 작성 * DAO객체 생성시 바로DB연동
	public Dao() {// 자식 객체가 생성되면 부모객체도 같이 생성됨.
		// 객체가 생성된다는 것은  생성자가 호출된다는 것.
		// 즉 자식의 객체가 생성되면 부모가 바로 호출되기때문에
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/jspweb", "root", "fm050426^^");
			// conn = DriverManager.getConnection("jdbc:mysql://18.222.109.190:3306", "root", "zxcv0246!@");
			System.out.println("디비 연동성공 ^ㅂ^☆");

		} catch (Exception e) {

			System.out.println(" 디비연동 실패  TㅂT☆" + e);
		}

	}


}

