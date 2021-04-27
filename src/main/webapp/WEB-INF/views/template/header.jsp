<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark nav nav justify-content-end bg-light">
		<!-- Links -->
		<ul class="navbar-nav">
			<c:if test="${empty member}">
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/member/memberLogin">Login</a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/member/memberJoinCheck">Join</a></li>
			</c:if>
			<c:if test="${not empty member}">
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/member/memberPage">Page</a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/member/memberLogout">Logout</a></li>
			</c:if>
		</ul>
	</nav>