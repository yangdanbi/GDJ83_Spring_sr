<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>지역 상세 페이지</h1>

<h3>${requestScope.dto.location_id}</h3>
<h3>${requestScope.dto.street_address}</h3>
<h3>${requestScope.dto.postal_code}</h3>
<h3>${requestScope.dto.city}</h3>
<h3>${requestScope.dto.state_province}</h3>
<h3>${requestScope.dto.country_id}</h3>

</body>
</html>