<%--
  Created by IntelliJ IDEA.
  User: SXH
  Date: 2019/4/9
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
</head>
<body>
<div id="moods">
    <b>说说列表：</b><br>
    <c:forEach items="${moods}" var="mood">
        ------------------------------------------------------
        <br>
        <b>用户：</b><span id="account">${mood.userName}</span><br>
        <b>说说内容：</b><span id="content">${mood.content}</span><br>
        <b>发表时间：</b><span id="publish_time">${mood.publishTime}</span><br>
        <b>点赞数：</b><span id="praise_number">${mood.praiseNum}</span><br>
        <div style="margin-left: 350px">
            <%--每次点赞都会向后端发起请求，吧moodid和userID传递给后端--%>
            <%--<a id="praise" href="/mood/${mood.id}/praise?userId=${mood.userId}">赞</a>--%>
            <%--引入Redis缓存的点赞请求--%>
            <a id="praise2" href="/mood/${mood.id}/praiseForRedis?userId=${mood.userId}">赞</a>
        </div>
    </c:forEach>
</div>
</body>
</html>
