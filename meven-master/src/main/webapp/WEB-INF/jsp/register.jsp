<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link href="../../css/bootstrap.css" rel="stylesheet">
    <link href="../../css/style.css" rel="stylesheet">
    <script src="../../js/jquery.js"></script>
    <script src="../../js/bootstrap.min.js"></script>

    <style>

        .container1-left {
            margin-top: 50px;
            background: rgba(109, 172, 168, 0.45);
        }
        .container1-right {
            margin-top: 50px;
            background: rgba(109, 172, 168, 0.45);
        }

        /* 需要在一行的元素 */
        .inline-style {
            display: inline-block;
        }

        /* 文字需要靠右 */
        .font-position-right {
            text-align: right;
        }

        /* 注册按钮 */
        .register-btn {
            margin-left: 10%;
            margin-top: 10px;
        }

        .ty {
            margin-bottom: 30px;
        }

        #userImg {
            width: 100px;
        }

    </style>
    <script>
        $(function () {
            $.post("addImg",{},function (response) {
                console.info(response)
            })
        })
    </script>
</head>
<body>
<div class="container">
    <div class="container1-left col-sm-5" style="border-radius: 20px">
        <form class="form-horizontal" action="register" method="post">
            <div class="form-group col-sm-3">
                <label  class="col-sm-2 control-label inline-style font-position-right">用户头像</label>
            </div>
            <div class="col-sm-3 inline-style">
                <input type="file"  id="file">
            </div>
            <div class="form-group col-sm-6">
                <img id="userImg" class="img-thumbnail" src="${user.img}">
                <input type="hidden" name="img" id="userUp" value="${user.img}">
            </div>
            <br> <br><br><br><br><br>
            <div class="form-group">
                <label for="exampleInputUsername1"
                       class="col-sm-3 control-label inline-style font-position-right">用户名</label>
                <div class="col-sm-8 inline-style">
                    <input type="text" class="form-control" value="${user.loginName}" name="loginName"
                           id="exampleInputUsername1" placeholder="用户名">
                </div>
            </div>
            <div class="form-group">
                <!--<h2 class="form-signin-heading">注册</h2>-->
                <label for="exampleInputUsername1"
                       class="col-sm-3 control-label  inline-style font-position-right">密码</label>
                <div class="col-sm-8  inline-style">
                    <input type="password" class="form-control" value="${user.loginPassword}" name="loginPassword"
                           id="exampleInputPassword1" placeholder="密码">
                </div>
            </div>
            <div class="form-group">
                <label for="exampleInputPassword2"
                       class="col-sm-3 control-label  inline-style font-position-right">重复密码</label>
                <div class="col-sm-8  inline-style">
                    <input type="password" class="form-control" name="loginPassword1" id="exampleInputPassword2"
                           placeholder="再输入密码">
                </div>
            </div>
            <div class="form-group">
                <label for="exampleInputUsername2"
                       class="col-sm-3 control-label inline-style font-position-right">真实名</label>
                <div class="col-sm-8 inline-style ">
                    <input type="text" class="form-control" value="${user.trueName}" name="trueName"
                           id="exampleInputUsername2" placeholder="真实名">
                </div>
            </div>
            <div class="form-group">
                <label for="exampleInputUsername1"
                       class="col-sm-3 control-label   inline-style font-position-right">手机</label>
                <div class="col-sm-8  inline-style">
                    <input type="tel" class="form-control" name="tel" value="${user.tel}" id="exampleInputPhone1"
                           placeholder="手机">
                </div>
            </div>
            <div class="form-group">
                <label for="exampleInputPhone3"
                       class="col-sm-3 control-label   inline-style font-position-right">身份证</label>
                <div class="col-sm-8  inline-style">
                    <input type="tel" class="form-control" name="card" value="${user.card}" id="exampleInputPhone3"
                           placeholder="身份证">
                </div>
            </div>
            <div class="form-group">
                <label for="exampleInputUsername1"
                       class="col-sm-3 control-label  inline-style font-position-right">邮箱</label>
                <div class="col-sm-8  inline-style">
                    <input type="email" class="form-control" value="${user.email}" id="exampleInputEmail1"
                           placeholder="邮箱">
                </div>
            </div>

            <p style="color: #c33">${message}</p>
            <div class="form-group ty">
                <div class="col-sm-offset-4 col-sm-2">
                    <button class="btn btn-sm btn-primary  register-btn" type="submit" style="position: relative;left: -80px">提交</button>
                </div>
                <div class="col-sm-offset-1 col-sm-2">
                    <button class="btn btn-sm btn-primary  register-btn" type="reset" style="position: relative;left: -80px">重置</button>
                </div>
                <div class="col-sm-offset-1 col-sm-2">
                    <a class="btn btn-sm btn-primary  register-btn ty" href="login" style="position: relative;left: -80px">返回</a>
                </div>
            </div>
        </form>
    </div>

<div class="container1-right col-sm-offset-1 col-sm-6">
    <h3>请选择你的头像</h3>
    <div style="padding-bottom: 20px">
<c:forEach items="${imglist}" var="p">

    <img style="width: 100px;margin: 10px" class="allImg" title="${p}" src="${p}">
</c:forEach>
    </div>
</div>

</div>
<script>
    $(".allImg").click(function() {
let title = $(this).attr("title")

    $("#userImg").attr("src", title);
    $("#userUp").val(title);
    })
    function heardImg(i){


    }

    $("#file").change(function () {

        let formData = new FormData();
        let file = $(this).get(0).files[0];
        formData.append("file", file);
        console.info("aaaaaaaaaaaaaaa");
        console.info(formData);
        /*  *$.post("upDateUser",formData,function (response) {
              console.info(response)
              $("#userImg").attr("src",response)
              $("#userUp").val(response)
          })*/
        $.ajax({
                url: "updateUser",
                type: "post",
                data: formData,
                processData: false,
                contentType: false,
                success: function (response) {
                    console.info(response)
                    $("#userImg").attr("src", response)
                    $("#userUp").val(response)
                }
            }
        )
        return false;
    })
</script>
</body>
</html>
