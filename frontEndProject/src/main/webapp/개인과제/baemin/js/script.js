/**
 *
 */
console.log("JS파일 연결");

/*
  scrollActionBlock
  휠 전체 기능을 막을 것.
 */

/*window.addEventListener("wheel", function(e){
    e.preventDefault();
},{passive : false});

*/
//var mHtml = $("html");
var mHtml = document.querySelector(".container");

var page = 1;

//mHtml.animate({scrollTop : 0},10); //Yposition이 0이 아닐경우를 대비
/*
 deltaX : 마우스 휠 (X 축)의 가로 스크롤 량을 반환.
deltaY :마우스 휠의 세로 스크롤 량 (y 축) 반환. WheelEvent
deltaZ :z 축의 마우스 휠 스크롤 양 반환. WheelEvent
deltaMode : 델타 값 (픽셀, 선 또는 페이지)에 대한 측정 단위를 나타내는 숫자 반환. WheelEvent
 */
window.addEventListener("wheel", (e) => {
   // if(mHtml.is(":animated")) return;
    if(e.originalEvent.deltaY > 0) {
        if(page == 4) return;
        page++;
    } else if(e.originalEvent.deltaY < 0) {
        if(page == 1) return;
        page--;
    }
    var posTop =(page-1) * $(window).height();
    mHtml.animate({scrollTop : posTop});
});