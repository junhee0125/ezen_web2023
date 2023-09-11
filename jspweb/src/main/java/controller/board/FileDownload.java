package controller.board;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownload
 */
@WebServlet("/FileDownload")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDownload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		//-----------------------1. 첨부파일 다운로드-------------------------/
			// 1. 다운로드 할 파일명 요청
		String filename = request.getParameter("filename");
		
		
			//2. 다룬로드 파일경로
		String uploadPath = request.getServletContext().getRealPath("/board/files");
		
			//3.  다룬로드할 파일의 전체경루
		String filepath = uploadPath  + "/" + filename;
		
		//-----------------------2.응답시 :파일 다운로드 옵션-------------------------/
		response.setHeader("Content-Disposition", 
				"attachment;filename = "+ URLEncoder.encode( filename, "UTF-8")); 
		//import java.net.URLEncoder; URLEncoder클래스
			//.encodee( filename, "UTF-8");  // URL(HTTP주소의 한글깨짐방지
			// 
	
	
		//------------------------3. 파일 내보내기------------------------/
		// 1.파일 객체 : 해당 경로의 파일을 객체화했을 때 다양한 메소드를 제공받을 수 있음.
		File file = new File(filepath);
		// 2. 파일 입력 스트림 객체 [파일 바이트로 읽어오기]
			// 1. 입력객체
			FileInputStream fin = new FileInputStream(file);
			// 2.읽어온 바이트를 저장할 바이트 배열 선언 (배열의 길이 = 파일의 용량만큼)  
			byte[] bytes = new byte[(int)file.length()];
			//3. 바이트를 읽어서 배열에 저장하기
			fin.read(bytes);
			
		// 3. 파일출력 스트림객체
			// 1. 파일 출력스트림객체 [ 출력할 위치가 response]
			//BufferedOutputStream oin = new BufferedOutputStream(response.getOutputStream());
			ServletOutputStream oin = response.getOutputStream();;
			oin.write(bytes);
			
		// 4. 대용량 전송시 안전하게 스트림(바이트 전송통로) 닫기
			fin.close();
			oin.flush();
			oin.close();
			
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
