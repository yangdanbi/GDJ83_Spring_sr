<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/sample/header_css.jsp"></c:import>
</head>
<body style="background-image: url('/resources/images/background-img.png')">
<c:import url="/WEB-INF/views/sample/topheader.jsp"></c:import>


  <div class="col-12">
    <button type="button" class="btn btn-primary" id="add">파일추가</button>
  </div>

  <div id="result">

  </div>



<c:import url="/WEB-INF/views/sample/footer.jsp"></c:import>
</body>
<script type="text/javascript" src="/resources/js/commons/files.js"></script>

<script>
    setMax(5);
</script>

</html>