package 과제.과제6;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class 주차요금정산기 {
	public static void main(String[] args) {
		
		String reqDateStr = "202307201430"; //입차시간
		
		//현재시간 Date
		Date curDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMddHHmm");
		 
		System.out.println("현재시간 : "+dateFormat.format(curDate) );
		Date reqDate;
		try {
			reqDate = dateFormat.parse(reqDateStr);
			long reqDateTime = reqDate.getTime();
			
			//현재시간을 요청시간의 형태로 format 후 time 가져오기
			
			curDate = dateFormat.parse(dateFormat.format(curDate));
			long curDateTime = curDate.getTime();
			//분으로 표현
			long minute = (curDateTime - reqDateTime) / 60000;
			
			System.out.println("요청시간 : " + reqDate);
			System.out.println("현재시간 : " + curDate);
			System.out.println(minute+"분 차이"); 
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
}
