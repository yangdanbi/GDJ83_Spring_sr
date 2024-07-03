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

<div class ="text-center">
<h1>상품 수정 정보 입력</h1>
</div>

<form action="/product/update" method="post">
<input type="hidden" name = "item_id" value="${dto.item_id}">
<div>
<div class="mb-3">
  <label for="formGroupExampleInput" class="form-label">상품명</label>
  <input type="text" class="form-control" id="formGroupExampleInput" name = "item_name" value="${dto.item_name}" >
</div>
<div class="mb-3">
  <label for="formGroupExampleInput" class="form-label">상품설명</label>
  <input type="text" class="form-control" id="formGroupExampleInput" name = "item_detail" value="${dto.item_detail}">
</div>
<div class="mb-3">
  <label for="formGroupExampleInput" class="form-label">이자율</label>
  <input type="text" class="form-control" id="formGroupExampleInput" name ="item_rate" value="${dto.item_rate}">
</div>
</div>
<button type = "submit">수정하기</button>
</form>

<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>