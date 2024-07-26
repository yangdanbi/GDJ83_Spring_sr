<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/sample/header_css.jsp"></c:import>
</head>
<body style="background-image: url('/resources/images/background-img.png')">
<c:import url="/WEB-INF/views/sample/topheader.jsp"></c:import>

<div class = "justify-content-center text-center mt-3 mb-3">

<h3>${requestScope.dto.item_name} 상품 설명</h3>

</div>

<div class ="container mt-5 justify-content-center text-center">

<table class="table table-hover">

	<thead>
	
		<tr>
			<td>상품명</td>
			<td>상품설명</td>
			<td>이자율</td>
		</tr>

	</thead>
	<tbody>
			
		<tr>
		
			<td>${dto.item_name}</td>
			<td>${dto.item_detail}</td>
			<td>${dto.item_rate}</td>
		
		</tr>	

	</tbody>


</table>

<div align="left">
	<c:forEach items="${dto.productFileDTO}" var="f">
		<a href="/resources/upload/products/${f.fileName}">${f.oriName}</a>
	</c:forEach>
</div>
<div>
	<!-- Button trigger modal -->
	<button type="button" id="openModal" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#commentModal">
		댓글 입력
  	</button>

		<!-- 댓글 모달-->
		<div>
			<!-- Modal -->
			<div class="modal fade" id="commentModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
					<h1 class="modal-title fs-5" id="exampleModalLabel">comment</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<div class="mb-3">
							<textarea class="form-control" id="commentContents" rows="3"></textarea>
						  </div>
					</div>
					<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-bs-dismiss="modal" id="commentClose">Close</button>
					<button type="button" class="btn btn-primary" id="commentButton" data-id="${dto.item_id}">Save</button>
					</div>
				</div>
				</div>
			</div>
		</div>
  
	<!-- <textarea id="commentContents">

	</textarea>

	<button id="commentButton">댓글</button> -->

	<!-- 댓글 목록-->
	<div id="commentList">
		

	</div>



 </div>

</div>



<div class="container">

<div align="right">
<div class="mb-2">

	<a href="/account/add?item_id=${dto.item_id}"><button class="btn btn-primary">상품가입</button></a>
	
</div>



<div class="mb-2">

	<a href="./update?item_id=${dto.item_id}"><button class="btn btn-primary">수정하기</button></a>
	
</div>



<div class="mb-2">

	<a href="./delete?item_id=${dto.item_id}"><button class="btn btn-primary">삭제하기</button></a>
	
</div>

<div class="mb-2">

	<button type="button" class="btn btn-primary" id="addWish" data-product-id="${dto.item_id}">관심목록추가</button>
	
</div>

</div>
</div>

<div id="wishResult">

</div>


<c:import url="/WEB-INF/views/sample/footer.jsp"></c:import>
<script src="/resources/js/product/wish.js"></script>
<script src="/resources/js/commons/comment.js"></script>
</body>
</html>