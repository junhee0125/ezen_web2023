

let output=`` //출력용
// 문제1) 입력받은 수 만큼 * 출력 
console.log('문제1) 입력받은 수 만큼 * 출력') 
let num = Number(prompt('정수를 입력해주세요'))
for(let i=1; i<=num; i++){
	output += `*`	
}	
console.log(output)

// 문제2) 입력받은 수 만큼 * 출력 [  - 3줄(3배수)마다 줄바꿈 ]
console.log('문제2) 입력받은 수 만큼 * 출력') 
output=``
num = Number(prompt('정수를 입력해주세요'))
for(let i=1 ; i<= num ; i++) {
	output += `*` //*
	if( i%3 == 0){ output += `\n` }	
}
console.log(output)

/* 문제3) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]
		줄	별	줄바꿈
*		1	1	\n
**		2	2	\n         
***		3	3	\n      
****	4	4	\n   
*****	5	5	\n
*/
console.log('문제3) 입력받은 줄 수 만큼 * 출력') 
output=``
num = Number(prompt('정수를 입력해주세요'))
for(let i=1 ; i<=num ; i++){
	for(let j=1 ; j <=i ; j++){
		output +=`*`
		
	}
	output  +=`\n`
}
console.log(output)

/*문제4) 입력받은 줄 수 만큼 * 출력 [ ex) 5 ]
*****
****
***
**
*
*/
console.log('문제4) 입력받은 수 만큼 * 출력') 
output=``//줄수가 3
num = prompt('정수를 입력해주세요')
for(let i=num ; i>=1 ; i--){ 
	for(let j=1 ; j <=i ; j++){ output +=`*`}
	output  +=`\n`
}
console.log(output)

/*
// 문제5) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]
    *   스페이스 4 별1  1줄
   **   스페이스 3 별2  2줄
  ***   스페이스 2 별3  3줄
 ****   스페이스 1 별4  4줄
*****   스페이스 0 별5  5줄
*/
console.log('문제5) 입력받은 수 만큼 * 출력') 
output=``//
num = prompt('정수를 입력해주세요')
									//입력이 3
for(let i=1 ; i <= num ; i++ ){ 	//i=1  1<=3 
	let space = num-i
	//console.log(space);
	for(let j=1; j<=space; j++ ){//sp j=1 1<=2 	
		output += ` `
	}
	for(let k=1; k<=i ; k++){//*	k=1 1<=1
		output +=`*`
	}
	output += `\n`
		
}console.log(output)


/**
// 문제6) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]
*****	5	5		0	
 ****	4	4(줄수-i+1)		1
  ***	3	3		2
   **	2	2		3
    * 	1	1		4
 */
console.log('문제6) 입력받은 수 만큼 * 출력') 
output=``//
num = prompt('정수를 입력해주세요')
for(let i=1; i<=num ; i++){		// i=3	
	for(let k=1;k<=i-1;k++){		
		output += ` `
	}
	for(let j=1; j <=num-i+1; j++){ //*
		output +=`*`		
	}
	
	output += `\n`
}console.log(output)


/*
console.log('문제7) 입력받은 수 만큼 * 출력') 
// 문제7) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]
			줄       b	s 	b	
    *		1		4 	1	4	5줄- 1번째	1시작		
   ***		2		3	3	3	5줄 -2번째	2증가		
  *****		3		2	5	2				2증가
 *******	4		1	7	1				2증가
*********	5		0	9	0				2증가
 */

console.log('문제7) 입력받은 수 만큼 * 출력') 
output=``//
num = prompt('정수를 입력해주세요')
for(let i=1 ; i<=num ; i++){ //줄수만큼
	for(let j=1; j<=num-i; j++){//좌측 스페이스 
		output += ` `
	}
	for(let s=1 ;s <= (2*i-1) ;s++){//가운데 별
		output += `*`
	}
	for(let j=1; j<=num-i; j++){//좌측 스페이스 
		output += ` `
	}
	output += `\n`
}
console.log(output)

