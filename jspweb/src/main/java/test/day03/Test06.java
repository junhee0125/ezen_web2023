package test.day03;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test06
 */
/*
 	서버내 동일한  http 주소는 절대로 가질 수 없다.
 */
@WebServlet("/Test06") // 해당 클래스를 호출하는  url[매핑연결]
public class Test06 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test06() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("스크립트가 통신을 요청함.");
		//요청
		String value1 = request.getParameter("value1");
		//request.getParameter("data객체내 속성명");
		
		System.err.println("js] Ajax가 보내온 데이터" +value1);
		// 응답
		response.getWriter().print(true);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
