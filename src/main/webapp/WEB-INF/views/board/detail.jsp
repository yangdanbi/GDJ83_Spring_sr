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



<div class="container mt-3">
		<div class="mb-3">
		  <label for="exampleFormControlInput1" class="form-label disabled">작성자</label>
		  <input class="form-control" type="text" name="boardWriter" value="${dto.boardWriter}" readonly aria-label="input example">
		</div>
		<div class="mb-3">
		  <label for="exampleFormControlInput1" class="form-label">글제목</label>
		  <input type="text" class="form-control" id="exampleFormControlInput1" name="boardTitle" value="${dto.boardTitle}" readonly>
		</div>
		<div class="mb-3">
		  <label for="exampleFormControlTextarea1" class="form-label">글내용</label>
		  <textarea class="form-control" id="exampleFormControlTextarea1" rows="6" name="boardContents" readOnly>${dto.boardContents}</textarea>
		</div>
		<div align="right">
		<div class="col-8 mt-3">
		  <a href="./update?write=update&boardTitle=${dto.boardTitle}&boardContents=${dto.boardContents}&boardNum=${dto.boardNum}"><button type="submit" class="btn btn-primary">수정하기</button></a>
		  </div>
		<div class="col-8 mt-3">
		  <a href="./delete?boardNum=${dto.boardNum}"><button type="submit" class="btn btn-primary">삭제하기</button></a>
		  </div>
		  </div>	

</div>


<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>