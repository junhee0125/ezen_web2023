<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

   <link href="library.css" rel="stylesheet">
</head>
<body>
   <%@ include file="../header.jsp" %>
   <div class="wrap">   
      <h3>도서관 열람실 좌석 현황</h3>
      <div class="seat_table">
         <span class="button_box">   
               <button class="button" onclick="setSeatno(1)" type="button"> 1 </button>
               <button class="button" onclick="setSeatno(2)" type="button"> 2 </button>
               <button class="button" onclick="setSeatno(3)" type="button"> 3 </button>
               <button class="button" onclick="setSeatno(4)" type="button"> 4 </button><br/>                              
               <button class="button" onclick="setSeatno(5)" type="button"> 5 </button>
               <button class="button" onclick="setSeatno(6)" type="button"> 6 </button>
               <button class="button" onclick="setSeatno(7)" type="button"> 7 </button>
               <button class="button" onclick="setSeatno(8)" type="button"> 8 </button>   
         </span>
         <span class="input_box">
            <input class="name" type="text" placeholder="이름"/>
            <input class="phonenumber" type="text" placeholder="전화번호"/>
         </span>
      </div>
      <div class="botton_table">   
         <div>현재 선택된 좌석 번호 : <span class="ch_num"></span></div>
         <div class="room_button">
            <button class="getIn" onclick = "checkIn()" type="button">입실</button>
            <button class="getOut"  onclick = "checkOut()"  type="button">퇴실</button>
         </div>
      </div>
      
   </div>







   <script src="library.js" type="text/javascript"></script>
</body>
</html>