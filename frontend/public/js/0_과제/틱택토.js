//김준희-----------------------------

console.log('js연결')

let player_list =[]; //플레이어 선택버튼 
let com_list = []; //컴퓨터 선택


 /******************************************
함수명	: 	playerCheck(index)
인 자		: 	index : 버튼의 index (0~9)
기 능		1. 플레이어가 버튼을 클릭했을때.
			- 플레이어의 배열에 해당번호를 저장
			- 해당 버튼은 "O"표시되고 
			- disabled 속성을 추가
			- 삼목체크함수 호출
*******************************************/
 function playerCheck(index){

	 console.log('player: '+index)
	 //플레이어가 첫번째로 선택한것 배열에 담기
	 player_list.push(index);
	 console.log(player_list)
	 
	 //pBtnElement 변수를 생성. 클릭한 버튼을 찾아. 
	 let pBtnElement=  document.querySelector(`.btn${index}`);
	 
	 // disabled 속성을 추가하고
	 pBtnElement.setAttribute('disabled', true);	
	 

	 //버튼의 이름에 ' O '	를 넣어준다. 
	 pBtnElement.innerText = 'O';
	 


	
	 //삼목체크 함수를 호출해서 삼목여부를 체크한다.
	 ranNum();
	 삼목체크();	
	 
	 //다음 순서인 컴퓨터 

	 //컴퓨터


 }


 //--------------------------------------
 
 
 //15:16 시작
 //김근배---------------------------------
 
 function 삼목체크(){
	 if(player_list.length >= 3 && com_list >= 3){
		 //플레이어 배열을 검색 ,  삼목일 경우의 수와 부합하면 alert("플레이어 승리") 
		 //삼목 경우의 수  036 / 147 / 258 / 012 / 345 / 678 / 048 / 246
		 if(player_list.indexOf(0) != -1 &&  player_list.indexOf(3) != -1 && player_list.indexOf(6) != -1 ){ alert(`플레이어 승리`); return; }
		 if(player_list.indexOf(1) != -1 &&  player_list.indexOf(4) != -1 && player_list.indexOf(7) != -1 ){ alert(`플레이어 승리`); return; }
		 if(player_list.indexOf(2) != -1 &&  player_list.indexOf(5) != -1 && player_list.indexOf(8) != -1 ){ alert(`플레이어 승리`); return; }
		 if(player_list.indexOf(0) != -1 &&  player_list.indexOf(1) != -1 && player_list.indexOf(2) != -1 ){ alert(`플레이어 승리`); return; }
		 if(player_list.indexOf(3) != -1 &&  player_list.indexOf(4) != -1 && player_list.indexOf(5) != -1 ){ alert(`플레이어 승리`); return; }
		 if(player_list.indexOf(6) != -1 &&  player_list.indexOf(7) != -1 && player_list.indexOf(8) != -1 ){ alert(`플레이어 승리`); return; }
		 if(player_list.indexOf(0) != -1 &&  player_list.indexOf(4) != -1 && player_list.indexOf(8) != -1 ){ alert(`플레이어 승리`); return; }
		 if(player_list.indexOf(2) != -1 &&  player_list.indexOf(4) != -1 && player_list.indexOf(6) != -1 ){ alert(`플레이어 승리`); return; }
		 //컴퓨터 배열을 검색 , 삼목일 경우의 수와 부합하면 alert("컴퓨터 승리")
		 //삼목 경우의 수  036 / 147 / 258 / 012 / 345 / 678 / 048 / 246
		 if(com_list.indexOf(0) != -1 &&  com_list.indexOf(3) != -1 && com_list.indexOf(6) != -1 ){ alert(`컴퓨터 승리`); return; }
		 if(com_list.indexOf(1) != -1 &&  com_list.indexOf(4) != -1 && com_list.indexOf(7) != -1 ){ alert(`컴퓨터 승리`); return; }
		 if(com_list.indexOf(2) != -1 &&  com_list.indexOf(5) != -1 && com_list.indexOf(8) != -1 ){ alert(`컴퓨터 승리`); return; }
		 if(com_list.indexOf(0) != -1 &&  com_list.indexOf(1) != -1 && com_list.indexOf(2) != -1 ){ alert(`컴퓨터 승리`); return; }
		 if(com_list.indexOf(3) != -1 &&  com_list.indexOf(4) != -1 && com_list.indexOf(5) != -1 ){ alert(`컴퓨터 승리`); return; }
		 if(com_list.indexOf(6) != -1 &&  com_list.indexOf(7) != -1 && com_list.indexOf(8) != -1 ){ alert(`컴퓨터 승리`); return; }
		 if(com_list.indexOf(0) != -1 &&  com_list.indexOf(4) != -1 && com_list.indexOf(8) != -1 ){ alert(`컴퓨터 승리`); return; }
		 if(com_list.indexOf(2) != -1 &&  com_list.indexOf(4) != -1 && com_list.indexOf(6) != -1 ){ alert(`컴퓨터 승리`); return; }		
			
		 	alert(`무승부`)
 	}else{ return;}
 }

 //-------------------------------------

	/*병철 작업 시작*/
 //최병철---------------------------------
 
 // 최병철 : 컴퓨터 난수 만드는 함수
 
 
 	//1 난수 생성 Math.random() // 마지막번호 + 시작번호
