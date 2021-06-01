<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>网易云音乐</title>
<meta property="og:title" content="网易云音乐">
<meta property="og:site_name" content="网易云音乐">
<%@ page language="java" import="java.lang.*"%>
<%
	String base = "/OnlineMusicSite/resource/home/";
%>
<script src="<%=base%>musicfrontencryptvalidator.js" async=""></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.1/themes/base/jquery-ui.css" />
    <script src="http://code.jquery.com/jquery-1.8.2.js"></script>
    <script src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
<!-- base href="https://music.163.com/" -->
<link rel="shortcut icon"
	href="https://s1.music.126.net/style/favicon.ico?v20180823">
<link href="<%=base%>core_67aebd0bc8c9dcda93fb58bf37db973d.css"
	type="text/css" rel="stylesheet">
<link href="<%=base%>pt_frame_ef22bf4d2f6f9ce7e5eb4d28fe42b0e5.css"
	type="text/css" rel="stylesheet">
<link
	href="<%=base%>pt_discover_index_8d6a74f73cf730a86d019a23c526c3d2.css"
	type="text/css" rel="stylesheet">
<script src="<%=base%>prompt.js"></script>
<style>
.alert {
	display: none;
	position: fixed;
	top: 50%;
	left: 50%;
	min-width: 300px;
	max-width: 600px;
	transform: translate(-50%,-50%);
	z-index: 99999;
	text-align: center;
	padding: 15px;
	border-radius: 3px;
}

.alert-success {
    color: #3c763d;
    background-color: #dff0d8;
    border-color: #d6e9c6;
}

.alert-info {
    color: #31708f;
    background-color: #d9edf7;
    border-color: #bce8f1;
}

.alert-warning {
    color: #8a6d3b;
    background-color: #fcf8e3;
    border-color: #faebcc;
}

.alert-danger {
    color: #a94442;
    background-color: #f2dede;
    border-color: #ebccd1;
}
#btm {
	display: block;
	width: 100px;
	height: 31px;
	position: relative;
	top: 5px;
	left: 30px;
	line-height: 31px;
	text-align: center;
	color: #fff;
	background: #C20C0C;
}
#btm1 {
	display: block;
	width: 100px;
	height: 31px;
	position: relative;
	top: 5px;
	left: 140px;
	line-height: 31px;
	text-align: center;
	color: #fff;
	background: #C20C0C;
}

#login {
	display: none;
}

