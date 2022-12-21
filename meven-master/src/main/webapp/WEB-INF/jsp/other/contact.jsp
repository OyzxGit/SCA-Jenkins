<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
<title>联系</title>
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
			<div class="contact-section">
				<h2 class="w3">联系</h2>


					<div class="contact-grids">
						<div class="col-md-8 contact-grid">

							<p>那一年，梁山伯与祝英台终究要双双长眠于地下，那一年白蛇终究别了许仙，杜十娘饮恨投下了百宝箱，随同自己枯萎的爱情，那昙花一现的梦幻，一起破碎的跳入滚滚不息的大江。原来苍天是没有感情的，下雨了，不是为人们流泪，千年来依旧这么默默残忍的观看着人间，它没有感情，因为它选择了不老。</p>
							<form action="addContactUs" method="post">
                                <input type="hidden" name="userId" value="${user.id}">
								<div class="form-group">
							<label>姓名</label><input type="text" name="trueName" value="${user.trueName}">
								</div>
								<div class="form-group">
								<label>邮箱</label>	<input type="email" name="email" value="${user.email}" >
								</div>
									<div class="form-group">
										<label>电话</label>	<input type="text" name="tel" value="${user.tel}" placeholder="电话"></div>
								<textarea type="text" name="context" placeholder="内容" ></textarea>
								<input type="submit" value="发送">
							</form>
						</div>
						<div class="col-md-4 contact-grid1">
							<h4>地址</h4>
							<div class="contact-top">


								<div class="clearfix"></div>
							</div>
							<ul>
									<li><i class="glyphicon glyphicon-earphone" aria-hidden="true"></i> 联系人：123456789</li>
									<li><i class="glyphicon glyphicon-phone" aria-hidden="true"></i> 公司电话： 369822147</li>
									<li><i class="glyphicon glyphicon-envelope" aria-hidden="true"></i> <a href="#"></a><a href="mailto:info@example.com">520@321.com</a></li>
									<li><i class="glyphicon glyphicon-print" aria-hidden="true"></i> Fax : 199002563</li>
								</ul>

						</div>
						<div class="clearfix"></div>
					</div>
			</div>
		</div>
		<!-- technology-right -->
		<jsp:include page="../technology-left/technology-right1.jsp"></jsp:include>
		<%--<div class="col-md-3 technology-right">


				<div class="blo-top1">

					<div class="tech-btm">
					<div class="search-1">
							<form action="#" method="post">
								<input type="search" name="Search" value="搜索" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}" required="">
								<input type="submit" value=" ">
							</form>
						</div>
					<h4>热门帖子 </h4>
						<c:forEach items="${PageBlog.list}" var="p">
						<div class="blog-grids">
							<div class="blog-grid-left">
								<a href="singLePage?id=${p.id}"><img src="${p.image}" class="img-responsive" alt=""></a>
							</div>
							<div class="blog-grid-right">

								<h5><a href="singLePage?id=${p.id}">${p.info}</a> </h5>
							</div>
							<div class="clearfix"> </div>
						</div>
						</c:forEach>
					&lt;%&ndash;	<div class="blog-grids">
							<div class="blog-grid-left">
								<a href="singlepage.jsp"><img src="images/m2.jpg" class="img-responsive" alt=""></a>
							</div>
							<div class="blog-grid-right">

								<h5><a href="singlepage.jsp">Pellentesque dui Maecenas male</a> </h5>
							</div>
							<div class="clearfix"> </div>
						</div>
						<div class="blog-grids">
							<div class="blog-grid-left">
								<a href="singlepage.jsp"><img src="images/f3.jpg" class="img-responsive" alt=""></a>
							</div>
							<div class="blog-grid-right">

								<h5><a href="singlepage.jsp">Pellentesque dui Maecenas male</a> </h5>
							</div>
							<div class="clearfix"> </div>
						</div>
						<div class="blog-grids">
							<div class="blog-grid-left">
								<a href="singlepage.jsp"><img src="images/t3.jpg" class="img-responsive" alt=""></a>
							</div>
							<div class="blog-grid-right">

								<h5><a href="singlepage.jsp">Pellentesque dui Maecenas male</a> </h5>
							</div>
							<div class="clearfix"> </div>
						</div>
						<div class="blog-grids">
							<div class="blog-grid-left">
								<a href="singlepage.jsp"><img src="images/m3.jpg" class="img-responsive" alt=""></a>
							</div>
							<div class="blog-grid-right">

								<h5><a href="singlepage.jsp">Pellentesque dui Maecenas male</a> </h5>
							</div>
							<div class="clearfix"> </div>
						</div>&ndash;%&gt;
						<div class="insta">
					<h4>欢迎</h4>
						<ul>
							<c:forEach items="${PageBlog.list}" var="p">
							<li><a href="singLePage?id=${p.id}"><img src="${p.image}" class="img-responsive" alt=""></a></li>
							</c:forEach>
						</ul>
					</div>

					<p>人会因为一个味道，一辈子，都对一个事情印象深刻。就像是，下雨打在泥土上的味道，我就会想起来小时候在校园里面跑步的时候突然下大雨，然后我们几个赶快跑跑跑，跑到教室躲雨的样子。</p>
					</div>



				</div>


		</div>
		<div class="clearfix"></div>--%>
		<!-- technology-right -->
	</div>
</div>

<jsp:include page="../inc/footer.jsp"></jsp:include>
</body>
</html>