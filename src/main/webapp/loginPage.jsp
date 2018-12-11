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
        <div class="row top"></div>
        <div class="row middle container-fluid">
            <div class="col-lg-8 middle_left"></div>
            <div class="col-lg-4 middle_right">
                <div class="login_div container-fluid">
                    <div class="row login_title text-center">
                        <h3>登录</h3>
                    </div>
                    <div id="err_msg" class="row alert-warning ng-binding"></div>
                    <div class="row login_text">
                        用户：
                        <span class="alert-warning" ng-bind="user.username.err"></span>
                        <input id="username" class="inputAccount form-control" type="text" ng-model="user.username.data" ng-blur="user.username.check()"
                        />
                    </div>
                    <div class="row login_text">
                        密码：
                        <span class="alert-warning" ng-bind="user.password.err"></span>
                        <input id="password" class="inputPassword form-control" type="password" ng-model="user.password.data" ng-blur="user.password.check()"
                        />
                    </div>
                    <div class="row login_text">
                        <div class="col col-lg-6 container-fluid">
                            请输入验证码
                            <br>
                            <input type="text" id="identifier" class="identifier">
                        </div>
                        <div class="col-lg-6 container-fluid">
                            <img alt="" src="capture" id="capture">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6 remember_btn text-center">
                            <input type="checkbox" value="记住密码">记住密码</div>
                        <div class="col-lg-6 remember_btn text-center">
                            <input type="checkbox" value="自动登陆">自动登陆</div>
                    </div>
                    <div class="row login_text">
                        <br />
                        <input id="login_btn" class="btn btn-s-xs btn-success" type="button" value="登录" />
                        <input class="btn btn-s-xs btn-default" type="button" value="重置" ng-click="reset()" />
                        <input class="btn btn-s-xs btn-twitter" type="button" value="注册" ng-click="register()" />
                    </div>
                    <div class="row">
                        <a href="">忘记密码？</a>
                    </div>
                    <div class="login_text loginFooter text-center">
                    </div>
                </div>
            </div>
        </div>
        <div class="row bottom"></div>
    </body>
    <script type="text/javascript">
        $(function () {
            $("#capture").on("click", function () {
                $(this).attr("src", "capture?t=" + Math.random());
            });
            $("#login_btn").on("click", function () {
                var username = $("#username").val();
                if (username == "" || username == undefined) {
                    $("#err_msg").text("请输入账号");
                    return;
                }
                var password = $("#password").val();
                if (password == "" || password == undefined) {
                    $("#err_msg").text("请输入密码");
                    return;
                }
                var identifier = $("#identifier").val();
                if (identifier == "" || identifier == undefined) {
                    $("#err_msg").text("请输入验证码");
                    return;
                }
                var data = {
                    username: username,
                    password: password,
                    identifier: identifier
                };
                 $.ajax({
                    type: "post",
                    url: "login",
                    data: data,
                    success: function (back) {
                        if (back == 1) { //登陆成功
                            $(location).attr('href', 'workbench');
                        } else {
                            $("#err_msg").text(back);
                            $("#capture").trigger("click");
                        }
                    }
                }); 
            });
        });
    </script>

    </html>
