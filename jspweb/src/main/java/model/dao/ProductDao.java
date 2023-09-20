package model.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.dto.ProductDto;

public class ProductDao extends Dao{
	//싱글톤
	private static ProductDao productDao = new ProductDao();
	public static ProductDao getInstance() {return productDao;}
	private ProductDao() { }



	// 제품 등록
	public boolean register(ProductDto dto  ) {
 
		try {
			String sql = "insert into product (pcno, pname, pcomment ,pprice ,plat ,plng, mno) values (?,?,?,?,?,?,?);";
			ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, dto.getPcno());
			ps.setString(2, dto.getPname());
			ps.setString(3, dto.getPcomment());
			ps.setInt(4, dto.getPprice());
			ps.setString(5, dto.getPlat());
			ps.setString(6, dto.getPlng());
			ps.setInt(7, dto.getMno());
			int count = ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			System.out.println("insert produc"+ ps);
			rs.next();
			
			if(count ==1) { //만약에 제품등록 1개 등록했으면
				//1-2 제품 등록후 생성된 상품pk를 가지고 이미지 등록
					//dto 에 저장된 이미지 개수만큼
					// Map<Integer, String> : ㅡmap 객체명.keySet();
				
				 for(String img:dto.getImgList().values()) { // : 이렇게 하면 value
				//for(int key:dto.getImgList().keySet()) {
					sql = "insert into productimg (pimg, pno) values(?,?)";
					
					ps = conn.prepareStatement(sql);
					ps.setString(1, img);
					ps.setInt(2, rs.getInt(1));
					ps.executeUpdate();
					System.out.println("insert productimg"+ ps);
				}
				 return true;	
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	
	
	// 제품 1개 출력
	
	// 제품수정
	
	// 제품삭제
	
	
	
	//0 제품의 해당하는 이미지 출력하는 함수
	public Map<Integer, String> getProductImg(int pno){
		
		try {
			Map<Integer, String> imgList = new HashMap<>(); //제품의 다수 이미지정보
			String sql = " select * from productimg where pno ="+pno;
			PreparedStatement ps = conn.prepareStatement(sql);
			//System.out.println("getProductImg(int pno) :: SQL"+ ps);
			ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					imgList.put(rs.getInt("pino"), rs.getString("pimg"));
				}	
			return imgList;
			
		} catch (Exception ex) {
			System.out.println("getProductImg::Exception :: "+ ex );
		}
		return null;
	}
	
	
	//3. 
	public ProductDto getItemDetail(int pno ) {
		
		try {
			String sql = " select * from product p natural join pcategory pc natural join member m where p.pno = "+pno;  
			
			PreparedStatement ps = conn.prepareStatement(sql);
			//System.out.println(" getItemDetail(int pno ) :: SQL"+ ps);
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				ProductDto productDto = new ProductDto(
						  rs.getInt("pcno")
						, rs.getString("pcname") 
						, rs.getInt("pno")  
						, rs.getString("pname") 
						, rs.getString("pcomment") 
						, rs.getInt("pprice") 
						, rs.getInt("pstatus")
						, rs.getString("pdate")
						, rs.getString("plat") 
						, rs.getString("plng") 
						, rs.getInt("mno") 
						, getProductImg( rs.getInt("pno"))
						, rs.getString("mid") );
						System.out.println(productDto.toString());
			return productDto;
			}
		} catch (Exception e) {
			System.out.println("getItemDetail ::Exception :: "+ e );
		}
		
		return null;
		
	}
	// cnt만큼 제품 가져오기
	public List<ProductDto> getNewItem(int cnt ) {
		List<ProductDto> list = new ArrayList<>();
		try {
			String sql = " select pno from product order by pdate desc limit "+cnt;
			ps = conn.prepareStatement(sql);
			rs= ps.executeQuery();
			while(rs.next()) { list.add(getItemDetail(rs.getInt("pno"))); } return list;
		} catch (Exception e) {
			System.out.println(" getNewItem :: Exception :: "+ e );
		}
		
		
		return null;
	}
	
