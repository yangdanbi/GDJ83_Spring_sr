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
	
<div class = "justify-content-center text-center mt-5 mb-5">

<h1>로그인 정보 입력</h1>

</div>

<form action="/member/login" method="post">
	<div class="mb-3">
		<label for="formGroupExampleInput" class="form-label">ID</label> 
		<input type="text" class="form-control" id="formGroupExampleInput" name="member_id" value="${id}">
	</div>
	<div class="mb-3">
		<label for="formGroupExampleInput2" class="form-label">PW</label> <input
			type="password" class="form-control" id="formGroupExampleInput2" name="member_pw">
	</div>
	
	<div class="mb-3 form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1" name="remember">
    <label class="form-check-label" for="exampleCheck1">ID기억하기</label>
  </div>
	
	
	<div class="col-12">
		<button type="submit" class="btn btn-primary">로그인</button>
	</div>
</form>



	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>