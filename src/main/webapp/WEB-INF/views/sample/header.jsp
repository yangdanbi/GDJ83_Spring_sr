<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar justify-content-center" style="background-color: #FFD9E9;">
  <ul class="nav nav-underline">
    <li class="nav-item">
    <a class="nav-link" aria-current="page" href="/">HOME</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" aria-current="page" href="/product/list">금융상품</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="/notice/list">공지사항</a>

<c:if test="${empty member}">	
  <li class="nav-item">
    <a class="nav-link" href="/member/join">회원가입</a>
  </li>
    <li class="nav-item">
    <a class="nav-link" href="/member/login">로그인</a>
  </li>
</c:if>
<c:if test="${not empty member}">
  <li class="nav-item">
    <a class="nav-link" href="/member/mypage">마이페이지</a>
  </li>
    <li class="nav-item">
    <a class="nav-link" href="/member/logout">로그아웃</a>
  </li>
  </c:if>
</ul>
</nav>

<%-- 

<c:choose>


	<c:when test=""></c:when>
	<c:when test=""></c:when>
	<c:otherwise></c:otherwise>


</c:choose>

 --%>