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
<title>管理歌曲</title>
<%@ page language="java" import="java.lang.*"%>
<%String base="/OnlineMusicSite/resource/css/"; %>
</head>
<link href="<%=base %>songlist.css" type="text/css" rel="stylesheet">
<body class="body">
<jsp:include page="navigation.jsp"></jsp:include><br/>
<h1 class="titletype">查询歌曲</h1>
<div class="search">
	
	<form method="GET" action="searchsong">
	歌曲名: <input type="text" class="input" placeholder="输入歌曲名" name="name"/>
	<input type="submit" class="search" value="查询" />
	</form><br/>
</div>  

<h1 class="titletype">添加歌曲</h1>
<div class="addsong">

<sf:form method="GET" commandName="song" action="addsong">
<sf:errors path="*" cssClass="error" /><br/>
歌名:  <sf:input  path="name" /><sf:errors path="name" cssClass="error" ></sf:errors><br/>
歌曲文件:  <sf:input  path="url"/><sf:errors path="url" cssClass="error" ></sf:errors><br/>
歌词文件:<sf:input  path="lyricURL"/><sf:errors path="lyricURL" cssClass="error" ></sf:errors><br/>
歌手名:<sf:input  path="singer"/><sf:errors path="singer" cssClass="error" ></sf:errors><br/>
专辑:<sf:input  path="album"/><sf:errors path="album" cssClass="error" ></sf:errors><br/>
歌曲类型:<sf:input  path="type"/><sf:errors path="type" cssClass="error" ></sf:errors><br/> 
<input type="submit" value="添加"  />
</sf:form>
<h1 class="titletype">歌曲列表</h1>
	<div class="songList">
		<table width="100%" border="1">
	<tr align="center">
  	<td>id</td>
  	<td>name</td>
  	<td>release</td>
  	<td>url</td>
  	<td>click</td>
    <td>singer</td>
    <td>album</td>
     <td>type</td> 
    <td>修改</td>
  	<td>删除</td>
</tr>
<c:forEach items="${songpaginationSupport.items}" var="song">
<tr>
<td>
<c:out value="${song.id}" />
</td>
<td>
<c:out value="${song.name}" />
</td>
<td >
<c:out value="${song.release}" />
</td>
<td >
<c:out value="${song.url }" />
</td>
<td >
<c:out value="${song.click}" />
</td>
<td >
<c:out value="${song.singer.getName()}" />
</td>
<td >
<c:out value="${song.album.getName()}" />
</td>
 <td >
<c:out value="${song.type.getName()}" />
</td> 
<td>
<a href="<c:url value="altersong?id=${song.id }" />">修改</a>
</td>
<td>
	<a href="<c:url value="deletesong?id=${song.id }" />">删除</a>
</td>
</tr>
</c:forEach>
</table>
</div>
每页${songpaginationSupport.pageSize}首歌曲，第${songpaginationSupport.currentPageNo }/${songpaginationSupport.totalPageCount }页，共${songpaginationSupport.totalCount }首歌曲
<c:if test="${songpaginationSupport.previousPage}">
<a href="<c:url value="/manager/songlist?pageNo=${songpaginationSupport.currentPageNo-1}" />">上一页</a>
</c:if>
<c:if test="${songpaginationSupport.nextPage}">
<a href="<c:url value="/manager/songlist?pageNo=${songpaginationSupport.currentPageNo+1}" />">下一页</a>
</c:if>

</body>
</html>