<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-md-9 technology-left">
    <div class="tech-no">
        <!-- technology-top -->
        <c:forEach items="${PageBlog.list}" var="p">

                <div class="tc-ch wow fadeInDown"  data-wow-duration=".8s" data-wow-delay=".2s">

                    <div class="tch-img">
                        <a href="singLePage?id=${p.id}">
                            <img src="${p.image}" class="img-responsive" alt=""></a>
                    </div>

                    <h3><a href="singLePage?id=${p.id}">${p.title}</a></h3>
                    <h6> <a href="singLePage?id=${p.id}">中国 </a>${p.creteTime}</h6>
                    <p>${p.info}</p>
                    <div class="bht1">
                        <a href="singLePage?id=${p.id}">更多</a>
                    </div>
                    <div class="soci">
                        <ul>
                            <li class="hvr-rectangle-out"><a class="fb" href="#"></a></li>
                            <li class="hvr-rectangle-out"><a class="twit" href="#"></a></li>
                            <li class="hvr-rectangle-out"><a class="goog" href="#"></a></li>
                            <li class="hvr-rectangle-out"><a class="pin" href="#"></a></li>
                            <li class="hvr-rectangle-out"><a class="drib" href="#"></a></li>
                        </ul>
                    </div>
                    <div class="clearfix"></div>
                </div>

               <%-- <c:when test="${p.categoriesId==4}">

                  <div class="wthree">
                        <div class="col-md-6 wthree-left wow fadeInDown"  data-wow-duration=".8s" data-wow-delay=".2s">
                            <div class="tch-img">
                                <a href="singLePage?id=${p.id}"><img src="${p.image}" class="img-responsive" alt=""></a>
                            </div>
                        </div>
                        <div class="col-md-6 wthree-right wow fadeInDown"  data-wow-duration=".8s" data-wow-delay=".2s">
                            <h3><a href="singLePage?id=${p.id}">${p.title}</a></h3>
                            <h6>BY <a href="singLePage?id=${p.id}">中国 </a>${p.creteTime}</h6>
                            <p>${p.info}</p>
                            <div class="bht1">
                                <a href="singLePage?id=${p.id}">更多</a>
                            </div>
                            <div class="soci">
                                <ul>

                                    <li class="hvr-rectangle-out"><a class="twit" href="#"></a></li>
                                    <li class="hvr-rectangle-out"><a class="pin" href="#"></a></li>
                                </ul>
                            </div>
                            <div class="clearfix"></div>

                        </div>
                    </div>
                </c:when>
                <c:when test="${p.categoriesId==3}">
                         <div class="w3ls">
                             <div class="col-md-6 w3ls-left wow fadeInDown"  data-wow-duration=".8s" data-wow-delay=".2s">
                                 <div class="tc-ch">
                                     <div class="tch-img">
                                         <a href="singLePage?id=${p.id}">
                                             <img src="${p.image}" class="img-responsive" alt=""></a>
                                     </div>

                                     <h3><a href="singLePage?id=${p.id}">${p.title}</a></h3>
                                     <h6> <a href="singLePage?id=${p.id}">中国 </a>${p.creteTime}</h6>
                                     <p>${p.info}</p>
                                     <div class="bht1">
                                         <a href="singLePage?id=${p.id}">更多</a>
                                     </div>
                                     <div class="soci">
                                         <ul>
                                             <li class="hvr-rectangle-out"><a class="fb" href="#"></a></li>
                                             <li class="hvr-rectangle-out"><a class="pin" href="#"></a></li>
                                         </ul>
                                     </div>
                                     <div class="clearfix"></div>
                                 </div>
                             </div>--%>
                   <%-- <div class="wthree">
                        <div class="col-md-6 wthree-left wow fadeInDown"  data-wow-duration=".8s" data-wow-delay=".2s">
                            <div class="tch-img">
                                <a href="singLePage?id=${p.id}">
                                    <img src="${p.image}" class="img-responsive" alt=""></a>
                            </div>

                            <h3><a href="singLePage?id=${p.id}">${p.title}</a></h3>
                            <h6> <a href="singLePage?id=${p.id}">中国 </a>${p.creteTime}</h6>
                            <p>${p.info}</p>
                            <div class="bht1">
                                <a href="singLePage?id=${p.id}">更多</a>
                            </div>
                            <div class="soci">
                                <ul>
                                    <li class="hvr-rectangle-out"><a class="goog" href="#"></a></li>
                                    <li class="hvr-rectangle-out"><a class="fb" href="#"></a></li>
                                </ul>
                            </div>
                            <div class="clearfix"></div>

                        </div>
                        <div class="clearfix"></div>
                    </div>--%>


                    <%-- <div class="w3ls">
                         <div class="col-md-6 w3ls-left wow fadeInDown"  data-wow-duration=".8s" data-wow-delay=".2s">
                             <div class="tc-ch">
                                 <div class="tch-img">
                                     <a href="singLePage?id=${p.id}">
                                         <img src="${p.image}" class="img-responsive" alt=""></a>
                                 </div>

                                 <h3><a href="singLePage?id=${p.id}">${p.title}</a></h3>
                                 <h6> <a href="singLePage?id=${p.id}">中国 </a>${p.creteTime}</h6>
                                 <p>${p.info}</p>
                                 <div class="bht1">
                                     <a href="singLePage?id=${p.id}">更多</a>
                                 </div>
                                 <div class="soci">
                                     <ul>
                                         <li class="hvr-rectangle-out"><a class="fb" href="#"></a></li>
                                         <li class="hvr-rectangle-out"><a class="pin" href="#"></a></li>
                                     </ul>
                                 </div>
                                 <div class="clearfix"></div>
                             </div>
                         </div>--%>
                  <%--                          <div class="col-md-6 w3ls-left wow fadeInDown"  data-wow-duration=".8s" data-wow-delay=".2s">
                                                <div class="tc-ch">
                                                    <div class="tch-img">
                                                        <a href="singLePage?id=${p.id}"><img src="${p.image}" class="img-responsive" alt=""></a>
                                                    </div>

                                                    <h3><a href="singLePage?id=${p.id}">${p.title}</a></h3>
                                                    <h6> <a href="singLePage?id=${p.id}">中国 </a>${p.creteTime}</h6>
                                                    <p>${p.info}</p>
                                                    <div class="bht1">
                                                        <a href="singLePage?id=${p.id}">更多</a>
                                                    </div>
                                                    <div class="soci">
                                                        <ul>
                                                            <li class="hvr-rectangle-out"><a class="twit" href="#"></a></li>
                                                            <li class="hvr-rectangle-out"><a class="drib" href="#"></a></li>
                                                        </ul>
                                                    </div>
                                                    <div class="clearfix"></div>
                                                </div>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>--%>
<%--                </c:when>--%>
<%--            </c:choose>--%>
        </c:forEach>

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

        <div class="clearfix"></div>
    </div>
</div>

