<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
	.t1{
		font-size: 10pt;
		font-weight: bold;
		color: white;
	}
	div.title{font-size: 12px}
	div.title a:LINK {text-decoration: underline; color: white}
	div.title a:visited {text-decoration: underline; color: white}
	div.title a:active {text-decoration: underline; color: white}
	div.title a:hover {text-decoration: underline; color: white}
	div.top{font-size: 12px;margin-top: 5; position: relative;}
	.gg{font-size: 13px;color: #F6DDB5;}
</style>
<table border="0" align="center" cellpadding="0" cellspacing="0" width="800">
 	<tr align="center">
 		<td background="images/top.jpg" width="800" height="204" align="center" valign="top" colspan="3">
 			<div class="top" align="center">
 				<c:choose>
	 				<c:when test="${empty user}">
	 					&gt;&gt; 您尚未 
		 				<a href="index.jsp#login"><b>登录</b></a>
		 				<a href="user_reg.jsp"><b>注册</b></a>
	 				</c:when>
	 				<c:when test="${!empty admin}">
	 					管理员：${user.username}
	 					<a href="UserServlet?method=exit"><b>退出</b></a>
	 				</c:when>
	 				<c:otherwise>
	 					用户名：${user.username}
	 					<a href="UserServlet?method=exit"><b>退出</b></a>
	 				</c:otherwise>
	 			</c:choose>
 				| 帮助 | 社区
 			</div>
 		</td>
 	</tr>
 	<tr bgcolor="#941F53">
 		<td width="10%" align="center">
 			<img src="images/gg.jpg">
 		</td>
 		<td width="60%">
 			<marquee behavior="scroll" direction="left" scrolldelay="200">
 			<font class="gg">公告：在这里可以发表信息，写下祝福，留下与青春有关的美好回忆...</font>
 			</marquee> 
 		</td>
 		<td align="center" height="40" class="t1" width="30%">
 			<div class="title">
	 			<a href="index.jsp" class="title">首页</a>
	 			<c:choose>
	 				<c:when test="${empty user}">
	 					<a href="user_reg.jsp">注册</a>
	 					<a href="index.jsp#login">登录</a>
	 				</c:when>
	 				<c:when test="${!empty admin}">
	 					<a href="UserServlet?method=exit">退出</a>
	 					管理员：${user.username}
	 				</c:when>
	 				<c:otherwise>
	 					<a href="UserServlet?method=exit">退出</a>
	 					用户名：${user.username}
	 				</c:otherwise>
	 			</c:choose>
 			</div>
 		</td>
 	</tr>
</table>
