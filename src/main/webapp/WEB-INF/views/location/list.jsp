<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<h1>지역 리스트</h1>

<div>

	<table class="table table-bordered border-primary text-center">
	
		<thead>
		
			<tr class="table-danger">
				<th>지역 번호</th>
				<th>지번 주소</th>
				<th>우편 번호</th>
				<th>도시 이름</th>
				<th>주 이름</th>
				<th>나라 번호</th>
			</tr>
		
		</thead>
		
		<tbody>
		
		<c:forEach items="${requestScope.list}" var ="dto">
		
			<tr>
			
				<td>${pageScope.dto.location_id}</td>
				<td><a href="./detail?location_id=${pageScope.dto.location_id}">${pageScope.dto.street_address}</a></td>
				<td>${pageScope.dto.postal_code}</td>
				<td>${pageScope.dto.city}</td>
				<td>${pageScope.dto.state_province}</td>
				<td>${pageScope.dto.country_id}</td>
			
			</tr>
		
		
		
		</c:forEach>
		
		
		</tbody>
	
	</table>
	
			<div>
		
			<a class="btn btn-danger" href="./add" role="button">지역등록</a>
		
		</div>

</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>

</body>
</html>