<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	777
	<!-- POST 방식인데 get방식으로 받을때 오류 HTTP 상태 405 – 허용되지 않는 메소드  -->
	<!-- <form method="post" action="student"> -->
	<form method="post" action="student">
		student id :<input type="text" name="id"><br>
		<input type=submit value="전송">
	</form>
</body>
</html>