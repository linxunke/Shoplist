<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Shoppinglist</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <h1>Shoppinglist</h1>
    <hr/>

    <h3>ALL SHOPPINGLIST <a href="/addFood" type="button" class="btn btn-default btn-sm">ADD</a></h3>

    <!-- 如果用户列表为空 -->
    <c:if test="${empty foodList}">
        <p class="bg-warning">
            <br/>
            Shoppinglist is empty.<a href="/addFood" type="button" class="btn btn-default btn-sm">ADD</a>
            <br/>
            <br/>
        </p>
    </c:if>

    <!-- 如果用户列表非空 -->
    <c:if test="${!empty foodList}">
        <table class="table table-bordered table-striped">
            <tr>
                <th>FOODID</th>
                <th>FOODNAME</th>
                <th>FOODNUMBER</th>

            </tr>

            <c:forEach items="${foodList}" var="food">
                <tr>
                    <td>${food.foodId}</td>
                    <td>${food.foodName}</td>
                    <td>${food.foodNo}</td>

                    <td>
                        <a href="/showFood/${food.foodId}" type="button" class="btn btn-sm btn-success">Detial</a>
                        <a href="/updateFood/${food.foodId}" type="button" class="btn btn-sm btn-warning">Update</a>
                        <a href="/deleteFood/${food.foodId}" type="button" class="btn btn-sm btn-danger">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>