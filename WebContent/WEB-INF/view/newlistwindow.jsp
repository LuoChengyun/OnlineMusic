<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#popBox1 {
            display: none;
            background-color: #FFFFFF;
            z-index: 11;
            position:fixed;
            top:20%;
            left:35%;
        }

</style>
</head>
<body>
<div class="auto-1610519790492 m-layer z-show m-layer-w2" id="popBox1">
<div class="zbar" id="auto-id-RkD82XMdKWneeQCG"><div class="zttl f-thide">新建歌单</div></div>
<div class="zcnt"><div class="lyct m-crgd f-cb f-tc" id="auto-id-3HZ0RgV808inP6g0">
<p>歌单名：<input type="text" class="u-txt j-flag" id="auto-id-VdhQZmmrkVi7Mq5u"></p>
<div class="u-err f-vhide j-flag"><i class="u-icn u-icn-25"></i>错误提示</div>
<p class="tip s-fc4">可通过“收藏”将音乐添加到新歌单中</p>
<div class="btn">
<a href="javascript:;" class="u-btn2 u-btn2-2 u-btn2-w2 j-flag" hidefocus="true" id="auto-id-g7lvtGuTQGZwCNPn" onclick="closeBox11()"><i>新 建</i></a>
<a href="javascript:;" class="u-btn2 u-btn2-1 u-btn2-w2 j-flag" hidefocus="true" id="auto-id-Lp2NJuTuzhDTuGQr" onclick="closeBox12()"><i>取 消</i></a>
</div>
</div></div><span class="zcls" title="关闭窗体" id="auto-id-7WoFmimIxhHNBUQm">×</span></div><div class="auto-1610519790491">&nbsp;</div>
<script>
  
    function closeBox11() {
        var popBox = document.getElementById("popBox1");
        popBox.style.display = "none";
        $('.alert').html('操作成功').addClass('alert-success').show().delay(1500).fadeOut();
    }
    function closeBox12() {
        var popBox = document.getElementById("popBox1");
        popBox.style.display = "none";
       
    }
</script>
</body>
</html>