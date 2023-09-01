package model.dto;

public class HrmDto {

	//1. 필드
	int hno;
    String hname;
    String hphone;
    String hrank;
    String hphoto;
    String hdate;

    //2. 생성자
	public HrmDto() {
		// TODO Auto-generated constructor stub
	}


		//- 풀생성자
	public HrmDto(int hno, String hname, String hrank, String hphone, String hphoto, String hdate) {
		super();
		this.hno = hno;
		this.hname = hname;
		this.hphone = hphone;
		this.hrank = hrank;
		this.hphoto = hphoto;
		this.hdate = hdate;
	}

		//- 등록
	public HrmDto(String hname,  String hrank, String hphone, String hphoto) {
		super();
		this.hname = hname;
		this.hphone = hphone;
		this.hrank = hrank;
		this.hphoto = hphoto;
	}

	//3. 메소드
	public int getHno() {
		return hno;
	}

	public void setHno(int hno) {
		this.hno = hno;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public String getHphone() {
		return hphone;
	}

	public void setHphone(String hphone) {
		this.hphone = hphone;
	}

	public String getHrank() {
		return hrank;
	}

	public void setHrank(String hrank) {
		this.hrank = hrank;
	}

	public String getHphoto() {
		return hphoto;
	}

	public void setHphoto(String hphoto) {
		this.hphoto = hphoto;
	}

	public String getHdate() {
		return hdate;
	}

	public void setHdate(String hdate) {
		this.hdate = hdate;
	}

	//toString
	@Override
	public String toString() {
		return "HrmDto [hno=" + hno + ", hname=" + hname + ", hphone=" + hphone + ", hrank=" + hrank + ", hphoto="
				+ hphoto + ", hdate=" + hdate + "]";
	}

}
