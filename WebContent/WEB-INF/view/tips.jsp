<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>提示</title>
</head>
<body>
<h1>操作结果信息提示</h1>
<c:out value="${tipMessage}"></c:out><br/><br/>
<a href="<c:url value="/manager/userlist" />">返回管理员主界面</a>

</body>
</html>