<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="utf-8" />
        <title>Polaris·微校园</title>
        <link rel="stylesheet" href="static/css/bootstrap.css" />
        <link rel="stylesheet" href="static/css/font.css" />
        <link rel="stylesheet" href="static/css/app.v2.css" />
        <link rel="stylesheet" href="static/css/index.css">
        <script type="text/javascript" src="static/js/base/jquery-2.1.0.js"></script>
    </head>

    <body>
       <input type="button" value="查询" id="queryAllUsersBtn" />
       <a id="loginBtn" href="toLoginPage">去登录</a>
    </body>
    <script type="text/javascript">
        $(function () {
            $("#queryAllUsersBtn").on("click", function () {
                $.ajax({
                   type: "get",
                   url: "queryAllUsers",
                   success: function (back) {
                       console.log(back);
                   }
               }); 
            });
        });
    </script>

    </html>
