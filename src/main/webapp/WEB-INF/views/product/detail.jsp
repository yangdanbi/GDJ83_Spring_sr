<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>

		<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>

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
</div>
</div>


<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>