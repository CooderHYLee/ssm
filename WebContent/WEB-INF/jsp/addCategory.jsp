<%--
  Created by IntelliJ IDEA.
  User: lihongye
  Date: 2018/2/1
  Time: 下午3:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add category</title>
    <%--<style type="text/css">@import url(css/main.css);</style>--%>
</head>
<body>
<div  id="global">
    <form action="saveCategory" method="post">
        <fieldset>
            <legend>Add a category</legend>
            <p>
                <label for="name">category Name: </label>
                <input type="text" id="name" name="name"
                       tabindex="1">
            </p>
            <%--<p>--%>
                <%--<label for="id">category ID: </label>--%>
                <%--<input type="text" id="id"--%>
                       <%--name="id" tabindex="2">--%>
            <%--</p>--%>
            <p id="buttons">
                <input id="reset" type="reset" tabindex="3">
                <input id="submit" type="submit" tabindex="4"
                       value="添加category">
            </p>
        </fieldset>
    </form>
    <form  action="listCategory" method="post">
        <p id="1">
            <input id="submit1" type="submit" tabindex="1"
                   value="查看无分页列表">
        </p>
    </form>
    <form  action="listPageCategory" method="post">
        <p id="2">
            <input id="submit2" type="submit" tabindex="1"
                   value="查看原生分页列表">
        </p>
    </form>
    <form  action="listPageHelperCategory" method="post">
        <p id="3">
            <input id="submit3" type="submit" tabindex="1"
                   value="查看pageHelper分页列表">
        </p>
    </form>
</div>

</body>
</html>
