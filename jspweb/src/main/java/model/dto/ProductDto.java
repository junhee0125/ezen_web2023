package model.dto;

import java.util.HashMap;
import java.util.Map;

public class ProductDto {

	private int	pcno;
	private String pcname;
	private int pno;				// 제품번호
	private String pname; 			// 제품명
	private String pcomment ;		// 제품설명
    private int pprice;				// 제품가격 signed(기본값, 음수사용,int의 경우 ) / unsigned(음수사용안함, int의 경우 41억까지 표현가능) : 음수사용여부
    private int pstatus;    		// 제품상태 0:판매중/ 1:거래중/ 2:판매대기 / 3 판매완료 
    private String pdate;  			// 등록일
    private String plat; 			// 위치[위도]
    private String plng;  			// 위치[경도]
    private int mno ;				// 회원번호
    private Map<Integer,String>  imgList = new HashMap<>();	// 이미지이름.경로
    private String mid;
    
    
	public ProductDto() {
		// TODO Auto-generated constructor stub
	}


	public ProductDto(int pcno, String pcname, int pno, String pname, String pcomment, int pprice, int pstatus,
			String pdate, String plat, String plng, int mno, Map<Integer, String> imgList, String mid) {
		super();
		this.pcno = pcno;
		this.pcname = pcname;
		this.pno = pno;
		this.pname = pname;
		this.pcomment = pcomment;
		this.pprice = pprice;
		this.pstatus = pstatus;
		this.pdate = pdate;
		this.plat = plat;
		this.plng = plng;
		this.mno = mno;
		this.imgList = imgList;
		this.mid = mid;
	}
	
	


	public ProductDto(int pcno, String pname, String pcomment, int pprice, String plat, String plng, int mno,
			Map<Integer, String> imgList) {
		super();
		this.pcno = pcno;
		this.pname = pname;
		this.pcomment = pcomment;
		this.pprice = pprice;
		this.plat = plat;
		this.plng = plng;
		this.mno = mno;
		this.imgList = imgList;
	}


	


	public int getPcno() {
		return pcno;
	}


	public void setPcno(int pcno) {
		this.pcno = pcno;
	}


	public String getPcname() {
		return pcname;
	}


	public void setPcname(String pcname) {
		this.pcname = pcname;
	}


	public int getPno() {
		return pno;
	}


	public void setPno(int pno) {
		this.pno = pno;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	


	public String getPcomment() {
		return pcomment;
	}


	public void setPcomment(String pcomment) {
		this.pcomment = pcomment;
	}


	public int getPprice() {
		return pprice;
	}


	public void setPprice(int pprice) {
		this.pprice = pprice;
	}


	public int getPstatus() {
		return pstatus;
	}


	public void setPstatus(int pstatus) {
		this.pstatus = pstatus;
	}


	public String getPdate() {
		return pdate;
	}


	public void setPdate(String pdate) {
		this.pdate = pdate;
	}


	public String getPlat() {
		return plat;
	}


	public void setPlat(String plat) {
		this.plat = plat;
	}


	public String getPlng() {
		return plng;
	}


	public void setPlng(String plng) {
		this.plng = plng;
	}


	public int getMno() {
		return mno;
	}


	public void setMno(int mno) {
		this.mno = mno;
	}


	public Map<Integer, String> getImgList() {
		return imgList;
	}


	public void setImgList(Map<Integer, String> imgList) {
		this.imgList = imgList;
	}


	public String getMid() {
		return mid;
	}


	public void setMid(String mid) {
		this.mid = mid;
	}


	@Override
	public String toString() {
		return "ProductDto [pcno=" + pcno + ", pcname=" + pcname + ", pno=" + pno + ", pname=" + pname + ", pcomment="
				+ pcomment + ", pprice=" + pprice + ", pstatus=" + pstatus + ", pdate=" + pdate + ", plat=" + plat
				+ ", plng=" + plng + ", mno=" + mno + ", imgList=" + imgList + ", mid=" + mid + "]";
	}
	
}
