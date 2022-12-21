<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-md-3 technology-right">


    <div class="blo-top1">

        <div class="tech-btm">
            <div class="search-1">
                <form action="index" method="post">
                    <input type="search" name="Search" >
                    <input type="submit" >
                </form>
            </div>
            <h4>热门帖子 </h4>
            <c:forEach items="${PageBlog.list}" var="p">
                <div class="blog-grids">
                    <div class="blog-grid-left">
                        <a href="singLePage?id=${p.id}"><img src="${p.image}" class="img-responsive" alt=""></a>
                    </div>
                    <div class="blog-grid-right">

                        <h5 style="overflow:hidden;text-overflow:ellipsis;display:-webkit-box;-webkit-box-orient:vertical;-webkit-line-clamp:4;  "><a href="singLePage?id=${p.id}">${p.info}</a> </h5>
                    </div>
                    <div class="clearfix"> </div>
                </div>
            </c:forEach>
            <%--	<div class="blog-grids">
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
                </div>--%>
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
<div class="clearfix"></div>