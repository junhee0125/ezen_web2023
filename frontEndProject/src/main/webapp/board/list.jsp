<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 뷰포트 모바일에서의 적절한 반응형 동작을 위해 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<!-- 부트 스트랩 CSS적용 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
	<%@include file="../header.jsp" %>
	
	<!-- 
		css/js관련 라이버러리 제공 
		https://getbootstrap.kr/ 
		https://codepen.io/
		
	-->
	<div class="container"><!-- 현재 게시물출력 페이지 전체 구역 -->
		<h3> 커뮤니티 </h3>
		
		<!-- 버튼 -->
		<div class="row gy-5  my-3"><a href="write.jsp"><button type="button" class="btn btn-dark ">글쓰기</button></a></div>
		<!-- 게시판 테이블 시작 -->
		<table class="table table-striped table-hover text-center" >
			<thead class="table-dark">
				<tr >
					<th width="5%">번호</th> <th  width="55%">제목</th>  <th  width="10%">작성자</th>
					<th  width="10%">작성일</th> <th  width="5%">조회수</th> <th  width="5%">추천수</th>
				</tr>
			</thead>
			<tbody class="table-group-divider tcontent">
				<!-- 게시물 1개 행
				<tr>
					<td> 1 </td> <td> 게시물제목1 </td> <td> 유재석 </td>
					<td> 2023-07-06 </td> <td> 40 </td> <td> 2 </td>
				</tr>
				 -->
				
			</tbody>
			<tfoot class="total">
				<tr>
					<td colspan="6">total : 0</td>
				</tr>
			</tfoot>
		</table> <!-- 테이블 끝 -->
		
		<!-- 페이지네이션 시작 -->
		<nav aria-label="Page navigation example">
		  <ul class="pagination justify-content-center">
		    <li class="page-item disabled">
		      <a class="page-link">Previous</a>
		    </li>
		    <li class="page-item"><a class="page-link" href="#">1</a></li>
		    <li class="page-item"><a class="page-link" href="#">2</a></li>
		    <li class="page-item"><a class="page-link" href="#">3</a></li>
		    <li class="page-item">
		      <a class="page-link" href="#">Next</a>
		    </li>
		  </ul>
		</nav>
		<!-- 페이지네이션 끝 -->
		<!-- 검생 창 구역 -->
		<div class="row justify-content-md-center gx-1" >
			<div class="col-1" >
				<select class="form-select">
					<option>키워드</option>
					<option>번호</option>
					<option>제목</option>
					<<option>작성자</option>
				</select>
			</div>
			<div class="col-3"><input type="text" class="form-control" aria-label="First name"></div>
			<div class="col-1"><button class="form-control">검색</button></div>
		</div>
	</div>
	<%@include file="../footer.jsp" %>
<!-- 부트 스트랩 JS적용 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="../js/list.js" type="text/javascript"></script>	
</body>
</html>