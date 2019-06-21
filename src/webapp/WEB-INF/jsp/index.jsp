<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var ="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>定岗定级系统</title>
        <link rel="stylesheet" href="${path}/static/css/pintuer.css">
        <link rel="stylesheet" href="${path}/static/css/admin.css">
        <script src="${path}/static/js/jquery.js"></script>
    </head>
    <body>
    <div class="header bg-main">
        <div class="logo margin-big-left fadein-top">
            <h1>
                <img src="images/y.jpg" class="radius-circle rotate-hover"
                     height="50" alt="" /> 定岗定级系统
            </h1>
        </div>
        <div class="head-l">
            <a
                class="button button-little bg-red" href="#" target="_self"
                onClick="logout();"><span class="icon-power-off"></span> 退出登录
            </a>&nbsp;&nbsp;&nbsp;&nbsp;
        </div>
    </div>
    <div class="leftnav">
        <div class="leftnav-title">
            <strong><span class="icon-list"></span>菜单列表</strong>
        </div>
        <%--<c:if test="${type=='管理员'}">--%>

            <h2>
                <span class="icon-user"></span>基本设置
            </h2>
            <ul style="display: block">
                <li><a href="${path}/" target="right"><span
                        class="icon-caret-right"></span>员工信息管理</a></li>
                <li><a href="${path}/" target="right"><span
                        class="icon-caret-right"></span>修改密码</a></li>
            </ul>
        <%--</c:if>--%>

        <h2>
            <span class="icon-pencil-square-o"></span>评分管理
        </h2>
        <ul>
            <li><a href="${path}/" target="right"><span
                    class="icon-caret-right"></span>自评</a></li>
        </ul>
        <ul>
            <li><a href="${path}/" target="right"><span
                    class="icon-caret-right"></span>复评</a></li>
        </ul>

    </div>
    <script type="text/javascript">
        $(function() {
            $(".leftnav h2").click(function() {
                $(this).next().slideToggle(200);
                $(this).toggleClass("on");
            })
            $(".leftnav ul li a").click(function() {
                $("#a_leader_txt").text($(this).text());
                $(".leftnav ul li a").removeClass("on");
                $(this).addClass("on");
            })
        });
    </script>
    <ul class="bread">
        <li><a href="<${path}/" target="right"
               class="icon-home"> 首页</a></li>
        <li><a href="${path}/" target="right"
               id="a_leader_txt">网站信息</a></li>
    </ul>
    <div class="admin">
        <iframe scrolling="auto" rameborder="0"
                src="${path}/" name="right" width="100%"
                height="100%"></iframe>
    </div>
    </body>
</html>
<script language=JavaScript>
    function logout() {
        if (confirm("您确定要退出定岗定级系统吗？"))
            top.location = "loginout.jsp";
        return false;
    }
</script>
