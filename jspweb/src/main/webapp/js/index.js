/**
 * 
 */
console.log('js연결');
getNewItem(10);
function getNewItem(count){
	console.log(' getNewItem(count) ::' + count)
	
	let requestData = {type : 'M', nItemCount: count}
	$.ajax({
		url:"/jspweb/ProductInfoController",
		method:"get",
		data: requestData,
		success: jsonarray => { console.log(jsonarray)
			let productBox = document.querySelector('.productBox');
			let html = ``;
			
			jsonarray.forEach((p) => {
				console.log(p);
				let firstImg = Object.values(p.imgList)[0];
				
				html+=`<div class="col">
					    <div class="card">
					      <img src="/jspweb/product/img/${firstImg}" class="card-img-top" alt="...">
					      <div class="card-body">
					        <h5 class="card-title">${p.pname}</h5>
					        <p class="card-text">${p.pcomment}</p>
					      </div>
					    </div>`
				
				
			});
			productBox.innerHTML = html;
		},
		error : e => {} 
	});
	
	
}

function getItemLocation(){
	
	let requestData = {type : 'K',  e : 10, w: 10,s:10, n:10 }
	
	$.ajax({
		url:"/jspweb/ProductInfoController",
		method:"get",
		data: requestData,
		success: r => {},
		error : e => {} 
	});
	
	
}

function getItemDetail(pno){
	
	let requestData = {type : 'D',  pno : pno }
	
	$.ajax({
		url:"/jspweb/ProductInfoController",
		method:"get",
		data: requestData,
		success: r => {},
		error : e => {} 
	});
	
	
}


function getItemList(pcno){
	//페이징은 생략 let requestData = {type : 'D',   pcno: 0 , listSize : 10, page:1 , searchType :'', keyword:''}
	let requestData = {type : 'A',   pcno: pcno }
	
	$.ajax({
		url:"/jspweb/ProductInfoController",
		method:"get",
		data: requestData,
		success: r => {},
		error : e => {} 
	});
	
	
}

/*
	 자바스크립트의 객체
	 	형태  let 변수명 = {키 : 데이터, 키:데이터}
	 	- 데이터 : 데이터(상수/변수), 함수, 배열/리스트 등등 
	 	변수명.새로운필드명 = 데이터
	 	속성값삽입 : 갳
	 	속성호출 ㅣ 객체명. 속성명  or 객체명['속성명']
	 	${p.imgList[0]}
	 자바스크립트의 배열/리스트 
	 	형태 let 변수명 = []	
 */