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
import model.dto.PageDto;

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

		String type = request.getParameter("type");
		System.out.println("Controller__type :: "+ type);
		String json= null;

		ObjectMapper objectMapper = new ObjectMapper();

		if(type.equals("1")) { //게시판 전체 글보기
			
			// 1. 카테고리별 출력
			int bcno = Integer.parseInt(request.getParameter("bcno"));
			// 2. 하나의 페이지에 출력할 최대 게시물 수
			int listsize = Integer.parseInt(request.getParameter("listSize"));
			// 3. 페이징처리하기
			int page = Integer.parseInt(request.getParameter("page"));
				// 페이지 레코드의 시작번호가 필요함 : (pagenum-1) *출력할 게시물
			//시작번호
			int startrow = (page-1) * listsize;
			
			//4. 마지막 페이지번호
				// 전체 게시물수 / 페이별최대 게시물수(listsize) +1
			int totalsize = BoardDao.getInstance().getTotalCount(bcno);
			int totalpage = totalsize % listsize == 0 ?  totalsize/listsize : totalsize / listsize +1;
			
			// 5. 페이지번호버튼, 시작번호, 마지막번호
			/*
			 * 5개 출력시  1-5 / 6-10/ 11-15
			 * n = (페이지/번호버튼겟숫)*
			 * n개 출력시  1-n / n+1 -  2n/ 2n+1 - 3n
			 * 페이지 /출력
			 * */
			// 1. 페이지버튼 출력 개수
			int btnsize = 5;
			//2. 페이지버튼 번호의 시작번호
			int startbtn  = ((page-1)/btnsize)*btnsize+1;
			// 3. 페이지버튼 번호의 마지막 번호
			int endbtn = startbtn + btnsize-1;
				//단 마지막 번호느는 총페
			if(endbtn >= totalpage) endbtn = totalpage;
			
			
			ArrayList<BoardDto> result = BoardDao.getInstance().boardList(bcno, listsize, startrow);
			
			//pageDto
			PageDto pageDto = new PageDto(page, listsize, startrow, totalsize, totalpage,startbtn, endbtn, result);
			
			System.out.println( result );
			// * java객체 --> js객체[JSON] 형식 의 문자열 으로 변환
			json = objectMapper.writeValueAsString( pageDto );


		} else if(type.equals("2")) { // 1개의 게시물 상세보기
			int bno = Integer.parseInt(request.getParameter("bno"));
			BoardDto result = BoardDao.getInstance().boardView(bno);
			System.out.println("bno :: "+ bno);
			System.out.println( result );
				// 만약에 (로그인 혹은 비로그인) 욫ㅇ한 사람과 게시물 작성한람이 동일하면
			Object object = request.getSession().getAttribute("loginDto");

			if(object == null) { // 로그인안햇을 경우


			} else { //로그인을 한경우
				MemberDto loginDto = (MemberDto)object;
				if(loginDto.getMno() == result.getMno()) {
					result.setHost(true);
				} else {
					result.setHost(false);
				}
			}

			json = objectMapper.writeValueAsString( result );

		}


		// 4. 응답
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(  json );
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

		response.setContentType("applicaton/json;charset=UTF-8");
		response.getWriter().print(result);
	}

	/**
	 * 글수정
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String saveDirectory = request.getSession().getServletContext().getRealPath("/board/files");
		//첨부파일 업로드
		MultipartRequest multi = new MultipartRequest(
				request,
				saveDirectory,
				1024*1024*10,
				"UTF-8",
				new DefaultFileRenamePolicy());

		//저장용
		int bcno = Integer.parseInt(multi.getParameter("bcno"));
		int bno = Integer.parseInt(multi.getParameter("bno"));
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");

		System.out.println(" bcno ::: "+ bcno);
		System.out.println(" bno ::: "+ bno);
		System.out.println(" btitle ::: "+ btitle);
		System.out.println(" bcontent ::: "+ bcontent);
		System.out.println(" btitle ::: "+ btitle);

		BoardDto boardDto = new BoardDto(bcno, bno, btitle, bcontent, bfile);
		boolean result = BoardDao.getInstance().boardUpdate(boardDto);

		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);

	}

	/**
	 * 글삭제
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		System.out.println("bno :: " + bno);

		boolean result = BoardDao.getInstance().boardDelete(bno);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

}
