<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html5>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="register_ok">
	<div align="center">
		<table style="width: 300px;" border="1">
			<tr>
				<td colspan="2" height="50">
					<h2>회원 가입 신청</h2>
				</td>
			</tr>
			<tr>
				<td width="40%">User ID</td>
				<td width="60%">
					<input type="text" name="id">
				</td>
			</tr>
			<tr>
				<td>암호</td>
				<td>
					<input type="password" name="pw">
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<input type="text" name="name">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit">등록</button>
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>