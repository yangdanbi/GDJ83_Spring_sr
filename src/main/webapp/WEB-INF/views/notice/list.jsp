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

<div class = "justify-content-center text-center mt-3">
<h3>~ 공지사항 게시판 ~</h3>
</div>


<div class ="container mt-5 justify-content-center text-center">


<table class="table table-hover">

	<thead>
	
		<tr>
			<td>글번호</td>
			<td>글제목</td>
			<td>작성자</td>
			<td>작성일자</td>
			<td>조회수</td>
		</tr>
	</thead>
	<tbody>
			<c:forEach items="${map.list}" var="ar">
		<tr>
		
			<td>${ar.item_id}</td>
			<td><a href="">${ar.item_id}</a></td>
			<td>${ar.item_id}</td>
			<td>${ar.item_detail}</td>
			<td>${ar.item_rate}</td>
		
		</tr>	
			</c:forEach>
	</tbody>


</table>

<!--페이지 버튼-->
<nav aria-label="Page navigation example">
  <ul class="pagination">

    <li class="page-item ${map.pre?'':'disabled'}">
      <a class="page-link" href="./list?page=${map.startNum-1}&kind=${map.kind}&search=${map.search}" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>

	<c:forEach begin="${map.startNum}" end="${map.lastNum}" step="1" var="i">
    <li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${map.kind}&search=${map.search}">${i}</a></li>
	</c:forEach>
	
    <li class="page-item ${map.next?'':'disabled'}">
      <a class="page-link" href="./list?page=${map.lastNum+1}&kind=${map.kind}&search=${map.search}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>

<!--검색 폼-->
	<form action="./list" method="get" class="row row-cols-lg-auto g-3 align-items-center">
  
  <div class="col-12">
    <label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
    <select name = "kind" class="form-select" id="inlineFormSelectPref">
      <option value="k1">제목</option>
      <option value="k2">내용</option>
      <option value="k3">작성자</option>
    </select>
  </div>
  
  <div class="col-12">
    <label class="visually-hidden" for="inlineFormInputGroupUsername"></label>
    <div class="input-group">
      <input name = "search" type="text" class="form-control" id="inlineFormInputGroupUsername" placeholder="검색어를 입력하세요">
    </div>
  </div>


  <div class="col-12">
    <button type="submit" class="btn btn-primary">검색하기</button>
  </div>
</form>


  <div class="col-8 mt-3">
    <a href="./add"><button type="submit" class="btn btn-primary">글쓰기</button></a>
  </div>

</div>


<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>