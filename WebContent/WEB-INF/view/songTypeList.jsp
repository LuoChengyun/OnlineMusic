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
<title>分类管理</title>
<%@ page language="java" import="java.lang.*"%>
<%String base="/OnlineMusicSite/resource/css/"; %>
</head>
<link href="<%=base %>songTypeList.css" type="text/css" rel="stylesheet">
<body class="body">
<jsp:include page="navigation.jsp"></jsp:include><br/>
<h1 class="titletype">添加分类</h1>
<div class="addsongtype">
<sf:form method="GET" commandName="newsongtype" action="addsongtype" >
<sf:errors path="*" cssClass="error" /><br/>
分类名:  <sf:input  path="name" class="input"/><sf:errors path="name" cssClass="error" ></sf:errors><br/>
分类图片:  <sf:input  path="picture" class="input"/><sf:errors path="picture" cssClass="error" ></sf:errors><br/>
<input type="submit" class="add" value="添加"  />
</sf:form>

</div>

<h1 class="titletype">分类名单</h1>
	<div class="userList">
		
		<table  width="100%" border="1">
	<tr align="center">
  	<td>id</td>
  	<td>name</td>
  	<td>picture</td>
  	<td>删除</td>
  	<td>修改</td>
</tr >
<c:forEach items="${songtypepaginationSupport.items}" var="songtype">
<tr>
<td>
<c:out value="${songtype.id}" />
</td>
<td>
<c:out value="${songtype.name}" />
</td>
<td >
<c:out value="${songtype.picture}" />
</td>
<td>
	<a href="<c:url value="deletesongtype?id=${songtype.id }" />">删除</a>
</td>
<td>
	<a href="<c:url value="/manager/altersongtypepage?id=${songtype.id }" />">修改</a>
</td>
</tr>
</c:forEach>
</table>
</div>
每页${singerpaginationSupport.pageSize}个分类，第${songtypepaginationSupport.currentPageNo }/${songtypepaginationSupport.totalPageCount }页，共${songtypepaginationSupport.totalCount }个分类
<c:if test="${songtypepaginationSupport.previousPage}">
<a href="<c:url value="songtype/songtypelist?pageNo=${userpaginationSupport.currentPageNo-1}" />">上一页</a>
</c:if>
<c:if test="${userpaginationSupport.nextPage}">
<a href="<c:url value="/songtype/songtypelist?pageNo=${userpaginationSupport.currentPageNo+1}" />">下一页</a>
</c:if>
</body>
</body>
</html>