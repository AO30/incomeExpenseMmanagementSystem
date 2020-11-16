<%--
  Created by IntelliJ IDEA.
  User: Aotingting
  Date: 2020-11-09
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>收入管理</title>
    <link rel="stylesheet" href="CSS/incomeMain.css">
    <link rel="stylesheet" href="CSS/global.css">
    <script type="text/javascript" src="JS/global.js"></script>
    <script src=".../jquery.min.js?t=1484026799191" charset="utf-8"></script>
</head>
<body>
<div id="content">
    <div class="head">
        <img src="images/title.png" class="img1"/>
        <img src="images/vegetables.png"/>
        <img src="images/fruits.png"/>
        <img src="images/meat.png"/>
        <img src="images/bread.png"/>
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
        <table border="2" align="center" id="tb">
            <tr>
                <th>Department Name</th>
                <th>Business Date</th>
                <th>Last mod Date</th>
                <th>Daily Income</th>
                <th>Update</th>
            </tr>
            <c:forEach items="${incomes}" var = "income">
                <tr>
                    <td>${income.dept.dept_name}</td>
                    <td>${income.business_date}<br><br></td>
                    <td>${income.lst_mod_timestemp}<br><br></td>
                    <td>${income.daily_income}$<br><br></td>
                    <td><a href="updateIncome1?income_id=${income.income_id}">Update</a></td>
<%--                    <td><button onclick="javascript:window.location.href='updateIncome.jsp'"><a href="queryDeptName">Update</a> </button></td>--%>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="qaa" align="center">
        <form action="queryIncomeByTime" method="post">
            <p>Date:<input type="text" name="date" placeholder="例：2020-08-13"><input type="submit" value="query"><br/></p>
        </form>
        <button onclick="javascript:window.location.href='addIncome.jsp'"><a href="queryDeptName">Add Income</a> </button>
    </div>
</div>

</body>
</html>
