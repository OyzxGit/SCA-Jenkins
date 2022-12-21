<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>联系</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content=""/>
    <script type="applijewelleryion/x-javascript">
         addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); }
    </script>
    <link href="../../css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <!-- Custom Theme files -->
    <%--<link href='http://fonts.useso.com/css?family=Raleway:400,600,700' rel='stylesheet' type='text/css'>--%>
    <link href="../../css/style.css" rel='stylesheet' type='text/css'/>
    <script src="../../js/jquery.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="inc/header.jsp"></jsp:include>

<!-- technology-left -->
<div class="technology">
    <div class="container">
        <div class="col-md-9 technology-left">
            <div class="contact-section">
                <h2 class="w3">博客添加</h2>


                <div class="contact-grids">
                    <div class="col-md-12 contact-grid">
                        <form action="editBlog" method="post">
                            <c:if test="${blog.id != null}">
                            <input type="hidden" name="id" value="${blog.id}">
                            </c:if>
                            <input type="text" name="title" value="${blog.title}">
                            <textarea type="text" name="info">${blog.info}</textarea>
                            <select name="categoriesId" >
                                <option value="2">旅行</option>
                                <option value="3">时尚</option>
                                <option value="4">音乐</option>
                            </select>

                            <input type="file" id="file" >
                            <input type="hidden" name="image" id="imageUp" value="${blog.image}">
                            <img  alt="..." id="wo" class="img-thumbnail" src="${blog.image}">
                            <input type="hidden" name="userId" value="${user.id}">
                            <input type="hidden" name="HtmlId" value="${bolgHtml.id}">

                            <div id="div1">

                            </div>
                            <textarea id="text1"  name="html"  style="width:100%; height:200px;">${bolgHtml.html}</textarea>
                            <br>
                            <input id="html" type="submit" value="发送">
                        </form>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="google-map">
                </div>

            </div>
        </div>
        <!-- technology-right -->
        <jsp:include page="technology-left/technology-right1.jsp"></jsp:include>
        <!-- technology-right -->
    </div>
</div>

<jsp:include page="inc/footer.jsp"></jsp:include>
<script type="text/javascript">
    $('#text1').hide();
    const E = window.wangEditor
    const editor = new E('#div1')
    const $text1 = $('#text1')
    editor.config.onchange = function (html) {
        // 第二步，监控变化，同步更新到 textarea
        $text1.val(html)
    }
    editor.create()

    // 第一步，初始化 textarea 的值
    $text1.val(editor.txt.html())
    editor.txt.html(${bolgHtml.html})
</script>
<script type="text/javascript">
        $("#file").change(function () {
                    let formData = new  FormData();
            let file = $(this).get(0).files[0];
            formData.append("file",file);
            $.ajax({
                 url: "update",
                type: "post",
                data: formData,
                processData: false,
               contentType: false,
                success:function (response) {
                     console.info(response)
                    $("#wo").attr("src",response)
                    $("#imageUp").val(response)
                }
            }
            )
        })
</script>
</body>
</html>