/**
 * 
 */

if(loginState == null){ location.href = '/'}

getWishList()
let checkList = document.querySelectorAll('.checkbox');
console.log(checkList);
	//2 첫번째 체크박스를 클릭
		//dom객체명.addEventListener(이벤트명, (이벤트결과매개변수)=>{}) //
	checkList[0].addEventListener('click', (e)=> {
		console.log('1번 클릭했어요');
		console.log(e);
		console.log(checkList[0].checked);
		//3. 만약에 첫번째 체크박스가 체크되면 모든 체크박스는 체크 활성화
		
		if(checkList[0].checked == true){
			checkList.forEach((c)=>{ c.checked = true; });
		} else {
			checkList.forEach((c)=>{ c.checked = false; });
		}

	})
// 제품목록에서의 ]
 //1. 찜한 목록 출력하기
 function getWishList(){
	 
	$.ajax({
		url:"/jspweb/PwishListController",
		async:false,
		method:"get",
		data: {type:'findByAll'},
		success: jsonArray => {
			console.log(jsonArray);
			
		let wishlist = document.querySelector('.wishlist')
		let html =``
			
		jsonArray.forEach((p)=> {
				html+=`<tr>
							<td><input type="checkbox" class="checkbox" ></td>
							<td> <img src = "/jspweb/product/img/${Object.values(p.imgList)[0]}" width="100%" ></td>
							<td> ${p.pname} </td>
							<td> ${p.pprice}원</td>
							<td> <button onclick= "deleteWish(pno)"> X </button> </td>
						</tr>`
		});
		wishlist.innerHTML = html;

		},
		error : e => {} 
	}); 
 }
 function deleteWish(pno){
	 $.ajax({
		url:"/jspweb/PwishListController",
		async:false,
		method:"post",
		data: {type:'findByAll'},
		success: jsonArray => {
			console.log(jsonArray);
			
		let wishlist = document.querySelector('.wishlist')
		let html =``
			
		jsonArray.forEach((p)=> {
				html+=`<tr>
							<td><input type="checkbox" class="checkbox" value ></td>
							<td> <img src = "/jspweb/product/img/${Object.values(p.imgList)[0]}" width="100%" ></td>
							<td> ${p.pname} </td>
							<td> ${p.pprice}원</td>
							<td> <button onclick= "deleteWish(pno)"> X </button> </td>
						</tr>`
		});
		wishlist.innerHTML = html;

		},
		error : e => {} 
	});
	 
	 
 }