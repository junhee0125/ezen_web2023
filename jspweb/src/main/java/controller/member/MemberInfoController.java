package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;
import model.dto.MemberDto;

/**
 * Servlet implementation class MemberInfoController
 */
@WebServlet("/MemberInfoController")
public class MemberInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 1. 회원정보 호출(세션호출)/로그아웃(세션초기화)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청 [기능구분을 위한]
		String type = request.getParameter("type");
			if(type.equals("login")) {
				Object session = request.getSession().getAttribute("loginDto");
				//2. 타입변환 [부모는 자식이 될수없으므로 강제 캐스팅]
				MemberDto loginDto = (MemberDto)session;

					// Dto는  JS가 이해할 수 없는 언어이므로 JS가 이해할 수 있게  JS언어로 변환 [by Jackson라이브러리]
				ObjectMapper objectMapper = new ObjectMapper();
				String json = objectMapper.writeValueAsString(loginDto);
				response.setContentType("application:json;charset=UTF-8");
				response.getWriter().print(json);
			} else if( type.equals("logout")) {
				//세션에 저장된 로그인객체를 없애기.초기화.지우기.삭제
				//방법1: 모든 세션 초기화하는 함수
					//request.getSession().invalidate(); //로그인 정보 뿐만 아니라 모두 삭제
				//방법2:JVM GC
						//삭제할 세션 속성명과 동일하게  null대입
					request.getSession().setAttribute("loginDto", null); //GC가 삭제할것.
			}

		//2, 유효성검사
		//3. dao
		//4 응답
			//* 세션에 저장된 로그인객체 꺼내기
			//1, 세션호출 [세션타입은 Object]

	}

	/**
		2. 회원가입
	 */
	//[첨부파일이 있을 때]

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//------------------------------파일업로드------------------------------------//
		// 첨부파일 저장할 폴더의 절대경로
   		// 1. 개발자 pc 경로 업로드 [ 문제발생 : 개발자pc에 업로드하면 업로드파일을 서버로 빌드 ]
   		//String uploadPath = "C:\\Users\\zecace\\Desktop\\uploaded"; // 첨부파일 저장할 경로
   		// 2. 서버 pc 경로 업로드  [ 사용자는 바로 서버pc 업로드 ]
   		//String uploadpath ="C:\\Users\\504-t\\eclipse-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\jspweb\\member\\img";
   		// 3. 서버 pc 경로 ( 상대경로 = 서버경로 찾아주는 함수 )
   			// 서버에 build(배포)된 파일/폴더 의 경로 찾기
   			// request.getServletContext().getRealPath("프로젝트명이하 경로");
		String uploadPath = request.getSession().getServletContext().getRealPath("/member/img");
		//서버PC 톰캣
			// RealPath : C:\\Users\\504-t\\eclipse-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\jspweb\\member\\img
			// HttpPath : http://localhost/jspweb/member/img/
		System.out.println( "member 폴더 img 폴더 실제(서버) 경로 : " + uploadPath );

		//첨부파일 전송 했을 때.
			// 1. 첨부파일 업로드 (COS라이브러리)
			MultipartRequest multi = new MultipartRequest(
					request,			// 1. 요청방식
					uploadPath,			// 2. 첨부파일을 저장할 경로
					1024*1024*10,		// 3. 첨부파일 용량 허용 범위 [ 바이트 단위 ]10mb
					"UTF-8",			// 4.한글인코딩타입
					new DefaultFileRenamePolicy()
		//5. 만약에 서버내 첨부파일의 동일한 이름이 있을때 이름 뒤에 숫자를 자동으로 부여
					);
			// 2. form 안에 있는 각 데이터 호출


		//---------------------------------DB 저장------------------------------------------//
		//일반 input : multi.getParameter("form내의 inputbox name값");
		//첨부파일은
		String mid= multi.getParameter("mid");
		String mpwd= multi.getParameter("mpwd");
		String memail= multi.getParameter("memail");
		String mfile= multi.getFilesystemName("mfile");

		// *만약에 사진업로드 안했으면 기본프로필 사용하도록 변경 = default.webp
   		if( mfile == null ) {mfile = "default.webp";}

		System.out.println(" mid :  "+mid );
		System.out.println(" mpwd  :  "+ mpwd);
		System.out.println(" memail :  "+ memail);
		System.out.println(" mfile  :  "+mfile );

		//dto
		MemberDto memberDto = new MemberDto(mid, mpwd, memail, mfile);
		boolean result = MemberDao.getInstance().signup(memberDto);

		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);

	}

	/*
	 * [첨부파일이없을 때]
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid= request.getParameter("mid");
		String mpwd= request.getParameter("mpwd");
		String memail= request.getParameter("memail");
		String mfile= request.getParameter("mfile");

		System.out.println(" mid :  "+mid );
		System.out.println(" mpwd  :  "+ mpwd);
		System.out.println(" memail :  "+ memail);
		System.out.println(" mfile  :  "+mfile );

		//dto
		MemberDto memberDto = new MemberDto(mid, mpwd, memail, mfile);
		boolean result = MemberDao.getInstance().signup(memberDto);

		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);

	}
	*/


	/**
	 * 3. 회원정보 수정
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uploadPath = request.getSession().getServletContext().getRealPath("/member/img");
		MemberDto loginDto = (MemberDto) request.getSession().getAttribute("loginDto");
		MultipartRequest multi = new MultipartRequest( //cos라이브러리
				request,			// 1. 요청방식
				uploadPath,			// 2. 첨부파일을 저장할 경로
				1024*1024*10,		// 3. 첨부파일 용량 허용 범위 [ 바이트 단위 ]10mb
				"UTF-8",			// 4.한글인코딩타입
				new DefaultFileRenamePolicy());

		String mfile = multi.getFilesystemName("mfile");
		if(mfile == null) {
			mfile = loginDto.getMfile();
		}

		String mpwd = multi.getParameter("mpwd");
		String newmpwd = multi.getParameter("newmpwd");
		if(mpwd == null || newmpwd == null) {
			mpwd = loginDto.getMpwd();
			newmpwd = loginDto.getMpwd();
		}
		int mno =loginDto.getMno();
		System.out.println("MemberInfoController:: mfile ::"+mfile);
		boolean result = MemberDao.getInstance().mupdate(mno,mfile,mpwd,newmpwd);

		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(result);


	}

	/**
	 * 4. 회원정보 삭제
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// *** MemberInfoControll: mpwd:: null
		//server >> server.xml >> 63라인즘..
		//<Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443"  parseBodyMethods="POST,PUT,DELETE"   URIEncoding="UTF-8"/>
		// parseBodyMethods="POST,PUT,DELETE"  << -없으면 put/delete안됨
		String mpwd= request.getParameter("mpwd");
		System.out.println("MemberInfoControll: mpwd:: " +mpwd);
		int mno =((MemberDto) request.getSession().getAttribute("loginDto")).getMno();

		boolean result = MemberDao.getInstance().mdelete(mno, mpwd);
		System.out.println("MemberInfoControll: result:: " +result);
		response.setContentType("application/json;charset-UTF-8");
		response.getWriter().print(result);

	}

}
