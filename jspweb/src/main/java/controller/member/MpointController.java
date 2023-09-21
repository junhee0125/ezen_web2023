package controller.member;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.MemberDao;
import model.dto.MemberDto;
import model.dto.MpointDto;

/**
 * Servlet implementation class MpointController
 */
@WebServlet("/MpointController")
public class MpointController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MpointController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * 1. public long getPoint(int mno)	  # 누적된 포인트의 합계가져오기
	 * 2. public List<MpointDto> getPointList(int mno) # 포인트내역 전체 리스트 가져오기
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		int mno = ((MemberDto)request.getSession().getAttribute("loginDto")).getMno();
		String json = null;
		
		ObjectMapper mapper = new ObjectMapper();

		
		if( type.equals("getPoint")) {
			long result = MemberDao.getInstance().getPoint(mno);
			json = mapper.writeValueAsString(result);
			
			
		}else if(type.equals("getList")) {
			List<MpointDto> list =  MemberDao.getInstance().getPointList(mno);
			json = mapper.writeValueAsString(list);
			
		}
		
		
		response.setContentType("utf-8");
		response.getWriter().print(json);
	}

	
	/**
	 * public boolean setPoint(MpointDto mpDto) #포인트 지금 / 사용 내역 테이블에 저장 
	 * UUID => static 클래스
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mpno = UUID.randomUUID().toString();
		int mno = ((MemberDto)request.getSession().getAttribute("loginDto")).getMno();
		long mpamount = Long.parseLong(request.getParameter("mpamount"));
		String mpcommnet = request.getParameter("mpcommnet");
		MpointDto mpointDto = new MpointDto(mpno, mno, mpamount, mpcommnet);
		boolean result = MemberDao.getInstance().setPoint(mpointDto);
		
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(result);
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
