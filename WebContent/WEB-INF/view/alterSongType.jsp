<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改分类</title>
<%@ page language="java" import="java.lang.*"%>
<%String base="/OnlineMusicSite/resource/"; %>
</head>
<link href="<%=base %>css/alter.css" type="text/css" rel="stylesheet">
<body>
<div class="container">
	<div class="box-title">
            分类编辑
        </div>
        <div class="info-container">
        	<form method="GET" class="info-form" name="songTypeForm" action="altersongtype">
        		<div class="item">
                    <label class="info-text">分类名:</label>
                    <input type="text" name="name" autocomplete="off"  placeholder="分类名称" maxlength="20" value="<c:if test="${not empty songtype }">${songtype.name }</c:if>" class="info-input">
                </div>
                <div class="item">
                    <label class="info-text">分类照片:</label>
                    <input type="text" name="picture" autocomplete="off"  placeholder="分类图" maxlength="20" value="<c:if test="${not empty songtype }">${songtype.picture }</c:if>" class="info-input">
                </div>
                <div class="item">
                    <div class="info-line"></div>
                    <div class="info-btn-box">
                        <input type="submit" class="info-btn" value="提    交" onclick="return postSongType();">
                    </div>
                </div>
        	</form>
        </div>
</div>
	<script src="<c:url value="/resource/SongTypeInfo.js"/>"></script>
</body>
</html>