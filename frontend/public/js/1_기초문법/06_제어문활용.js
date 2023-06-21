/**
 *     조건 : 반복문X 입력:prompt 출력 : console 
       문제 1 : 2개의 정수 를 입력받아서 가장 큰수를 출력 
       문제 2 : 3개의 정수 를 입력받아서 가장 큰수를 출력     [ max 함수 x ]
       문제 3 : 4개의 정수 를 입력받아서 가장 큰수를 출력    [ max 함수 x ]
       
       문제 4 : 3개의 정수 를 입력받아서 오름차순 / 내림차순 출력 
       문제 5 : 4개의 정수 를 입력받아서 오름차순 / 내림차순 출력 
       
       문제 6 : 점수를 입력받아 점수 90점이상 합격 출력 아니면 탈락 출력 
       문제 7 : 점수를 입력받아 점수 90점이상 A등급 출력 
                            80점이상 B등급 출력 
                            70점이상 C등급 출력  
                            그외 재시험
       문제 8 : 아이디와 비밀번호 입력받기 
             회원아이디가 admin 이고 비밀번호가 1234 이면 로그인 성공 출력 
                                     아니면 로그인
 */
//문제 1 : 2개의 정수 를 입력받아서 가장 큰수를 출력 
let a1 = Number(prompt("문제1- 첫번째 정수를 입력하세요"))
let b1 = Number(prompt("문제1- 두번째 정수를 입력하세요"))
if( a1> b1) {
	console.log('두 정수중 큰수는  a1 : '+a1+'입니다')
} else if (a1< b1) { 
	console.log('두 정수중 큰수는  b1 : '+b1+'입니다')
} else { 
	console.log('[문제1] 두 수의 크기는 같습니다. :' + a1)	
}

//문제 2 : 3개의 정수 를 입력받아서 가장 큰수를 출력     [ max 함수 x ]
let a2 = Number(prompt("문제2- 첫번째 정수를 입력하세요"))
let b2 = Number(prompt("문제2- 두번째 정수를 입력하세요"))
let c2 = Number(prompt("문제2- 세번째 정수를 입력하세요"))

if (a2 > b2) { 
	if(a2 > c2) {
		console.log('[문제2]세 정수중 큰 수는 첫번째 정수 :' + a2)
	}
} else if(b2 > c2) {
	console.log('[문제2]세 정수중 큰 수는 두번째 정수 :' + b2)
} else {
	console.log('[문제2]세 정수중 큰 수는 세번째 정수 :' + c2)
}

/* 선생님 코드
let max2 = a2
if(max2 < b2 ){ max2 = b2}
if(max2 < c2 ){ max2 = c2}
console.log(max2)
 */

//문제 3 : 4개의 정수 를 입력받아서 가장 큰수를 출력    [ max 함수 x ]
let a3 = Number(prompt("문제3- 첫번째 정수를 입력하세요"))
let b3 = Number(prompt("문제3- 두번째 정수를 입력하세요"))
let c3 = Number(prompt("문제3- 세번째 정수를 입력하세요"))
let d3 = Number(prompt("문제3- 네번째 정수를 입력하세요"))



if( a3 > b3){ //a가 크면
	if(a3 > c3) { //c랑 비교해
		if(a3 > d3) { //c보다 a가 크면 d랑 비교해
			//d보다 a가 크면 a 출력
			console.log('[문제3] 네 개의 정수중 큰 수는 첫번째 정수 :' + a3)
		} else { // a가 d보다 작으면  d출력
			console.log('[문제3] 네 개의 정수중 큰 수는 네번째 정수 :' + d3)
		}
		
	}else if(c3 > d3){ //c가  a보다 크면 d와ㅣ 비교
		//c 가 크면 c출력
		console.log('[문제3] 네 개의 정수중 큰 수는 세번째 정수 :' + c3)
		
	} else {
		console.log('[문제3] 네 개의 정수중 큰 수는 네번째 정수 :' + d3)
	}
	
} else if( b3 > c3) { //b 크면 c와 비교
	// b가 c 보다 크면 d랑 비교
	if(b3 > d3) { // b > d
		console.log('[문제3] 네 개의 정수중 큰 수는 두번째 정수 :' + b3)
	} else { //b < d
		console.log('[문제3] 네 개의 정수중 큰 수는 네번째 정수 :' + d3)
	}	
} else if (c3 > d3) {
	console.log('[문제3] 네 개의 정수중 큰 수는 세번째 정수 :' + c3)
	
} else {
	console.log('[문제3] 네 개의 정수중 큰 수는 네번째 정수 :' + d3)
}

