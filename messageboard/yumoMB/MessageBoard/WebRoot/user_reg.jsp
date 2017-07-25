<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户注册</title>
	<link rel="stylesheet" type="text/css" href="images/style.css">
    <script type="text/javascript">
    	function reg(form){
        	if(form.elements["username"].value == ""){
				alert("用户名不能空！");
				return false;
        	}
        	if(form.elements["password"].value == ""){
				alert("密码不能空！");
				return false;
        	}
        	if(form.elements["repassword"].value == ""){
				alert("确认密码不能空！");
				return false;
        	}
        	if(form.elements["repassword"].value != form.elements["password"].value){
				alert("两次密码输入不一致！");
				return false;
        	}
        	if(form.elements["email"].value == ""){
				alert("电子邮件不能空！");
				return false;
        	}
    	}
    </script>
  </head>
  
  <body background="images/bg1.jpg">
  	<jsp:include page="head.jsp"/>
  	<div align="center">
  	<div align="center" class="div2">
  	<form action="UserServlet" method="post" onsubmit="return reg(this);">
  		<input type="hidden" name="method" value="guestReg" />
	    <table align="center" width="100%" border="0" bgcolor="#C1C1C1" cellpadding="1" cellspacing="1">
	    	<tr>
	    		<td colspan="2" align="center" height="30" bgcolor="#941F53">
					<font class="title2">用 户 注 册</font>
				</td>
	    	</tr>
	    	<tr bgcolor="#FAFAFA" height="30">
	    		<td align="right">用户名：</td>
	    		<td>
	    			<input type="text" name="username"/><font color="red"> *</font>
	    			不能有空格，可以是中文，长度在3-50字节以内
	    		</td>
	    	</tr>
	    	<tr bgcolor="#FAFAFA">
	    		<td align="right">密 码：</td>
	    		<td>
	    			<input type="password" name="password" class="input1">
	    			<font color="red"> *</font>
	    			英文字母或数字，不少于6位
	    		</td>
	    	</tr>
	    	<tr bgcolor="#FAFAFA">
	    		<td align="right">确认密码：</td>
	    		<td>
	    			<input type="password" name="repassword" class="input1">
	    			<font color="red"> *</font>
	    		</td>
	    	</tr>
	    	<tr bgcolor="#FAFAFA">
	    		<td align="right">电子邮件：</td>
	    		<td>
	    			<input type="text" name="email"/>
	    			<font color="red"> *</font>
	    			<input type="checkbox"> 公开邮箱 
	    		</td>
	    	</tr>
	    	<tr bgcolor="#FAFAFA">
	    		<td colspan="2" align="center" height="50">
	    			<input type="submit" value="注册"/>
	    			<input type="reset" value="重置"/>
	    		</td>
	    	</tr>
	    </table>
    </form>
    </div>
    </div>
    <jsp:include page="bottom.jsp"></jsp:include>
  </body>
</html>
