<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改歌手信息</title>
<%@ page language="java" import="java.lang.*"%>
<%String base="/OnlineMusicSite/resource/"; %>
</head>
<link href="<%=base %>css/alter.css" type="text/css" rel="stylesheet">
<body >
<div class="container">
 <div class="box-title">
            歌手编辑
        </div>
        <div class="info-container">
        	<form method="GET" class="info-form" name="singerForm" action="altersinger">
        		<div class="item">
                    <label class="info-text">姓名:</label>
                    <input type="text" name="name" autocomplete="off"  placeholder="歌手名字" maxlength="20" value="<c:if test="${not empty singer }">${singer.name }</c:if>" class="info-input">
                </div>
                <div class="item">
                    <label class="info-text">性别:</label>
                    <input type="text" name="sex" autocomplete="off"  placeholder="歌手性别" maxlength="20" value="<c:if test="${not empty singer }">${singer.sex }</c:if>" class="info-input">
                </div>
                <div class="item">
                    <label class="info-text">介绍:</label>
                    <input type="text" name="introduct" autocomplete="off"  placeholder="歌手简介" maxlength="20" value="<c:if test="${not empty singer }">${singer.introduct }</c:if>" class="info-input">
                </div>
                <div class="item">
                    <label class="info-text">照片:</label>
                    <input type="text" name="pictureURL" autocomplete="off"  placeholder="照片" maxlength="20" value="<c:if test="${not empty singer }">${singer.pictureURL }</c:if>" class="info-input">
                </div>
                
                 <div class="item">
                    <div class="info-line"></div>
                    <div class="info-btn-box">
                        <input type="submit" class="info-btn" value="提    交" onclick="return postSinger();">
                    </div>
                </div>
        	</form>
        </div>
</div>
	<script src="<c:url value="/resource/singerInfo.js"/>"></script>
	
</body>
</html>