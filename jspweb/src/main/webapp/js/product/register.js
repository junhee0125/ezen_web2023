/**
 * /jspweb/ProductInfoController
 */             
console.log("JS연결");     
if( loginState == false ){ alert('회원전용 페이지입니다.'); location.href="/jspweb/member/login.jsp"; }
console.log( '채팅방에 입장한 아이디 : ' + loginMid );
/* ------------------ 카카오맵 ------------------ */
//현재 접속한 클라이언트의 위치좌표 구하기
let plat = 0; //현재 카카오지도에서 선택한 좌표
let plng = 0;
navigator.geolocation.getCurrentPosition( e =>{
	console.log(e);
	console.log("위도" + e.coords.latitude);
	console.log("경도" + e.coords.longitude);
	let currentlat  = e.coords.latitude;
	let currentlng = e.coords.longitude;
	
	// 내의 현재 위치(위도경도를) 대입해줌

	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = { 
	        center: new kakao.maps.LatLng(currentlat,currentlng), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    };
	
	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
	
	// 지도를 클릭한 위치에 표출할 마커입니다
	var marker = new kakao.maps.Marker({ 
	    // 지도 중심좌표에 마커를 생성합니다 
	    position: map.getCenter() 
	}); 
	// 지도에 마커를 표시합니다
	marker.setMap(map);
	
	// 지도에 클릭 이벤트를 등록합니다
	// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
	kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
	    
	    // 클릭한 위도, 경도 정보를 가져옵니다 
	    var latlng = mouseEvent.latLng; 
	    
	    // 마커 위치를 클릭한 위치로 옮깁니다
	    marker.setPosition(latlng);
	    
	    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
	    message += '경도는 ' + latlng.getLng() + ' 입니다';
	    
	    var resultDiv = document.getElementById('clickLatlng'); 
		    resultDiv.innerHTML = message;
		plat =  latlng.getLat();
		plng = latlng.getLng();
	});
})


/*-------------------------------------------- */
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
function onRegister(){
	console.log('onRegister()');
	let registerForm = document.querySelectorAll('.registerForm')[0];
	
	console.log(registerForm)
	let formData = new FormData(registerForm);
	console.log(formData);
	 if( plat ==0 || plng == 0){ alert('제품의 위치를 표시해주세요'); }
		 
		 formData.append('plat',plat)
		 formData.append('plng',plng)
	 
		//회원아이디 
		formData.append('mid',loginMid)
	/*
		드래그엔드랍을 사용했을때
			현재 드랍된 파일을  form에 같이 추가해줘야함
			왜냐면 드랍된파일은  input태그에 드랍된것이 아니기때문에~~
	 */
	
	if(fileList.length >= 1){ //드랍된 파일이 한개이상이면
		fileList.forEach(f =>{
		console.log("f :: "+ f);
			//formData.set('fileList', f);
			//폼데이터 객체.set('키',값); : 폼데이터객체에 데이터를 추가하는 방법
			// 파일이 다수일 경우 문제가 발생함.키값은 중이 안되기 때문에
			formData.append('fileList', f);
			//폼데이터 객체.append('키',값); : 폼데이터객체에 데이터를 추가하는 방법
		})
	}
	
	$.ajax({
		url:"/jspweb/ProductInfoController",
		method:"post",
		data: formData,
		contentType:false,
		processData : false,
		success: r => { 
			console.log("성공"+ r)
			if(r == true){
				alert('제품등록');
				location.href = '/jspweb/index.jsp'
			}else{
				alert('제품등록실패');
			}
		},
		error: e => { console.log("에러"+ e)}
		
	});
}



// 2. 드래그앤 드랍
	//1. 드래그 앤 드랍 할 구역 dom객체 호출
let fileDropBox = document.querySelector('.fileDropBox');

	//2. 
	/*
	  	방법1 : 	< 태그  ondragenter="" >
	  	방법2 : queryselector로  이벤트 주고 싶은  dom객체를 불러와서
	  			객체.addEventListener("dragenter".(e)=>{})
	  			# dragenter : 드래그가 들어왔을때
	  			# dragleave : 드래그가 나갔을때.
	 */
	
fileDropBox.addEventListener("dragenter", (e)=>{
	e.preventDefault(); // 브라우저가 가진 이벤트를 실행하지 못하도록 prevent!!
	console.log('드래그 들어옴');
});

fileDropBox.addEventListener("dragleave", (e)=>{
	console.log('드래그 나감');
	fileDropBox.style.backgroundColor='#FFFFFF';
	e.preventDefault(); // 브라우저가 가진 이벤트를 실행하지 못하도록 prevent!!
});


fileDropBox.addEventListener("dragover", (e)=>{
	console.log('드래그상자위를  위치중');
	e.preventDefault(); // 브라우저가 가진 이벤트를 실행하지 못하도록 prevent!!
});

/*
	# 드랍을 하면 브라우저 자체로  drop이벤트를 실행해서 이벤트 실행이 불가능
		# 크롬은 사진이 열리고 / 엣지는 다운로드됨
	# 브라우저가 가진 이벤트를 실행하지 못하도록 prevent!!
		 e.preventDefault;
 */
fileDropBox.addEventListener("drop", (e)=>{
	console.log('드래그상자위를  떨어짐');
	console.log(e);
	e.preventDefault(); // 브라우저가 가진 이벤트를 실행하지 못하도록 prevent!!
	
	
	//------------------드랍된 파일의 정보??------------------------//
	
	// 1. 드랍된 데이터 정보를 이벤트 결과에서 찾기
		console.log(e.dataTransfer)
		console.log(e.dataTransfer.files)
		console.log(e.dataTransfer.files[0])
		console.log(e.dataTransfer.files[0].name)
		
	let files =	e.dataTransfer.files
		for(let i=0; i <files.length; i++){
			if(files[i] != null && files[i] != undefined){
				fileList.push(files[i])	
			}
		}
	fileDropBox.style.bakcgroundColor = '#ffffff';
	fileListPrint();	
}); //f
 let fileList = []; //현재 드래그앤
 function fileListPrint(){
	 
	 let html = ``;
	 fileList.forEach((f,i)=>{
		 let fname = f.name;
		 let fsize = (f.size/1024).toFixed(1);//파일용량이  바이트단위이므로 kb로 변환
		 //(f.size/1024).toFixed(1); toFixed(소숫점자리수)
		 html += `<div>
				<span>${fname}</span>
				<span>${fsize}</span>
				<span><button onclick="fileDelete(${i})" type="button">삭제</button></span>
			
			</div>`
		 
		 
	 })
	 // 3 대입
	 fileDropBox.innerHTML= html;
	 
	 
 }
 
 function fileDelete(index){
	 
	 fileList.splice(index, 1);
	 fileListPrint();
	 
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