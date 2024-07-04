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

<h1>회원 가입 정보 입력</h1>

</div>

<form class="row g-3" action="/member/join" method="post">

  <div class="col-md-6">
    <label for="inputID" class="form-label">ID</label>
    <input type="text" class="form-control" id="inputEmail" name="member_id">
  </div>
  <div class="col-md-6">
    <label for="inputPassword" class="form-label">Password</label>
    <input type="password" class="form-control" id="inputPassword" name="member_pw">
  </div>
   <div class="col-md-6">
    <label for="inputName" class="form-label">이름</label>
    <input type="text" class="form-control" id="inputName" name="member_name">
  </div>
   <div class="col-md-6">
    <label for="inputPhone" class="form-label">전화번호</label>
    <input type="text" class="form-control" id="inputPhone" name="member_phone">
  </div>
  <div class="col-12">
    <label for="inputMail" class="form-label">E-mail</label>
    <input type="text" class="form-control" id="inputMail" name="member_mail">
  </div>

  <div class="col-12">
    <button type="submit" class="btn btn-primary">회원가입 하기</button>
  </div>
  
</form>



<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>