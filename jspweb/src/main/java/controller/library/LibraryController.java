package controller.library;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.LibraryDao;
import model.dto.LibraryDto;

/**
 * Servlet implementation class LibraryController
 */
@WebServlet("/LibraryController")
public class LibraryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibraryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 좌석정보
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * 입실 or 퇴실
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strType = request.getParameter("type");
		int seatno = Integer.parseInt(request.getParameter("seatno"));
		String name = request.getParameter("name");
		String phonenumber = request.getParameter("phonenumber");

		System.out.println("doPost");
		System.out.println(" type :  "+ strType );
		System.out.println(" seatno :  "+ seatno );
		System.out.println(" name :  "+ name );
		System.out.println(" phonenumber :  "+ phonenumber );


		boolean result = false;

		if(strType.equals("C")) { //입실
			LibraryDto libraryDto = new LibraryDto(name, phonenumber, seatno, true);
		    result = LibraryDao.getInstance().checkIn(libraryDto);
		}else if(strType.equals("U")) { //퇴실
			LibraryDto libraryDto = new LibraryDto(name, phonenumber, seatno, false);
			result = LibraryDao.getInstance().checkOut(libraryDto);
		}

		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

	/**
	 * 퇴실
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPut");

		//String seatno = request.getParameter("seatno");
		String name = request.getParameter("name");
		String phonenumber = request.getParameter("phonenumber");

		//System.out.println(" seatno :  "+ seatno );
		System.out.println(" name :  "+ name );
		System.out.println(" phonenumber :  "+ phonenumber );

		//LibraryDto libraryDto = new LibraryDto(name, phonenumber, seatno, false);
		//boolean result = LibraryDao.getInstance().checkOut(libraryDto);

		//response.setContentType("application/json;charset=UTF-8");
		//response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
