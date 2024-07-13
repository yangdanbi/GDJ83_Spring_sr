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

<h3>마이페이지</h3>

</div>

<div class="container">


  <div class="col-12">
    <label for="inputID" class="form-label">ID</label>
    <input type="text" class="form-control" id="inputEmail" name="member_id" value="${member.member_id}" readonly>
  </div>
   <div class="col-12">
    <label for="inputName" class="form-label">이름</label>
    <input type="text" class="form-control" id="inputName" name="member_name" value="${member.member_name}" readonly>
  </div>
   <div class="col-12">
    <label for="inputPhone" class="form-label">전화번호</label>
    <input type="text" class="form-control" id="inputPhone" name="member_phone" value="${member.member_phone}" readonly>
  </div>
  <div class="col-12">
    <label for="inputMail" class="form-label">E-mail</label>
    <input type="text" class="form-control" id="inputMail" name="member_mail" value="${member.member_mail}" readonly>
  </div>
  
  <div class="col-12 mt-3">
    <a href="/member/update"><button class="btn btn-primary">회원정보 수정하기</button></a>
  </div>
  </div>
  

  <div class="container mt-3 text-center">
  	<h3>🌟내가 가입한 상품🌟</h3>
  </div>
  

  <div class ="container mt-5 justify-content-center text-center">
<table class="table table-hover mt-3">

	<thead>
	
		<tr>
			<td>계좌번호</td>
			<td>잔액</td>
		</tr>
	</thead>
	<tbody>
  		<c:forEach items="${member.dtos}" var="ac">
		<tr>
		
			<td><a href="../account/detail?bank_id=${ac.bank_id}">${ac.bank_id}</a></td>
			<td> ${ac.balance}</td>

		
		</tr>	
			</c:forEach>
	</tbody>


</table>  

</div>








<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>