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
		<div class="row justify-content-center">
		
		<c:if test="${not empty member}">
		<div class="justify-content-center text-center">
			<h3>🖤${member.member_name}님 환영합니다🖤</h3>
		</div>
		</c:if>
		
		<c:if test="${empty member}">
		<div class="justify-content-center text-center">
			<h3>🖤회원이시라면 로그인을, 아니라면 회원가입을 해주세요🖤</h3>
		</div>
		</c:if>
		
			<div id="carouselExampleFade" class="carousel slide col-md-8 carousel-fade mt-3">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="./resources/images/index/img1.png" class="d-block w-100" alt="...">
					</div>
					<div class="carousel-item">
						<img src="./resources/images/index/img2.png" class="d-block w-100" alt="...">
					</div>
					<div class="carousel-item">
						<img src="./resources/images/index/img3.png" class="d-block w-100" alt="...">
					</div>
					<div class="carousel-item">
						<img src="./resources/images/index/img4.png" class="d-block w-100" alt="...">
					</div>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleFade" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleFade" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>
		</div>


	</div>


<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>