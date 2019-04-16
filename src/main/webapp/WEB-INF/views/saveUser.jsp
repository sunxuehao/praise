<%--
  Created by IntelliJ IDEA.
  User: SXH
  Date: 2019/4/8
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/ssm_war_exploded/user/insert">
    <table>
        <tr>
            <td>姓名：</td>
            <td><input id="name" name="name" type="text"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input id="password" name="password" type="password"></td>
        </tr>
        <tr>
            <td>年龄：</td>
            <td><input id="age" name="age" type="text"></td>
        </tr>
        <tr><td><input type="submit" value="保存"></td></tr>
    </table>
</form>
</body>
</html>
