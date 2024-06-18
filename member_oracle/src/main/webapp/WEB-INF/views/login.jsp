<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	window.onload=function(){
		var msg = document.getElementById("msg").value;
		if(msg != '') {
			alert("ID 또는 비번 확인");	
			document.getElementById("msg").value = "";
		}
	}
</script>
<body>
	<form method="post" action="login_ok">
	<center>
		<input type="hidden" id="msg" name="msg" value="${msg }">
		<table style="width: 300px" border="1">
			<tr height="30">
				<td width="40%">사용자 ID</td>
				<td width="60%">
					<input type="text" name="mem_uid">
				</td>
			</tr>
			<tr height="30">
				<td>비밀번호</td>
				<td>
					<input type="password" name="mem_pwd">
				</td>
			</tr>
			<tr height="30">
				<td colspan="2">
					&nbsp;&nbsp;&nbsp;&nbsp;<button type="submit">로 그 인</button>
				</td>
			</tr>
		</table>
	</center>
	</form>
</body>
</html>