<%--
  Created by IntelliJ IDEA.
  User: Aotingting
  Date: 2020-11-10
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>添加收入</title>
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
    <div>
        <form action="addIncome" method="post">
            <div>Department Name:
                <select name="dept_id" class="select" >
                    <option value="">请选择</option>
                    <c:forEach items="${depts}" var = "dept">
                      <option value="${dept.dept_id}">${dept.dept_name}</option>
                    </c:forEach>
                </select>
            </div>
            <p>Daily Income Sum:<input type="text" name="daily_income" id="daily_income"></p>
            <input type="submit" value="Add">
            <button onclick="document.getElementById('daily_income').value=''">Reset</button>
<%--            <button onclick="javascript:window.location.href='addDepartment.jsp'">Add Department</button>--%>
        </form>
    </div>
</div>


</body>
</html>