/**
 * // 문제8) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]
 * 			줄		공란		별		공란
*********	1		0		9		0
 *******	2		1		7		1
  *****		3		2		5		2
   ***		4		3		3		3
    *		5		4		1		4
 */

console.log('문제8) 입력받은 수 만큼 * 출력') 
output=``
num = prompt('정수를 입력해주세요')
for(let i=num ;i >= 1; i-- ){
	for(let j=1; j<=num-i ; j++){
		output +=` `
	}
	for(let k=1 ; k<=(i*2-1); k++){
		output +='*'
	}
	for(let j=1; j<num-i ; j++){
		output +=` `
	}
	output += `\n`
}
console.log(output)

/*
// 문제9) 입력받은 줄 수 만큼 * 출력  [ ex) 10 ]9
    *		1			1
   ***		2			3	
  *****		3			5
 *******	4			7
*********	5			9
*********	6			9
 *******	7		
  *****		8
   ***		9
    *		10
 */
console.log('문제9) 입력받은 수 만큼 * 출력') 
output=``
num = prompt('정수를 입력해주세요')

	for(let i=1; i <= num/2; i++ ){
		for(let j=1; j<=(num/2-i);j++){
			output += ` `
		}	
		for(let k=1; k <=(i*2-1);k++){
			output += `*`
		}
		for(let j=1; j<=(num/2-i);j++){
			output += ` `
		}
		output += `\n`
	}
	for(let i=num/2; i >=1/2; i--){
		for(let j=1; j<=num/2-i ;j++){
			output += ` `
		}
		for(let k=1; k <=(i*2-1);k++){
			output += `*`
		}
		for(let j=1; j<=num/2-i ;j++){
			output += ` `
		}
		output += `\n`
	}
	
	console.log(output)	
	



/*
// 문제10) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]			*          *
*           *	1	1	0	1 	10	1	0             *      *
  *       *		2	2	2	1	6	1	2               *  *
    *   *		3	3	4	1	2	1	4                 *
      *			4	4	6	0	1	0	6
    *   *		5	3	4
  *       *		6	2	2
*           *	7	1	0
*/
console.log('문제10) 입력받은 수 만큼 * 출력 (3이상 홀수 입력)') 
output=``
num = Number(prompt('정수를 입력해주세요'))
for(let i=1 ; i<=num; i++){
	// 첫번째 라인과 마지막 라인인경우

	if(i == 1 || i== num){
		//첫번째 별 찍기
		output +=`*`;
		//공백찍기
		for(let j=1 ; j<= 2*num-3;j++){
			output += ` `;
		}
		output += `*`;
	} else if(i == parseInt(num/2 + 1)) { // 맨가운데 라인
		
		for(let j=1 ;j<=num-1;j++){
			output += ` `;
		}
		output +=`*`;
		for(let j=1 ;j<=num-1;j++){
			output += ` `;
		}
	} else{
		let total = num*2-5;// 라인에서 별을 제외한 공란의 갯수  
		let bcount = 0 ;
		if(i < num/2+1){
			for(let j=1 ; j<=(i-1)*2 ; j++){
				output += ` `;
				bcount++; //b
			}	
			output +=`*`;
			for(let j=1;j <=total-bcount;j++){output += ` `;}
			output +=`*`;
			for(let j=1 ; j<=(i-1)*2 ; j++){output += ` `;}
			console.log('total'+total);
			console.log('bcount'+bcount);
		} else{
			for(let j=1 ; j<=(i-num/2+1)*2 ; j++){
				output += ` `;
				bcount ++; //b
			}	
			output +=`*`;
			for(let j=1;j <=total-bcount;j++){output += ` `;}
			output +=`*`;
			for(let j=1 ; j<=(i-num/2+1)*2 ; j++){output += ` `;}
			console.log('total'+total);
			console.log('bcount'+bcount);
		}
	}
	output += `\n`;			
}
console.log(output)	



	