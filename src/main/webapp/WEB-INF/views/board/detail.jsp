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
<body>

<c:import url="/WEB-INF/views/sample/topheader.jsp"></c:import>
	<div class = "justify-content-center text-center mt-3 mb-3">
		<h3>${board} 글</h3>
	</div>
	
	<div class ="container mt-5 justify-content-center text-center">


<table class="table table-hover">

	<thead>
	
		<tr>
			<td>글번호</td>
			<td>글제목</td>
			<td>작성자</td>
			<td>작성일자</td>
			<td>수정일자</td>
			<td>조회수</td>
		</tr>

	</thead>
	<tbody>
		<tr>
			<td>${dto.boardNum}</td>
			<td>${dto.boardTitle}</td>
			<td>${dto.boardWriter}</td>
			<td>${dto.createDate}</td>
			<td>${dto.updateDate}</td>
			<td>${dto.boardHit}</td>
		</tr>
	</tbody>


</table>

	
		<div>
		  <label for="exampleFormControlTextarea1" class="form-label"></label>
		  <textarea class="form-control" id="exampleFormControlTextarea1" rows="6" name="boardContents" readOnly>${dto.boardContents}</textarea>
		</div>
		<div align="right">
		<c:if test="${board=='QnA'}">
		<div class="col-8 mt-3">
		  <a href="./reply?boardNum=${dto.boardNum}"><button type="submit" class="btn btn-primary">답글달기</button></a>
		  </div>
		  </c:if>
		  
		  <c:if test="${member.member_id==dto.boardWriter}">
		<div class="col-8 mt-3">
		  <a href="./update?write=update&boardNum=${dto.boardNum}"><button type="submit" class="btn btn-primary">수정하기</button></a>
		  </div>
		<div class="col-8 mt-3">
		  <a href="./delete?boardNum=${dto.boardNum}"><button type="submit" class="btn btn-primary">삭제하기</button></a>
		  </div>
		</c:if>
		</div>
</div>

<c:import url="/WEB-INF/views/sample/footer.jsp"></c:import>
</html>