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
<title>管理专辑</title>
<%@ page language="java" import="java.lang.*"%>
<%String base="/OnlineMusicSite/resource/"; %>
</head>
<link href="<%=base %>css/albumList.css" type="text/css" rel="stylesheet">
<body class="body">
<jsp:include page="navigation.jsp"></jsp:include><br></br>
  <h1 class="titletype">查询专辑</h1>
<div class="search">
	
	<form method="GET" action="searchalbum">
	专辑名: <input type="text" class="input" placeholder="输入专辑名" name="name"/>
	<input type="submit" class="search" value="查询" />
	</form><br/>
</div>  
<h1 class="titletype">添加专辑</h1>
<div class="adduser">

<sf:form method="GET" commandName="addalbum" action="addalbum" >
<sf:errors path="*" cssClass="error" /><br/>
专辑名: <sf:input path="albumName"   /><sf:errors path="albumName" cssClass="error" ></sf:errors><br/>
歌手:  <sf:input  path="albumSingerName"/><sf:errors path="albumSingerName" cssClass="error" ></sf:errors><br/>
头像:  <sf:input  path="picture"/><sf:errors path="picture" cssClass="error" ></sf:errors><br/>
<input type="submit" class="search" value="添加"  />
</sf:form>
</div>  
<h1 class="titletype">专辑列表</h1>
	<div >
		<table width="100%" border="1" >
	<tr align="center">
  	<td>id</td>
  	<td>name</td>
  	<td>release</td>
  	<td>singer</td>
    <td>picture</td>
    <td>删除</td>
  	<td>修改</td>
</tr>
<c:forEach items="${albumpaginationSupport.items}" var="album">
<tr align="center">
<td>
<c:out value="${album.id}" />
</td>
<td>
<c:out value="${album.name}" />
</td>
<td >
<c:out value="${album.release }" />
</td>
<td >
<c:out value="${album.singer.getName()}" />
</td>
<td >
<c:out value="${album.picture}" />
</td>
<td>
<a href="<c:url value="deletealbum?id=${album.id }" />">删除</a>
</td>
<td>
	<a href="<c:url value="alteralbumpage?id=${album.id }" />">修改</a>
</td>
</tr>
</c:forEach>
</table>
</div>
每页${albumpaginationSupport.pageSize}个专辑，第${albumpaginationSupport.currentPageNo }/${albumpaginationSupport.totalPageCount }页，共${albumpaginationSupport.totalCount }个专辑
<c:if test="${albumpaginationSupport.previousPage}">
<a href="<c:url value="/manager/albumlist?pageNo=${albumpaginationSupport.currentPageNo-1}" />">上一页</a>
</c:if>
<c:if test="${albumpaginationSupport.nextPage}">
<a href="<c:url value="/manager/albumlist?pageNo=${albumpaginationSupport.currentPageNo+1}" />">下一页</a>
</c:if>
 
</body>
</html>