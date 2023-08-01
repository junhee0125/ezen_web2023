/**
 *
 */
console.log("js파일 연결");
new LuminousGallery(document.querySelectorAll('.grid-gallery'), {}, {
	caption: function(trigger) {
	    return trigger.querySelector('img').getAttribute('alt');
	}
});
//스크립트 추가
//라이트박스 적용할 요소 지정해주기
//grid-gallery클래스가 움직이도록 설정

//AOS 애니메이션
AOS.init({
  duration: 1000 // 실행시간 늦추기
});