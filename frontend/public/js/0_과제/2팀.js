//2팀
let 포장 = prompt('매장이면 0, 포장이면 1')
let 메뉴 = ['비빔밥','잔치국수','비빔국수','수제비']
let 가격 = ['5000','6000','6500','3000']
let 주문할메뉴 = [] //최종 담기한메뉴
let 선택한메뉴;  // 메뉴선택에서 손님이 입력한 메뉴
let 사이즈; //사이즈 곱배기 or  보통 (가격차이는 없음.)
let 수량;	 //수량
let 주문stop // 담기를 종료하고 결제할지 여부 
let b = 4 //1회 최대 주문수량
let 결제YN =''; // 결제성공여부

for(let i = 0; i < b; i++){			// for문 시작
	선택한메뉴 = ''
	사이즈 = ''
	수량 = ''
	선택한메뉴 = prompt('메뉴를 입력해주세요') 
	if(선택한메뉴 != ''){
		주문할메뉴.push(선택한메뉴)  //메뉴 , 사이즈 , 수량, 가격
		주문할메뉴.push(가격[메뉴.indexOf(선택한메뉴)])
		console.log(주문할메뉴)
		사이즈 = prompt('사이즈를 입력해주세요')
		if(사이즈 != ''){
			주문할메뉴.push(사이즈)
			console.log(주문할메뉴)
		}else{
			사이즈 = '보통'
			주문할메뉴.push(사이즈)
			console.log(주문할메뉴)
		}
		수량 = prompt('수량을 입력해주세요')
		if(수량 != ''){
			주문할메뉴.push(수량)
			console.log(주문할메뉴)
		}else{
			수량 = '1'
			주문할메뉴.push(수량)
			console.log(주문할메뉴)
		}
	}
	주문stop = prompt('계속 담기 = 0 , 결제 = 1')
	if(주문stop == 1){
		i = b
	}
}
console.log( '최종 주문 ' + 주문할메뉴 )

let 결제선택;

	결제선택 = prompt('결제 방법 = 카드 0, 현금1')
if(결제선택 == 0){	
	//
	if(주문할메뉴.length%4 == 0 && 주문할메뉴.length/4 ==1){
		가격=prompt('결제하실 금액은 '+주문할메뉴[1] * 주문할메뉴[3]+'입니다. 결제해주세요')
		if(가격 == 주문할메뉴[1] * 주문할메뉴[3]){
			console.log("결제가 완료되었습니다.");
			결제YN = 'Y'
		} else{
			console.log("결제가 실패했습니다.");
		}
		
		if(결제YN == 'Y'){
			if(포장 == '1'){
				console.log("이모님 주문이요 "+주문할메뉴[0] +", "+주문할메뉴[3] +"개 포장이요" )
			} else {
				console.log("이모님 주문이요 "+주문할메뉴[0] +", "+주문할메뉴[3] +"개 홀 주문이요 " )
			}
			
			console.log("영수증 :결제하신 금액은 " + 가격 + "입니다.")
			console.log("번호가 출력되었습니다.")
		}
	} else if(주문할메뉴.length%4 ==0) {
		
		
	}
}
/**
 * 
 */