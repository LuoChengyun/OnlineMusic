<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta http-equiv="pragma" content="no-cache"/>
<base href="." target="_top">
<%@ page language="java" import="java.lang.*"%>
<%
	String base = "/OnlineMusicSite/resource/list/";
%>
<link rel="shortcut icon"
	href="https://s1.music.126.net/style/favicon.ico?v20180823">
<link
	href="<%=base%>pt_discover_index_8d6a74f73cf730a86d019a23c526c3d2.css"
	type="text/css" rel="stylesheet">
<link href="<%=base%>core_67aebd0bc8c9dcda93fb58bf37db973dabc.css"
	type="text/css" rel="stylesheet">
<link href="<%=base%>pt_frame_ef22bf4d2f6f9ce7e5eb4d28fe42b0e5.css"
	type="text/css" rel="stylesheet">
<script type="text/javascript" src="<%=base%>vipcashier.umd.js"></script>
<script type="text/javascript" charset="UTF-8"
	src="<%=base%>watchman.min.js"></script>
<style>
.ziti{
  font-size:16px;
   font-family:'微软雅黑';
color: #C20C0C;
}
.ziti2{
line-height: 24px;
font-size: 20px;
font-weight: normal;
color: #333;}
</style>
</head>
<body id="auto-id-U682P7RoLcWXx0WF" class="auto-1610207238397-parent">
<jsp:include page="head.jsp"></jsp:include>
	<script>
		try {
			top.matchNav("discover", "other");
		} catch (e) {
		}
	</script>
	<div id="m-playlist" class="g-bd4 f-cb n-top">
		<div class="g-mn4">
			<div class="g-mn4c">
				<div class="g-wrap6">
					<div class="m-info f-cb" id="auto-id-KKrF448WBYDgX2E">
						<div class="cover u-cover u-cover-dj">
							<img src="<%=base %><c:out value="${songtype.getPicture()}"/>"
								class="j-img"
								data-src="http://p3.music.126.net/i096h-DPkKPN5f_Q7l-XHQ==/109951165614206944.jpg">
							<span class="msk"></span>
						</div>
						<div class="cnt">
							<div class="cntc">
								<div class="hd f-cb">
									<i class="f-fl u-icn u-icn-13 f-pr"><span
										class="f-pa f-r-white-icon"
										style="display: inline-block; width: 8px; height: 8px; top: 2px; background-size: cover; left: 34px;"></span></i>
									<div class="tit">
                                            <a class="ziti2">火箭(<c:out value="${songtype.getName()}" /></a>
                                            <a class="ziti">专辑</a>
                                            <a class="ziti2">)</a>
											

									</div>
								</div>
								<%-- <div class="user f-cb">
									<a class="face" href="https://music.163.com/user/home?id=1"><img
										src="<%=base %><c:out value="${songtype.getPicture()}"/>"></a>
								</div> --%>
								<div id="content-operation" class="btns f-cb"
									data-rid="2409342460" data-type="13" data-special="100">
									<a data-res-action="play" data-res-id="2409342460"
										data-res-type="13" href="javascript:;"
										class="u-btn2 u-btn2-2 u-btni-addply f-fl" hidefocus="true"
										title="播放"><i><em class="ply"></em>播放</i></a>

								</div>
								<p id="album-desc-more" class="intr f-brk">								
									<b>歌手：</b> 每周最新上线歌曲，编辑精选推荐。<br>
								</p>
								<p id="album-desc-more" class="intr f-brk">
								
									<b>介绍：</b> 每周最新上线歌曲，编辑精选推荐。<br>
								</p>
							</div>
						</div>
					</div>
					<div class="n-songtb">
						<div class="u-title u-title-1 f-cb">
							<h3>
								<span class="f-ff2">歌曲列表</span>
							</h3>
							<span class="sub s-fc3"><span id="playlist-track-count"><c:out
										value="${songlist.size()}" /></span>首歌</span>
							<div class="out out-list s-fc3">
								<i class="u-icn u-icn-95 f-fl"></i>
							</div>
						</div>
						<div id="song-list-pre-cache" data-key="track_playlist-2409342460"
							data-simple="1" data-pvnamed="1">
							<div oncopy="return false;" oncut="return false;"
								ondragstart="return false;" id="auto-id-KvTaGiPTom8oU1fO">
								<div class="j-flag" id="auto-id-SqM4bng5SFH014M7">
									<table class="m-table ">
										<thead>
											<tr>
												<th class="first w1"><div class="wp">&nbsp;</div></th>
												<th><div class="wp af0"></div></th>
												<th class="w2"><div class="wp "></div></th>
												<th class="w3"><div class="wp "></div></th>
												<th class="w4"><div class="wp "></div></th>
											</tr>
										</thead>
										<tbody>
										<% int i=0; %>
											<c:forEach items="${songlist}" var="song">
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

												<td class=" s-fc3"><span class="u-dur "></span>
												
                                               <div class="opt hshow">
														<a class="u-icn u-icn-81 icn-add" href="javascript:;"
															title="添加到播放列表" hidefocus="true" data-res-type="18"
															data-res-id="1805219914" data-res-action="addto"
															data-res-from="13" data-res-data="2409342460"></a>
													</div>
											</td>
												<td class=""><div class="text"
														title="<c:out value="${song.getSinger().getName()}"/>">
														<span title="<c:out value="${song.getSinger().getName()}"/>"><a class=""
															href="<c:url value="/SingerDetail?singer_id=${song.getSinger().getId()}"/>"
															>
														</a></span>
													</div></td>
												<td class=""><div class="text">
														<a href=""
															title="<c:out value="${song.getAlbum().getName()}"/>">
														</a>
													</div></td>
											</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<div class="j-flag"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="g-sd4">
			<div class="g-wrap7 n-top">
				<div id="j-music-ad" class="m-sidead f-hide" data-has-music-ad="0">
					<div class="j-flag f-hide" id="auto-id-0cDCU6FWTII3DZbo"></div>
					<div class="f-hide j-flag">
						<ins class="adsbydm" inner-prod="adbid" inner-width="200"
							inner-height="220"
							inner-src="https://iad.g.163.com/wa/ad?site=netease&amp;affiliate=music&amp;cat=detail&amp;type=logo200x220&amp;location=1"
							check-src="https://iad.g.163.com/wa/ad_check?site=netease&amp;affiliate=music&amp;cat=detail&amp;type=logo200x220&amp;location=1"></ins>
					</div>
				</div>
				<script src="<%=base%>core_9182ad1a80bc85131d29707ed69da654.js"
					type="text/javascript"></script>
				<iframe frameborder="0" id="auto-id-cvO2Rs6T5a1mnWyc"
					style="display: none;" src="<%=base%>saved_resource(2).html"></iframe>
				<script type="text/javascript" src="<%=base%>tool.min.js"></script>
				<script
					src="<%=base%>pt_playlist_index_0197927c98e28b6e3fb10b44b48f4400.js"
					type="text/javascript"></script>
				<script defer="defer" src="<%=base%>ntes-ad-cloud.min.js"></script>
				<div>
					<div></div>
				</div>
				<div></div>
				<div></div>
				<div class="global_container__10fOb"></div>
			</div>
		</div>
	</div>
</body>
</html>