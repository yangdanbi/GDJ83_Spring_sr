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

<h3>Join</h3>

</div>

<div class="container">
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
    <label for="inputName" class="form-label">Name</label>
    <input type="text" class="form-control" id="inputName" name="member_name">
  </div>
   <div class="col-md-6">
    <label for="inputPhone" class="form-label">Phone-Number</label>
    <input type="text" class="form-control" id="inputPhone" name="member_phone">
  </div>
  <div class="col-12">
    <label for="inputMail" class="form-label">E-mail</label>
    <input type="text" class="form-control" id="inputMail" name="member_mail">
  </div>

  <div class="col-12">
    <button type="submit" class="btn btn-primary">Join</button>
  </div>
  
</form>
</div>

<c:import url="/WEB-INF/views/sample/footer.jsp"></c:import>
</html>