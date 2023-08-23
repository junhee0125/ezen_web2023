package controller.visitlog;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.VisitLogDao;
import model.dto.VisitLogDto;

/**
 * Servlet implementation class VisitLogController
 */
@WebServlet("/VisitLogController") //해당 서블릿(자바)컨트롤러
public class VisitLogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisitLogController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * 1. 저장
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 아작스로 요청하기
		//request.getParameter("vpwd");
		String vwriter = request.getParameter("vwriter"); System.out.println( "vwriter: "+ vwriter);
		String vpwd = request.getParameter("vpwd");	System.out.println( "vpwd: "+ vpwd);
		String vcontent = request.getParameter("vcontent"); System.out.println( "vcontent: "+ vcontent);
		
		// 2.객체화하기
		VisitLogDto VisitLogDto  = new VisitLogDto(vwriter, vpwd, vcontent);
		System.out.println( "VisitLogDto: "+ VisitLogDto.toString());
		
		
		boolean result = VisitLogDao.getInstance().vRead(VisitLogDto);
		//response.getWriter().print(응답할데이터);
		//response.setContentType("text/html;charset=UTF=8");
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
		
	}

	/**
	 * 2.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청 [ X ] : 모든 글 출력은 조건이 없으므로 요청값 없다. vs 개별 글 출력 : 조건이 출력할 글 번호
		// 2. 객체화 [ X ]
		// 3. DAO 
		ArrayList<VisitLogDto> result = VisitLogDao.getInstance().vRead();
			// * JS는 ArrayList타입을 사용할수 없으므로 ArrayList타입 JSON배열로 변환해서 전달하자. [ 라이브러리 : jackson ]
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString( result ); // JSON타입으로 변환은 불가능하지만 JSON형식의 문자열타입 로 변환 
			System.out.println( jsonArray );
		// 4. 응답 
		// response.getWriter().print(result); // 응답은 가능하나... js가  ArrayList타입 사용이 불가능 [ 문제발생 ]
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print( jsonArray );
	}

	

	/**
	 * 3.
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

	/**
	 * 4.
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

}
