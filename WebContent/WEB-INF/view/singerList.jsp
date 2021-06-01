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
<title>歌手管理</title>
<%@ page language="java" import="java.lang.*"%>
<%String base="/OnlineMusicSite/resource/css/"; %>
</head>
<link href="<%=base %>singerList.css" type="text/css" rel="stylesheet">
<body class="body">
<jsp:include page="navigation.jsp"></jsp:include><br/>
 <h1 class="titletype">查询歌手</h1>
<div class="search">
	
	<form method="GET" action="searchsinger">
	歌手名: <input type="text" class="input" placeholder="输入歌手名" name="name"/>
	<input type="submit" class="search" value="查询" />
	</form><br/>
</div>  

<h1 class="titletype">添加歌手</h1>
<div class="addsinger">

<sf:form method="GET" commandName="newsinger" action="addsinger">
<sf:errors path="*" cssClass="error" /><br/>
姓名:  <sf:input  path="name"/><sf:errors path="name" cssClass="error" ></sf:errors><br/>
性别:  <sf:input  path="sex"/><sf:errors path="sex" cssClass="error" ></sf:errors><br/>
简介:  <sf:input  path="introduct"/><sf:errors path="introduct" cssClass="error" ></sf:errors><br/>
照片:<sf:input  path="pictureURL"/><sf:errors path="pictureURL" cssClass="error" ></sf:errors><br/>
<input type="submit" value="添加"  />
</sf:form>
</div>
	<h1 class="titletype">歌手名单</h1>
	<div class="userList">
		
		<table width="100%" border="1">
	<tr align="center">
  	<td>id</td>
  	<td>name</td>
  	<td>sex</td>
  	<td>introduct</td>
  	<td>删除</td>
  	<td>修改</td>
</tr>
<c:forEach items="${singerpaginationSupport.items}" var="singer">
<tr align="center">
<td>
<c:out value="${singer.id}" />
</td>
<td>
<c:out value="${singer.name}" />
</td>
<td >
<c:out value="${singer.sex}" />
</td>
<td >
<c:out value="${singer.introduct}" />
</td>
<td>
	<a href="<c:url value="deletesinger?id=${singer.id }" />">删除</a>
</td>
<td>
	<a href="<c:url value="altersingerpage?id=${singer.id }" />">修改</a>
</td>
</tr>
</c:forEach>
</table>
</div>
每页${singerpaginationSupport.pageSize}个歌手，第${singerpaginationSupport.currentPageNo }/${singerpaginationSupport.totalPageCount }页，共${singerpaginationSupport.totalCount }个歌手
<c:if test="${singerpaginationSupport.previousPage}">
<a href="<c:url value="/manager/singerlist?pageNo=${userpaginationSupport.currentPageNo-1}" />">上一页</a>
</c:if>
<c:if test="${userpaginationSupport.nextPage}">
<a href="<c:url value="/manager/singerlist?pageNo=${userpaginationSupport.currentPageNo+1}" />">下一页</a>
</c:if>
</body>
</html>