/**
 * ### 연산자[ 연산 or 계산시 사용되는 특수문자]

1. 산술 연산자 : 
    1. +더하기 / - 빼기 /* 곱하기 / /나누기 / %나머지
2. 연결 연산자 
    1. 숫자 + 숫자 = 더하기
    2. 숫자 + 문자 = 문자로 연결
    3. 문자+ 문자 = 문자로 연결
3. 비교 연산자 : true / false로 출력
    1. 초과 /크다 >
    2. 미만 / 작다 <
    3. 이상 / 크거나 같다 :  > =
    4. 이하 / 작거나 같다 :  < =
    5. 같다 [데이터비교] = =
    6. 같다[데이터형/데이터비교] === 
    7. 같지 않다. 아니다 : ! = 
    8. 같지 않다. 아니다 (데이터형까지 비교) ! ==
4. 관계 연산자 : true / false
    1. &&  : and조건  모든 조건이 참이어야 참
    2. ||  : or조건  두 조건 중 하나라도 참이면 참  
    3. ! : 반대 부정  not조건 예) !(a =0) : a가 이 아니면
5. 대입 연산자
    1. =  대입 : 오른쪽 데이터를 왼쪽에 대입
    2. += : 오른쪽 데이터를 왼쪽에 더한 후 왼쪽에 대입
    3. -= : 오른쪽 데이터를 왼쪽에서 뺀 후 대입
    4. *= ,  /= , %= : 같은 방식으로..곱하고, 나누고, 나머지를 구하고 대입..
        1. 1. 변수 =10   : 변수에 10을 넣어준 것
        2. 2. 변수 +=30 : 변수에 30을 넣어주고 대입 : 40을 대입
6. 증감 연산자
    1. ++ 1증가 
    2. — 1감소
        1. 선위 증가(감소) : ++변수 ,( —변수)
        2. 후위증가(감소) : 변수++(변수—)
7. 삼항 연산자 : 항 3개 존재하는 연산자
    1. 조건 ? 참 true : 거짓 false
        1. 만약에 조건이  true이면 참 실행
        2. 만약에 조건이 false이면 거짓 실행
        3. 중첩가능
            1. 조건1?참1: 조건2? 참2
 */

 //1. 산술연산자
 console.log('더하기' + 10+3) //더하기103
 console.log('더하기'+(10+3)) //더하기13
 console.log('빼기'+(10-3)) //7
 console.log('곱하기'+(10*3))//30
 console.log('나누기'+(10/3))//3.3333333333333335~
 console.log('나머지'+(10%3))//1
 
 

 
 //문제1 : 국어 , 영어 , 수학 점수를 입력받아 각 변수에 저장하고 총점 출력 , 평균 출력
 /*
 	Number('300') => 숫자 300 문자열숫자가 숫자로 변환 
 	예) let kor = Number(prompt('국어점수를 입력하세요'))
  */
 /*
 console.log("문제 1")
 //세과목의 점수 입력받기
 let kor = parseInt(prompt('국어점수를 입력하세요'))
 let eng = parseInt(prompt('영어점수를 입력하세요'))
 let math = parseInt(prompt('수학점수를 입력하세요.'))
 console.log(parseInt(kor))
let sum =kor+eng+math
 console.log("총점입니다. : "+sum)
 console.log("평균입니다. : "+(sum/3))
 */
 //문제2 : prompt 함수 로 반지름 입력받아서 원넓이[ 반지름*반지름*3.14 ] 출력
 /*
 	'10'/3 => 숫자로 계산됨.. 헐!!!!
 	덧셈만 특별히 주의주의!!!!
  
 
 console.log(10*3)
 console.log('10'*3)
 console.log("문제 2")
 const pie =  3.14 
 let r = parseInt(prompt('반지름을 입력하세요'))
 console.log("원의 넓이 : "+(r*r*pie))
 
 
 //문제3 : prompt 함수 로 두 실수를 입력받아서 앞실수의 값이 뒤실수의 값의 몇%인지 출력
 console.log("문제 3")
 let a = prompt('값 A를 입력하세요')
 let b = prompt('값 B를 입력하세요')
 console.log('A는 B의' +(a/b *100) + '% 입니다.')
 
 //2.  비교연산자
console.log('초과 : ' +(10>3)) //true
console.log('미만 : ' +(10<3)) //false
console.log('이상 : ' +(10>=3)) //true
console.log('이하 : ' +(10<=3)) //false
console.log('같다 : ' +(10==3)) //false
console.log('같지않다 : ' +(10!=3)) //true

//3. 관계연산자
console.log('이면서 : ' +(10>3 &&20>15)) //10은 3보다 크면서 20은 15보다 크다 //true
console.log('이면서 : ' +(10>3 &&10>30)) //false
console.log('이거나 :' +(10>3 || 20>15)) //조건중 하나만 true이면 true
console.log('이거나 : ' +(10>3 ||20>30)) //true
console.log('부정 : ' +!(10>3)) //true =>false

*/
//문제4 : prompt 함수 로 정수를 입력받아 홀수[true] / 짝수[false] 여부 출력
let num = prompt("정수를 입력하세요")	
console.log((num %2 == 0)? "짝수": "홀수")

//문제5 : prompt 함수 로 정수를 입력받아 7배수이면 true / 아니면 false 출력
let num1 = prompt("정수를 입력하세요")
console.log((num1 % 7) ==0 ? true : false)

/*문제6 : prompt 함수 로 십만원 단위의 금액을 입력받아 지폐 개수 세기 
         356789      결과 : 십만원3장 만원5장 천원6장  
      */   
