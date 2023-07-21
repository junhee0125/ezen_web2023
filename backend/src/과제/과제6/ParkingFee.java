/***
 * 주제 : 주차요금 정산기 [ 입차 , 출차(요금지출) , 입출차현황 , 매출(입차시간과 출차시간 기준으로 요금산정) ] 등등 
 *    - 날짜/시간 함수를 이용한 요금 계산 
 *    - 입차시 : 차량 번호만 입력받습니다.   - 출차시 : 차량 번호 입력받고 일차할 경우 금액을 입력받습니다.
 *    - 상단 기본 기능 모두 구현 후 기능 추가 
 *       - 주차 좌석배치
 *       - 매출 세분화 및 그래프화
 *       - 관리자 기능 
 * 
 * * 센서 및 터치 기능은 입력 기능으로 대체
 * * 주제에 맞춰서 C R U D [ 추가 호출 수정 삭제 ] 기능을 1개 이상씩 필수로 한다.
 * * 모든 정보를 영구저장 할 수 있도록 파일처리 합니다.
 ***/

package 과제.과제6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ParkingFee {
	public static void main(String[] args) throws IOException {
		
		
		
		while(true) {
			
			Scanner in = new Scanner(System.in); //입력객체
			
			//파일처리 객체
			String path = "./src/과제/과제6/입출차현황.txt";
			File file = new File(path);
			FileOutputStream fileOutputStream = new FileOutputStream(path, true);
			FileInputStream  fileInputStream = new FileInputStream(path);
		
			
			//while문이 실행될때마다. 파일의 정보 가져오기
			byte[] inByteArray = new byte[(int)file.length()];//  파일의 길이를 int로 형변환후 (배열의 크기)  byte배열 생성 
			fileInputStream.read(inByteArray);
			String fileInfo = new String(inByteArray);
			
			//가져온 정보를 차량 1대 기준으로 분리
			String[] carInfo = fileInfo.split("\n");
			//System.out.println(" 차량별 정보 ::" + carInfo);
			
			//현재기준 날짜와 시간정보 가져기
			Date curDate = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMddHHmm");
			String now = dateFormat.format(curDate);
			
			
			
			/*--- 프로그램 출력 시작---*/
			System.out.println("\n\n------------------------------------------------------------------------- ");
			System.out.println("0:입차등록 | 1:출차 및 결제 | 2: 입출차현황 | 3: 매출현황  | 4: 프로그램 종료");
			System.out.println("------------------------------------------------------------------------- ");

			System.out.print(">>>>>> 선택 : "); int ch = in.nextInt();
			
			
			if(ch == 0 ) {
				System.out.print(" 입차할 차량번호를 입력하세요  : "); String carNum = in.next(); int fee = 0;  
				
				
				for(int i = 0 ; i < carInfo.length ; i++) {
					
					if(carInfo[i].split(",")[0].equals(carNum)&&carInfo[i].split(",")[3].equals(0)) {
						
						System.out.println("이미 입차 중입니다.");
						
						break;
						
					} else {
						
						//입차 차량 데이터 구성 :  차량넘버 , 입차시간 , 출차시간, 정산금액 \n  (속성은 ',' 구분하고 데이터셋은 '\n'으로 구분
						String outStr = carNum +"," + now +"," + "YYYYMMddHHmm" +","+ fee+ "\n";
						
						//입력받은 차량번호를 포함한 데이터셋은 파일로 보내기
						fileOutputStream.write(outStr.getBytes());
						
						System.out.println("입차등록이 정상처리되었습니다.");
						break;
					}
				}
				
				
				
			} else if(ch == 1) { //출차 및 결제.
				System.out.print(" 출차할 차량번호를 입력하세요  : "); String carNum = in.next();				
				long parkingTime = 0; // 총 주차 시간 (뿐)				
				int fee = 0;
				int usedTime = 0; //주차시간 int형
				int carIndex = 0;
				String parkingEnd = now; //출차시간에 현재시간 대입
				String parkingStart ="";
				
				
				for ( int i = 0; i < carInfo.length ; i++ ) {
					 if(carInfo[i] == null) i++;
					// System.out.println( carNum + "차량을 출차 요청합니다.");
					 if ( carInfo[i].split(",")[0].equals(carNum)) { // 입력된 차량번호와 carNum의 일치하는 배열을 찾아
						 System.out.println( carNum + "차량을 출차 요청합니다.");
						 
						 parkingStart = carInfo[i].split(",")[1]; //입차시간 : 정산의 기준
						 carIndex = i;

						// 입차 출차 시간 계산기
						    
							Date reqDate;
							try {

								reqDate = dateFormat.parse(parkingStart);
								long reqDateTime = reqDate.getTime();

								//현재시간을 요청시간의 형태로 format 후 time 가져오기

								curDate = dateFormat.parse(dateFormat.format(curDate));
								long curDateTime = curDate.getTime();
								//분으로 표현


								parkingTime = (curDateTime - reqDateTime) / 60000;

								//System.out.println("요청시간 : " + reqDate);
								//System.out.println("현재시간 : " + curDate);
								//System.out.println(parkingTime+"분 ");

							} catch (ParseException e) {
								e.printStackTrace();
							}

							System.out.println("이용시간은  [" +parkingTime+"분] 입니다. ");

						//usedTime += (Integer.parseInt(outTime[i]) - Integer.parseInt(inTime[i]));
						usedTime  = (int)parkingTime;
						fee = (usedTime* 100); //1분에 100원
						System.out.println("결제할 금액   : " +usedTime*100 +"원 입니다.");
						break;
					 }
				}	
				System.out.println("1: 결제   2: 취소  "); int  payYN = in.nextInt();
				
				if(payYN == 1 ) {
					System.out.println("결제금액을 입력하세요."); int pay = in.nextInt();
					
					
					
					if( pay >= fee) {
						
						if (pay > fee ) { System.out.println("거스름돈 "+(pay-fee) +"원이 반환되었습니다." ); }
						else { 	System.out.println("정상 결제되었습니다. \n \n  이용해주셔서 감사합니다. "); }
						// 출차정보 세팅
						carInfo[carIndex] = carNum +"," + parkingStart +"," + parkingEnd +","+ fee;
						
						String outStr = "";
						for( int i = 0 ; i < carInfo.length ; i++) {
							outStr +=  carInfo[i].split(",")[0]+","+
									carInfo[i].split(",")[1]+","+
									carInfo[i].split(",")[2]+","+
									carInfo[i].split(",")[3]+"\n";
						} //for end
						FileOutputStream fileOutputStream2 = new FileOutputStream(path);
						fileOutputStream2.write(outStr.getBytes());
						
					
					} else {
						
						System.out.println(" 입금하신 금액이 부족하여 결제가 취소처리 되었습니다. \n 처음부터 다시 해주세요 ");
					}
					
				} else {
					
					System.out.println("출차 처리가 취소되었습니다. ");
					
				}
						
						
				
				
			} else if(ch == 2) { //입출차 현황리스트 출력
				
				System.out.println("\n\n-------------------------------------------------------------");
				System.out.println(" 차량번호 | 입차 시간정보 | 출차 시간정보 | 현재  상태 | 정산금액");
				System.out.println("---------------------------------------------------------------- ");
				
				if(carInfo.length > 0) {
				
					for(int i = 0 ; i < carInfo.length ; i++ ) {
						String carNum = carInfo[i].split(",")[0];
						String parkingStart = carInfo[i].split(",")[1];
						String parkingEnd = carInfo[i].split(",")[2];
						String paidFee = carInfo[i].split(",")[3];
						String parkingState = "  주차중  ";
						
						if(!parkingEnd.equals("YYYYMMddHHmm")) parkingState = " 출차완료 ";
						
						System.out.println("|  "+ carNum +"  | "+parkingStart+" | "+parkingEnd+" | "+ parkingState +" | "+paidFee+"원");
					}
				}  else {
					
				System.out.println(" --------------  현재  등록된 정보가 없습니다.  --------------");
					
				}
				
			} else if(ch == 3) { //매출현황출력
				int sum = 0;
				for(int i = 0 ; i < carInfo.length; i++) {
					sum += Integer.parseInt(carInfo[i].split(",")[3]);
					
					
				}	
				System.out.println( "총 매출은 " + sum +"원 입니다.");
					
				
			} else {
				System.out.println("프로그램을 종료합니다.");
				break;
			}	
		
		}
	}
}
