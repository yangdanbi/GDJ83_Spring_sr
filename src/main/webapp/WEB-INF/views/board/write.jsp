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

<c:choose>
	<c:when test="${write=='add'}">
	<div class = "justify-content-center text-center mt-3 mb-3">
	
	<c:choose>
		<c:when test="${reply=='reply'}">
			<h3>${board} 답글 작성하기</h3>
		</c:when>
		<c:otherwise>
			<h3>${board} 새 글 작성하기</h3>
		</c:otherwise>
	</c:choose>



</div>
<div class="container text-left">
		<form method ="post">
		<input type="hidden" value="${boardDTO.boardNum}" name="boardNum">
		<div class="mb-3">
		  <label for="exampleFormControlInput1" class="form-label disabled">작성자</label>
		  <input class="form-control" type="text" name="boardWriter" value="${member.member_id}" readonly aria-label="input example">
		</div>
		<div class="mb-3">
		  <label for="exampleFormControlInput1" class="form-label">글제목</label>
		  <input type="text" class="form-control" id="exampleFormControlInput1" name="boardTitle">
		</div>
		<div class="mb-3">
		  <label for="exampleFormControlTextarea1" class="form-label">글내용</label>
		  <textarea class="form-control" id="exampleFormControlTextarea1" rows="6" name="boardContents"></textarea>
		</div>
		  <div class="col-8 mt-3">
		  <button type="submit" class="btn btn-primary">작성하기</button>
		  </div>
		</form>
		</div>
	</c:when>


	<c:otherwise>
	<div class = "justify-content-center text-center mt-3 mb-3">

<h3>글 수정하기</h3>

</div>
<div class="container">
	<form method="post">
	<input type="hidden" name="boardNum" value="${dto.boardNum}">
		<div class="mb-3">
		  <label for="exampleFormControlInput1" class="form-label">글제목</label>
		  <input type="text" class="form-control" id="exampleFormControlInput1" name="boardTitle" value="${dto.boardTitle}">
		</div>
		<div class="mb-3">
		  <label for="exampleFormControlTextarea1" class="form-label">글내용</label>
		  <textarea class="form-control" id="exampleFormControlTextarea1" rows="6" name="boardContents">${dto.boardContents}</textarea>
		</div>
		<div class="col-8 mt-3">
		  <button type="submit" class="btn btn-primary">수정하기</button>
		  </div>	
	</form>	
	</div>
	</c:otherwise>
</c:choose>



<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>