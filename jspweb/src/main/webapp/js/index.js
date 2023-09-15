/**
 * 
 */
function getNewItem(count){
	
	let requestData = {type : 'M', nItemCount: 10}
	
	$.ajax({
		url:"/jspweb/ProductInfoController",
		method:"post",
		data: requestData,
		success: r => {
			
		},
		error : e => {} 
	});
	
	
}

function getItemLocation(){
	
	let requestData = {type : 'K',  e : 10, w: 10,s:10, n:10 }
	
	$.ajax({
		url:"/jspweb/ProductInfoController",
		method:"post",
		data: requestData,
		success: r => {},
		error : e => {} 
	});
	
	
}

function getItemDetail(pno){
	
	let requestData = {type : 'D',  pno : pno }
	
	$.ajax({
		url:"/jspweb/ProductInfoController",
		method:"post",
		data: requestData,
		success: r => {},
		error : e => {} 
	});
	
	
}


function getItemList(pcno){
	//페이징은 생략 let requestData = {type : 'D',   pcno: 0 , listSize : 10, page:1 , searchType :'', keyword:''}
	let requestData = {type : 'D',   pcno: pcno }
	
	$.ajax({
		url:"/jspweb/ProductInfoController",
		method:"post",
		data: requestData,
		success: r => {},
		error : e => {} 
	});
	
	
}