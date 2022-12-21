<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<div class="services w3l wow fadeInDown" data-wow-duration=".8s" data-wow-delay=".2s">
    <div class="container">
        <div class="grid_3 grid_5">
            <div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">
                <ul id="myTab" class="nav nav-tabs" role="tablist">
                    <li role="presentation" class="active"><a href="#expeditions" id="expeditions-tab" role="tab"
                                                              data-toggle="tab" aria-controls="expeditions"
                                                              aria-expanded="true">时尚</a></li>
                    <li role="presentation" class=""><a href="#safari" role="tab" id="safari-tab" data-toggle="tab" aria-controls="safari">旅行</a></li>
                    <li role="presentation" class=""><a href="#trekking" role="tab" id="trekking-tab" data-toggle="tab" aria-controls="trekking">音乐</a></li>
                </ul>

<%--                <c:forEach items="${PageBlog.list}" var="p" varStatus="v">--%>
                <div id="myTabContent" class="tab-content">
                    <div role="tabpanel" class="tab-pane fade" id="expeditions" aria-labelledby="expeditions-tab">
                        <div class="col-md-4 col-sm-5 tab-image">
                            <img src="${PageBlog.list[0].image}" class="img-responsive" alt="Wanderer">
                        </div>
                        <div class="col-md-4 col-sm-5 tab-image">
                            <img src="${PageBlog.list[1].image}" class="img-responsive" alt="Wanderer">
                        </div>
                        <div class="col-md-4 col-sm-5 tab-image">
                            <img src="${PageBlog.list[2].image}" class="img-responsive" alt="Wanderer">
                            <%-- <img src="images/f2.jpg" class="img-responsive" alt="Wanderer">--%>
                        </div>
                        <div class="clearfix"></div>
                    </div>


                    <div role="tabpanel" class="tab-pane fade" id="safari" aria-labelledby="safari-tab">
                        <div class="col-md-4 col-sm-5 tab-image">
                            <img src="${PageBlog.list[3].image}" class="img-responsive" alt="Wanderer">
                        </div>
                        <div class="col-md-4 col-sm-5 tab-image">
                            <img src="${PageBlog.list[4].image}" class="img-responsive" alt="Wanderer">
                        </div>
                        <div class="col-md-4 col-sm-5 tab-image">
                            <%--                            <img src="images/t2.jpg" class="img-responsive" alt="Wanderer">--%>
                            <img src="${PageBlog.list[5].image}" class="img-responsive" alt="Wanderer">
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div role="tabpanel" class="tab-pane fade active in" id="trekking" aria-labelledby="trekking-tab">
                        <div class="col-md-4 col-sm-5 tab-image">
                            <img src="${PageBlog.list[6].image}" class="img-responsive" alt="Wanderer">
                        </div>
                        <div class="col-md-4 col-sm-5 tab-image">
                            <img src="${PageBlog.list[7].image}" class="img-responsive" alt="Wanderer">
                        </div>
                        <div class="col-md-4 col-sm-5 tab-image">
                            <img src="${PageBlog.list[8].image}" class="img-responsive" alt="Wanderer">
                        </div>

                        <div class="clearfix"></div>
                    </div>
                </div>
<%--                </c:forEach>--%>
            </div>
        </div>
    </div>
</div>