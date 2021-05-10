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
					<th>타율</th>
					<th>경기 수</th>
					<th>타수</th>
					<th>안타</th>
					<th>2루타</th>
					<th>3루타</th>
					<th>홈런</th>
					<th>타점</th>
					<th>득점</th>
					<th>도루</th>
					<th>볼넷</th>
					<th>삼진</th>
					<th>출루율</th>
					<th>장타율</th>
					<th>OPS</th>
					<th>WAR</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.rankNum}</td>
						<td>${dto.player}</td>
						<td>${dto.batavg}</td>
						<td>${dto.gcnt_s}</td>
						<td>${dto.atbat}</td>
						<td>${dto.hit}</td>
						<td>${dto.sbh}</td>
						<td>${dto.tbh}</td>
						<td>${dto.homerun}</td>
						<td>${dto.rbi}</td>
						<td>${dto.hitball}</td>
						<td>${dto.score}</td>
						<td>${dto.steal}</td>
						<td>${dto.fourball}</td>
						<td>${dto.strikeout}</td>
						<td>${dto.onbase}</td>
						<td>${dto.slugging}</td>
						<td>${dto.ops}</td>
						<td>${dto.war}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	<a href="./rankBatterInsert" class="btn btn-primary" role="button">등록</a>
	</div>
</body>
</html>