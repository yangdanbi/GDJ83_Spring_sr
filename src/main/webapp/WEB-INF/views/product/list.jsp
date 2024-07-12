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


<div class ="container mt-5 justify-content-center text-center">
<!--검색어 입력 폼-->

	<form action="./list" method="get" class="row row-cols-lg-auto g-3 align-items-center">
  
  <div class="col-12">
    <label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
    <select name = "kind" class="form-select" id="inlineFormSelectPref">
      <option value="k1">상품명</option>
      <option value="k2">상품내용</option>
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





<table class="table table-hover">

	<thead>
	
		<tr>
			<td>상품번호</td>
			<td>상품명</td>
			<td>상품설명</td>
			<td>이자율</td>
		</tr>
	</thead>
	<tbody>
			<c:forEach items="${map.list}" var="ar">
		<tr>
		
			<td>${ar.item_id}</td>
			<td><a href="./detail?item_id=${ar.item_id}">${ar.item_name}</a></td>
			<td>${ar.item_detail}</td>
			<td>${ar.item_rate}</td>
		
		</tr>	
			</c:forEach>
	</tbody>


</table>
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

</div>



<div>

	<a href="/product/add"><button>상품 추가</button></a>

</div>





<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>