	 	
//1. 함수의 정의
function 함수1(){} //1. 인수 x 반환 x
function 함수2(아무거나){} //2. 인수 o 반환  x
function 함수3(x,y,z){} // 3 인수가 다수일 때 /반환x
function 함수4(x,y,z){return 3;} //4. 인수 o, 반환 o =>  함수종료 역할
function 함수5(){return 3;} //4. 인수 x, 반환 o =>  함수종료 역할
function 함수6(){return ;} //6. 인수 x, 반환 => 단순 함수종료 역할

//2. 함수의 호출
console.log("안녕") ; 	//1. 미리 정의된 (js만든 사람) log(인수 = 출력하고 싶은 문자열) 할수
배열명.splice(0,1) ; 		//2. 미리 정의된 (js만든 사람) splice(인수1, 인수2)
document.querySelector('') // 3. 미리 정의된 querySelector(인수1 =???)
함수1(); // 4. js내에 내가 만든 함수
함수2(3); //5. 함수의 호출과 동시에 함수에 3을 전달 [x = 3]
함수3(3,5,20) //6. 함수 호출과 동시에 해당함수에 데이터 3개 전달 [x=3, y=5, z=20]

let 함수결과1= 함수4(3.5,20) //7. 함수 종료후 리턴 / 반환값을 변수에 저장
let 함수결과2 = 함수5() //8. 함수 종료 후 리턴/ 반환값을 변수에 저장
함수6() //9. 함수 종료후  리턴 반환값 없이 별도로 저장 안함)

//3.함수 호출 2
	// 3-1 html 이벤트 함수 호출
/* 
 * <input type= "button " onclick="함수명()">
 * <button type="button" onclick="함수명()">
 */ 
 	// 3-2 함수 내에서 다른 함수 호출
 function 함수7(){ console.log('함수 안에서 함수 호출')}
 function 함수8(){ 함수7();}

// 4. 함수연산
let 연산결과 = 함수5() +10 ;// 함수5의 반환값이 3이므로  3+10 출력 
			// 1함수실행 2. +연산 3 = 대입 
			
// 5. 함수 호출/ 사용
	// 1.JS : 함수명 (인수1, 인수2, 인수3)
	// HTML			
	
	
/*
	
}





 */