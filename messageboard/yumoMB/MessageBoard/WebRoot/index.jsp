<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>'index.jsp'</title>
    <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
    -->
  </head>
  
  <body>
    <jsp:forward page="MessageServlet?method=view"></jsp:forward>
  </body>
</html>
