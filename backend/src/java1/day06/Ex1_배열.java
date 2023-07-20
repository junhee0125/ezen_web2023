package java1.day06;

import java.util.Arrays;

public class Ex1_배열 { //class s
	public static void main(String[] args) { //main s
	
		//p. 168
		// 1. 선언
		String[] season = {"spring","summer","fall","winter"}; 
		//String 타입으로 배열 선언했다면. String 데이터만 가능
		//{ 값, 값2, 값3,} 배열에 저장할 데이터 순서대로 작성
		
		//2. 호출
		System.out.println(season); //주소값을 가지고 있음 [Ljava.lang.String;@3d012ddd
		System.out.println(Arrays.toString(season));  //Arrays.toString(배열변수명) : 주소를 찾아서 배열의 정보를 호출 [spring, summer, fall, winter]
		
		System.out.println(season[0]); //spring
		System.out.println(season[1]); //summer
		System.out.println(season[2]); //fall
		System.out.println(season[3]); //winter
		
		//3.변경 (새로운 값을 대입)
		season[1] = "여름";
		System.out.println(season[1]); //여름
		System.out.println(Arrays.toString(season)); //[spring, 여름, fall, winter]
		
		//4. delete : 삭제는 안됨.
		season[1] = null;
		System.out.println(Arrays.toString(season)); //[spring, null, fall, winter]
		
		//5. 추가 없음. 안됨. //index중에 null이 있으면 해당 위치에 데이터 추가
		season[1] = "여름";
		System.out.println(Arrays.toString(season)); //[spring, null, fall, winter]
		
		if( season[1] == null) { season[1] = "초여름";}
		else { System.out.println("공간이 부족합니다.");
		
		}
		
		//
		int[] scores = {83,90, 87 };
		int sum  = 0 ;
		for(int i = 0; i <scores.length; i++) {
			sum += scores[i];
		}
		System.out.println("합계 점수"+sum);
		System.out.println("평균" +sum/3.0);
		
		
		//173
		//1 new 연산자를 이용한 배열선언
		int[] arr1 = new int[3];
		System.out.println(Arrays.toString(arr1)); //결과 :  [0, 0, 0]
		
		
		//2. 배열내 모든 데이터 호출
		for(int i=0; i<3 ;i++) {
			System.out.print("arr1["+i+"] :" + arr1[i] +", "  ); //result: arr1[0] :0, arr1[1] :0, arr1[2] :0, 
		}
		
		//3. 배열내 값 변경
		arr1[0] = 10; arr1[1] = 20; arr1[2] = 30;
		System.out.println("\n"+Arrays.toString(arr1)); //결과 : [10, 20, 30]

		
		double[] arr2 = new double[3];
		System.out.println(Arrays.toString(arr2)); //결과 :  [0.0, 0.0, 0.0]
		
		//배열의 길이를 구할때 배열명.length  ** 문자열.length()
		for (int i = 0; i< arr2.length; i++ ) { System.out.println(arr2[i]); } //result ;0.0 0.0 0.0
		
		//3. 배열의 값 변경
		arr2[0] = 10.0; arr2[1] = 2.00; arr2[2] = 30.0;
		
//		arr2[3] = 0.4; Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
//		at java1.day06.Ex1_배열.main(Ex1_배열.java:76)   : Bounds저장   저장할수 배열 인덱스를 

		 String[] arr3 = new String[3];
		 for(int i = 0 ; i < arr3.length ; i++ ) { 
			 System.out.print(arr3[i]); //nullnullnull
		 }
		 arr3[0] ="1월"; arr3[1] ="2월"; arr3[2] ="3월";
		System.out.println(Arrays.toString(arr3)); //결과 :  [0, 0, 0]
		
		// * 값 삭제 ( 불가능 : 배열은 선언시 고정 길이 이므로 , 값 대신에 기본값으로 변경 )
		arr3[1] = null;		System.out.println( Arrays.toString( arr3 ) );
		
		// * 삭제된 인덱스 뒤로 값을 한칸 당기기
		for( int i = 1 ; i < arr3.length ; i++ ) { 
		
			// 만약에 마지막인덱스에 도착했으면 다음인덱스가 없으므로 당기기 할 필요X
			if( i == arr3.length-1 ) { arr3[i] = null; break; }
			// 마지막 인덱스가 아니면 값을 한칸씩 당기기 
			arr3[i]=arr3[i+1];
		}
			System.out.println( Arrays.toString( arr3 ) );
					
		// * 값 추가 ( 불가능 : 배열은 선언시 고정 길이 이므로 , null 빈공간을 있으면 값 변경 )
			for( int i = 0 ; i<arr3.length ; i++ ) {
		
				if( arr3[i] == null  ) { // 만약에 i번째 인덱스의 값이 비어 있으면 
					arr3[i] = "5월"; break; // 해당 위치에 값 추가
				}
			}
			System.out.println( Arrays.toString( arr3 ) );
	} //main e
} //class e

/*
 	변수 : 하나의 데이터를 저장
 	배열 : 여러개의 데이터를 저장
 		1. 연속적인 공간에 데이터 저장하고 나열
 		2. 각 데이터공간에 인덱스를 부여 [인덱스 : 0 ~ ]
 		3. 특징
 			1. 배열은 선언된 타입의 값만 저장할 수 있다. 
 				int[] intArray = {1, "ddd"}  [x]
 				int[] intArray = {1, 2,3,4}	 [O]

 			
 			2. 배열의 길이는 선언될 때 고정되므로 늘리거나 줄일 수 없다.
 				int[] arr = new int[길이]  <-- 길이의 값을 바꿀 수 없다. 고정
 				
 				List : 배열.. 길이가 가변적
  		4. 배열의 선언
  			1. 타입[] 변수명 ; int[] intArray;
  			2. 선언과 동ㅅ에 값 대입
  				타입[] 변수명 = { 갑1. 값2, 값3...}
  			3. new연산자로 배열생성 기본값으로 생성하는 방법
  			 	타입[] 변수명 = new 타입[길이];
 */
