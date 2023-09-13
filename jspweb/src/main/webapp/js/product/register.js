/**
 * /jspweb/ProductInfoController
 */             
console.log("JS연결");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
function onRegister(){
	console.log('onRegister()');
	let registerForm = document.querySelectorAll('.registerForm')[0];
	
	console.log(registerForm)
	let formData = new FormData(registerForm);
	console.log(formData);
	
	$.ajax({
		url:"/jspweb/ProductInfoController",
		method:"post",
		data: formData,
		contentType:false,
		processData : false,
		success: r => { console.log("성공"+ r)},
		error: e => { console.log("에러"+ e)}
		
	});
}













/*
// 1. 
function register1(){
	
	$.ajax({ //  [ form 태그 없는경우 1 ]  
		url : "/jspweb/ProductInfoController",
		method : "post" ,
		data : {
			pname1 : document.querySelector('.pname1').value , 
			pcontent1 : document.querySelector('.pcontent1').value 
		} , 
		success : r => { console.log( r ) } , 
	})
	
}
function register2(){

	let registerForm1 = document.querySelectorAll('.registerForm1')[0];
	let formData = new FormData( registerForm1 );
	
	$.ajax({ //  [ form 태그 이용하는 경우 2 - form 전송시 ]
		url : "/jspweb/ProductInfoController",
		method : "post" ,
		data : formData , 
		// 전송타입 1. text/html , 2.application/json 3. multipart/form-data 
		contentType: false ,
 		processData: false ,
		success : r => { console.log( r ) } , 
	})
	
}



 */                                                                            