/*	console.log(Math.random())		//Math.random() : 0~1 사이의 난수(실수) 생성
	console.log(Math.random()+1)	// (0~1) + 1 > 1~2 사이의 난수생성
	console.log(Math.random()*45+1)	// (0~1)*45 > 1~45 사이의 난수생성 [ 끝값 , 45는 포함 안한다]
									//// (0~1)*45+1 > 1~46 사이의 난수생성 [ 끝값 , 46은 포함 안한다]*/

/*	//2 실수(소수점)을 > 정수로 변환 : parseInt() : 실수를 정수로 변환
	console.log( parseInt(Math.random()*45+1))*/

	//3 1~45 사이의 난수생성[중복검사 후 push] 6회 반복

 function ranNum(){ // 컴퓨터 랜덤 번호 생성 함수
		
	for(let i=0 ;i < 1 ; i++){
		let random = parseInt(Math.random()*9); // 0~8까지 난수 생성 후 random 변수에 저장
		console.log('com   :  '+random)
		if(player_list.indexOf(random) !=-1) { 
			console.log('중복선택 됐어요.');
			i--; 
			console.log('i : '+i)
			return;
			
			
		} else {
			com_list.push(random); // com_list 배열에 저장
			console.log('컴퓨터 선택  : '+ com_list);
			document.querySelector(`.btn${random}`).innerText = 'X';
			document.querySelector(`.btn${random}`).setAttribute('disabled', true);	
			
			
		}
			
		
	}	
	}
		 
//		for( let i = 0; i<9; i++ ){ // for 시작
//			// i는 8까지 1씩 증가 // 총 9번 실행 
//	
//			if(player_list.indexOf(random) == -1){ // 플레이어 배열에 컴퓨터 배열과 중복되는게 없다면
//				com_list.push(random); // com_list 배열에 저장
//				document.querySelector(`.btn${random}`).innerText = 'X';
//				return;
//			}else{ i--; return;	} // 중복의 경우 값을 저장하지 못하였으니 for 문 한번 더 실행을 위하여 i-- 해준다
//		
//		} //for 끝
	

 
  //컴퓨터 랜덤 번호 생성 종료
 	/* 병철 작업 끝*/
 //-------------------------------------
 
 //황기준---------------------------------
 function reset(){ 
	player_list =[];
	com_list = [];
	
		for(i=0;i<=8;i++){	//i가 8이 될때까지 8개의 버튼을 찾아서 버튼의 disabled 속성값을 지운다.
			let btnElement= document.querySelector(`.btn${i}`);
			btnElement.removeAttribute('disabled' );
			//해당 버튼의 이름을 지운다.
			btnElement.innerText = '';
		}
		console.log(btnElement.getAttribute( 'disabled' ));
		 
 	}
 
 
 // * 저장 성공시 input 상자 입력값 초기화

 
 //-------------------------------------