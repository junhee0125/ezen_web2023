package model.dto;

public class MsgDto {

		private String fromMid; //보낸사람
		private String msg ; //보낸내용
		
		
		public MsgDto() {
			// TODO Auto-generated constructor stub
		}


		public MsgDto(String fromMid, String msg) {
			super();
			this.fromMid = fromMid;
			this.msg = msg;
		}


		public String getFromMid() {
			return fromMid;
		}


		public void setFromMid(String fromMid) {
			this.fromMid = fromMid;
		}


		public String getMsg() {
			return msg;
		}


		public void setMsg(String msg) {
			this.msg = msg;
		}


		@Override
		public String toString() {
			return "MsgDto [fromMid=" + fromMid + ", msg=" + msg + "]";
		}


		

}
