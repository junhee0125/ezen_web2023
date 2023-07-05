/**
 * 
 */
console.log('kiosk JS 연결성공!!')
//--------------------------------------------------------------------------------------//
let bimgList=['top_img01.png','top_img02.png','top_img03.jpg','top_img04.png','top_img05.png']

let categoryList = ['신제품(new)','프리미엄','와퍼&주니어','치킨&슈프림버거','올데이킹&킹모닝']
/*1. 제품 여러개 저장하는 배열
		- 서로 다른 유형의 데이터 여러개 저장 = 객체{}
		- 동일한 유형들의 데이터 여러개 저장 = 배열리스트 []
		- [{버거명/버거가격/버거사진/카테고리]},{버거명/버거가격/버거사진/카테고리},{버거명/버거가격/버거사진/카테고리}]
		- 다른 배열이나 객체의 연관관계
		- 카테고리(상위) -> 제품(하위) // 카테고리식별값 = > 제품에 저장 [ pk ---> fk]
 */

let burgerList=[
	
	{name : '헬로디아블로와퍼', price: 9500, img:'menu2.png',category:0},
	{name : '헬로키티주니어와퍼', price: 12000, img:'menu3.png',category:1},
	{name : '세이헬로우슈프림버거', price: 9500, img:'menu4.png',category:2},
	{name : '와퍼주니어', price: 6500, img:'menu5.png',category:4},
	{name : '치킨버거', price: 8500, img:'menu6.png',category:3},
	{name : '와퍼', price: 10500, img:'menu7.png',category:4}
]

let cartList = [];
/*
	1. 주문(주문내역) 배열
		주문{ 주문번호: , 주문날짜 : ,결제금액 ,  주문제품[], 상태 : true(주문요청)/false(완료) }
		주문{ ono: 1 , date : '2023-07-05 13:30:21' ,pay:30000 ,  products[0,0,2] }
		주문 { 주문번호 : , 주문날짜 :  , 결제금액 : , 주문제품들 : [ ] , 상태 : 0[주문요청] 1[주문완료] 2[주문취소]  } 
*/

let orderList = [ 
	{ ono : 1 , date : '2023-07-05 13:30:21' , pay : 30000 , products : [ 0 , 0 , 2 ] , state : 1  }
]
//---------------------------------------------------------------------------------------------------//
/*1. 광고이미지 변경
	1.광고이미지 여러개 = > 베열로

*/
//광고이미지 여러개를 저장하고 있는 공간

let viewhimg = 0; // 현재 보여지는 광고이미지 인덱스 
//	2. 특정시간마다 이미지의  scr변경하기
	//-setInterval(함수/기능, 밀리초):1/1000초
	//1.funciton 함수명(){}, 2.function(){}, 3.()=>{}
setInterval(()=>{
	//1. 해당태그 호출
	let himg = document.querySelector('.himg')
	
	//2. 호출된 객체에서  src속성 대입/바꿔치기
	viewhimg++;
	
	if(viewhimg >= bimgList.length){ viewhimg = 0;	} //마지막 인덱스가 되면 viewhimg(보여질 이미지 인덱스)기 0번으로 세팅됨
	himg.src=`../img/kiosk/${bimgList[viewhimg]}` //himg의 src속성값을  변경한다. 
	
}, 2000) //2초마다 실행코드 주기적으로 실행


/****
 * 2. 카테고리 출력 [어디에?? 무엇을??]
 *  어디에 : .categorymenu안에 
 * *****/
// 1. 카테고리 여러개 저장하는 배열
categoryPrint(0); //최초 1번 실행

function categoryPrint(selectNo){
	//1. 어디에?
	let categorymenu = document.querySelector('.categorymenu');
	let html = '';
	//html구성 : 배열내 모든 데이터를 (for를 사용해서) li형식으로 출력
	console.log('categoryPrint');
	for(let i = 0 ; i < categoryList.length ; i++){
		if( selectNo == i) {
			html += `<li class='selected_c' onclick='categorySelect(${i})'>${categoryList[i]}</li>`;
			console.log(`${categoryList[i]}`);
		} else {
			html += `<li onclick='categorySelect(${i})'>${categoryList[i]}</li>`;
		}
		
	}
	categorymenu.innerHTML = html;
	productPrint(selectNo);
}


//3. 카테고리 클릭 이벤트

function categorySelect(selectNo){
	console.log(selectNo);
	//querySelectorAll를 이용해서 .categorymenu의  li를 query하면 배열로 담겨짐 
	let categoryli = document.querySelectorAll('.categorymenu li');
	console.log(categoryli)
	for(let i= 0 ; i<categoryList.length; i++){ //카테고리 메뉴의 갯수만큼 반복하면서 
		if(i == selectNo){ //선택된 no가  i와 일치하면. i번의 
			//해당 li에 class= 추가 DOM객체명.classList.add('추가할 클래스명')
			categoryli[i].classList.add('selected_c')
		} else {
			//해당 li에 class=삭제 DOM객체명. classList.remove('삭제할클래스명')
			categoryli[i].classList.remove('selected_c')
		}
	}
	productPrint(selectNo);
}

