<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="header" id="ban">
    <div class="container">
        <div class="head-left wow fadeInLeft animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInLeft;">
            <div class="header-search">
                <div class="search">
                    <input class="search_box" type="checkbox" id="search_box">
                    <label class="icon-search" for="search_box"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></label>
                    <div class="search_form">
                        <form action="#" method="post">
                            <input type="text" name="Search" placeholder="Search...">
                            <input type="submit" value="Send">
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="header_right wow fadeInLeft animated animated" data-wow-delay=".5s" style="visibility: visible;margin-left:30px; animation-delay: 0.5s; animation-name: fadeInLeft;">
            <nav class="navbar navbar-default">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
                    <nav class="link-effect-7" id="link-effect-7">
                        <ul class="nav navbar-nav" id="ty">
                            <li class="${pageContext.request.requestURI.contains("index")?"active act":""}"><a href="/index">主页</a></li>
                            <li class="${pageContext.request.requestURI.contains("about")?"active act":""}"><a href="/about">关于</a></li>
                            <li class="${pageContext.request.requestURI.contains("travel")?"active act":""}"><a href="/travel">旅行</a></li>
                            <li class="${pageContext.request.requestURI.contains("fashion")?"active act":""}"><a href="/fashion">时尚</a></li>
                            <li class="${pageContext.request.requestURI.contains("music")?"active act":""}"><a href="/music">音乐</a></li>
                            <li class="${pageContext.request.requestURI.contains("contact")?"active act":""}"><a href="/contact">联系</a></li>
                            <li class="${pageContext.request.requestURI.contains("userUpdate")?"active act":""}"><a href="/userUpdate?id=${user.id}">用户修改</a></li>
                            <li class="${pageContext.request.requestURI.contains("editBlog")?"active act":""}"><a href="/editBlog">博客添加</a></li>
                            <li class="${pageContext.request.requestURI.contains("userblog")?"active act":""}"><a href="/userblog?id=${user.id}">博客修改</a></li>
                        </ul>
                    </nav>
                </div>
                <!-- /.navbar-collapse -->
            </nav>
        </div>
        <script>

             /*    alert( $("#ty li").length)
                let num = $(this).index();
                $("#ty li").removeClass("active act")
                $("#ty li").addClass('active act')
               $(this).parent().children('i').removeClass('on');
            $(this).addClass('on').prevAll('i').addClass('on');*/

        </script>
        <div class="nav navbar-nav navbar-right social-icons wow fadeInRight animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInRight;">
            <ul>
                <li><a href="#"> </a></li>
              <c:choose>
                    <c:when test="${user.loginName != null}">
                        <img class="img-thumbnail" style="width: 40px"  src="${user.img}">
                <li><p>用户名:</p></li>
                <li><a href="/userblog?id=${user.id}">${user.loginName} </a></li>
                        <li><a href="#"> </a></li>
                <li><a href="/logout" >logout</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><p>你还没有登录</p></li>
                    </c:otherwise>
                </c:choose>

            </ul>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>
<script
        type="text/javascript"
        src="https://cdn.jsdelivr.net/npm/wangeditor@latest/dist/wangEditor.min.js"
></script>
