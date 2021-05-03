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
		<h4>팀 순위</h4>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>순위</th>
					<th>팀</th>
					<th>경기 수</th>
					<th>승</th>
					<th>패</th>
					<th>무</th>
					<th>승률</th>
					<th>게임 차</th>
					<th>연속</th>
					<th>출루율</th>
					<th>장타율</th>
					<th>최근 10경기</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.rankNum}</td>
						<td>${dto.team}</td>
						<td>${dto.gcnt_s}</td>
						<td>${dto.wpnt}</td>
						<td>${dto.lwpn}</td>
						<td>${dto.dpnt}</td>
						<td>${dto.wnrt}</td>
						<td>${dto.wlpnt}</td>
						<td>${dto.streak}</td>
						<td>${dto.onbase}</td>
						<td>${dto.slugging}</td>
						<td>${dto.lately}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	<a href="./rankTeamInsert" class="btn btn-primary" role="button">등록</a>
	</div>
</body>
</html>