	public List<ProductDto> getItemLocation(String e, String w, String s,String n ) {
			List<ProductDto> list = new ArrayList<>();
		try {
			//제품의 좌표가 동쪽 경도보다 크고 서쪽 경도보다 작고 남위도보다 크고 북 위도보다 작은.
			String sql = "select * from product "
					+ "	where	plat <= ?  "
					+ "	  and	plat >= ?  "
					+ "	  and	plng >= ?  "
					+ "	  and	plng <= ? "
					+ " order by pdate desc ";
			ps = conn.prepareStatement(sql);
			ps.setString(4, e);
			ps.setString(3, w);
			ps.setString(2, s);
			ps.setString(1, n);
			
			
			rs = ps.executeQuery();
			System.out.println("DAO ::getItemLocation  ::" + ps);
			while(rs.next()) {
				
				list.add(getItemDetail(rs.getInt("pno")));			
						
			}
			
			return list;
		} catch (Exception ex) {
			System.out.println("getItemLocation Exception :: "+ ex );
		}
		return null;
	}
	
	//모든 제품 가져오기
	public List<ProductDto> getItemList() {
		try {
			List<ProductDto> list = new ArrayList<>();
			String sql = " select * from product ";  
			ps= conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) { 
				
				list.add( getItemDetail(rs.getInt("pno")));
			}
			return list;
		} catch (Exception e) {
			System.out.println("Exception :: "+ e );
		}
		return null;
	}
	
	// 3. 제품 찜하기 등록(=찜하기상태가 아닐때=조건에따른 레코드없을때) / 취소(=찜하기상태 일때=조건에따른 레코드있을때)
		public boolean setWish( int mno , int pno) {
			try {
				String sql = getWish(mno, pno) ? 
							"delete from pwishlist where mno = ? and pno = ?" : 
							"insert into pwishlist values( ? , ? )";
				ps = conn.prepareStatement(sql);
				ps.setInt( 1 , mno); ps.setInt( 2, pno);
				int count = ps.executeUpdate();
				if( count == 1 ) { return true; }
			}catch (Exception e) { e.getStackTrace(); }
			return false;
		}
		// 4. 제품 찜하기 상태 출력
		public boolean getWish( int mno , int pno ) {
			try { String sql ="select * from pwishlist where mno = ? and pno = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt( 1 , mno ); ps.setInt( 2 , pno);
				rs = ps.executeQuery(); if( rs.next() ) { return true; }
			}catch (Exception e) { e.getStackTrace(); }
			return false;
		}
		
		// 5. 현재 로그인된 회원의 찜한 제품[여러개] 정보를 출력하는 함수 
		public List<ProductDto> getWishProductList( int mno ){
			List<ProductDto> list = new ArrayList<>();
			try { // 현재 회원이 찜한 제품번호 찾기 
				String sql = "select pno from pwishlist where mno = "+ mno; // 현재 회원의 찜하기 제품번호 목록 찾기 
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				System.out.println("getWishProductList  SQL:: " + ps);
				// 현재 회원이 찜한 제품번호의 레코드반환 // 찾은 제품번호 하나씩 findByPno() 함수에게 전달해서 제품정보를 list 담기
				while( rs.next() ) { list.add( getItemDetail( rs.getInt("pno") ) ); }
			}catch (Exception e) { e.getStackTrace();} return list;
		}

}










/* 어떤통신방식으로 / 
 	1. 메인페이지에 N개(정해진 갯수)만큼 출력 - 최신순으로 정렬하고 / ---- Main NewItem  		
 	2. 카카오지도에서 현재 보고있는 범위 만큼의 좌표(동서남북)의 범위 안에서 	Map
 	3. 선택된제품의 개별출력 - 개별 상품의 상세페이지
 	4. 관리자입장에서의 제품 모두 출력 [페이지 처리]
 
 	[제출] 백엔드입장 
 		. 프론트엔드와 통신방법 : 아작스 or 소켓
 		. 통신방법에 따른  servlet Ser
 		- 서블릿(두겟) onMessage
 		- 프론트엔드와 백엔드가 요청 응답할때 주고 받을 데이터 선택
 		- 서블릿,소켓은 Dao와 무엇을 주고 받을지 데이터
 		
 */		
 