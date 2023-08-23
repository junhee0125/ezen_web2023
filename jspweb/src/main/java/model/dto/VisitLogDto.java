package model.dto;

public class VisitLogDto {
	
	//1.필드
	private int vno ;
	private String vwriter;
	private String vpwd;
	private String vcontent;
	private String vdatetime;
	
	//2.생성자
	public VisitLogDto() {
		// TODO Auto-generated constructor stub
	}

	public VisitLogDto(int vno, String vwriter, String vpwd, String vcontent, String vdatetime) {
		super();
		this.vno = vno;
		this.vwriter = vwriter;
		this.vpwd = vpwd;
		this.vcontent = vcontent;
		this.vdatetime = vdatetime;
	}
	//글저장용
	public VisitLogDto(String vwriter, String vpwd, String vcontent) {
		super();
		this.vwriter = vwriter;
		this.vpwd = vpwd;
		this.vcontent = vcontent;
	}

		
		
	//3.메소드
		public int getVno() {
			return vno;
		}

		public void setVno(int vno) {
			this.vno = vno;
		}

		public String getVwriter() {
			return vwriter;
		}

		public void setVwriter(String vwriter) {
			this.vwriter = vwriter;
		}

		public String getVpwd() {
			return vpwd;
		}

		public void setVpwd(String vpwd) {
			this.vpwd = vpwd;
		}
	
		public String getVcontent() {
			return vcontent;
		}
	
		public void setVcontent(String vcontent) {
			this.vcontent = vcontent;
		}
	
		public String getVdatetime() {
			return vdatetime;
		}
	
		public void setVdatetime(String vdate) {
			this.vdatetime = vdate;
		}
	
		@Override
		public String toString() {
			return "VisitLogDto [vno=" + vno + ", vwriter=" + vwriter + ", vpwd=" + vpwd + ", vcontent=" + vcontent
					+ ", vdatetime=" + vdatetime + "]";
		}

}