//4. 제품출력함수 [실행조건 : 카테고리 클릭하면(변경되면) 해당 카테고리의 제품만 출력]
function productPrint(categoryNo){ 
	console.log(categoryNo);
	//1. 어디에?
	let productbox = document.querySelector('.product_box');
	//2. 무엇을
	let html='';
		//html 구성
	for(let i =0;i<burgerList.length; i++){
		if(burgerList[i].category == categoryNo) {
			html += `<div class="product">
						<img onclick="productSelect(${i})" src="../img/kiosk/${burgerList[i].img}"/>
						<div class="product_info">
							<div class="pname">${burgerList[i].name}</div>
							<div class="pprice">${burgerList[i].price}</div>
						</div>
					</div>`
		}
	}
	//3. 출력
	productbox.innerHTML = html;
	
}



//5. 제품 선택함수 [실행조건 : 제품이미지를 클릭하면 장바구니에 담는 함수]
function productSelect(productNo){
	console.log(burgerList[productNo].name);
	cartList.push(productNo);
	console.log(cartList);
	cartPrint();
}

//6.선택한 제품의 카트에 출력하는 함수
function cartPrint(){
	console.log('카트에 출력되야할 '+ cartList);
	let cartBottom = document.querySelector('.cart_bottom')
	let html = ''
	
	for(let i=0 ; i<cartList.length ; i++){
		console.log(burgerList[cartList[i]]);
		html += `<div class="citem">
					<div class="iname">${burgerList[cartList[i]].name}</div>
					<div class="iprice">${burgerList[cartList[i]].price.toLocaleString()}원</div>
					<span onclick="particalCancel(${i})" class="icancel">X</span>						
				</div>`
	}
	cartBottom.innerHTML = html;
	document.querySelector('.ccount').innerHTML = `${cartList.length}`
	cartTotalPrint();
	//만약 카트내 제품이 많아서 스크롤이 생성되었을때 자동으로 맨 오른쪽으로 이동시켜 보여주는...
	//세로 스크롤의 경우 스크롤의 height를 top값에 넣어주면 맨 아래쪽에 붙음. 
	cartBottom.scrollLeft=10000;
}

//7 카트내 부분 취소 [실행조건 : 카트에 담긴 제품 아이템의 x 버튼이 클릭되면 ]
function particalCancel(cartIndex){
	console.log('부분취소할 인덱스'+cartIndex);
	//카트리스트에서 해당인덱스 하나를 삭제한다.
	cartList.splice(cartIndex,1);
	cartPrint();
	
}

//8. 카트내 전체 취소
function wholeCancel(){
	if(cartList.length <= 0 ) {
		alert('삭제할 제품이 없습니다.')
	} else {
		
			cartList.splice(0);
			console.log(cartList);
			cartPrint();
		
	}
}
// 9. 카트에 담긴 제품들의 합계 출력하는 함수
function cartTotalPrint(){
	let total = 0;
	let ctotalbox = document.querySelector('.ctotalbox')
	//let html='';
	for(let i=0 ; i<cartList.length;i++){
		total += Number(burgerList[cartList[i]].price);
		console.log(total);
		//html = `<span class="ctotal">${total.toLocaleString()}</span></div>`
		
	}
	document.querySelector('.ctotal').innerHTML=`${total.toLocaleString()}원`
}

//10. 카트에 저장된 버거 주문(등록) 함수
function productOrder(){ alert('주문 했습니다.')
	// * 주문번호 만들기  // 마지막인덱스 : 배열명.length-1
	let ono = orderList[orderList.length-1].ono; // 주문배열내 마지막주문의 번호 	
	// * 카트(전역변수) 에 있던 버거인덱스를 새로운 배열에 저장 
	let products = []; // 주문이 들어가는 버거들 인덱스
	let totalPrice = 0;
	for( let i = 0 ; i<cartList.length ; i++ ){
		products.push( cartList[i] ); // i번째 버거의 인덱스 를 새로운 배열에 저장 
		totalPrice += burgerList[ cartList[i] ].price
	} 	
	// 1. 주문객체 생성해서 
	let order = {
		ono : ono+1 ,			// 주문번호 생성 해서 저장 [ 마지막 주문번호 + 1 ]
		date : new Date() ,		// 현재날짜/시간 구해주는 함수 이용해서 자동으로 대입  
		pay : totalPrice ,		// 카트내 제품들의 총가격 			
		products : products ,	// 카트에 있던 모든 제품들 // 전역변수[cartList] 대입 시 문제발생
		state : 0				// 주문객체 생성시 '주문요청' 으로 상태 초기로 사용 
	}	
	// 2. 주문배열에 저장하기 
	orderList.push( order ); alert('주문이 들어갔습니다.')
	// * 카트 초기화 
	wholeCancel() // 전체취소 함수로 동일하기 때문에 재호출 
	// * 주문 리스트 확인 
	console.log( orderList )
}
	
