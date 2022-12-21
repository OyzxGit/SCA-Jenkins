<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Music</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="applijewelleryion/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<%--<link href='http://fonts.useso.com/css?family=Raleway:400,600,700' rel='stylesheet' type='text/css'>--%>
<link href="css/style.css" rel='stylesheet' type='text/css' />	
<link rel="stylesheet" type="text/css" href="css/component.css" />
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/modernizr.custom.js"></script>
</head>
<body>
<jsp:include page="../inc/header.jsp"></jsp:include>

	<!-- technology-left -->
	<div class="technology">
	<div class="container">
		<div class="col-md-9 technology-left">
			<div class="music">
				<div class="latest">
						<h2 class="w3">音乐</h2>
						<div class="tip-grids">
							<div class="col-md-6 tip-grid">
								<figure class="effect-julia">
									<img src="${PageBlog.list[3].image}" alt="">
												
								</figure>
							</div>
							<div class="col-md-6 tip-grid-right">
								<div class="tip-gd-left">
										<h4>${PageBlog.list[3].title}</h4>
										<p>${PageBlog.list[3].info}</p>
									<p> </p>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
				</div>
				<div class="effect-grid">
						<h3 class="w3">详情</h3>
						<ul class="grid cs-style-3">
							<c:forEach items="${PageBlog.list}" var="p">
						<li>
							<figure>
								<img src="${p.image}" alt="img02">
								<figcaption >
									<a style="padding-right: 110px;" href="singLePage?id=${p.id}"><h4>更多</h4></a>
								</figcaption>
							</figure>
						</li>
							</c:forEach>
						<div class="clearfix"></div>
					</ul>
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