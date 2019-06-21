<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="author" content="Dreamer-1">
    <meta name="renderer" content="webkit" />
    <link href="css/login/login.css" rel="stylesheet">
    <script type="text/javascript" src="js/login/jquery/jquery.min.js?v=20170207"></script>
    <script type="text/javascript" src="js/login/md5/md5.js"></script>
</head>
<body>
<form name="form1" method="post" action="/login" id="form1" onsubmit="return checkLogin();">
    <div id="main">
        <div class="wrapper">
            <div class="login-hd"></div>
            <div class="login-body">
                <div class="logo">
                    <span class="icon-logo"></span>
                </div>
                <div class="box">
                    <div class="login-item">
                        <span class="icon-user"></span>
                        <input name="username" type="text" id="username" class="login-input" tabindex="1" maxlength="50" placeholder="请输入用户名" />

                    </div>
                    <div class="login-item mt35">
                        <span class="icon-pwd"></span>
                        <input type="password" id="password"  class="login-input" tabindex="2" maxlength="32" placeholder="请输入密码"/>
                        <input type="hidden" id="hidePwd" name="password">
                    </div>
                    <div class="login-forget" style="visibility:hidden">
                        <a href="#">忘记密码</a>
                    </div>

                    <input type="submit" name="Logon" value="登录" id="Logon" tabindex="3" class="login-btn" />
                    <div class="login-bottom">
                        <div class="msg"  style="display:none;" >
                            <span class="icon-err"></span>
                            <span id="message"></span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>
