package 과제.accountbook;

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
 * Servlet implementation class Accountbook
 */
@WebServlet("/Accountbook")
public class Accountbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accountbook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 1. 등록 create
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String atext = request.getParameter("atext"); System.out.println("atext  : " + atext);
		int anumber = Integer.parseInt(request.getParameter("anumber")); System.out.println("anumber  : " + anumber);
		
		AccountbookDto dto = new AccountbookDto(atext, anumber);
		boolean result = AccountbookDao.getInstance().aWrite(dto);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}
	
	/**
	 * 2. 출력 Read
	 */
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ArrayList<AccountbookDto> result = AccountbookDao.getInstance().aRead();
    	
    	ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString( result ); // JSON타입으로 변환은 불가능하지만 JSON형식의 문자열타입 로 변환 
		System.out.println( jsonArray );
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print( jsonArray );
		
	}

	/**
	 * 3. 수정 Update
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ano =Integer.parseInt(request.getParameter("ano")); System.out.println("ano  : " + ano);
		String atext = request.getParameter("atext"); System.out.println("atext  : " + atext);
		int anumber = Integer.parseInt(request.getParameter("anumber")); System.out.println("anumber  : " + anumber);
		
		boolean result = AccountbookDao.getInstance().aUpdate(ano,atext,anumber);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
		
		
		
	}

	/**
	 * 4.삭제 Delete
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ano =Integer.parseInt(request.getParameter("ano")); System.out.println("ano  : " + ano);
		boolean result = AccountbookDao.getInstance().aDelete(ano);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

}