let price = prompt('십만 단위의 금액을 입력하세요','100000')
let 십만 = parseInt(price/100000)
console.log(십만)
let 만 = parseInt((price-(100000*십만))/10000)
let 천 = parseInt((price-100000*십만 -10000*만)/1000)
console.log('십만원'+십만+'장. ' + '만원 '+만+'장. ' +'천원 '+천+'장')

/*문제7 : prompt 함수 로 아이디와 비밀번호를 입력받아 아이디가 admin 이고 비밀번호가 1234 와 일치하면 
         결과 : true 출력 아니면 false 출력 */
let id = prompt('아이디를 입력하세요')
let pwd = prompt('비밀번호를 입력ㅎ세요')
console.log((id == 'admin' && pwd=='1234') ? 'true' : 'false')

/*문제8 : prompt 함수로 정수를 입력받아 홀수 이면서 7배수이면 true 아니면 false 출력 */
let num2 = prompt('정수를 입력하세요','홀수이면서 7배수이면 true 아니면 fasle')
console.log('결과 : '+(num2 %2 == 1 && num2 %7 == 0))

 // 4. 대입연산자
 let 데이터1 = 10 // let키워드(변수)로 '데이터1' 이라는 변수명에 10을 저장했다. 
 console.log(데이터1)
 데이터1 += 10 // 10+10 => 20을 대입
 console.log(데이터1)
 데이터1 -=5 //20-5 =>15 
 console.log(데이터1)
 데이터1 *=2 //15*2 =>30
 console.log(데이터1)
 데이터1 /= 6 //30/6=>5
 console.log(데이터1)
 데이터1 %= 2  //5%2 =>1
 console.log(데이터1)
 
 	//예제1
 	let html = '<h3> JS에서 작성된 HTML입니다</h3>' //html언어를 문자열 안에서 작성한다.
 	html +='<p> 문단을 추가했습니다.</p>'
 	// html 변수의 데이터 상태 '<h3> JS에서 작성된 HTML입니다</h3><p> 문단을 추가했습니다.</p>'
 	document.write(html); //document.write() //document:html문서,write:쓰다 	
 	
 // 5. 증감연산자 [data+1. data +=1, data++]
 let 데이터2 = 10;
 console.log('data : '+데이터2) //10
 console.log('data : '+(데이터2++)) //10 출력후에 증가
 console.log('data : '+ 데이터2) //11
 console.log('data : '+(++데이터2)) //12 [출력 전에 증가]
 
 console.log('data : '+ (데이터2--)) //12
 console.log('data : '+ 데이터2) //11
 console.log('data : '+ --데이터2) //10

 // 6. 삼항연산자 [조건? 참:거짓]
 let 나이 =28 // '나이'라는 변수에 38을 저장
 let 연령구간 = 나이 <=19 ? '청소년': '성인'
 console.log('연령대는 '+ 연령구간)
 	//예제2[조건1? 참1:조건2?참2:조건3?참3:거짓]
 let 점수 =78
 let 등급 = 점수 >90  ? 'A등급' : 점수>=80 ? 'B등급0 ' : 점수>=70? 'C등급' : '탈락'
 console.log('등급 : ' + 등급)
 
 
 /*
   문제9 : 정수 2개를 입력받아 더 큰수 를 출력
   문제10 : 정수 3개를 입력받아 가장 큰수 를 출력 
   문제11 : 정수 3개를 입력받아 오름차순 으로 출력    [ 7 5 9 -> 5 7 9]
  */
 //문제 9
 let a9 =  Number(prompt('첫번째 정수를 입력하세요'))
 let b9 =  Number(prompt('두번째 정수를 입력하세요 '))
 let result9 = a9 > b9 ? a9 :b9
 console.log('입력하신 두 정수중 더 큰 수는 '+ result9 )
 
 
 //문제 10
 let a10 =  Number(prompt('첫번째 정수를 입력하세요'))
 let b10 =  Number(prompt('두번째 정수를 입력하세요'))
 let c10 =  Number(prompt('세번째 정수를 입력하세요'))
 
 let max = a10 > b10 && a10 > c10 ? a10 :
 		   b10 > a10 && b10 > c10 ? b10 : c10
console.log("입력하신 세 개의 정수중 가장 큰 수는 : "+ max+"입니다.")

//문제 10-1 (선생님 풀이)
 let max10 = a10
 max = max < b10 ? b10 :max
 max = max <c10 ? c10 : max
 console.log('세 수 중에서  가장 큰 수는  : '+ max)
 

//문제11
let a11 =  Number(prompt('첫번째 정수를 입력하세요'))
let b11 =  Number(prompt('두번째 정수를 입력하세요'))
let c11 =  Number(prompt('세번째 정수를 입력하세요')) 
let max11 = a11 > b11 && a11 > c11 ? a11 :
 		  	b11 > a11 && b11 > c11 ? b11 : c11
let min11 = a11 < b11 && a11 < c11 ? a11 :
 		  	b11 < a11 && b11 < c11 ? b11 : c11 	
let mid11 = max11 == a11 && min11 == b11 ? c11 :
			max11 == a11 && min11 == c11 ? b11 :
			max11 == b11 && min11 == a11 ? c11 :
			max11 == b11 && min11 == c11 ? a11 :
			max11 == c11 && min11 == a11 ? b11 :a11
console.log('세 정수의 오름차순으로 정렬하면 ' + min11 + '/'+ mid11 +'/'+max11)			
					  		  	
 		  	