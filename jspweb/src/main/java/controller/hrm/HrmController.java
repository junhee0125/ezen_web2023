package controller.hrm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.HrmDao;
import model.dto.HrmDto;

/**
 * Servlet implementation class HrmController
 */
@WebServlet("/HrmController")
public class HrmController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HrmController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String saveDirectory = request.getSession().getServletContext().getRealPath("/hrm/img") ;
		System.out.println( "hrm 폴더 img 폴더 실제(서버) 경로 : " + saveDirectory );
		System.out.println("ctr-post");
		MultipartRequest multi = new MultipartRequest(
				request,					//요청방식
				saveDirectory,				//저장위치
				1024*1024*10,				//제한용량 10mb
				"UTF-8",					//한글인코딩
				new DefaultFileRenamePolicy()	//파일명중복시 파일명수정
		);

		String hname = multi.getParameter("hname");
		String hrank = multi.getParameter("hrank");
		String hphone = multi.getParameter("hphone");
		String hphoto = multi.getFilesystemName("hphoto"); //파일은 getFilesystemName("")

		if( hphoto == null ) {hphoto = "default.webp";}

		System.out.println(" hname :  "+hname );
		System.out.println(" hrank  :  "+ hrank);
		System.out.println(" hphone :  "+ hphone);
		System.out.println(" hphoto  :  "+hphoto );

		HrmDto hrmDto = new HrmDto(hname, hrank, hphone, hphoto);
		boolean result = HrmDao.getInstance().hrmSave(hrmDto);

		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);

		//dto


	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
