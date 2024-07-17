<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>


<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./sample/header_css.jsp"></c:import>
</head>
<body style="background-image: url("background-img.png")">

<c:import url="./sample/topheader.jsp"></c:import>

</body>

 
<section id="categories">
	<div class="container my-3 py-6" >
		<div class="row my-5">
			<div class="col text-center">
				<a href="/" class="categories-item"> <iconify-icon
						class="category-icon" icon="ph:bird"></iconify-icon>
					<h5></h5>
				</a>
			</div>
			<div class="col text-center">
				<a href="#" class="categories-item"> <iconify-icon
						class="category-icon" icon="ph:dog"></iconify-icon>
					<h5></h5>
				</a>
			</div>
			<div class="col text-center">
				<a href="#" class="categories-item"> <iconify-icon
						class="category-icon" icon="ph:fish"></iconify-icon>
					<h5></h5>
				</a>
			</div>
			<div class="col text-center">
				<a href="#" class="categories-item"> <iconify-icon
						class="category-icon" icon="ph:cat"></iconify-icon>
					<h5></h5>
				</a>
			</div>
		</div>
	</div>
</section>


<c:import url="./sample/footer.jsp"></c:import>
</html>