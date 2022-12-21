<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Singlepage</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content=""/>
    <script type="applijewelleryion/x-javascript">
         addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); }


    </script>
    <link href="../../../css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <!-- Custom Theme files -->
    <%--<link href='http://fonts.useso.com/css?family=Raleway:400,600,700' rel='stylesheet' type='text/css'>--%>
    <link href="../../../css/style.css" rel='stylesheet' type='text/css'/>
    <script src="../../../js/jquery.js"></script>
    <script src="../../../js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="../inc/header.jsp"></jsp:include>
<!-- technology-left -->
<div class="technology">
    <div class="container">
        <div class="col-md-9 technology-left">
            <div class="agileinfo">

                <h2 class="w3">${blog.title}</h2>
                <div class="single">
                    <img src="${blog.image}" class="img-responsive" alt="">
                    <div class="b-bottom">
                        <h5 class="top">${blog.info}</h5>
                        ${blogHtml.html}
                        <p>创建时间: &emsp; ${blog.creteTime} <a class="span_link collect" href="#"><span class="glyphicon glyphicon-comment"></span>收藏${blog.topCount}
                        </a><a class="span_link" href="#"><span class="glyphicon glyphicon-eye-open"></span>浏览${blog.viewCount}</a></p>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <!-- technology-right -->
        <jsp:include page="../technology-left/technology-right1.jsp"></jsp:include>
        <div class="clearfix"></div>
        <!-- technology-right -->


        <%--		comment--%>
        <div class="response">
            <h4>评论</h4>
            <c:forEach items="${liComment}" var="p" varStatus="i">

                <div class="media response-info">
                    <c:choose>
                        <c:when test="${p.parentId==0}">
                            <div class="media-left response-text-left">
                                <a href="#">
                                    <img src="${p.user.img}" style="width: 80px" class="img-responsive" alt="">
                                    <p>${p.user.loginName}</p>
                                </a>
                            </div>

                            <div class="media-body response-text-right">
                                <p>${p.content}</p>
                                <ul>
                                    <li>${p.creteTime}</li>
                                    <butoon class="Reply2">回复</butoon>
                                </ul>
                                <div  class="col-lg-9 Reply1">
                                    <input value="${blog.id}" id="blogId1" type="hidden">
                                    <input value="${user.id}" id="userId1" type="hidden">
                                    <input value="${p.id}" class="parentId" type="hidden">
                                    <textarea class="form-control Reply3" name="Reply3"></textarea>
                                    <button class="btn btn-sm btn-primary Reply4">提交</button>
                                </div>

                            <c:forEach items="${p.li}" var="q">
                                <c:choose>
                                    <c:when test="${p.id eq q.parentId}">

                                        <div class="media response-info">
                                            <div class="media-left response-text-left">
                                                <a href="#">
                                                    <img src="${q.user.img}" style="width: 80px" class="img-responsive"alt="">
                                                    <p>${q.user.loginName}</p>
                                                </a>
                                            </div>
                                            <div class="media-body response-text-right">
                                                <p>${q.content}</p>
                                                <ul>
                                                    <li>${q.creteTime}</li>
                                                    <li><a href="#">Reply</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </c:when>
                                </c:choose>
                            </c:forEach>
                            <div class="clearfix"></div>

                        </c:when>
                    </c:choose>


                    <div class="clearfix"></div>
                </div>
                </div>
            </c:forEach>

            <%--		留下你的评论--%>
            <div class="coment-form">
                <div class="col-sm-offset-1 col-sm-10">
                    <h4>留下你的评论</h4>
                </div>
                <form>
                    <input name="blogId" value="${blog.id}" id="blogId" type="hidden">
                    <input name="userId" value="${user.id}" id="userId" type="hidden">
                    <div class="col-sm-offset-1 col-sm-10">
                        <input type="text" value="${user.loginName}" name="loginName" id="loginName"
                               class="form-control" style="width: 100%" required="">
                    </div>
                    <div class="col-sm-offset-1 col-sm-10">
                        <textarea placeholder="你的评论" class="form-control" name="content" id="content"
                                  required=""></textarea>
                    </div>
                    <div class="col-sm-offset-1 col-sm-10" style="margin-top: 10px">
                        <input class="btn btn-sm btn-block btn-primary" type="button" onclick="sub()" value="提交评论">
                    </div>
                </form>
            </div>
        </div>


    </div>
    <jsp:include page="../inc/footer.jsp"></jsp:include>


    <script>
        $(".collect").click(function () {
          let blogId1 =  ${blog.id};
          let topCount1 =  ${blog.topCount};

          $.post("collectColl", {blogId1,topCount1}, function () {
               window.location.reload();
          })
        })




        $(".Reply1").css('display', 'none');
        $(".Reply2").click(function () {
            $(this).parent().siblings().show();
        })

        $(".Reply4").click(function () {
            let blogId = $("#blogId1").val();
            let userId = $("#userId1").val();
            let content = $(this).parent().children(".Reply3").val()
            let parentId = $(this).parent().children(".parentId").val()
            $.post("addComment", {blogId, userId, content, parentId}, function (response) {
                console.info(response);
                window.location.reload();
            })

        })

        function sub() {
            let blogId = $("#blogId").val();
            let userId = $("#userId").val();
            let content = $("#content").val();

            $.post("addComment", {blogId, userId, content}, function (response) {
                console.info(response);
                window.location.reload();
            })
        }
    </script>
</body>
</html>