#nologin {
	display: none;
}
#pos{
position: absolute;
	top: 0px;
	left: 100px;
	weight:730px;
	height:283.883px;
}
</style>
</head>
<body id="auto-id-XCDrxsFOUILfNsLq">
<jsp:include page="head.jsp"></jsp:include>

	<div id="g_nav" class="m-subnav ">&nbsp;</div>
	<script>
		try {
			top.matchNav("discover", "discover");
		} catch (e) {
		}
	</script>
	<div class="n-ban d-flag mv-top" id="index-banner"
		style="background-image: url(&quot;http://p1.music.126.net/k39efbmtR6wkKQemsY4CCA==/109951165614698177.jpg?imageView&amp;blur=40x20&quot;); background-size: 6000px; background-position: center center;">
		<div class="wrap">
			<div class="ban f-pr" style="z-index: 10;">
				<div class="ban-img">
					<!-- <a hidefocus="true" class="active d-flag " style="overflow: hidden"
						href="https://music.163.com/song?id=1810350739" target=""> --> 
						<img
						class="d-flag" src="<%=base%>109951165614698177.jpg"
						id="pos"
						style="transition: none 0s ease 0s; opacity: 1;"  >
					<!-- </a> -->
				</div>
				<a hidefocus="true" href="javascript:void(0)"
					class="btnl click-flag f-alpha">&lt;</a> <a hidefocus="true"
					href="javascript:void(0)" class="btnr click-flag f-alpha">&gt;</a>
				<div class="dots f-cb">
					<a hidefocus="true" href="#" class="pg click-flag pg-flag f-alpha"
						data-index="0"></a> <a hidefocus="true" href="#"
						class="pg click-flag pg-flag f-alpha z-slt" data-index="1"></a> <a
						hidefocus="true" href="#" class="pg click-flag pg-flag f-alpha "
						data-index="2"></a> <a hidefocus="true" href="#"
						class="pg click-flag pg-flag f-alpha " data-index="3"></a> <a
						hidefocus="true" href="#" class="pg click-flag pg-flag f-alpha "
						data-index="4"></a> <a hidefocus="true" href="#"
						class="pg click-flag pg-flag f-alpha " data-index="5"></a> <a
						hidefocus="true" href="#" class="pg click-flag pg-flag f-alpha "
						data-index="6"></a> <a hidefocus="true" href="#"
						class="pg click-flag pg-flag f-alpha " data-index="7"></a> <a
						hidefocus="true" href="#" class="pg click-flag pg-flag f-alpha "
						data-index="8"></a>
				</div>
			</div>
		</div>
	</div>
	<div id="discover-module" class="g-bd1 f-cb n-top">
		<div class="g-mn1">
			<div class="g-mn1c">
				<div class="g-wrap3">
					<div class="n-rcmd">
						<div class="v-hd2">
							<a href="https://music.163.com/discover/playlist/"
								class="tit f-ff2 f-tdn">热门分类</a> <span class="more"><a
								href="https://music.163.com/discover/playlist/" class="s-fc3"></a><i
								class="cor s-bg s-bg-6">&nbsp;</i></span>
						</div>
						<ul class="m-cvrlst f-cb">
							<c:forEach items="${songtypes}" var="songtype">
								<li>
									<div class="u-cover u-cover-1">
										<img src="<%=base%><c:out value="${songtype.getPicture()}"/>">
										<a title="${songtype.getName()}"
											href="<c:url value="/typelist?st_id=${songtype.getId()}" />"
											class="msk"></a>
									</div>
									<p class="dec">
										<a title="${songtype.getName()}" class="tit s-fc0"
											href="<c:url value="/typelist?st_id=${songtype.getId()}" />">
											<c:out value="${songtype.getName()}" />
										</a>
									</p>
								</li>
							</c:forEach>
						</ul>
					</div>
					<div class="n-rcmd" id="personalRec"></div>
					<div id="j-music-ad" class="n-clmnad" data-has-music-ad="0">
						<div class="j-flag f-hide" id="auto-id-fmWCnJtOrh9Iq5QD"></div>
					</div>
					<div class="n-new">
						<div class="v-hd2">
							<a href="https://music.163.com/discover/album/"
								class="tit f-ff2 f-tdn">新专辑上架</a> <span class="more"><a
								href="https://music.163.com/discover/album/" class="s-fc3">更多</a><i
								class="cor s-bg s-bg-6">&nbsp;</i></span>
						</div>
						<div class="n-disk">
							<div class="inner" id="album-roller">
								<a hidefocus="true" href="#"
									class="click-flag pre s-bg s-bg-7 f-tdn">&nbsp;</a>
								<div class="roll f-pr">
									<!-- <ul class="f-cb roller-flag" style="left: -645px;"> -->

									<c:forEach items="${newalbums}" var="newalbum">
										<li>
											<div class="u-cover u-cover-alb1">
												<img class="j-img"
													src="<%=base%><c:out value="${newalbum.getPicture()}"/>">
												<a title="${newalbum.getName()}"
													href="<c:url value="/albumlist" />" class="msk"></a>
											</div>
											<p class="f-thide">
												<a title="${newalbum.getName()}"
													href="<c:url value="/albumlist" />" class="s-fc0 tit"><c:out
														value="${newalbum.getName()}" /></a>
											</p>
											<p class="tit f-thide" title="${newalbum.getName()}">
												<a class="s-fc3" href="<c:url value="/SingerDetail" />"><c:out
														value="${newalbum.getSinger().getName()}" /></a>
											</p>
										</li>
									</c:forEach>
									<!-- </ul> -->
								</div>
							</div>
						</div>
					</div>
					<div class="n-bill">
						<div class="v-hd2">
							<a href="https://music.163.com/discover/toplist"
								class="tit f-ff2 f-tdn">榜单</a> <span class="more"><a
								href="https://music.163.com/discover/toplist" class="s-fc3">更多</a><i
								class="cor s-bg s-bg-6">&nbsp;</i></span>
						</div>
						<div class="j-flag" id="auto-id-SqM4bng5SFH014M7">
									<table class="m-table ">
										<thead>
											<tr>
												<th class="first w1"><div class="wp">&nbsp;</div></th>
												<th><div class="wp af0"></div></th>
												<th class="w2"><div class="wp af1"></div></th>
												<th class="w3"><div class="wp af2"></div></th>
												<th class="w4"><div class="wp af3"></div></th>
											</tr>
										</thead>
										<tbody>
										<% int i=0; %>
											<c:forEach items="${songs}" var="song">
											<% i++; %>
											 <tr id="18052199141610207238391" class="even ">
												<td class="left"><div class="hd ">
														<span data-res-id="1805219914" data-res-type="18"
															data-res-action="play" data-res-from="13"
															data-res-data="2409342460" class="ply ">&nbsp;</span><span
															class="num"><%=i %></span>
													</div></td>
												<td class=""><div class="f-cb">
														<div class="tt">
															<div class="ttc">
																<span class="txt"><a
																	href="<c:url value="/SongPlay?song_id=${song.getId()}"/>"><b
																		title="<c:out value="${song.getName()}"/>">
																		<c:out value="${song.getName()}"/>
																	</b></a></span>
															</div>
														</div>
													</div></td>

												<td class=" s-fc3"><span class="u-dur ">   </span>
												
                                               <div class="opt hshow">
														<a class="u-icn u-icn-81 icn-add" href="javascript:;"
															title="添加到播放列表"  onclick="popBox()" ></a>
													</div>
											</td>
												<td class=""><div class="text"
														title="<c:out value="${song.getSinger().getName()}"/>">
														<span title="<c:out value="${song.getSinger().getName()}"/>"><a class=""
															href="<c:url value="/SingerDetail?singer_id=${song.getSinger().getId()}"/>"
															><c:out value="${song.getSinger().getName()}"/>
														</a></span>
													</div></td>
												<td class=""><div class="text">
														<a href="<c:url value="/albumDetail?album_id=${song.getAlbum().getId()}"/>"
															title="<c:out value="${song.getAlbum().getName()}"/>">
															<c:out value="${song.getAlbum().getName()}"/>
														</a>
													</div></td>
											</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
					</div>
				</div>
			</div>
		</div>
		<div class="g-sd1">
			<div class="n-user-profile">
				<div class="n-myinfo n-myinfo-1 s-bg s-bg-1" id="nologin">
					<p class="note s-fc3">登录网易云音乐，可以享受无限收藏的乐趣</p>
					<div >
					<a id="btm" href="login" class="btm">用户登录</a>
					<a id="btm1" href="OnlineMusicSite/user/register" class="btm">注册</a>
					</div>
				</div>




				<div class="n-myinfo n-myinfo-1 s-bg s-bg-1" id="login">
					<div class="f-cb">
						<a href="https://music.163.com/user/home?id=1958670928"
							class="head f-pr"> <img src="./109951163250233892(1).jpg">
						</a>
						<div class="info">
							<h4 style="overflow: hidden;">
								<a id="j-vip-code-to-home"
									href="https://music.163.com/user/home?id=1958670928"
									class="nm nm-icn f-fs1 f-ib f-thide">木偶奇遇记1908</a><span
									id="j-vip-code"></span>
							</h4>
							<div class="btnwrap f-pr">
								<a data-need-safety="false" data-action="checkin"
									href="javascript:;" hidefocus="true"
									class="sign u-btn2 u-btn2-2"><i>退 出</i></a>
							</div>
						</div>

					</div>
				</div>


