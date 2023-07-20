package 과제.과제6;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class 과제6_1_주차요금정산프로그램 { // class s

	public static void main(String[] args) {// main s

		Scanner scanner = new Scanner( System.in );

		String[] carNum = new String[20]; 		// 주차중인 차량번호 넣을 배열
		String[] inTime = new String[20]; 		// 주차중인 차의 입차시간 담을 배열
		String[] outTime = new String[20];

		String[] endParking= new String[20]; 	//출차된 차들 목록
		int price = 10; 						// 1분 단위에 10원
		int totalPaid = 0; 						//매출액


		String date; 							// 현재시간을 담을 변수 / 입차시간과 출차시간

		String reqDateStr; 						// 결제때 사용할 목적,  출차 차량의 입차시간을 담을 변수
		long minute = 0 ;						// 총 이용주차시간 (입차시간 - 출차시간)

		//현재시간 Date




		//--------------------------------------------------------------------------------------
		while ( true ) { // while s

			//반복문이 실행될때마 현재시간 생성해서 Date
			Date curDate = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMddHHmm");
			date = dateFormat.format(curDate);


			System.out.println("현재시간 : "+dateFormat.format(curDate) );
			 System.out.println("-------------- <주차요금 관리 프로그램> ------------- ");
			 System.out.println("------------------------------------------------");
			 System.out.println(" 1. 입차 | 2. 출차(요금지불) | 3. 입출차현황 | 4. 매출 ");
			 System.out.println("------------------------------------------------");
			 System.out.print(" 선택 > "); int ch = scanner.nextInt();


			 if( ch == 1 ) { // 입차  ------------------------------------------------
				 System.out.print(" 차량번호 > ");
				 String car = scanner.next();
				 for ( int i = 0 ; i < carNum.length ; i++ ) {
					 if ( carNum[i] == null ) { // i 번째 인덱스에 널값이면
						 carNum[i] = car;		//차량넘버
						 inTime[i] = date;		//현재시간을 입력하고
						 break;					//반복문을 빠져나온다.

					 }
					 //System.out.println(carNum[i]);
				 }System.out.println(Arrays.toString( carNum ));
				 //입력받은 차량번호를 carNum 저장하기 인덱스는 차례대로
				 //차량번호 저장되는 시간을 함수로 끌어와서 inTime에 저장

			 } else if ( ch == 2 ) { // 출차 ------------------------------------------------
				 System.out.print(" 차량번호 > ");
				 String car = scanner.next();
				 int usedTime = 0;
				 int ingCar = 0; // 현재 프로그램 조작중인 차량의 인덱스 번호 저장해두기



				 for ( int i = 0; i < carNum.length ; i++ ) {
					 if(carNum[i] == null) i++;
					 if ( carNum[i].equals(car)) { // 입력된 차량번호와 carNum의 일치하는 배열을 찾아

						// 입차 출차 시간 계산기
						    reqDateStr= inTime[i]; // 출차요청한 차량의 입차시간을 reqDataStr변수에 저장
							Date reqDate;
							try {

								reqDate = dateFormat.parse(reqDateStr);
								long reqDateTime = reqDate.getTime();

								//현재시간을 요청시간의 형태로 format 후 time 가져오기

								curDate = dateFormat.parse(dateFormat.format(curDate));
								long curDateTime = curDate.getTime();
								//분으로 표현


								minute = (curDateTime - reqDateTime) / 60000;

								System.out.println("요청시간 : " + reqDate);
								System.out.println("현재시간 : " + curDate);
								System.out.println(minute+"분 차이");

							} catch (ParseException e) {
								e.printStackTrace();
							}

							System.out.println("minute" +minute);

						//usedTime += (Integer.parseInt(outTime[i]) - Integer.parseInt(inTime[i]));
						usedTime =(int)minute;
						totalPaid += (usedTime*price);
						System.out.println("결제할 금액   : " +usedTime*price);

						ingCar = i;
						break;
					 }


				 }
				 System.out.print(" 1. 결제 | 2. 취소 "); int payCh = scanner.nextInt();
				 if( payCh == 1 ) {

					 System.out.print(" 주차요금은 "+usedTime*price+"원 입니다.");
					 System.out.print(" 결제하실금액을 입력해주세요. > "); int payInput = scanner.nextInt();

					 String endCar;
					 if( payInput == usedTime*price ) {
						 System.out.print(" 결제가 완료되었습니다. \n 안녕히 가십시오.\n");
						 outTime[ingCar] = date;
						 endCar =carNum[ingCar]+","+inTime[ingCar]+","+ outTime[ingCar]+"\n";

						 for ( int i = 0; i<endParking.length; i++ ) {
							 if ( endParking[i] == null ) {
								 endParking[i] = endCar;
								 System.out.println(Arrays.toString( endParking ));
								 break;
							 }
						 }
						// 출차된 차량의 데이터를 배열에서 삭제하기
						 carNum[ingCar] = null;
						 inTime[ingCar] = null;
						 outTime[ingCar] = null;

					 } else if ( payInput > usedTime*price ){
						 System.out.print(" 결제가 완료되었습니다. \n거스름돈은 "+ (payInput-(usedTime*price)) +"원 입니다.\n안녕히 가십시오.\n");
						 outTime[ingCar] = date;
						 endCar =carNum[ingCar]+"/"+inTime[ingCar]+"/"+ outTime[ingCar];

						 for ( int i = 0; i<endParking.length; i++ ) {
							 if ( endParking[i] == null ) {
							 endParking[i] = endCar;
							 break;
						}
						// 출차된 차량의 데이터를 배열에서 삭제하기
						 carNum[ingCar] = null;
						 inTime[ingCar] = null;
						 outTime[ingCar] = null;

					 }System.out.println(Arrays.toString( endParking ));

					 } else if ( payInput < usedTime*price ) {
						 System.out.print(" 금액 부족으로 결제가 취소되었습니다. ");
					 }
				 } if( payCh == 2 ) {
					 System.out.print(" 결제가 취소되었습니다.\n ");
				 }



				 //입력받은 차량번호를 carNum 넘버에서 찾아서 인덱스번호 알아내고
				 // 그 인덱스 번호로 inTime을 호출 하고 현재 시간을 outTime에 저장하기
				 // 그리고 outTime - inTime 해서 10분단위로 200원 부과해서 결제할 금액 출력하고
				 // 1.결제 2.취소
				 // 결제금액 입력하고 결제금액보다 미만이면 추가 입력 받고
				 // 많이 입력하면 거스름돈
				 // 결제 금액이 매출액에 합산
				 // 출차된 내역을 endParking 배열에 저장하기
				 // 그리고 해당 인덱스에 잇는 데이터 삭제 하기
				 // 출차된 차량이 있으면 삭제되어서 빈 공간이된 자리에 뒷 인덱스 값 당겨오기
			 } else if ( ch == 3 ) { // 현황 ------------------------------------------------
				 System.out.println(" 차량번호 |   입차시간   |   출차시간   |   상태 ");
				 System.out.println("-----------------------------------------------");
				 for ( int i = 0; i<carNum.length; i++ ) {
					 if( carNum[i] !=  null ){
						 System.out.println( "  " + carNum[i] + "  |" + inTime[i] +"|" + "     ------     " + "|  주차중" );
					 }
				 }

				 if(endParking != null) {
					 for( int i = 0; i < endParking.length; i++) {
						String eCarNum ="";
						String eInTime ="";
						String eOutTime="";
						if(endParking[i] == null) {
							i++;
							if(i == endParking.length-1) {	break; }
						} else {
//								String a = endParking[i].split("\n")[i];
								eCarNum = endParking[i].split("/")[0];
								eInTime = endParking[i].split("/")[1];
								eOutTime =endParking[i].split("/")[2];
						}
						System.out.println( "  " + eCarNum + "  |" + eInTime +"|" + eOutTime + "|  출차완료" );


					 }


				}


				 //System.out.println( " " + carNum[i] + " |" + inTime[i] +"|" + "-------" + "|  정산완료 " );
				 // 현재 배열에 있는 차량번호를 찾아서 배열내에 값이 있는 인덱스를
				 // 현재 주차중인 차, 이미 출차된 차 따로 출력
			  }else if ( ch == 4 ) { // 매출 ------------------------------------------------
				  System.out.println(" 총매출 > " + totalPaid);
			 } else { System.out.print("없는 메뉴입니다."); }




		} //while e
	}// main e
} // class e




// 해결해야할 오류
// 1. 사용시간 계산이 아직 안됨
// 2.
