<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>

	<div class="container">
		<h2>KBO</h2>
		<h2>아이디 찾기</h2>
		<form action="./memberFindId" method="post">
			<div class="search">
				<label>이름</label>
				<input type="text" class="form-control"	id="name" name="name" required="required">
			</div>
			<div class="search">
				<label>이메일</label>
				<input type="text" class="form-control"	id="email" name="email" required="required">
			</div>
			<button type="submit" id="findId" class="btn btn-danger">FIND</button>
			<a href="${pageContext.request.contextPath}/member/memberLogin" class="btn btn-primary" role="button">로그인</a>
		</form>
	</div>
	<script type="text/javascript" src="../resources/jquery/memberFindId.js"></script>
</body>
</html>