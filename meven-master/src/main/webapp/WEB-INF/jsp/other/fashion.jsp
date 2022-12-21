<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Fashion</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="applijewelleryion/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<%--<link href='http://fonts.useso.com/css?family=Raleway:400,600,700' rel='stylesheet' type='text/css'>--%>
<link href="css/style.css" rel='stylesheet' type='text/css' />	
<script src="js/jquery-1.11.1.min.js"></script>
<!--light-box-files-->
<link rel="stylesheet" href="css/chocolat.css" type="text/css" media="screen">
<script src="js/jquery.chocolat.js"></script>
<script type="text/javascript">
	$(function() {
		$('.gallery-grid a').Chocolat();
	});
</script>
<!--//light-box-files-->
<script src="js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="../inc/header.jsp"></jsp:include>

<%--外引入  start--%>
<%--<div class="module index-slide" style="border-top-color: rgb(216, 216, 216);">
	<div class="main">
		<div class="swiper-container">
			<div class="swiper-wrapper clearfix" style="width: 12000px; transition-duration: 0ms; transform: translate3d(-2000px, 0px, 0px);">
				<c:forEach items="${PageBlog.list}" var="p">
				<div class="swiper-slide" style="width: 1000px;">
				<a href="singLePage?id=${p.id}" target="_blank" title="新剧《智异山》上线，40岁的全智贤又一次美上了热搜"><img src="${p.image}" width="1000" height="564" alt="新剧《智异山》上线，40岁的全智贤又一次美上了热搜" title="新剧《智异山》上线，40岁的全智贤又一次美上了热搜"></a>
				<div class="title-mask">
					<a href="singLePage?id=${p.id}" target="_blank" title="新剧《智异山》上线，40岁的全智贤又一次美上了热搜">新剧《智异山》上线，40岁的全智贤又一次美上了热搜</a>
					<div class="des">最近韩剧《智异山》上线了。一经播出韩国首尔地区平均收视12.2%，在同时间段占据了韩国电视剧的第1位，饰演护林员的女主全智贤...</div>
				</div>
			</div>
				</c:forEach>

			</div>
			<div class="index-slide-line"></div>
			<div class="arrow pre-arrow">
				<div class="arrow-bg"></div>
				<i></i>
			</div>
			<div class="arrow next-arrow">
				<div class="arrow-bg"></div>
				<i></i>
			</div>
			<div class="slide-helper-l"></div>
			<div class="slide-helper-r"></div>
		</div>
		<div class="pagination"><span class="swiper-pagination-switch swiper-visible-switch swiper-active-switch"></span><span class="swiper-pagination-switch"></span><span class="swiper-pagination-switch"></span><span class="swiper-pagination-switch"></span><span class="swiper-pagination-switch"></span><span class="swiper-pagination-switch"></span><span class="swiper-pagination-switch"></span><span class="swiper-pagination-switch"></span></div>
	</div>
</div>--%>
<%--外引入   end--%>
	<!-- technology-left -->
	<div class="technology">
	<div class="container">
		<div class="col-md-9 technology-left">
			<div class="gallery" id="gallery">
		
			<h2 class="w3">时尚</h2>
			<p>时尚，拼音 shí shàng，“时尚”一词已是这个世界的潮流代言词，英文为fashion，几乎是经常挂在某些人的嘴边，频繁出现在报刊媒体上。很多人对时尚的理解都不同，有人认为时尚即是简单，与其奢华浪费，不如朴素节俭；有时时尚只是为了标新立异；给人焕然一新拥有时尚王风范的感觉，现实中很多与时尚不同步的人被指为老土、落伍；所谓时尚，是时与尚的结合体。所谓时，乃时间，时下，即在一个时间段内；尚，则有崇尚，高尚，高品位，领先。时尚在这个时代而言的，不只是为了修饰，而已经演化成了一种追求真善美的意识。</p>
			<div class="gallery-grids">
				<c:forEach items="${PageBlog.list}" var="p">
				<div class="gallery-grid">
					<a href="singLePage?id=${p.id}" class="wow fadeInUp animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInUp;">
						<img src="${p.image}" alt=" " class="img-responsive zoom-img">
					</a>
				</div>
				</c:forEach>
				<div class="clearfix"> </div>
			</div>
	</div>
		</div>
		<!-- technology-right -->
		<jsp:include page="../technology-left/technology-right1.jsp"></jsp:include>
		<!-- technology-right -->
	</div>
</div>
<jsp:include page="../inc/footer.jsp"></jsp:include>
</body>
</html>