/**
 * 
 */
console.log('kiosk JS 연결성공!!')

/*1. 광고이미지 변경
	1.광고이미지 여러개 = > 베열로

*/
//광고이미지 여러개를 저장하고 있는 공간
let bimgList=['top_img01.png','top_img02.png','top_img03.jpg','top_img04.png','top_img05.png']
let viewhimg = 0; // 현재 보여지는 광고이미지 인덱스 
//	2. 특정시간마다 이미지의  scr변경하기
	//-setInterval(함수/기능, 밀리초):1/1000초
	//1.funciton 함수명(){}, 2.function(){}, 3.()=>{}
setInterval(()=>{
	//1. 해당태그 호출
	let himg = document.querySelector('.himg')
	
	//2. 호출된 객체에서  src속성 대입/바꿔치기
	viewhimg++;
	if(viewhimg >= bimgList.length){ viewhimg = 0;	} //이미지 마지막 
	himg.src=`../img/kiosk/${bimgList[viewhimg]}`
	
}, 2000) //2초마다 실행코드 주기적으로 실행


/****
 * 2. 카테고리 출력 [어디에?? 무엇을??]
 *  어디에 : .categorymenu안에 
 * *****/
// 1. 카테고리 여러개 저장하는 배열
let categoryList = ['신제품(new)','프리미엄','와퍼&주니어','치킨&슈프림버거','올데이킹&킹모닝']
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
}


//3. 카테고리 클릭 이벤트

function categorySelect(selectNo){
	console.log(selectNo);
	let categoryli = document.querySelectorAll('.categorymenu li');
	console.log(categoryli)
	for(let i= 0 ; i<categoryList.length; i++){
		if(i == selectNo){
			//해당 li에 class= 추가 DOM객체명.classList.add('추가할 클래스명')
			categoryli[i].classList.add('selected_c')
		} else {
			//해당 li에 class=삭제 DOM객체명. classList.remove('삭제할클래스명')
			categoryli[i].classList.remove('selected_c')
		}
	}
}