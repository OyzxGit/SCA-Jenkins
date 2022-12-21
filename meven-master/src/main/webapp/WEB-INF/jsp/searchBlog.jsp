<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/15 0015
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link href="../../css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <link href="../../css/style.css" rel='stylesheet' type='text/css'/>
    <script src="../../js/jquery.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <link href="../../css/animate.min.css" rel="stylesheet">
    <script src="../../js/wow.min.js"></script>
    <style>
        .row.userAll {
            margin-bottom: 10px;
            padding: 10px;
            border: 2px solid black;
        }

        #imgBig {
            width: 190px;
        }

        #loName {
        }

    </style>
</head>
<body>
<jsp:include page="inc/header.jsp"></jsp:include>
<div class="technology">
    <div class="container">
        <div class="col-md-9 technology-left">
            <div class="row">
                <div class="container col-md-12">
                    <div style="overflow: auto">
                            <div class="wthree">
                                    <%--  for--%>
                                        <c:forEach items="${SearchBlog.list}" var="p" varStatus="i">
                                <div class="col-md-6 wthree-left wow fadeInDown" style="padding-right: 10px" data-wow-duration=".8s"
                                     data-wow-delay=".2s">
                                    <div class="tch-img">
                                        <a href="singLePage?id=${p.id}">
                                            <img src="${p.image}" class="img-responsive" alt=""></a>
                                    </div>

                                    <h3><a href="singLePage?id=${p.id}">${p.title}</a></h3>
                                    <h6><a href="singLePage?id=${p.id}">中国 </a>${p.creteTime}</h6>
                                    <p>${p.info}</p>
                                    <div class="bht1">
                                        <a href="singLePage?id=${p.id}">更多</a>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                              <%--  <c:if test="${i.index%2 == 0}">
                                <div class="col-md-2">1
                                </div>
                                </c:if>--%>
                                        </c:forEach>
                                    <%--  尾部--%>
                                <div class="clearfix"></div>
                            </div>

                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="technology-left/technology-right1.jsp"></jsp:include>

    </div>
</div>
<jsp:include page="inc/footer.jsp"></jsp:include>
</body>
</html>
