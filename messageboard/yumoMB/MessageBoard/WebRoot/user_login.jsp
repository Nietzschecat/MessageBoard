<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>'user_login.jsp'</title>
		<link rel="stylesheet" type="text/css" href="images/style.css">
		<script type="text/javascript">
	    	function login(form){
	        	if(form.elements["username"].value == ""){
					alert("用户名不能空！");
					return false;
	        	}
	        	if(form.elements["password"].value == ""){
					alert("密码不能空！");
					return false;
	        	}
	    	}
	    	function message(form){
	    		if(form.elements["title"].value == ""){
					alert("留言标题不能为空！");
					return false;
	        	}
	        	if(form.elements["content"].value == ""){
					alert("留言内容不能空！");
					return false;
	        	}
	    	}
	    </script>
	</head>

	<body>
		<c:choose>
			<c:when test="${empty user}">
				<form action="UserServlet" method="post" onsubmit="return login(this);">
					<input type="hidden" name="method" value="userLogin">
					<table border="0" width="750" align="center" cellpadding="1" cellspacing="1"  bgcolor="#F0F0F0">
						<tr bordercolor="#FFFFFF">
							<td colspan="2" align="center" height="32" bgcolor="#941F53">
								<font class="title2">用户登录</font>
								<a name="login"></a>
							</td>
						</tr>
						<tr>
							<td height="20"></td>
						</tr>
						<tr bordercolor="#FFFFFF">
							<td align="right">用户名：</td>
							<td>
								<input type="text" name="username">
							</td>
						</tr>
						<tr bordercolor="#FFFFFF">
							<td align="right">密 码：</td>
							<td>
								<input type="password" name="password" class="input1">
							</td>
						</tr>
						<tr bordercolor="#FFFFFF">
							<td colspan="2" align="center" height="50">
								<input type="submit" value="登 录" />
								<input type="reset" value="重 置" />
							</td>
						</tr>
					</table>
				</form>
			</c:when>
			<c:otherwise>
				<form action="MessageServlet" method="post" onsubmit="return message(this);">
					<input type="hidden" name="method" value="save">
					<table border="0" width="750" align="center" cellpadding="1" cellspacing="1"  bgcolor="#F0F0F0">
						<tr bordercolor="#FFFFFF">
							<td colspan="2" align="center" height="32" bgcolor="#941F53">
								<font class="title2">我 要 留 言</font>
							</td>
						</tr>
						<tr>
							<td height="10"></td>
						</tr>
						<tr bordercolor="#FFFFFF">
							<td align="right">标 题：</td>
							<td>
								<input type="text" name="title" size="30">
							</td>
						</tr>
						<tr bordercolor="#FFFFFF">
							<td align="right">内 容：</td>
							<td>
								<textarea rows="8" cols="50" name="content"></textarea>
							</td>
						</tr>
						<tr bordercolor="#FFFFFF">
							<td colspan="2" align="center" height="50">
								<input type="submit" value="留 言" />
							</td>
						</tr>
					</table>
				</form>
			</c:otherwise>
		</c:choose>
	</body>
</html>
