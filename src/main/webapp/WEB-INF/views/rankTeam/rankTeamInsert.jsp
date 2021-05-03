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
		<h2 class="mt-4">Insert Team Page</h2>
		<form id="frm" action="./rankTeamInsert" method="post">
			<div class="form-group">
				<input type="hidden" class="form-control etc" id="rankNum" name="rankNum">
			</div>
			<div class="form-group">
				<label for="team">팀 이름</label>
				<input type="text" class="form-control etc" id="team" name="team">
				<!-- 비어 있으면 X -->
			</div>
			<div class="form-group">
				<label for="gcnt_s">경기 수</label>
				<input type="number" class="form-control etc" id="gcnt_s" name="gcnt_s">
				<!-- 비어 있으면 X -->
			</div>
			<div class="form-group">
				<label for="wpnt">승리</label>
				<input type="number" class="form-control etc" id="wpnt" name="wpnt">
				<!-- 비어 있으면 X -->
			</div>
			<div class="form-group">
				<label for="lwpn">패배</label>
				<input type="number" class="form-control etc" id="lwpn" name="lwpn">
				<!-- 비어 있으면 X -->
			</div>
			<div class="form-group">
				<label for="dpnt">무승부</label>
				<input type="number" class="form-control etc" id="dpnt" name="dpnt">
				<!-- 비어 있으면 X -->
			</div>
			<div class="form-group">
				<label for="wnrt">승률</label>
				<input type="text" class="form-control etc" id="wnrt" name="wnrt">
				<!-- 비어 있으면 X -->
			</div>
			<div class="form-group">
				<label for="wlpnt">게임 차</label>
				<input type="text" class="form-control etc" id="wlpnt" name="wlpnt">
				<!-- 비어 있으면 X -->
			</div>
			<div class="form-group">
				<label for="streak">연속</label>
				<input type="text" class="form-control etc" id="streak" name="streak">
				<!-- 비어 있으면 X -->
			</div>
			<div class="form-group">
				<label for="onbase">출루율</label>
				<input type="text" class="form-control etc" id="onbase" name="onbase">
				<!-- 비어 있으면 X -->
			</div>
			<div class="form-group">
				<label for="slugging">장타율</label>
				<input type="text" class="form-control etc" id="slugging" name="slugging">
				<!-- 비어 있으면 X -->
			</div>
			<div class="form-group">
				<label for="lately">최근 10경기</label>
				<input type="text" class="form-control etc" id="lately" name="lately">
				<!-- 비어 있으면 X -->
			</div>
			<input type="submit" id="btn" value="등록" class="btn btn-primary">
		</form>
	</div>
</body>
</html>