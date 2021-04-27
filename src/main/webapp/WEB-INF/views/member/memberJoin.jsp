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

	<div class="container mt-2">
		<h2 class="mt-4">회원가입</h2>
		<form id="frm" action="./memberJoin" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="id">ID</label>
				<input type="text" class="form-control" id="id" name="id">
				<button type="button" class="btn btn-secondary" id="idCheck">중복검사</button>
				<h4 id="idResult"></h4>
				<h4 id="idCheckResult"></h4>
				<!-- ID는 6글자 이상 -->
			</div>
			<div class="form-group">
				<label for="pw">Password</label>
				<input type="password" class="form-control" id="pw" name="pw1">
				<h4 id="pwResult"></h4>
				<!-- PW는 8글자 이상 -->
			</div>
			<div class="form-group">
				<label for="pw">Password</label>
				<input type="password" class="form-control" id="pw2" name="pw">
				<!-- PW 두 개는 일치 -->
			</div>
			<div class="form-group">
				<label for="name">Name</label>
				<input type="text" class="form-control etc" id="name" name="name">
				<!-- 비어 있으면 X -->
			</div>
			<div class="form-group">
				<label for="email">Email</label>
				<input type="text" class="form-control etc" id="email" name="email">
				<!-- 비어 있으면 X -->
			</div>
			<div class="form-group">
				<label for="phone">Phone</label>
				<input type="text" class="form-control etc" id="phone" name="phone">
				<!-- 비어 있으면 X -->
			</div>
			<select name="favoriteTeam" class="form-group">
				<option selected>선호 구단을 선택하세요</option>
				<option value="nc">NC 다이노스</option>
				<option value="doosan">두산 베어스</option>
				<option value="kt">kt 위즈</option>
				<option value="lg">LG 트윈스</option>
				<option value="kiwoom">키움 히어로즈</option>
				<option value="kia">KIA 타이거즈</option>
				<option value="lotte">롯데 자이언츠</option>
				<option value="samsung">삼성 라이온즈</option>
				<option value="ssg">SSG 랜더스</option>
				<option value="hanwha">한화 이글스</option>
			</select>
			<input type="submit" value="JOIN" class="btn btn-primary">
		</form>
	</div>
	<script type="text/javascript" src="../resources/jquery/memberJoin.js"></script>
</body>
</html>