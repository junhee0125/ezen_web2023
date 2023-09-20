/**
 * 
 */

//게시판상세페이지. 제품상세페이지 등등에서는 클릭된식별자 [제품번호]
//URL(인터넷주소)에서 매개변수(쿼리스트링)가져오기
//쿼리스트링 : 페이지 전환때 많이 사용됨
let pno = new URL(location.href).searchParams.get('pno')
console.log("pno" + pno)
getItemDetail(pno);
//1. pno에 해당하는 제품 1개 호출
function getItemDetail(pno){
	
	let requestData = {type : 'D',  pno : pno }
	
	$.ajax({
		url:"/jspweb/ProductInfoController",
		method:"get",
		data: requestData,
		success: jOject => {
			console.log("jsonArray::"+jOject);
			
			let imgbox = document.querySelector('.imgbox')
			let html =``
			Object.values(jOject.imgList).forEach((img,i)=>{
				html+=`<div class="carousel-item ${i==0? 'active': ''}">
					      <img src="/jspweb/product/img/${img}" class="d-block w-100" alt="...">
					    </div>`
							
			})
			imgbox.innerHTML = html;
			//각위치에 데이터 넣어주기
			document.querySelector('.mid').innerHTML = `판매자 : ${jOject.mid}`
			document.querySelector('.pcname').innerHTML = `카테고리 : ${jOject.pcname}`
			document.querySelector('.pdate').innerHTML = `등록일 : ${jOject.pdate}`
			document.querySelector('.pname').innerHTML = `판매자 : ${jOject.pname}`
			document.querySelector('.pprice').innerHTML = `판매가격 : ${jOject.pprice}`			
			document.querySelector('.pcomment').innerHTML = `판매자 : ${jOject.pcomment}`
		},
		error : e => {} 
	});
	
	
}