package model.dao;


import java.sql.Statement;

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
	
	



}
