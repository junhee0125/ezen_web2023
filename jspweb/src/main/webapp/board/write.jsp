<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/board/list.css"  rel="stylesheet">
<link href="../css/board/write.css"  rel="stylesheet">

</head>
<body>
<%@include file="../header.jsp" %>
<div class="webcontainer">
    <h2  class="boardCategory">게시물작성</h2>

    <form class="writeForm"> <!-- 쓰기 입력 구역 -->
            카테고리 : <select name="bcno" class="bcno">
                        <!-- 게시물에 저장되는 카테고리정보는 카테고리이름X 카테고리번호 [FK] -->
                        <option value="1"> 공지사항 </option>
                        <option value="2"> 자유게시판 </option>
                        <option value="3"> 노하우 </option>
                    </select>   <br/>
            제목 : <input type="text" name="btitle" class="btitle" > <br/>
            내용 : <textarea name="bcontent" class="bcontent"></textarea> <br/>
            첨부파일 : <input type="file" name="bfile" class="bfile"> <br/>
           <div class="btnBox">
                <button onclick="bWrite()" type="button">글등록</button>
                <button onclick="bList()" type="button">목록보기</button>
                <button type="reset" >다시쓰기</button>
            </div>
        </form>


</div>
<script src="../js/board/write.js"></script>

</body>
</html>