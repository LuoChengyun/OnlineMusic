<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<title>我的歌单</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css" />">
</head>
<body>
<jsp:include page="head.jsp"></jsp:include><br></br>
<br></br>
    <form method="GET" action="/OnlineMusicSite/manager/selectuser">
      搜索用户名: <input type="text" name="userName" /><br/><br/>
   <input type="submit" value="确认搜索" />
   </form>
<div class="adduser">
<h1>添加歌单</h1>
<%-- <sf:form method="POST" commandName="newuser" action="adduser"> --%>
<%-- <sf:errors path="*" cssClass="error" /><br/> --%>
<%-- 姓: <sf:input path="lastName"   /><sf:errors path="lastName" cssClass="error" ></sf:errors><br/> --%>
<%-- 名:  <sf:input  path="firstName"/><sf:errors path="firstName" cssClass="error" ></sf:errors><br/> --%>
<%-- 性别:  <sf:input  path="sex"/><sf:errors path="sex" cssClass="error" ></sf:errors><br/> --%>
<%-- 简介:  <sf:input  path="introduct"/><sf:errors path="introduct" cssClass="error" ></sf:errors><br/> --%>
<%-- 用户名: <sf:input   path="userName" /> <sf:errors path="userName" cssClass="error" ></sf:errors><br/> --%>
<%-- 密码:  <sf:password   path="password" /><sf:errors path="password" cssClass="error" ></sf:errors><br/> --%>
<!-- <input type="submit" value="添加"  /> -->
<%-- </sf:form> --%>
</div>
	<div class="mysongList">
		<h1>歌单列表</h1>
		<table border="1">
	<tr>
  	<td>id</td>
  	<td>songlistname</td>
</tr>
<c:forEach items="${songlistpaginationSupport.items}" var="songlist">
<tr>
<td>
<c:out value="${songlist.id}" />
</td>
<td>
<c:out value="${songlist.name}" />
</tr>
</c:forEach>
</table>
</div>
<%-- 每页${songlistpaginationSupport.pageSize}个用户，第${userpaginationSupport.currentPageNo }/${userpaginationSupport.totalPageCount }页，共${userpaginationSupport.totalCount }个用户 --%>
<%-- <c:if test="${userpaginationSupport.previousPage}"> --%>
<%-- <a href="<c:url value="/manager/userlist?pageNo=${userpaginationSupport.currentPageNo-1}" />">上一页</a> --%>
<%-- </c:if> --%>
<%-- <c:if test="${userpaginationSupport.nextPage}"> --%>
<%-- <a href="<c:url value="/manager/userlist?pageNo=${userpaginationSupport.currentPageNo+1}" />">下一页</a> --%>
<%-- </c:if> --%>
</body>
</html>