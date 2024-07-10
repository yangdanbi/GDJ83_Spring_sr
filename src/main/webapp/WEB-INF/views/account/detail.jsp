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

<h1>해당 상품 정보 확인하기</h1>
<h3>가입자명 : ${member.member_name}</h3>
<h3>개설일 : ${acinfo.open_date}</h3>
<h3>계좌번호 : ${acinfo.bank_id}</h3>
<h3>상품명 : ${acinfo.productDTO.item_name}</h3>
<h3>상품내용 : ${acinfo.productDTO.item_detail}</h3>
<h3>이자율 : ${acinfo.productDTO.item_rate}</h3>
<h3>잔액 : ${acinfo.balance}</h3>

<div>
<a href="./transfer?bank_id=${acinfo.bank_id}&balance=${acinfo.balance}">이체</a>
<a href="./list?bank_id=${acinfo.bank_id}&order=0&view=0">이체 내역 조회</a>
</div>

<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>