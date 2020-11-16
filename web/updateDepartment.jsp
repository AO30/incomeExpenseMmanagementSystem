<%--
  Created by IntelliJ IDEA.
  User: Aotingting
  Date: 2020-11-10
  Time: 11:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>UpdateDepartment</title>
    <link rel="stylesheet" href="CSS/global.css">
    <script type="text/javascript" src="JS/global.js"></script>
</head>
<body>
<div id="content">
    <div class="head">
        <img src="images/title.png" class="img1"/>
        <img src="images/vegetables.png"/>
        <img src="images/fruits.png"/>
        <img src="images/bread.png"/>
        <img src="images/meat.png"/>
        <img src="images/eggs.png"/>
        <img src="images/hamburger.png">
    </div>
    <hr>
    <div class="divide">
        <p id="clock"></p>
    </div>
    <hr class="hr1">
    <div id="nav">
        <ul type="none">
            <li><a href="queryIncome">Income management</a></li>
            <li><a href="queryDept">Department management</a></li>
            <li><a href="queryVendor">Vendor management</a></li>
            <li><a href="queryVendor1">Bill management</a></li>
            <li><a href="billPaymentMain.jsp">Bill Payment</a></li>
        </ul>
    </div>
    <div class="context">
        <form action="updateDepartment1" method="post">
            <c:forEach items="${dept}" var = "dept">
                <input type="hidden" name="dept_id" value="${dept.dept_id}"/>
                <p>Department Name:<input type="text" name="dept_name" placeholder="${dept.dept_name}"></p>
                <p>Department Description:<input type="text" name="dept_description"  placeholder="${dept.dept_description}"></p>
            </c:forEach>
            <input type="submit" value="Update">
        </form>
    </div>
</div>
</body>
</html>
