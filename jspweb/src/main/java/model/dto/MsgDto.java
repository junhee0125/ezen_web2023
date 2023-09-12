package model.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import model.dao.MemberDao;

public class MsgDto { // 주고받을 메시지를 설계한 정보들

		private String fromMid; //보낸사람
		private String msg; //보낸내용
		private String fromimg; // 보낸사람의 프로필
		private String date;	//보낸일시
		
		
		public MsgDto() {
			// TODO Auto-generated constructor stub
		}

		
		public MsgDto(String fromMid, String msg) {
			super();
			this.fromMid = fromMid;
			this.msg = msg;
			//객체생성시 추가코드
				//1.보낸사람의 프로필 가져오기
			fromimg = MemberDao.getInstance().info(fromMid).getMfile();
				//2. 보낸일시 구하기
					//1.new Date() : 현재시간과 날짜 제공하는 클래스
			Date date = new Date();//
			System.out.println("현재시간  : "+date); //현재시간
					//2 . 날짜의 포멧(형식)
				SimpleDateFormat sdate = new SimpleDateFormat("aa hh:mm");
				//y연도 m 월 d일 h시 m분 s초 aa오전오후
				this.date = sdate.format(date); //현재시간을 정의한 형식으로 변환
		}


		public MsgDto(String fromMid, String msg, String fromimg, String date) {
			super();
			this.fromMid = fromMid;
			this.msg = msg;
			this.fromimg = fromimg;
			this.date = date;
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


		public String getFromimg() {
			return fromimg;
		}


		public void setFromimg(String fromimg) {
			this.fromimg = fromimg;
		}


		public String getDate() {
			return date;
		}


		public void setDate(String date) {
			this.date = date;
		}


		@Override
		public String toString() {
			return "MsgDto [fromMid=" + fromMid + ", msg=" + msg + ", fromimg=" + fromimg + ", date=" + date + "]";
		}

		
		

		

}
