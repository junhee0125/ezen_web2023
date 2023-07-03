/**
 *	누구를
 * 1. 조작 or ㅔ정할 html태그 객체호출
 */
//캐릭터영역
 let userbox = document.querySelector('.userbox');
 
 //어떻게: 키보드를 누를때
 /*
 userbox.addEventListener('keydown',()=>{
	
	console.log('키눌림')
	
}) */

let u_left = 50; //  userbox x의 좌표
let block
//key를 눌렀을때 이벤트
// e는  keydown의 상태를 저장하는 변수
document.body.addEventListener('keydown',(e)=>{
	//키다운때 콘솔확인	
	console.log('키눌림')
	//만일 방향키중 왼쪽키가 눌리면 
	if(e.keyCode == 37) {
		console.log('왼쪽으로 이동') // '왼쪽으로 이동' 콘솔에 출력
		u_left -= 10; // 케릭터영역의 x 좌표를 10차감
		
		//유효성검사 [배경 밖으로 못나가게...]
		if(u_left < 0 ) {u_left = 0;} //만일 0미만이 되면 0으로  세팅
		 
 	} else if(e.keyCode == 39){
	   console.log('오른쪽으로 이동')
	   u_left += 10;
	   if(u_left > 900 ) {u_left = 900;}
	    userbox.style.backgroundImage=`url(img/char_move.png)`; //오른쪽 방향으로 이동시 이미지변경
	    
	} else if(e.keyCode == 65) {//A 키를 눌렀을때
		console.log('공격!')
		userbox.style.backgroundImage=`url(img/char_attack.png)`;
		
	} 
	console.log(userbox.style.left);
	//3. 이동
	userbox.style.left = `${u_left}px`

})  // f end
 
 //2. 키를 누르고 떼었을때  = keyup
 document.body.addEventListener('keyup', (e)=>{
	 userbox.style.backgroundImage=`url(img/user01.png)`;
 })
 