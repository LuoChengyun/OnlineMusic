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
<title>最近播放</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css" />">
</head>
<body>
<jsp:include page="head.jsp"></jsp:include><br></br><br></br>
    <form method="GET" action="/OnlineMusicSite/user/recentlist/searchbyname">
      搜索最近播放: <input type="text" name="songName" /><br/><br/>
   <input type="submit" value="确认搜索" />
   </form>
<div class="adduser">

</div>
	<div class="recentList">
		<h1>最近播放名单</h1>
		<table border="1">
	<tr>
  	<td>id</td>
  	<td>用户名</td>
  	<td>歌曲名</td>
  	<td>播放时间</td>
</tr>
<c:forEach items="${paginationSupport.items}" var="recentlist">
<tr>
<td>
<c:out value="${recentlist.id}" />
</td>
<td>
${recentlist.user.getUserName()}
</td>
<td >
<c:out value="${recentlist.song.getName()}" />
</td>
<td >
<c:out value="${recentlist.time}" />
</td>
</tr>
</c:forEach>
</table>
</div>
每页${paginationSupport.pageSize}首歌曲，第${paginationSupport.currentPageNo }/${paginationSupport.totalPageCount }页，共${paginationSupport.totalCount }首歌曲
<c:if test="${paginationSupport.previousPage}">
<a href="<c:url value="user/recentlist?pageNo=${paginationSupport.currentPageNo-1}" />">上一页</a>
</c:if>
<c:if test="${paginationSupport.nextPage}">
<a href="<c:url value="/user/recentlist?pageNo=${paginationSupport.currentPageNo+1}" />">下一页</a>
</c:if>
</body>
</html>