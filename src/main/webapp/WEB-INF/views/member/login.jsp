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
</body>
	
<div class = "justify-content-center text-center mt-3 mb-3">

<h3>로그인 정보 입력</h3>

</div>

<div class="container">
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
	
	<div class="justify-content-end">
		<button type="submit" class="btn btn-primary" style="float:right">로그인</button>
	</div>

	
</form>
</div>
<c:import url="/WEB-INF/views/sample/footer.jsp"></c:import>
</html>