<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2015/11/30
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Food List Home Page</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="/css/bootstrap.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <h1>Food Update</h1>
    <hr/>

    <form:form action="/updateFoodPost" method="post" commandName="foodP" role="form">
        <div class="form-group">
            <label for="foodName">Food Name:</label>
            <input type="text" class="form-control" id="foodName" name="foodName" placeholder="Enter FoodName:"
                   value="${food.foodName}"/>
        </div>
        <div class="form-group">
            <label for="foodNo">Food Number:</label>
            <input type="text" class="form-control" id="foodNo" name="foodNo" placeholder="Enter FoodNo:"
                   value="${food.foodNo}"/>
        </div>
        <div class="form-group">
            <label for="foodExpireDate">FoodExpireDate:</label>
            <input type="text" class="form-control" id="foodExpireDate" name="foodExpireDate" placeholder="Enter FoodExpireDate:"
                   value="${food.foodExpireDate}"/>
        </div>
        <!-- 把 id 一并写入 userP 中 -->
        <input type="hidden" id="foodid" name="foodid" value="${food.foodId}"/>

        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">Submit</button>
        </div>
    </form:form>
</div>


<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="/js/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/js/bootstrap.min.js"></script>
</body>
</html>
