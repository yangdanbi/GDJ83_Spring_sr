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

<div>
<h1>내 정보 수정하기</h1>
</div>

<form action="/member/update" method="post">
<div>
   <div class="col-12">
    <label for="inputName" class="form-label">이름</label>
    <input type="text" class="form-control" id="inputName" name="member_name" value="${member.member_name}">
  </div>
   <div class="col-12">
    <label for="inputPhone" class="form-label">전화번호</label>
    <input type="text" class="form-control" id="inputPhone" name="member_phone" value="${member.member_phone}">
  </div>
  <div class="col-12">
    <label for="inputMail" class="form-label">E-mail</label>
    <input type="text" class="form-control" id="inputMail" name="member_mail" value="${member.member_mail}">
  </div>
  
  <div class="col-12">
    <a href="/member/update"><button class="btn btn-primary" type="submit">수정하기</button></a>
  </div>
 
</div>
</form>

<div>
<form action="/member/delete" method="post">

<button class="btn btn-primary" type="submit" >탈퇴하기</button>

</form>
</div>


<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>