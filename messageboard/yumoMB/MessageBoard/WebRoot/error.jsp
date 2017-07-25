<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>错误</title>
   <link rel="stylesheet" type="text/css" href="images/style.css">
  </head>
  
  <body background="images/bg1.jpg">
  	<jsp:include page="head.jsp"/>
  	<div align="center">
  	<div align="center" class="div2">
   <table align="center" width="100%" border="0" bgcolor="#C1C1C1" cellpadding="1" cellspacing="1">
    	<tr>
    		<td align="center" height="30" bgcolor="#941F53">
				<font class="title2">出 错 了</font>
			</td>
    	</tr>
    	<tr bgcolor="#FAFAFA" align="center">
    		<td height="50">
    			<c:if test="${!empty error}">
    				${error}
    			</c:if>
    		</td>
    	</tr>
    	<tr bgcolor="#FAFAFA" align="center">
    		<td height="50">
    			<a href="javascript:history.go(-1);">返 回</a>
    		</td>
    	</tr>
    </table>
    </div>
    </div>
    <jsp:include page="bottom.jsp"></jsp:include>
  </body>
</html>
