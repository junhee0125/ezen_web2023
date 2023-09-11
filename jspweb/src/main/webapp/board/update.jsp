<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판수정</title>



<!-- 부트스트랩에서 만든 CSS 적용 -->
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
   <!-- 썸머노트 css 적용 - 부트스트랩v5 -->
   <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/summernote-lite.min.css" rel="stylesheet">

<link href="../css/board/list.css"  rel="stylesheet">
<link href="../css/board/write.css"  rel="stylesheet">
<link href="../css/board/update.css"  rel="stylesheet">

</head>
<body>
<%@include file="../header.jsp" %>
<div class="webcontainer">
<h2  class="boardCategory">상세보기</h2>

 <form class="writeForm"> <!-- 쓰기 입력 구역 -->
    카테고리 : <select name="bcno" class="bcno">
                <!-- 게시물에 저장되는 카테고리정보는 카테고리이름X 카테고리번호 [FK] -->
                <option value="1"> 공지사항 </option>
                <option value="2"> 자유게시판 </option>
                <option value="3"> 노하우 </option>
            </select>   <br/>
    제목 : <input type="text" name="btitle" class="btitle" > <br/>
    내용 : <textarea name="bcontent" id="summernote"  class="bcontent"></textarea> <br/>
    <div class="oldfile"></div>
    첨부파일 : <input type="file" name="bfile" class="bfile"> <br/>
   <div class="btnBox">
        <button onclick="onUpdate()" type="button">글등록</button>
        <button onclick="onList()" type="button">목록보기</button>
        <button type="reset" >다시쓰기</button>
    </div>
</form>






</div>
<!-- 최신 JQUERY import ( ajax() 사용할 js파일부터 위에서 호출)  -->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- 부트스트랩에서 만든 JS 적용 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<!-- 썸머노트 js 적용 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/summernote-lite.min.js"></script>
<!-- 썸머노트 한글적용  -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/lang/summernote-ko-KR.min.js"></script>

<script src="../js/board/update.js"></script>

</body>
</html>