<div class="alert"></div>
				<div class="n-singer">
					<h3 class="v-hd3">
						<span class="f-fl">歌手</span> <a
							href="https://music.163.com/discover/artist/signed/"
							class="more s-fc3">查看全部 &gt;</a>
					</h3>
					<ul class="n-enter f-cb" id="singer-list">
						<c:forEach items="${singers}" var="singer">
							<li><a href="<c:url value="/Singer" />" class="itm f-tdn">
									<div class="head">
										<img class="j-img"
											src="<%=base%><c:out value="${singer.getPictureURL()}"/>" />">
									</div>
									<div class="ifo">
										<h4>
											<span class="nm f-fs1 f-ib f-thide"><c:out
													value="${singer.getName()}" /></span>
										</h4>
									</div>
							</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<script src="core_9182ad1a80bc85131d29707ed69da654.js"
			type="text/javascript"></script>
		<iframe style="display: none;" id="auto-id-Th6JOGaxN81k2DWg"
			src="a.html" frameborder="0"></iframe>
		<script type="text/javascript" src="tool.js"></script>
		<script src="pt_discover_index_a8aeabe164ee75512a95c4111820e9f2.js"
			type="text/javascript"></script>
		<script type="text/javascript" src="tool.js"></script>
		<script src="ad_check.html" id="j-script-ad" type="text/javascript"></script>
		<div>
			<div></div>
		</div>
		<div></div>
		<div></div>
		<div class="global_container__10fOb"></div>
		<script>
			/*点击弹出按钮*/
			function popBox() {
				
				var user = '${user}';
				var arr = Object.keys(user);
				if (arr.length == 0) {
				        $('.alert').html('请先登录').addClass('alert-warning').show().delay(1500).fadeOut();

				} else {
					var popBox = document.getElementById("popBox");
					popBox.style.display = "block";
				}
			};
			window.onload = function() {
				var user = '${user}';
				var arr = Object.keys(user);
				if (arr.length == 0) {
					var nologin = document.getElementById("nologin");
					nologin.style.display = "block";
				} else {
					var login = document.getElementById("login");
					nologin.style.display = "block";
				}

			};
		</script>
		<jsp:include page="listwindow.jsp"></jsp:include>
		<jsp:include page="newlistwindow.jsp"></jsp:include>
		<%-- <%@ include file="listwindow.jsp"%> --%>
		<%-- <%@ include file="newlistwindow.jsp"%> --%>
</body>
</html>