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
					<th>선수</th>
					<th>방어율</th>
					<th>경기 수</th>
					<th>이닝</th>
					<th>승</th>
					<th>패</th>
					<th>세이브</th>
					<th>홀드</th>
					<th>탈삼진</th>
					<th>피안타</th>
					<th>피홈런</th>
					<th>실점</th>
					<th>볼넷</th>
					<th>사구</th>
					<th>WHIP</th>
					<th>WAR</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.rankNum}</td>
						<td>${dto.player}</td>
						<td>${dto.era}</td>
						<td>${dto.gcnt_s}</td>
						<td>${dto.inning}</td>
						<td>${dto.wpnt}</td>
						<td>${dto.lwpn}</td>
						<td>${dto.save}</td>
						<td>${dto.hold}</td>
						<td>${dto.strikeout}</td>
						<td>${dto.hit}</td>
						<td>${dto.homerunball}</td>
						<td>${dto.losepoint}</td>
						<td>${dto.fourball}</td>
						<td>${dto.deadball}</td>
						<td>${dto.whip}</td>
						<td>${dto.war}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	<a href="./rankPitcherInsert" class="btn btn-primary" role="button">등록</a>
	</div>
</body>
</html>