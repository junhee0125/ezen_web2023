/**
 * 반복문: 어디서부터 어디까지
 * 		1. 	
 * 			for(초기값 ; 조건문 ; 증감식) {
 * 					실행코드
 * 		}
 *			1. 초기값 : 반복의 처음값 
 * 			 	; : 구역부분
 * 		 	2. 조건문 : 조건문이  true이면 {} 실행 아니면 {} 실행 안함
 * 			 	; : 구역
 * 		 	3. 실행문 : 반복시 실행될 코드
 *		 	4. 증감식 : 반복변수 증가 / 감소 단위 
 
 		예) 	1부터 10까지 1씩 증가 반복
 			for(let i=1; i<=1- ; i++){}
 		예)	1부터 100까지 홀수만 반복
 			for(let i=1 ; i<=100 ; i+=2){}
 */
//1. for 반복문
 for( let i=0 ; i<10 ; i++){ //for s
	 // i는 0부터 10미만까지 1씩 증가 하면서 반복
	 console.log('반복문 : '+i);
	 /*순서도 = 알고리즘 != 자료구조? 
	 
	 */
 }//for end
 
 // 2. 배열 (인덱스)과 반복문
 let 상자 = ['사과','포도','딸기']
 	//	1. 반복문이 없을 때
 	console.log(상자[0])
 	console.log(상자[1])
 	console.log(상자[2])
 	
 	
 	// 2. 반복문이 있을 때
 	for(let i=0 ; i < 상자.length ; i++){
		 console.log(상자[i]);
	 }//for end
	 
	console.log('------------ex1-------------') 
	//예제1) : i는 1부터 10이하까지 1씩 증가 반복
	for(let i= 1; i<=10 ;i++ ){
		console.log(i)
	} 	
	console.log('------------ex2-------------') 
	//예제2) : i는 1부터 10이하까지 1씩 증가 반복 [한줄에 표시]
	let output=``
	for(let i= 1; i<=10 ;i++ ){
		output += `${i}  `		
		console.log(output)
	}  
	
	console.log('------------ex3-------------') 
	//예제3) : i는 1부터 10이하까지 1씩 증가 반복 [HTML 표시]
	output = `` //위에서 선언된 output변수를 재선언하지 않고 공백을 대입 (초기화)
	for(let i =1 ; i <=10 ; i++){
		output +=`<p> ${i} </p>`
	}
	document.write(output)
	
	console.log('------------ex4-------------') 
	//예제4) : i는 1부터 10이하까지 1씩 증가 반복 [누적합계]
	let sum =0;// 1부터 으로 더한 값을 저장할 변수
	for(let i=1 ; i <= 10 ;i++){
		console.log(sum +"+"+i+"="+(sum+i))
		sum += i
		
	}
	//console.log(sum +"+"+i+(sum+i))
	
	console.log('------------ex5-------------') 
	//예제5) : i는 1부터 100이하까지 7의 배수 누적합계 
	sum = 0;
	for( i=1 ; i <= 100 ; i++ ){
		if( i%7 == 0 ){	sum +=i }		
	}
	console.log(sum)
	
	console.log('------------ex6-------------') 
	//예제6) : 구구단 2단 출력하기
	for(let i=1 ; i<=9 ;i++){
		console.log(2+"x"+i+"="+2*i)
	}
	
	console.log('------------ex7-------------') 
	//예제7) : 구구단 9단까지 출력하기
	for(let i=2 ; i<=9 ;i++){		
		for(let j=1; j<=9 ;j++){
			if(j == 1){
				console.log(`-----(${i}단)-----`);
			}
			console.log(`${i} x ${j} = ${i*j} `)
		}
	}