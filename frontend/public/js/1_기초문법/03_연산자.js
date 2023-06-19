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
 console.log("문제 1")
 //세과목의 점수 입력받기
 let kor = parseInt(prompt('국어점수를 입력하세요'))
 let eng = parseInt(prompt('영어점수를 입력하세요'))
 let math = parseInt(prompt('수학점수를 입력하세요.'))
 console.log(parseInt(kor))
let sum =kor+eng+math
 console.log("총점입니다. : "+sum)
 console.log("평균입니다. : "+(sum/3))
 
 //문제2 : prompt 함수 로 반지름 입력받아서 원넓이[ 반지름*반지름*3.14 ] 출력
 /*
 	'10'/3 => 숫자로 계산됨.. 헐!!!!
 	덧셈만 특별히 주의주의!!!!
  */
 
 console.log(10*3)
 console.log('10'*3)
 console.log("문제 2")
 const pie =  3.14 
 let r = parseInt(prompt('반지름을 입력하세요'))
 console.log("원의 넓이 : "+(r*r*pie))
 
 
 //문제3 : prompt 함수 로 두 실수를 입력받아서 앞실수의 값이 뒤실수의 값의 몇%인지 출력
 console.log("문제 3")
 let a = parseFloat(prompt('값 A를 입력하세요'))
 let b = parseFloat(prompt('값 B를 입력하세요'))
 console.log('A는 B의' +(a/b *100) + '% 입니다.')


 