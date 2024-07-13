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

<h3>상품 추가 정보 입력하기</h3>

</div>

<div class="container">
<form action="/product/add" method="post">
<div>
<div class="mb-3">
  <label for="formGroupExampleInput" class="form-label">상품명</label>
  <input type="text" class="form-control" id="formGroupExampleInput" name = "item_name">
</div>
<div class="mb-3">
  <label for="formGroupExampleInput" class="form-label">상품설명</label>
  <input type="text" class="form-control" id="formGroupExampleInput" name = "item_detail">
</div>
<div class="mb-3">
  <label for="formGroupExampleInput" class="form-label">이자율</label>
  <input type="text" class="form-control" id="formGroupExampleInput" name ="item_rate">
</div>
</div>
<button type = "submit" class="btn btn-primary">추가하기</button>
</form>
</div>

<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>