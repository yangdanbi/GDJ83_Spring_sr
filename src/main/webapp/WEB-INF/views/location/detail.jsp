<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<h1>지역 상세 페이지</h1>

<h3>${requestScope.dto.location_id}</h3>
<h3>${requestScope.dto.street_address}</h3>
<h3>${requestScope.dto.postal_code}</h3>
<h3>${requestScope.dto.city}</h3>
<h3>${requestScope.dto.state_province}</h3>
<h3>${requestScope.dto.country_id}</h3>

<div>
<a href="./delete?location_id=${requestScope.dto.location_id}" class="btn btn-outline-dark" role="button">삭제</a>
</div>

<div>
<a href="./update?location_id=${requestScope.dto.location_id}" class="btn btn-outline-dark" role="button">수정</a>
</div>


<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>