<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<%@ page session="false" %>
<html>
  <head>
    <title>MusicPlayer</title>
      <%@ page language="java" import="java.lang.*"%>
<%String base="/OnlineMusicSite/resource/css/"; %>
  </head>
  <link href="<%=base %>register.css" type="text/css" rel="stylesheet">
  <body>
  <jsp:include page="head.jsp"></jsp:include><br/>
  <div class="login-container">
  <div class="box-title">
    <h1 >注册</h1>
    </div>
    <div class="login-box">
    <sf:form method="GET" commandName="user" action="/OnlineMusicSite/user/register" class="login-form">
    <sf:errors path="*" cssClass="error"/><br/><br/>
    <div class="login-item">
   	姓:  <sf:input path="lastName" class="login-input" /><sf:errors path="lastName" cssClass="error"/><br/>
   	</div>
   	<div class="login-item">
	名:  <sf:input path="firstName" class="login-input"/><sf:errors path="firstName" cssClass="error"/><br/>
	</div>
	<div class="login-item">
	性别:<sf:input path="sex" class="login-input"/><sf:errors path="sex" cssClass="error"/><br/>
	</div>
	<div class="login-item">
	个人简介:<sf:input path="introduct" class="login-input" /><sf:errors path="introduct" cssClass="error"/><br/>
	</div>
	<div class="login-item">
	用户名:<sf:input path="userName" class="login-input"/><sf:errors path="userName" cssClass="error"/><br/>
	</div>
	<div class="login-item">
	密码: <sf:password  path="password" class="login-input" /><sf:errors path="password" cssClass="error"/><br/>
	</div>
    <input type="submit" class="login-submit" value="注册" />
    </sf:form>
    </div>
    </div>
  </body>
</html>
