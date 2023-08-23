package 과제.accountbook;

public class AccountbookDto {
	
	//필드
	private int ano;
	private String atext;
	private int anumber;
	private String adate;
	 
	//생성자
	public AccountbookDto() {
		// TODO Auto-generated constructor stub
	}
		//풀생성자
	public AccountbookDto(int ano, String atext, int anumber, String adate) {
		super();
		this.ano = ano;
		this.atext = atext;
		this.anumber = anumber;
		this.adate = adate;
	}
	
		//등록용도
	public AccountbookDto(String atext, int anumber) {
		super();
		this.atext = atext;
		this.anumber = anumber;
	}
	
	
	//메소드
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getAtext() {
		return atext;
	}
	public void setAtext(String atext) {
		this.atext = atext;
	}
	public int getAnumber() {
		return anumber;
	}
	public void setAnumber(int anumber) {
		this.anumber = anumber;
	}
	public String getAdate() {
		return adate;
	}
	public void setAdate(String adate) {
		this.adate = adate;
	}
	@Override
	public String toString() {
		return "AccountbookDto [ano=" + ano + ", atext=" + atext + ", anumber=" + anumber + ", adate=" + adate + "]";
	}
	
	
	
	
	
	
	
	
	 
	 

}
