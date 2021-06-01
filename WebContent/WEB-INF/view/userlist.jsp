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
<meta charset="UTF-8">
<title>管理用户</title>
<%@ page language="java" import="java.lang.*"%>
<%String base="/OnlineMusicSite/resource/"; %>
</head>
<link href="<%=base %>css/userlist.css" type="text/css" rel="stylesheet">
<body class="body">
<jsp:include page="navigation.jsp"></jsp:include><br></br>
 <h1 class="titletype">查询用户</h1>
<div class="search">
	
	<form method="GET" action="searchuser">
	用户名: <input type="text" class="input" placeholder="输入用户名" name="userName"/>
	<input type="submit" class="search" value="查询"  "/>
	</form><br/>
</div> 
<h1 class="titletype">添加用户</h1>
<div class="adduser">

<sf:form method="GET" commandName="user" action="adduser" >
<sf:errors path="*" cssClass="error" /><br/>
姓: <sf:input path="lastName"   /><sf:errors path="lastName" cssClass="error" ></sf:errors><br/>
名:  <sf:input  path="firstName"/><sf:errors path="firstName" cssClass="error" ></sf:errors><br/>
性别:  <sf:input  path="sex"/><sf:errors path="sex" cssClass="error" ></sf:errors><br/>
简介:  <sf:input  path="introduct"/><sf:errors path="introduct" cssClass="error" ></sf:errors><br/>
头像:  <sf:input  path="pictureURL"/><sf:errors path="pictureURL" cssClass="error" ></sf:errors><br/>
用户名: <sf:input   path="userName" /> <sf:errors path="userName" cssClass="error" ></sf:errors><br/>
密码:  <sf:password   path="password" /><sf:errors path="password" cssClass="error" ></sf:errors><br/>
<input type="submit" class="search" value="添加"  />
</sf:form>
</div>  
<h1 class="titletype">用户名单</h1>
	<div >
		<table width="100%" border="1" >
	<tr align="center">
  	<td>id</td>
  	<td>name</td>
  	<td>username</td>
  	<td>sex</td>
  	<td>users_status</td>
    <td>users_identity</td>
    <td>禁用</td>
  	<td>删除</td>
</tr>
<c:forEach items="${userpaginationSupport.items}" var="user">
<tr align="center">
<td>
<c:out value="${user.id}" />
</td>
<td>
<c:out value="${user.lastName}" /><c:out value="${user.firstName}" />
</td>
<td >
<c:out value="${user.userName }" />
</td>
<td >
<c:out value="${user.sex}" />
</td>
<td>
 ${user.status eq 0 ? '可用':user.status eq 1?'不可用':'' }
</td>
<td >
${user.identity eq 0 ? '用户':user.identity eq 1?'管理员':'' }
</td>
<td>
<a href="<c:url value="checkuser?id=${user.id }" />">禁用</a>
</td>
<td>
	<a href="<c:url value="deleteuser?id=${user.id }" />">删除</a>
</td>
</tr>
</c:forEach>
</table>
</div>
每页${userpaginationSupport.pageSize}个用户，第${userpaginationSupport.currentPageNo }/${userpaginationSupport.totalPageCount }页，共${userpaginationSupport.totalCount }个用户
<c:if test="${userpaginationSupport.previousPage}">
<a href="<c:url value="/manager/userlist?pageNo=${userpaginationSupport.currentPageNo-1}" />">上一页</a>
</c:if>
<c:if test="${userpaginationSupport.nextPage}">
<a href="<c:url value="/manager/userlist?pageNo=${userpaginationSupport.currentPageNo+1}" />">下一页</a>
</c:if>
 
</body>
</html>