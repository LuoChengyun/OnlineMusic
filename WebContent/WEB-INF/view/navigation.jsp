<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>导航栏</title>
<%@ page language="java" import="java.lang.*"%>
<%String base="/OnlineMusicSite/resource/css/"; %>
</head>
<link href="<%=base %>navigation.css" type="text/css" rel="stylesheet">
<body>
<div class="nav">
    <nav class="nav-bar">
        <ul class="nav-items">
            <li> <a href="<c:url value="/manager/userlist" />" class="nav-item" >用户管理</a></li>
            <li> <a href="<c:url value="/manager/songlist" />"class="nav-item" >歌曲管理</a></li>
             <li> <a href="<c:url value="/manager/singerlist" />"class="nav-item" >歌手管理</a></li>
            <li> <a href="<c:url value="/manager/songtypelist" />" class="nav-item">分类管理</a></li>
            <li> <a href="<c:url value="/manager/albumlist" />" class="nav-item">专辑管理</a></li>
            <li> <a href="<c:url value="/manager/recordlist" />" class="nav-item">登录记录</a></li>
            <li> <a>&nbsp</a></li>
            <li> <a>&nbsp</a></li>
            <li> <a href="<c:url value="/manager/managerCenter" />" class="nav-item">个人中心</a></li>
             <li> <a href="<c:url value="/logout" />" class="nav-item">注销</a></li>
        </ul>
    </nav>
</div>
</body>
</html> 