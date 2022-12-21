<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Travel</title>
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
			<div class="blog">
		
			<h2 class="w3">旅行</h2>
			<div class="blog-grids1">
				<c:forEach items="${PageBlog.list}" var="p">
				<div class="col-md-6 blog-grid">
					<div class="blog-grid-left1">
<%--						<a href="singlepage.jsp"><img src="images/t1.jpg" alt=" " class="img-responsive"></a>--%>
						<a href="singLePage?id=${p.id}"><img src="${p.image}" alt=" " class="img-responsive"></a>
					</div>
					<div class="blog-grid-right1">
						<a href="singLePage?id=${p.id}">${p.info}</a>
						<h4>${p.creteTime}</h4>
						<p>${p.info}</p>
					</div>
					<div class="clearfix"> </div>
					<div class="more m1">
						<a class="btn effect6" href="singLePage?id=${p.id}">更多</a>
					</div>
				</div>
				</c:forEach>
			</div>
				<div class="clearfix"> </div>
			</div>
			<ul class="pagination">
				<li><a href="index?page=${PageBlog.page-1<1?1:(PageBlog.page-1)}" aria-label="Previous">上一页</a>
				</li>
				<c:forEach begin="1" end="${PageBlog.pageCount}" step="1" var="index">
					<li class="${PageBlog.page==index?'active':''}"><a href="index?page=${index}">${index}</a>
					</li>
				</c:forEach>
				<li>
					<a href="index?page=${(PageBlog.page+1>PageBlog.pageCount)?PageBlog.pageCount:(PageBlog.page+1)}">下一页 </a>
				</li>
			</ul>
		
	</div>

		<!-- technology-right -->
		<jsp:include page="../technology-left/technology-right1.jsp"></jsp:include>
		<!-- technology-right -->
		</div>
	</div>
<jsp:include page="../inc/footer.jsp"></jsp:include>
</body>
</html>




