<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员信息</title>
</head>
<body style="background-color:beige">
<a href="<c:url value="/manager/userlist" />">返回管理者首页</a>
<h1>个人信息</h1>
名:<c:out value="${user.firstName }" ></c:out><br/><br/>
姓: <c:out value="${user.lastName }" > </c:out><br/><br/>
用户名: <c:out value="${user.userName}"></c:out><br/><br/>
性别: <c:out value="${user.sex }" ></c:out><br/> <br/>
介绍: <c:out value="${user.introduct }" ></c:out><br/><br/>
<c:if test="${not empty sessionScope.user }">
<a href="<c:url value="/manager/altermanagerpage?${user.id }" />">修改信息</a>
</c:if>
</body>
</html>