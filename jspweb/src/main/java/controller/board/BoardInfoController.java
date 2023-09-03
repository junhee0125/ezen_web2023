package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dto.BoardDto;
import model.dto.MemberDto;

/**
 * Servlet implementation class BoardInfoController
 */
@WebServlet("/BoardInfoController")
public class BoardInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 글목록 / 상세보기
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청
		int bno = Integer.parseInt(request.getParameter("bno"));
		int bcno = Integer.parseInt(request.getParameter("bcno"));
		//유효성 or 객체화
		//Dao
		if(bno == 0) {
			ArrayList<BoardDto> list = BoardDao.getInstance().boardList(bcno);
			System.out.println(list.toString());
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonArray = objectMapper.writeValueAsString(list);
			//응답
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().print(jsonArray);
		} else {

		}


	}

	/**
	 * 글저장
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String saveDirectory = request.getSession().getServletContext().getRealPath("/board/files");
				//첨부파일 업로드
		MultipartRequest multi = new MultipartRequest(
				request,
				saveDirectory,
				1024*1024*10,
				"UTF-8",
				new DefaultFileRenamePolicy());

		//DB저장
		int bcno = Integer.parseInt(multi.getParameter("bcno"));
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");
		int mno = ((MemberDto)request.getSession().getAttribute("loginDto")).getMno();
		System.out.println(bcno);
		System.out.println(btitle);
		System.out.println(mno);
		System.out.println(bcontent);
		System.out.println(bfile);
		BoardDto boardDto = new BoardDto(bcno, btitle, bcontent, mno, bfile);
		boolean result = BoardDao.getInstance().boardSave(boardDto);

		response.setContentType("application/json;charset:UTF-8");
		response.getWriter().print(result);
	}

	/**
	 * 글수정
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * 글삭제
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
