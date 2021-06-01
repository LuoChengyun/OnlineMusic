<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改管理员信息</title>
<%@ page language="java" import="java.lang.*"%>
<%String base="/OnlineMusicSite/resource/"; %>
</head>
<link href="<%=base %>css/alter.css" type="text/css" rel="stylesheet">
<body style="background-color:beige">
<div class="container">
 <div class="box-title">
            信息编辑
        </div>
        <div class="info-container">
        	<form method="GET" class="info-form" name="managerInformationForm" action="altermanager">
        		<div class="item">
                    <label class="info-text">名:</label>
                    <input type="text" name="firstName" autocomplete="off"  placeholder="你的名" maxlength="20" value="<c:if test="${not empty user }">${user.firstName }</c:if>" class="info-input">
                </div>
                <div class="item">
                    <label class="info-text">姓:</label>
                    <input type="text" name="lastName" autocomplete="off"  placeholder="你的姓" maxlength="20" value="<c:if test="${not empty user }">${user.lastName }</c:if>" class="info-input">
                </div>
                <div class="item">
                    <label class="info-text">用户名:</label>
                    <input type="text" name="userName" autocomplete="off"  placeholder="你的用户名" maxlength="20" value="<c:if test="${not empty user }">${user.userName }</c:if>" class="info-input">
                </div>
                <div class="item">
                    <label class="info-text">密码:</label>
                    <input type="password" name="password" autocomplete="off"  placeholder="你的用户名" maxlength="20" value="<c:if test="${not empty user }">${user.userName }</c:if>" class="info-input">
                </div>
                <div class="item">
                    <label class="info-text">性别:</label>
                    <input type="text" name="sex" autocomplete="off"  placeholder="你的性别" maxlength="20" value="<c:if test="${not empty user }">${user.sex }</c:if>" class="info-input">
                </div>
                
                <div class="item">
                    <label class="info-text">简介:</label>
                    <input type="text" name="introduct" autocomplete="off"  placeholder="你的简介" maxlength="20" value="<c:if test="${not empty user }">${user.introduct }</c:if>" class="info-input">
                </div>
                 <div class="item">
                    <div class="info-line"></div>
                    <div class="info-btn-box">
                        <input type="submit" class="info-btn" value="提    交" onclick="return postManager();">
                    </div>
                </div>
        	</form>
        </div>
</div>
	<script src="<c:url value="/resource/managerInfo.js"/>"></script>
	



<%-- <h1>个人设置</h1> 
<sf:form method="POST" commandName="user" action="altermanager" >
<sf:errors path="*" cssClass="error" /><br/><br/>
名: <sf:input path="firstName" /><sf:errors path="firstName" cssClass="error" /><br/><br/>
姓: <sf:input path="lastName" /><sf:errors path="lastName" cssClass="error" /><br/><br/>
用户名: <sf:input path="userName" /><sf:errors path="userName" cssClass="error" ></sf:errors><br/><br/>
密码: <sf:password path="password" /><sf:errors path="password" cssClass="error" /><br/><br/>
性别:<sf:input path="sex" /><sf:errors path="sex" cssClass="error" /><br/><br/>
简介:<sf:input path="introduct" /><sf:errors path="introduct" cssClass="error" /><br/><br/>
<input type="submit" value="修改" />
</sf:form> --%>
</body>
</html>