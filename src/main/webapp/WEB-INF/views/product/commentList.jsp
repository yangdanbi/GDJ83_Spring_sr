<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/sample/header_css.jsp"></c:import>
</head>

<div class="container mt-5 justify-content-center text-center">


	<table class="table table-hover">

		<thead>

			<tr>
				<td>댓글번호</td>
				<td>내용</td>
				<td>작성자</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="ar" varStatus ="i">
				<tr>
					<td >${ar.boardNum}</td>
					<td id="con${i.index}">${ar.boardContents}</td>
					<td>${ar.boardWriter}</td>
					<td>
						<c:if test="${ar.boardWriter eq member.member_id}">
							<button type="button" class= "btn btn-primary dels" data-del-id="${ar.boardNum}" >
								X
							</button>
						</c:if>
					</td>
					<td>
						<c:if test="${ar.boardWriter eq member.member_id}">
							<button type="button" class= "btn btn-primary ups" data-del-id="${ar.boardNum}" data-update-con="con${i.index}"  data-bs-toggle="modal" data-bs-target="#commentModal">
								수정
							</button>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>


	</table>
		<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">

			<li class="page-item ${pager.pre?'':'disabled'}">
				<a class="page-link pn" data-page-num="${pager.startNum-1}" href="#" aria-label="Previous"> 
					<span aria-hidden="true">&laquo;</span>
				</a>
			</li>

			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" step="1"
				var="i">
				<li class="page-item"><a class="page-link pn" data-page-num="${i}"
					href="#">${i}</a></li>
			</c:forEach>

			<li class="page-item ${pager.next?'':'disabled'}">
			<a class="page-link pn" data-page-num="${pager.lastNum+1}" href="#"
				aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
	</nav>

</div>
<c:import url="/WEB-INF/views/sample/footer.jsp"></c:import>
</html>