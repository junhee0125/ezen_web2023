package model.dao;


import java.sql.Statement;
import java.util.ArrayList;

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
	
	// 제품 전체 출력
	
	// 제품 1개 출력
	
	// 제품수정
	
	// 제품삭제
	
	public ArrayList<ProductDto> getNewItem(int cnt ) {
		return null;
	}
	
	public ArrayList<ProductDto> getItemLocation(String e, String w, String s,String n ) {
		return null;
	}
	
	public ProductDto getItemDetail(int pno ) {
		return null;
	}
	public ArrayList<ProductDto> getItemList() {
		return null;
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
 