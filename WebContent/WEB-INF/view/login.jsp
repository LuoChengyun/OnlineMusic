<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
  <head>
    <title>登录界面</title>
    <%@ page language="java" import="java.lang.*"%>
<%String base="/OnlineMusicSite/resource/css/"; %>
  </head>
  <link href="<%=base %>login.css" type="text/css" rel="stylesheet">
  <body>
 <jsp:include page="head.jsp"></jsp:include><br></br>
    
     <div class="login-container">
     
        <div class="box-title">
        
                <h3>账号密码登录<h3/><br><br>
                <h3 class="logerror">${logined}</h3>
        </div>
        <div class="login-box">
        	
            <form method="POST" class="login-form">
                <div class="login-item">
                    <input type="text" class="login-input" name="userName" placeholder="账号">
                </div>
                <div class="login-item">
                    <input type="password" class="login-input" name="password" placeholder="密码">
                </div>
                <div class="login-btn">
                    <button type="submit" class="login-submit">登录</button>
                </div>
        
            </form>
        </div>
    </div>
  </body>
</html>
