/**
 * 변수와 상수
 */

 //1. 변수의 선언 let / 변수명 / 대입연산자 / 값
 let 변수1 = 10
 
 //2 변수출력
 console.log(변수1)
 
 //3. 변수의 수정
 변수1=20
 console.log(변수1)
  
  //4.변수의 연산
 let  변수2  = 변수1 + 10 
 console.log(변수2) // 30
 console.log(변수2+10) //40
 
 //5.입력받은 값 저장
 let 입력 = prompt('숫자 입력해주세요')
 console.log('입력받은 숫자 :'+ 입력)
 
 let 상태 = confirm('삭제하시겠습니까??')
 console.log('버튼 상태'+ 상태) //확인 : true / 취소: false 반환
 
 /********************************************************/
 // 1. 상수 선언
 const 상수1 = 10
 //2. 상수출력
 console.log(상수1)
 //3.상수 수정
 //상수1 = 2-
 console.log(상수1) //오류발생 :Uncaught TypeError: Assignment to constant variable.
 //4.상수의 연산
 const 상수2 = 상수1+20
console.log(상수2)
//입력받은 값을 상수에 저장
const 입력2 = prompt("문자를 입력해주세요")
console.log('입력받은 문자열은 : '+ 입력2)