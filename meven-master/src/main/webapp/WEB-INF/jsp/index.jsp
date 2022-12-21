<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content=""/>
    <script type="applijewelleryion/x-javascript">
         addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); }
    </script>
    <link href="../../css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <!-- Custom Theme files -->
<%--   <link href='http://fonts.useso.com/css?family=Raleway:400,600,700' rel='stylesheet' type='text/css'>--%>
    <link href="../../css/style.css" rel='stylesheet' type='text/css'/>
    <script src="../../js/jquery.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <!-- animation-effect -->
    <link href="../../css/animate.min.css" rel="stylesheet">
    <script src="../../js/wow.min.js"></script>
    <script>
        new WOW().init();
    </script>
    <!-- //animation-effect -->
    <style>
        #myTabContent img{
            width: 300px;
            height: 200px;
        }
        .tch-img   img{
            height: 300px;
        }
    </style>
</head>
<body>
<%@ include file="inc/header.jsp" %>
<jsp:include page="banner.jsp"></jsp:include>
<!-- technology-left -->
<div class="technology">
    <div class="container">
        <jsp:include page="technology-left/technology-left.jsp"></jsp:include>

<%--        <c:forEach items="${PageBlog.list}" var="p">--%>
<%--        <p>${p.image},${p.title},为啥${p},,,${p.categoriesId},,,${p.blog.title}</p>--%>
<%--        </c:forEach>--%>
        <!-- technology-right -->
        <jsp:include page="technology-left/technology-right1.jsp"></jsp:include>
        <div class="clearfix"></div>
        <!-- technology-right -->
    </div>
</div>
<%@ include file="inc/footer.jsp" %>
</body>
</html>