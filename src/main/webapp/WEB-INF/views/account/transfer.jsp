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

<h3>이체 정보 입력하기</h3>

</div>

<div class="container">
<form action="/account/transfer" method="post">

<div class="mb-3">
  <label for="formGroupExampleInput" class="form-label">내 잔액</label>
  <h3>${balance.balance}</h3>
  <input type="hidden" class="form-control" id="formGroupExampleInput" name ="balance" value="${balance.balance}">
</div>

<div class="mb-3">
  <input type="hidden" class="form-control" id="formGroupExampleInput" name ="bank_id" value="${balance.bank_id}">
</div>

<div class="mb-3">
  <label for="formGroupExampleInput" class="form-label">본인 계좌의 비밀번호를 입력하시오</label>
  <input type="text" class="form-control" id="formGroupExampleInput" name ="bank_pw">
</div>

<div class="mb-3">
  <label for="formGroupExampleInput" class="form-label">이체할 상대방의 계좌를 입력하시오</label>
  <input type="text" class="form-control" id="formGroupExampleInput" name ="account_u">
</div>

<div class="mb-3">
  <label for="formGroupExampleInput" class="form-label">이체할 금액을 입력하시오</label>
  <input type="text" class="form-control" id="formGroupExampleInput" name ="difference">
</div>

<button type = "submit" class="btn btn-primary">이체하기</button>
</form>
</div>

<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>