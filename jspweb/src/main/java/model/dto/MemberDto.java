package model.dto;

public class MemberDto {

	//필드
	private int mno ;
	private String mid;
	private String mpwd;
	private String memail;
	private String mfile;
	//DB없는 필드
	private String loginDateTime;

	//생성자
	// 로그인 객체를 만들 생성자 [패스워드 제외]
	public MemberDto(String loginDateTime, int mno, String mid, String memail, String mfile) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.memail = memail;
		this.mfile = mfile;
		this.loginDateTime = loginDateTime;
	}


	public MemberDto() {
		// TODO Auto-generated constructor stub
	}

	public MemberDto(int mno, String mid, String mpwd, String memail, String mfile) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpwd = mpwd;
		this.memail = memail;
		this.mfile = mfile;
	}

	public MemberDto(String mid, String mpwd, String memail, String mfile) {
		super();
		this.mid = mid;
		this.mpwd = mpwd;
		this.memail = memail;
		this.mfile = mfile;
	}

	//메소드
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

	public String getMpwd() {
		return mpwd;
	}

	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getMfile() {
		return mfile;
	}

	public void setMfile(String mfile) {
		this.mfile = mfile;
	}


	//로그인정보
	public String getLoginDateTime() {
		return loginDateTime;
	}

	public void setLoginDateTime(String loginDateTime) {
		this.loginDateTime = loginDateTime;
	}


	@Override
	public String toString() {
		return "MemberDto [mno=" + mno + ", mid=" + mid + ", mpwd=" + mpwd + ", memail=" + memail + ", mfile=" + mfile
				+ ", loginDateTime=" + loginDateTime + "]";
	}








}
