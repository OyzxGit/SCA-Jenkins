<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/15 0015
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link href="../../css/bootstrap.css" rel="stylesheet">
    <script src="../../js/jquery.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <style>
        body{
            background-image: url("/images/back2.jpg");
            width: 100%;
        }
       .login-box{
            width: 400px;
            height: 300px;
            background: rgba(186, 186, 147, 0.7);
           background-image: url("/images/he1.png");
           background-repeat:  no-repeat;
           background-size:254px auto;
           background-position: -46px -63px;
           position:absolute; top:50%; left:50%; transform:translate(-50%, -50%);
           border-radius: 20px;

        }
        .logbutton{
            margin-left: 70px;
            margin-top: 30px;
        }
        form {
            /*//position:absolute;left: 50%;top: 50%;margin-left: -240px;margin-top: -120px;*/
            position:relative; top:50%; left:50%; transform:translate(-50%, -50%);
            margin-left: 50px;
        }
    </style>
</head>
<body>
<div class="login-box">
<form  method="post" >
            <div class="form-group">
                <label for="user" style="display:inline;color: white">账户：</label>
                <input type="text" class="form-control" id="user" name="name" style="display:inline;width:200px;"autocomplete="off" value="${name}" />
            </div>
            <div class="form-group">
                <label for="password" style="display:inline;color: white">密码：</label>
                 <input type="text" class="form-control" id="password" name="pwd" style="display:inline;width:200px;"autocomplete="off" value="${pwd}" />
            </div>
                <p style="color: #c33">${message}</p>
    <div class="logbutton">
            <button type="submit" class="btn btn-primary">登录</button>
             <a type="submit" href="/register" class="btn btn-primary">注册</a>
    </div>
        </form>
</div>
</body>
</html>
