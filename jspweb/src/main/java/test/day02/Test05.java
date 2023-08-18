package test.day02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Test05
 */
@WebServlet("/Test05")
public class Test05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test05() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 //0. 게시물 DTO 생성
		BoardDto boardDto = new BoardDto("제목2", "안녕하세요2");
		//Dto는 Json으로  변환을 해야하는 데.. Json은  Dto를 몰라..어쩔
			// JAVA가 문자열타입의 JSON모양 만들어서 JS 에게 전달
			// 라이브러리 : jackson : 자바용 고성능 json 프로세서
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = mapper.writeValueAsString(boardDto); // json형식으로 변환할 객체 넣기
			System.out.println("자바[String 타입에서ㅏJson모양으로 변환해주는 라이브러리]"+jsonData);
			//응답타입
			response.setContentType("application/json;charset=UTF-8");
			//3.응답ㅌ데이타
			response.getWriter().print(jsonData);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
