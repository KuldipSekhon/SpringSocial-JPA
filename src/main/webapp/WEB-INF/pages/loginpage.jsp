<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Login</h1>
<!--
<div id="login-error">${error}</div>

<c:url var="logoUrl" value="/resources/openidlogosmall.png" />
<p><img src="${logoUrl}"></img>Login with OpenID:</p>
<!-- <c:url var="openIDLoginUrl" value="/j_spring_openid_security_check" /> -->
<form action="/j_spring_openid_security_check" method="post" >
	<label for="openid_identifier">OpenID Login</label>:
	<input id="openid_identifier" name="openid_identifier" type="text"/>
	<input  type="submit" value="Login"/>								
</form>

<hr/>
<!--
<c:url var="googleLogoUrl" value="/resources/google-logo.png" />
<img src="${googleLogoUrl}"></img>-->
<form action="/j_spring_openid_security_check" method="post">
	   For Google users:
	  <input name="openid_identifier" type="hidden" value="https://www.google.com/accounts/o8/id"/>
	  <input type="submit" value="Sign with Google"/>
</form>

</body>
</html>