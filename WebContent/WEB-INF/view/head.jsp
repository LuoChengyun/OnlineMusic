<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ page language="java" import="java.lang.*"%>
<%String base="/OnlineMusicSite/resource/home/"; %>
<style>
#logo1{
 height:50px;
 width:190px;
 position: absolute;
 top: 20px;
 left: 100px;
 color: red;
 background: #242424;
 
  font-size:25px;
   font-family:'微软雅黑';
}
#logo2{
 height:50px;
 width:190px;
 position: absolute;
 top: 20px;
 left: 140px;
 color: white;
 font-weight:bold;
 background: #242424;
 
  font-size:25px;
   font-family:'微软雅黑';
}
</style>
</head>
<link href="<%=base %>core_67aebd0bc8c9dcda93fb58bf37db973d.css" type="text/css" rel="stylesheet"><link href="<%=base %>pt_frame_ef22bf4d2f6f9ce7e5eb4d28fe42b0e5.css" type="text/css" rel="stylesheet">
<link href="<%=base %>pt_discover_index_8d6a74f73cf730a86d019a23c526c3d2.css" type="text/css" rel="stylesheet">
<body>
<div id="g-topbar" class="g-topbar" style="width: 1519px; top: 0px;">
<div class="m-top">
<div class="wrap f-cb">
<h1 class="logo"><a  href="https://music.163.com/#" >OnlineMusic</a></h1>
<a   id="logo1">On</a><a   id="logo2">Music</a>
<ul class="m-nav j-tflag">
<li class="fst">
<span><a  href="https://music.163.com/#" data-module="discover" class="z-slt"><em>发现音乐</em><sub class="cor">&nbsp;</sub></a></span>
</li>
<li>
<span><a data-action="bilog" data-log-action="page" data-log-json="{&quot;type&quot;:&quot;my&quot;}"  href="https://music.163.com/my/" data-module="my"><em>我的</em><sub class="cor">&nbsp;</sub></a></span>
</li>
</ul>
<!-- <div class="m-tophead f-pr j-tflag" id="auto-id-9mef29364ouff2rh"><a  href="#" class="link s-fc3" data-action="login">登录</a>
<div class="m-tlist j-uflag" style="display:none;">
<div class="inner">
</div>
<i class="arr"></i>
</div>
</div> -->
<!-- <a data-action="bilog" data-log-action="click" data-log-json="{&quot;target&quot;:&quot;uploadvideo&quot;,&quot;page&quot;:&quot;homepage&quot;}" href="https://music.163.com/login?targetUrl=%2Fcreatorcenter" target="_blank" class="m-topvd f-pr m-creator-center">创作者中心</a> -->
<div class="m-srch f-pr j-suggest" id="g_search">
<div class="srchbg">
<span class="parent">
<input type="text" name="srch" id="srch" class="txt j-flag" style="opacity: 1;">
<label class="ph j-flag" id="auto-id-nZo4MGUP6nFwMLAf">音乐/视频/电台/用户</label>
</span>
</div>
<div class="j-showoff u-showoff f-hide"><p>现在支持搜索MV啦~</p></div>
<span class="j-flag" style="display:none;" id="auto-id-T4M3OBOHqdorFAmq">&nbsp;</span>
<div class="u-lstlay j-flag" style="display:none;" id="auto-id-4KUq5xSCQl35Mvyr"></div>
</div>
</div>
</div>
<div class="m-subnav m-subnav-up f-pr j-tflag f-hide"></div>
<div id="g_nav2" class="m-subnav j-tflag">
<div class="wrap f-pr">
<ul class="nav">
<li><a  data-module="discover" href="./main/discover.html" class="z-slt" target="g_iframe"><em>推荐</em></a></li>
<li><a  data-module="toplist" href="https://music.163.com/discover/toplist"><em>音乐排行榜</em></a></li>
<li><a  data-module="artist" href="https://music.163.com/discover/artist"><em>歌手</em></a></li>
<li><a  data-module="album" href="https://music.163.com/discover/album"><em>新专辑上架</em></a></li>
</ul>
</div>
</div>
</div>
</body>
</html>