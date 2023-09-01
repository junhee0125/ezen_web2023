/**
 *
 */
console.log('hrm js 연결')
function save(){
	console.log('save() 시작')

	//  form가져오기
	let hrmForm = document.querySelectorAll('.hrmForm')[0];

	// form 정보 객체화
	let hrmData = new FormData(hrmForm);
	console.log(hrmData);
	//let selectedValue = mySelect.options[mySelect.selectedIndex].value;
	// formData.append("selectedValue", selectedValue);

//	for (let pair of hrmData.entries()) {
//		  console.log(pair[0] + ": " + pair[1]);
//		}
	let hrank = document.querySelector('.hrank');

	//selected된  옵션의 value가져오기
	let hrankValue = hrank.options[hrank.selectedIndex].value;
	hrmData.append("hrank",hrankValue);
	console.log('hrank :: ' + hrankValue);

	//ajax호출
	$.ajax({
		url:"/jspweb/HrmController",
		method:"post",
		data:hrmData,
		contentType:false,
		processData:false,
		success:r=>{
			console.log('성공 >>' + r )
			if(r){
				alert('직원정보가 등록 되었습니다.')
				location.href='/jspweb/hrm/hrmList.jsp';

			} else{

			}

		},
		error:e=>{ console.log(' error >> ' + e)}
	});
}

//사진 미리보기
function preimg(object){
	console.log('preimg');
	let file = new FileReader(); //파일읽기
	file.readAsDataURL(object.files[0]);

	//읽어온 파일을 화면에 load하기
	file.onload = e=>{
		//img src 속성에 대입
		document.querySelector('.preimg').src = e.target.result
	}
}
