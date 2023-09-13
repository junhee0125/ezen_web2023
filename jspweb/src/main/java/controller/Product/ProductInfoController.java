package controller.Product;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import model.dto.ProductDto;

/**
 * Servlet implementation class ProductInfoController
 */
@WebServlet("/ProductInfoController")
public class ProductInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 1. 제품조회
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * 2. 제품등록
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//commons.jar 이용한 업로드구현
		//commons-io.jar // commons-fileupload.jar 
		
		//1 . 저장경로 [첨부파일이 저장될 폴더 위치]
		String uploadPath = request.getServletContext().getRealPath("/product/img");
		
		//2.업로드 객체 import org.apache.commons.fileupload.disk.DiskFileItemFactory;
		// 파일 아이템저장소 객체
		DiskFileItemFactory itemFactory = new DiskFileItemFactory();
		//파일타입으로
		itemFactory.setRepository(new File(uploadPath)); // 저장위치
		itemFactory.setSizeThreshold(1024*1024-1024); // 용량
		itemFactory.setDefaultCharset("utf-8"); // 한글인코딩
		
		
		// 3.
		ServletFileUpload fileUpload = new ServletFileUpload(itemFactory);
		
		//4. 
		try {
			Map <Integer, String> imgList = new HashMap<>(); //업로드된 파일명을 저장하기 위한 map컬렉션
			//form전송시 모든 데이터를 한번에 요청해서 List로 반환 (request.getParameter.. 할필요없음)
			//첨부파일 뿐만 아니라..모든 input태그들..
			List<FileItem> fileList = fileUpload.parseRequest(request);
			
			//5.업로드 실행
			int i = 0;
			for(FileItem item : fileList ) {
				item.write(new File(uploadPath + "/업로드파일명"));
				//System.out.println(item.getString());
				// 일반필드와 file필드 식벽해야
				//item.isFormField() true : 일반필드 / false 첨부파일필드
				// 1. 일반필드인지 
					if(item.isFormField()) {
						
					}else {
				//2/. 파일필드인지 
						//getName 파일명가져옴
						System.out.println("업로드할 파일명 :: "+item.getName());
						File fileUploadPath = new File(uploadPath + "/"+ item.getName());
						System.out.println("fileUploadPath  :: "+fileUploadPath);
						//.write("저장할 경로 파일명포함") vkdlfdjqfhemgkf rudfhfmf file타입으로 제공
						item.write( fileUploadPath); // 업로드할 경로 file타입으로
						
						i++;
						imgList.put(i, item.getName());
						
					}
				}
		
			ProductDto productDto = new ProductDto(
					Integer.parseInt(fileList.get(0).getString()),
					fileList.get(1).getString(),
					fileList.get(2).getString(),
					Integer.parseInt(fileList.get(3).getString()),
					null, null,0,
					imgList
					); 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		/*MultipartRequest multi = new MultipartRequest(
					request
				, 	request.getServletContext().getRealPath("/jspweb/product/img")
				,	1024*1024*10
				,	"utf-8"
				, new DefaultFileRenamePolicy()
				);
		*/
		
	}

	/**
	 * 3. 제품수정
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * 4. 제품삭제
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
/*
 	// 1. 제품 등록 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doPost 통신 ");
		//[ form 태그 없는경우 1 ]  
		// 1. ajax 전달한 data의 객체 속성명을 이용한 호출 
		/*
		String pname1 = request.getParameter("pname1");
		String pcontent1 = request.getParameter("pcontent1");
			System.out.println( pname1 ) ; System.out.println( pcontent1 ) ;
		*/
		//[ form 태그 이용하는 경우 2 - form 전송시 ]
/*		MultipartRequest multi = new MultipartRequest(request , request.getServletContext().getRealPath("/product") );
		
		String pname2 = multi.getParameter("pname2");
		String pcontent2 = multi.getParameter("pcontent2");
			System.out.println( pname2 ) ; System.out.println( pcontent2) ;
		
	}
  
  */
