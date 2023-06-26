/**
 * 함수형태
 * 1. 인수x 반환 x 함수
 * 		<선언>
 * 		function 함수1() {console.log('함수1 실행')}
		
		<호출>
		함수1(); //함수호출시 한번
		
		<button onclick="함수1()" type="buttpn">함수실행</button> //클릭할때마다

 */
//1. 인수x 반환 x 함수
function 함수1() {console.log('함수1 실행')}
함수1(); //함수호출

//2. 인수 o 2개 반환x 함수정의
function 함수2(x,y){console.log(x+y)}
함수2(3,5);
함수2('코카콜라: ', 3)

//3. 인수o =2 개, 반환0 함수 정의
function 함수3(x, y){console.log(x+y); return x+y;}
let 결과값 = 함수3(3,5);
console.log('함수3 결과/리턴 : ' + 결과값)

function 함수4(x,y){
	if( x >= 3 ){return;}
}

//4. 인수x, 반환0 함수 정의
function 함수5(x,y){
	return 3+8;
	
	let 결과2 = 함수5();
	console.log('함수5 결과 / 리턴 : '+ 결과2 )
}

//5. 함수정의시 함수 호출 가능
function 함수6(){console.log(' 함수 6실행시 함수1 실행');함수1();}