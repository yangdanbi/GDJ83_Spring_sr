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
<!-- summer가 jquery 를 이용해서 만든거라 jquery 먼저 임포트 시킴 -->
<c:import url="/WEB-INF/views/sample/topheader.jsp"></c:import>
<c:import url="/WEB-INF/views/sample/summer.jsp"></c:import>
<div class = "justify-content-center text-center mt-3 mb-3">

  <h3>상품 추가 정보 입력하기</h3>
  
  </div>
  
  <div class="container">
  <form action="/product/add" method="post" enctype="multipart/form-data">
  <div>
  <div class="mb-3">
    <label for="formGroupExampleInput" class="form-label">상품명</label>
    <input type="text" class="form-control" id="formGroupExampleInput" name = "item_name">
  </div>
  <div class="mb-3">
    <label for="formGroupExampleInput" class="form-label">상품설명</label>
    <textarea rows="" cols="" id="item_detail" name = "item_detail" class="form-control" ></textarea>
  
  </div>
  <div class="mb-3">
    <label for="formGroupExampleInput" class="form-label">이자율</label>
    <input type="text" class="form-control" id="formGroupExampleInput" name ="item_rate">
  </div>
  </div>
  <div class="col-12">
    <button type="button" class="btn btn-primary" id="add">파일추가</button>
  </div>

  <div id="result">

  </div>
  <button type = "submit" class="btn btn-primary mt-3">추가하기</button>
  </form>
  </div>





<c:import url="/WEB-INF/views/sample/footer.jsp"></c:import>
</body>
<script type="text/javascript" src="/resources/js/commons/files.js"></script>


<script>
    setMax(5);
    $("#item_detail").summernote();
</script>

</html>