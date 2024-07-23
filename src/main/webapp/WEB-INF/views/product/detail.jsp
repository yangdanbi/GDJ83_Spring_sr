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
</body>
</html>