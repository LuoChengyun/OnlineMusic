<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>网易云音乐</title>
<%@ page language="java" import="java.lang.*"%>
<%
	String base = "/OnlineMusicSite/resource/song/";
%>
<link rel="icon" type="image/ico" href="<%=base %>images/format.ico " />
<link rel="stylesheet" type="text/css"
	href="<%=base %>css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css" href="<%=base %>css/index.css" />
<script type="text/javascript" src="<%=base %>libs/jquery-3.1.1.min.js"></script>
</head>

<body onselectstart="return false">
<jsp:include page="navigation.jsp"></jsp:include><br/>
	<!-- page_menu 页面顶部菜单 -->
	<div class="page_menu clearfix">
		<div class="menu_logo">
			<img src="<%=base %>images/netease-logo.png" alt="">
		</div>
		<div class="menu_btngroups">
			<a href="javascript:void(0);" class="btn backward"><i
				class="fa fa-angle-left" aria-hidden="true"></i></a>
			<!--
			-->
			<a href="javascript:void(0);" class="btn forward"><i
				class="fa fa-angle-right" aria-hidden="true"></i></a>
		</div>
		<div class="menu_search">
			<input type="text" placeholder="探索音乐、歌手、歌词、用户" autofocus=""
				id="inpSearch" class="search_inp" /> <span class="search_btn"
				id="top_searchBtn"><i class="fa fa-search" aria-hidden="true"></i></span>
		</div>
	</div>
	<!-- page_playerbar 页面底部播放控制条 -->
	<div class="page_playerbar clearfix">
		<!-- 播放控制按钮组 -->
		<div class="playerbar_playbtngroup" id="playBtnGroup">
			<div class="btn prev">
				<i class="fa fa-step-backward" aria-hidden="true"></i>
			</div>
			<div class="btn play">
				<i class="fa fa-play" aria-hidden="true"></i>
			</div>
			<div class="btn next">
				<i class="fa fa-step-forward" aria-hidden="true"></i>
			</div>
		</div>
		<!-- 进度条 -->
		<div class="playerbar_timeprogress">
			<div class="progress" id="progress_box">
				<div class="progress_cache" id="progress_cache">
					<!-- 缓冲条 -->
				</div>
				<div class="progress_curbar" id="progress_bar">
					<div class="curbar_arc" id="progress_arc"></div>
				</div>
				<div class="time start" id="audio_currentTime">00:00</div>
				<div class="time end" id="audio_duration">59:59</div>
			</div>
		</div>
		<!-- 其他控制按钮组 -->
		<div class="playerbar_others">
			<div class="volume">
				<div class="mutebtn" id="muteBtn" title="静音">
					<i class="fa fa-volume-up" aria-hidden="true"></i>
				</div>
				<div class="progress" id="vol_progress_box">
					<div class="progress_curbar" id="vol_progress_bar">
						<div class="curbar_arc" id="vol_progress_arc"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- page_lyric 歌曲详情页 -->
	<div class="page_songdetail" id="pageSongDetail">
		<!-- 模糊背景 -->
		<div class="g_blurbg" id="bgBlur"
			style="background-image: url('<%=base %>images/al8.png');"></div>
		<div class="maincontainer clearfix">
			<div class="discsection">
				<div class="disc_needle" id="discNeedle">
					<img src="<%=base %>images/needle.png" alt="">
				</div>
				<div class="disc_arc" id="bgDisc"
					style="background-image: url('<%=base %>images/al8.png');">
					<div class="poster">
						<img src="<%=base %>images/disc-o.png" alt="">
					</div>
				</div>
				<div class="disc_btns">
					<!-- <span class="btn playall"> <i class="fa fa-heart-o"
						aria-hidden="true"></i>&nbsp;&nbsp;喜欢</span> -->  <span class="btn playall"><i
						class="fa fa-folder" aria-hidden="true"></i>&nbsp;&nbsp;收藏</span> <span
						class="btn playall"><i class="fa fa-heart-o"
						aria-hidden="true"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;添加到歌单</span> <!-- <span class="btn playall"><i
						class="fa fa-share-square-o" aria-hidden="true"></i>&nbsp;&nbsp;分享</span> -->
				</div>
			</div>
			<div class="lyricsection">
				<div class="lrcinfo" id="songDetail">
					<p class="info_song">
						<span class="songname">--<c:out value="${song.getName()}" />--</span><!-- <span class="label mv">MV</span> --><span
							class="label quality">320k</span>
					</p>
					<p class="info_album">
						<span class="album">专辑：<span class="albumname">--<c:out value="${song.album.getName()}" />--</span>
						</span> <span class="singer">歌手：<span class="singersname">--<c:out value="${song.singer.getName()}" />--</span>
						</span> <!-- <span class="origin">来源：<span class="originname">--ORIGIN--</span> -->
						<!-- </span> -->
					</p>
				</div>
				<div class="lrccontainer" id="lrcContainer">
					<div class="lrcbox" id="lrcBox" >
					<%--  <c:set var="path" scope="session"  value="<%=base %><c:out value="${song.getLyricURL()}"/>"/>
						<%
					    String path = (String)pageContext.findAttribute("path"); // 这边文件目录路径
						File file = new File(path);
						FileReader fr = new FileReader(file); //字符输入流
						BufferedReader br = new BufferedReader(fr); //使文件可按行读取并具有缓冲功能
						StringBuffer strB = new StringBuffer(); //strB用来存储jsp.txt文件里的内容
						String str = br.readLine();
						while (str != null) {
							strB.append(str).append("<br>"); //将读取的内容放入strB
							str = br.readLine();
						}
						br.close(); //关闭输入流
						%> --%>
						<p><%="aaaa"%></p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- audio -->
	<audio src="<%=base %><c:out value="${song.getUrl()}"/>" controls="controls" hidden=true loop=0 id="audio"></audio>
	<!-- backscreen -->
	<div class="g_backscreen" id="backScreen"></div>
	<!-- tips box -->
	<div class="g_tipsbox" id="tipsBox">
		<p class="tip tip_error show">
			<i class="fa fa-times-circle" aria-hidden="true"></i>&nbsp;&nbsp;<span
				class="tiptext">ERROR STRING</span>
		</p>
		<p class="tip tip_info">
			<i class="fa fa-info-circle" aria-hidden="true"></i>&nbsp;&nbsp;<span
				class="tiptext">INFO STRING</span>
		</p>
		<p class="tip tip_ok">
			<i class="fa fa-check-circle" aria-hidden="true"></i>&nbsp;&nbsp;<span
				class="tiptext">OK STRING</span>
		</p>
	</div>

	<!-- scripts -->
	<script type="text/javascript" src="<%=base %>js/index.js"></script>
	<script type="text/javascript" src="<%=base %>js/lyricScroll.js"></script>
	<script type="text/javascript" src="<%=base %>js/request.js"></script>
	<script type="text/javascript" src="<%=base %>js/player.js"></script>

</body>

</html>