/** 선생님 풀이
let max3 = a3
if(max3 < b3 ){ max3 = b3}
if(max3 < c3 ){ max3 = c3}
if(max3 < d3 ){ max3 = d3}
console.log(max3)
 */


//문제 4 : 3개의 정수 를 입력받아서 오름차순 / 내림차순 출력 
let a4 = Number(prompt("문제4- 첫번째 정수를 입력하세요"))
let b4 = Number(prompt("문제4- 두번째 정수를 입력하세요"))
let c4 = Number(prompt("문제4- 세번째 정수를 입력하세요"))


if (a4 > b4) { let tmp = a4; 	a4 = b4;  	b4 = tmp ; }
if (a4 > c4) { let tmp = a4; 	a4 = c4; 	c4 = tmp ; }
if (b4 > c4) { let tmp = b4;	b4 = c4;   	c4 = tmp ; }

console.log(a4 +' '+b4 +' '+c4)

//문제 5 : 4개의 정수 를 입력받아서 오름차순 / 내림차순 출력 
//오름차순

let a5 = Number(prompt("문제5- 첫번째 정수를 입력하세요"))
let b5 = Number(prompt("문제5- 두번째 정수를 입력하세요"))
let c5 = Number(prompt("문제6- 세번째 정수를 입력하세요"))
let d5 = Number(prompt("문제6- 네번째 정수를 입력하세요"))
if(a5 > b5){ let tmp = a5; a5 = b5;  b5=tmp; } 
if(a5 > c5){ let tmp = a5; a5 = c5;  c5=tmp; }
if(a5 > d5){ let tmp = a5; a5 = d5;  d5=tmp; }
if(b5 > c5){ let tmp = b5; b5 = c5;  c5=tmp; }
if(b5 > d5){ let tmp = b5; b5 = d5;  d5=tmp; }
if(c5 > d5){ let tmp = c5; c5 = d5;  d5=tmp; }

console.log('[문제5] 결과 값  : '+a5 +' '+b5 +' '+c5+' '+d5)
//문제 6 : 점수를 입력받아 점수 90점이상 합격 출력 아니면 탈락 출력 
let score = Number(prompt("문제6- 점수를 입력하세요"))
if(score >= 90) { console.log('[문제6 결과] : 합격')}
else {console.log('[문제6 결과] : 탈락')}

/*문제 7 : 점수를 입력받아 점수 90점이상 A등급 출력 
                            80점이상 B등급 출력 
                            70점이상 C등급 출력  
                            그외 재시험 */
let score1 = Number(prompt("문제7- 점수를 입력하세요"))

if(score1 >= 90 ) {
	console.log('[문제7 결과] : A등급')
} else if( score1 >=80 ) {
	console.log('[문제7 결과] : B등급')
} else if(score1 >=70 ) {
	console.log('[문제7 결과] : C등급')
} else {
	console.log('[문제7 결과] : 재시험')
}

 /*문제 8 : 아이디와 비밀번호 입력받기 
             회원아이디가 admin 이고 비밀번호가 1234 이면 로그인 성공 출력 
                                     아니면 로그인 실패 출력*/
let id = prompt("문제8- 아이디를 입력하세요")
let pwd = prompt("문제8- 비밀번호를 입력하세요")

if(id=='admin'){
	if(pwd){
		console.log('[문제8 결과] : 로그인 성공')
	} else{
		console.log('[문제8 결과] : 로그인 실패 (패스워드가 일치하지 않습니다.')
	}	
} else {
	console.log('[문제8 결과] : 로그인 실패 (아이디가 일치하지 않습니다.) ' )
}                                     
                                     