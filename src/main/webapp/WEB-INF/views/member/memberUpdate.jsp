<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member Update</h1>
	
	<form action = "./memberUpdate" method="post">
		ID <input type="text" name="id" readonly="readonly" value="${member.id}"><br>
		PW <input type="password" name="pw" value="${member.pw}"><br>
		Name <input type="text" name="name" value="${member.name}"><br>
		Phone <input type="text" name="phone" value="${member.phone}"><br>
		Email <input type="text" name="email" value="${member.email}"><br>
		FavoriteTeam <select name="favoriteTeam" class="form-group">
				<option selected>선호 구단을 선택하세요</option>
				<option value="두산 베어스">두산 베어스</option>
				<option value="LG 트윈스">LG 트윈스</option>
				<option value="키움 히어로즈">키움 히어로즈</option>
				<option value="SSG 랜더스">SSG 랜더스</option>
				<option value="kt 위즈">kt 위즈</option>
				<option value="한화 이글스">한화 이글스</option>
				<option value="삼성 라이온즈">삼성 라이온즈</option>
				<option value="NC 다이노스">NC 다이노스</option>
				<option value="롯데 자이언츠">롯데 자이언츠</option>
				<option value="KIA 타이거즈">KIA 타이거즈</option>
			</select>
		<button>수정</button>
	</form>
</body>
</html>