<%--
  Created by IntelliJ IDEA.
  User: Aotingting
  Date: 2020-11-11
  Time: 9:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BillPaymentMain</title>
    <link rel="stylesheet" href="CSS/global.css">
    <script type="text/javascript" src="JS/global.js"></script>
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
        <form action="queryBill" method="post">
            <p>Vendor Name:<input type="text" name="vendor_name"></p>
            <input type="submit" value="Submit">
            <input type="button" value="Reset">
        </form>
    </div>
</div>

</body>
</html>
