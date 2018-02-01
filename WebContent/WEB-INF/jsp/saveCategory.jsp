<%--
  Created by IntelliJ IDEA.
  User: lihongye
  Date: 2018/2/1
  Time: 下午3:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>save category</title>
</head>
<body>
<div id="global">
    <h4>category添加上了.</h4>
    <p>
    <h5>Details:</h5>
    category Name: ${category.name}<br/>

    </p>
    <form action="listCategory" method="post">
        <input id="submit" type="submit" tabindex="1"
               value="查看列表">
    </form>
</div>

</body>
</html>
