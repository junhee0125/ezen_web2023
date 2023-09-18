package controller.Product;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.ProductDao;
import model.dto.MemberDto;
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
		String json =null;
		String type = request.getParameter("type");
		ObjectMapper mapper = new ObjectMapper();
		
		if(type.equals("M")){
			
			int cnt = Integer.parseInt(request.getParameter("nItemCount"));
			System.out.println("cnt :: "+ cnt);
			List<ProductDto> result = ProductDao.getInstance().getNewItem(cnt);
			json = mapper.writeValueAsString(result);
			
		} else if(type.equals("K")) {
			String eL = request.getParameter("e");
			String wL = request.getParameter("w");
			String sL = request.getParameter("s");
			String nL = request.getParameter("n");
			
			System.out.println("eL  : "+eL);
			List<ProductDto> result = ProductDao.getInstance().getItemLocation(eL,wL,sL,nL);
			json = mapper.writeValueAsString(result);
			
		} else if(type.equals("D")) {
			int pno = Integer.parseInt(request.getParameter("pno"));
			ProductDto productDto = ProductDao.getInstance().getItemDetail(pno);
			json = mapper.writeValueAsString(productDto);
			
		} else if(type.equals("A")) {
			
			List<ProductDto>  result = ProductDao.getInstance().getItemList();
			json = mapper.writeValueAsString(result);

			
		}
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(  json );

		
	}

	/**
	 * 2. 제품등록
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//commons.jar 이용한 업로드구현
		//commons-io.jar // commons-fileupload.jar 
		
		//1 . 저장경로 [첨부파일이 저장될 폴더 위치]
		String uploadPath = request.getServletContext().getRealPath("/product/img");
		
		// 2. 파일아이템저장소 객체 : 업로드할 옵션  [ import org.apache.commons.fileupload.FileItem; ]
		// 파일 아이템저장소 객체에 업로드 옵션을 set함
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
						System.out.println( item.getString() ); // .getString() : 해당 요청 input의 value 호출 
						
					}else {
				//2/. 파일필드인지 
						// 만약에 파일 필드이면 업로드 진행
						System.out.println( "업로드할 파일명 : " + item.getName() ); // .getName()
					// 6.업로드 경로 + 파일명 [ 조합 ] 
					
						// 파일명에 중복이 있을때 식별 생성 
						UUID uuid = UUID.randomUUID();
							// UUID 클래스 : 고유성을 보장하는 ID를 만들기 위한 식별자 표준 규약  [ - 하이픈 4개 구역 ]
						String filename = uuid+"-"+ item.getName().replaceAll("-", "_");
												// 만약에 파일명에 - 하이픈 존재하면 _언더바로 변경 
												// 왜?? 파일명과 UUID 간의 식별하기 위해 구분 -하이픈 사용하기 때문에.
												// 추후에 파일명만 추출시 사용자가 파일명에 - 이 있으면 파일명 추출시 쪼개기가 힘듬.
						// UUID[ - - -  ] - 파일명 : 추후에 파일명만 추출시 -하이픈 기준으로 쪼개기 
						
					File fileUploadPath = new File( uploadPath +"/"+ filename ) ;
							System.out.println("fileUploadPath  :: "+fileUploadPath);
						//.write("저장할 경로 파일명포함") vkdlfdjqfhemgkf rudfhfmf file타입으로 제공
						item.write( fileUploadPath); // 업로드할 경로 file타입으로
						
						i++;
						imgList.put(i,filename);
						
					}
					
					
				}
			//회원번호
			Object object = request.getSession().getAttribute("loginDto");
			MemberDto memberDto = (MemberDto)object;
			int mno = memberDto.getMno();
			//	public ProductDto(int cno, String pname, String pcoment, int pprice, String plat, String plng, int mno,Map<Integer, String> imgList) {

			ProductDto productDto = new ProductDto(
					Integer.parseInt( fileList.get(0).getString() ), // fileList.get(0) : name = pcno 호출 
					fileList.get(1).getString(),  // fileList.get(1) : name = pname 값 호출
					fileList.get(2).getString(), // fileList.get(2) : pcontent 값 호출 
					Integer.parseInt( fileList.get(3).getString() ), // fileList.get(3) : pprice 값 호출 
					fileList.get(4).getString(),  // formData.set( 'plat' , plat );
					fileList.get(5).getString(),  //formData.set( 'plng' , plng );
					mno , // 현재 로그인된[제품등록한] 회원의 번호 호출 
					imgList ); // 여러개 이미지는 위에서 리스트로 구성후 대입 	// 업로드한 파일명의 개수만큼 MAP 리스트
					
					
					
			
		
			
			
			System.out.println(productDto);
			boolean result = ProductDao.getInstance().register(productDto);
			
			//
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().print(result);
			
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
