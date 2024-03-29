package 과제.과제11.model.dto;

public class MemberDto {

	//필드
	private int mno;
	private String mid;
	private String mpw;
	private String mname;
	private String mphone;

	
	//생성자
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}

	public MemberDto(int mno, String mid, String mpw, String mname, String mphone) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.mphone = mphone;
	}

	//메소드
		//getter & setter
	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpw() {
		return mpw;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMphone() {
		return mphone;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}

	
		//toString
	
	@Override
	public String toString() {
		return "MemberDto [mno=" + mno + ", mid=" + mid + ", mpw=" + mpw + ", mname=" + mname + ", mphone=" + mphone
				+ "]";
	}

	
	
	
	
	

	
	
	
}
