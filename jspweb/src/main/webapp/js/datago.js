/**
 * 공공데이터 포탈
 * https://https://www.data.go.kr/
 * 	공공데이터
 */

 //1안산시 착한가격업소 API 호출
 api1();
 function api1(){
	 $.ajax({
		url:"https://api.odcloud.kr/api/15036759/v1/uddi:577ba1b9-b79f-4865-b31e-a9dc71ce67bc_201909231019?page=1&perPage=10&serviceKey=UR0jJYd%2BQa3amiFJFraFOt0P6hazB25RhiF%2Bc9YZfZxqkNgOmGoetCpZIV1zD2HESWcWbQjyJ8W4ZyPQoxNg1g%3D%3D",
		method:"get",
		data: {},
		success: r => {  // r= 객체
			console.log("success :: "+r)  
			let data = r.data;
			console.log(data);
			console.log(data[0]);
			console.log(data[0].업소명);
			
			//출력할 dom객체
			let apiTable1 = document.querySelector('.apiTable1');
			
			
			//2. HTML 구성
			let html = `<tr>
							<th>번호</th>
							<th>상호명</th>
							<th>주소</th>
							<th>연락처</th>
							<th>대표메뉴1</th>
							<th>대표메뉴2</th>
							<th>대표메노3</th>
						</tr>`;
			data.forEach((d, i)=>{
				html +=`<tr>
							<th>${i+1}</th>
							<th>${d.업소명}</th>
							<th>${d.소재지도로명주소}</th>
							<th>${d.연락처}</th>
							<th>${d.품목1} / ${d.가격1}</th>
							<th>${d.품목2} / ${d.가격2} </th>
							<th>${d.품목3} / ${d.가격3}</th>
						</tr>` 
			
				
			});
			apiTable1.innerHTML = html;
		},
		error : e =>{console.log( "error "+ e)}
		 
	 });
 } 
 
 
 
 /*
 		카카오 개발자 센터
 		https://developers.kakao.com/
 			카카오 지도  : https://apis.map.kakao.com/
 
  */

// 1. 접속한 브라우저의 GPS 좌표 얻기  [ geolocation ] - 엣지브라우저

/*
navigator.geolocation.getCurrentPosition( pos => {  console.log( pos ); 
	let lat = pos.coords.latitude;
	let lng = pos.coords.longitude;
	// 카카오지도 출력 
	var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
	var options = { //지도를 생성할 때 필요한 기본 옵션
		center: new kakao.maps.LatLng( lat , lng ), //지도의 중심좌표.
		level: 3 //지도의 레벨(확대, 축소 정도)
	};

	var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

	// 마커가 표시될 위치입니다 
	var markerPosition  = new kakao.maps.LatLng( lat ,  lng); 

	// 마커를 생성합니다
	var marker = new kakao.maps.Marker({
	    position: markerPosition
	});

	// 마커가 지도 위에 표시되도록 설정합니다
	marker.setMap(map);

}) // f end 

*/
/*
	클러스터 사용하기
	 - js 파일 api 키 뒤에 &libraries=clusterer 추가
 */

var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
        center : new kakao.maps.LatLng(36.2683, 127.6358), // 지도의 중심좌표 
        level : 14 // 지도의 확대 레벨 
    });
    
    
    //-----------------------------마커이미지 설정-----------------------------------------//
    // 마커 이미지의 주소
		var markerImageUrl = 'https://t1.daumcdn.net/localimg/localimages/07/2012/img/marker_p.png', 
		    markerImageSize = new kakao.maps.Size(40, 42), // 마커 이미지의 크기
		    markerImageOptions = { 
		        offset : new kakao.maps.Point(20, 42)// 마커 좌표에 일치시킬 이미지 안의 좌표
		    };

		// 마커 이미지를 생성한다
		var markerImage = new kakao.maps.MarkerImage(markerImageUrl, markerImageSize, markerImageOptions);

		// 지도에 마커를 생성하고 표시한다
		var marker = new kakao.maps.Marker({
		    position: new kakao.maps.LatLng(37.56682, 126.97865), // 마커의 좌표
		    draggable : true, // 마커를 드래그 가능하도록 설정한다
		    image : markerImage, // 마커의 이미지
		    map: map // 마커를 표시할 지도 객체
		});
  
 
    // 데이터를 가져오기 위해 jQuery를 사용합니다
    // 데이터를 가져와 마커를 생성하고 클러스터러 객체에 넘겨줍니다
    $.get("https://api.odcloud.kr/api/15090398/v1/uddi:6fe0e3f2-0285-4999-9edf-995afe19a6ea?page=1&perPage=96&serviceKey=UR0jJYd%2BQa3amiFJFraFOt0P6hazB25RhiF%2Bc9YZfZxqkNgOmGoetCpZIV1zD2HESWcWbQjyJ8W4ZyPQoxNg1g%3D%3D"
    
    , function(resoonse) {
        // 데이터에서 좌표 값을 가지고 마커를 표시합니다
        // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
        console.log(resoonse)
        var markers = $(resoonse.data).map(function(i, position) {
			console.log( i + "번의  postion : " + position['(WGS84)']);
			//개별마커 성성후 
			let marker = new  kakao.maps.Marker({
				 position : new kakao.maps.LatLng(position['위도(WGS84)'], position['경도(WGS84)']),
				 image : markerImage, // 마커의 이미지
				 map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
				 minLevel: 6 // 클러스터 할 최소 지도 레벨 
			})
			 // 마커에 클릭 이벤트를 등록한다 (우클릭 : rightclick)
			kakao.maps.event.addListener(marker, 'click', function() {
				let html =``;
				html += `<div>충전소명 : ${position.충전소명}</div>`;
				html += `<div>충전기타입명 : ${position.충전기타입명}</div>`;
				html += `<div>운영기관명 : ${position.운영기관명}</div>`;
				html += `<div>소재지도로주소명 : ${position.소재지도로명주소}</div>`;
				
				document.querySelector('.detailBox').innerHTML = html;
				
			    alert('마커를 클릭했습니다!');
			});
			
			//생성된 마커 리턴
            return marker;
        });

        // 클러스터러에 마커들을 추가합니다
        clusterer.addMarkers(markers);
    });

   
/*
	$.ajax({ url : "" , method:"" , data : {} , success : ()=>{}  } );
	$.method( url , data , ()=>{} )
	
	객체내 속성 호출 
		객체명.속성명
		객체명['속성명']  : 속성명에 특수문자가 있는경우
		
	
*/



/*
// 1. 접속한 브라우저의 GPS 좌표 얻기  [ geolocation ] - 엣지브라우저
navigator.geolocation.getCurrentPosition( pos => {  console.log( pos ); 
	let lat = pos.coords.latitude;
	let lng = pos.coords.longitude;
	// 카카오지도 출력 
	var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
	var options = { //지도를 생성할 때 필요한 기본 옵션
		center: new kakao.maps.LatLng( lat , lng ), //지도의 중심좌표.
		level: 3 //지도의 레벨(확대, 축소 정도)
	};
	
	var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
	
	// 마커가 표시될 위치입니다 
	var markerPosition  = new kakao.maps.LatLng( lat ,  lng); 
	
	// 마커를 생성합니다
	var marker = new kakao.maps.Marker({
	    position: markerPosition
	});
	
	// 마커가 지도 위에 표시되도록 설정합니다
	marker.setMap(map);
}) // f end 

*/
