<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
<title>About</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="applijewelleryion/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<%--<link href='http://fonts.useso.com/css?family=Raleway:400,600,700' rel='stylesheet' type='text/css'>--%>
<link href="css/style.css" rel='stylesheet' type='text/css' />	
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="../inc/header.jsp"></jsp:include>
	<!-- technology-left -->
	<div class="technology">
	<div class="container">
		<div class="col-md-9 technology-left">
		<div class="w3agile-1">
			<div class="welcome">
				<div class="welcome-top heading">
					<h2 class="w3">欢迎光临</h2>
					<div class="welcome-bottom">
						<img src="images/t4.jpg" class="img-responsive" alt="">
						<p>早上醒来，睡眼朦胧的站在窗前，被突然起来的大雨困扰起来了。早上鼓起了莫大的勇气才挣脱床爬起来，有点难过，难过辛苦爬起来却不能痛快的跑一场，有点开心，自己又可以偷懒了。</p>
						<p>一场大雨过后，天瓦蓝瓦蓝的，就像刚用水洗过的大玻璃，透亮透亮。空气中弥漫着厚重的泥土味，亲切，舒爽。</p>
					</div>
				</div>
			</div>
			<div class="team">	
				<h3 class="team-heading">告诉我们</h3>
				<div class="team-grids">
					<div class="col-md-6 team-grid">
						<div class="team-grid1">
							<img src="images/2.jpg" alt=" " class="img-responsive">
							<div class="p-mask">
								<p>美女图片献给大家</p>
								
							</div>
						</div>
						<h5>喜欢吗<span>太好看了</span></h5>

					</div>
					<div class="col-md-6 team-grid">
						<div class="team-grid1">
							<img src="images/3.jpg" alt=" " class="img-responsive">
							<div class="p-mask">
								<p>美女图片献给大家</p>
								
							</div>
						</div>
						<h5>可爱吗<span>太可爱了</span></h5>

					</div>
					
				
					<div class="clearfix"> </div>
				</div>				
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