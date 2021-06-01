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
<title>管理登录信息</title>
<%@ page language="java" import="java.lang.*"%>
<%String base="/OnlineMusicSite/resource/"; %>
</head>
<link href="<%=base %>css/recordList.css" type="text/css" rel="stylesheet">
<body class="body">
<jsp:include page="navigation.jsp"></jsp:include><br></br>

    <form method="GET" action="searchrecord" class="search">
      用户名搜索: <input type="text" name="userName" placeholder="输入用户名"  class="input"/><br/>
   <input type="submit" value="确认搜索" class="sure" /><br/><br/>
   </form>
   
	<div class="recordList">
		<h1>登录列表</h1>
		<table width="100%" border="1">
	<tr>
  	<td>id</td>
  	<td>userName</td>
  	<td>time</td>
</tr align="center">
<c:forEach items="${recordpaginationSupport.items}" var="record">
<tr>
<td>
<c:out value="${record.id}" />
</td>
<td>
<c:out value="${record.user.getUserName()}" />
</td>
<td>
<fmt:formatDate value="${record.time }" pattern="yyyy-MM-dd HH:mm:ss" />
</td>
</tr>
</c:forEach>
</table>
</div>
每页${recordpaginationSupport.pageSize}个登录信息，第${recordpaginationSupport.currentPageNo }/${recordpaginationSupport.totalPageCount }页，共${recordpaginationSupport.totalCount }个登录信息
<c:if test="${recordpaginationSupport.previousPage}">
<a href="<c:url value="/manager/recordlist?pageNo=${recordpaginationSupport.currentPageNo-1}" />">上一页</a>
</c:if>
<c:if test="${recordpaginationSupport.nextPage}">
<a href="<c:url value="/manager/recordlist?pageNo=${recordpaginationSupport.currentPageNo+1}" />">下一页</a>
</c:if>
</body>
</html>