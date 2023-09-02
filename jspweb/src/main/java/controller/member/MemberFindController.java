package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;
import model.dto.MemberDto;

/**
 * Servlet implementation class MemberFindController
 */
@WebServlet("/MemberFindController")
public class MemberFindController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFindController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		String data = request.getParameter("data");
		System.out.println("type 서블릿 " + type);
		System.out.println("data 서블릿 " + data);
		boolean result = MemberDao.getInstance().isExist(type, data);
		response.setContentType("application/json;charset=UTF-8;");
		response.getWriter().print(result);
	}

	/**
	 * 로그인
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mid");
		String mpwd = request.getParameter("mpwd");
		System.out.println("Mfind -post" + mid +"/"+ mpwd);
		boolean result = MemberDao.getInstance().login(mid, mpwd);
		//만약에 로그인 성공하면 세션에 로그인한 정보 저장
		if(result ==true ) {
			//1. 세션에
			MemberDto loginDto = MemberDao.getInstance().info(mid);
			request.getSession().setAttribute("loginDto", loginDto); //
			//세션상태 확인 (
			//MemberDto dto = request.getSession().getAttribute("loginDto"); # Dto != object (타입변환이 필요함)
			//Type mismatch: cannot convert from Object to MemberDto
			MemberDto dto = (MemberDto)request.getSession().getAttribute("loginDto");
			System.out.println("(LoginIfo )Dto :: "+ dto);
		}
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);

	}

	/*
	 	# 저장소 ( 무엇을 어디에 저장할 것인가?)
	  		1. JAVA/JS 메모리
	  				- 휘발성
	  				- JAVA /JS 종료 , 페이지전환, 새로고침시 초기화됨
	  				- DTO이동객체, 로직에 필요한 변수(생성조건에 따라 사용범위가 다름)

	  				세션객체( static ) : 모든 곳에서 동일한 메모리 사용
	  					- 장점 : 모든 곳에서 동일한 메모리 사용
	  					- 단점 : 프로그램/서버가 종료될때까지 유지 (이래서 메모리를 많이 차지함)
	  					- 로그인정보: 페이지 전환되더라도 로그인상태 유지

	  		2. DB메모리
	  				- 영구저장 [논리구조(관계형/표) 저장 ]
	  				- 회원정보, 게시판정보, 제품정보 등등
	  				- 실제 데이터

	  		3. 세션 / 쿠키

	  		4. 파일
	  			- 영구저장 [문자열 저장]
	  			- 로그/기록(예외처리. 오류정보, 사용자의 접속수 , 최상위보안자료)


	  	# 로그인 했다는 증거 => 인증 [인증서= >세션에 저장]

	  	JS : sesstionStorage	: 모든 JS에서 사용가능한 메모리 공간 [문자열타입]
	  		세션타입 : 문자열 타입 ( 타입변환 필수)
	  		세션 저장 : sesstionStorage.setItem(키, 데이터)
	  		세션 호출 : sesstionStorage.gettItem(키)

	  	JAVA(servlet) : request.getSession() : 모든 서블릿에서 사용가능한 메모리 공간
	  		세션타입 : 오브젝트 타입
			request.getSession().setAttribute("속성명", 데이터);
			request.getSession().getAttribute("속성명");
	  	servlet
	  		내장객체
	  			request
	  				request.getParameter() : 아작스로부터 전달된 데이터 요청
	  				request.getSession().getServletContext().getRealPath("/member/img"); :서블릿 저장소의 실제 주소
	  				request.getSession() : 서버내 섹션객체 호출
	  			response
	  				response.setContentType("application/json;charset=UTF-8"); 데이터 타입 설정
					response.getWriter().print(result);		아작스에게 전달할 데이터 응답


	 */

}
