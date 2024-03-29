/**
 * 
 */
var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
        center : new kakao.maps.LatLng(36.2683, 127.6358), // 지도의 중심좌표
        level : 14 // 지도의 확대 레벨
    });

    // 마커 클러스터러를 생성합니다
    // 마커 클러스터러를 생성할 때 disableClickZoom 값을 true로 지정하지 않은 경우
    // 클러스터 마커를 클릭했을 때 클러스터 객체가 포함하는 마커들이 모두 잘 보이도록 지도의 레벨과 영역을 변경합니다
    // 이 예제에서는 disableClickZoom 값을 true로 설정하여 기본 클릭 동작을 막고
    // 클러스터 마커를 클릭했을 때 클릭된 클러스터 마커의 위치를 기준으로 지도를 1레벨씩 확대합니다
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
        minLevel: 10, // 클러스터 할 최소 지도 레벨
        disableClickZoom: true // 클러스터 마커를 클릭했을 때 지도가 확대되지 않도록 설정한다
    });

    // 데이터를 가져오기 위해 jQuery를 사용합니다
    // 데이터를 가져와 마커를 생성하고 클러스터러 객체에 넘겨줍니다
    
    $.ajax({
		url:"/jspweb/ProductInfoController",
		method:"get",
		data:{type : 'A'},
		success: jsonArray => {
			console.log(jsonArray)
			var markers = jsonArray.map((p)=>{
				position : new kakao.maps.LatLng(p.plat, p.plng)
				
			});
			// 클러스터러에 마커들을 추가합니다
        	clusterer.addMarkers(markers);
		},
		error : e => {} 
	});
//    $.get("/download/web/data/chicken.json", function(data) {
//        // 데이터에서 좌표 값을 가지고 마커를 표시합니다
//        // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
//        var markers = $(data.positions).map(function(i, position) {
//            return new kakao.maps.Marker({
//                position : new kakao.maps.LatLng(position.lat, position.lng)
//            });
//        });
//
//        // 클러스터러에 마커들을 추가합니다
//        clusterer.addMarkers(markers);
//    });

    // 마커 클러스터러에 클릭이벤트를 등록합니다
    // 마커 클러스터러를 생성할 때 disableClickZoom을 true로 설정하지 않은 경우
    // 이벤트 헨들러로 cluster 객체가 넘어오지 않을 수도 있습니다
    kakao.maps.event.addListener(clusterer, 'clusterclick', function(cluster) {

        // 현재 지도 레벨에서 1레벨 확대한 레벨
        var level = map.getLevel()-1;

        // 지도를 클릭된 클러스터의 마커의 위치를 기준으로 확대합니다
        map.setLevel(level, {anchor: cluster.getCenter()});
    });
//현재보고있는 지도의 동서남북 얻기

getInfo();   
function getInfo() {
        clusterer.clear();
    // 지도의 현재 영역을 얻어옵니다 
    var bounds = map.getBounds();
    
    // 영역의 남서쪽 좌표를 얻어옵니다 
    var swLatLng = bounds.getSouthWest(); 
    
    // 영역의 북동쪽 좌표를 얻어옵니다 
    var neLatLng = bounds.getNorthEast(); 
    
	let e = neLatLng.getLng()
	let w = swLatLng.getLng()
	let s = swLatLng.getLat()
	let n = neLatLng.getLat() 
    
    console.log("동::"+e)
    console.log("서::"+w)
    console.log("남::"+s)
    console.log("북::"+n)
    
    
    // 개발자도구를 통해 직접 message 내용을 확인해 보세요.
    // console.log(message);
     getItemLocation(e,w,s,n);
}


//2. 해당 동서남북 좌표 범위 내에 제품 출력하기
function getItemLocation(e,w,s,n) {
	console.log(e+'\n'+w+'\n'+s+'\n'+n+'\n')
	let requestData = {type : 'K',  e : e, w: w , s:s, n:n }
    $.ajax({
		url:"/jspweb/ProductInfoController",
		async:false, /* ajax 통신의 기본 */
 		method:"get",
		data:requestData,
		success: jsonArray => {
			console.log(jsonArray)
			var markers = jsonArray.map((p)=>{
				
				 return new kakao.maps.Marker({
		            position : new kakao.maps.LatLng( p.plat, p.plng )
		        });
				
			});
			// 클러스터러에 마커들을 추가합니다
	    	clusterer.addMarkers(markers);
	
		// 2. 사이드바에 제품 출력
		
		let sidebar = document.querySelector('.sidebar');
		let html =``;
		jsonArray.forEach((p) => {
		console.log(p)
		html += `<div class="card mb-3" style="max-width: 540px;">	
				  <div class="row g-0">	
				    <div class="col-md-5">
				      <a href="/jspweb/product/view.jsp?pno=${p.pno}"><img src="/jspweb/product/img/${ Object.values(p.imgList)[0] }" class="img-fluid rounded-start" alt="..."></a>
				    </div>
				    <div class="col-md-7">
				      <div class="card-body">
				        <h5 class="card-title">${ p.pname }</h5>
				        <p class="card-text">
				        	<div> ${ p.pcontent } </div>
				        	<div> ${ p.pprice.toLocaleString() } 원 </div>
				        </p>
				      </div>
				    </div>
				  </div>
				</div>`
		});					
		sidebar.innerHTML = html; 
		},
		error : e => {} 
	});
}
//카카오 지도에서 드래그했을때 동서남불 위치를 다시 가져오기 (1번함수 호출)
kakao.maps.event.addListener(map, 'dragend', function() {
   getInfo();
});


