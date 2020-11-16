<%--
  Created by IntelliJ IDEA.
  User: Aotingting
  Date: 2020-11-12
  Time: 10:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>AddBill</title>
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
        <form action="addDepartmentItem" method="post">
            <p>Bill Date:<input type="text" name="bill_date"></p>
            <p>Bill Due Date:<input type="text" name="bill_due_date"></p>
            <select name="vendor_id" class="select" >
                <option value="">请选择</option>
                <c:forEach items="${vendors}" var = "vendor">
                    <option value="${vendor.vendor_id}">${vendor.vendor_name}</option>
                </c:forEach>
            </select>
            <button><a href="addVendor.jsp">new Vendor</a></button>
            <input type="submit" value="Add department Item">
            <button>Reset</button>
        </form>

    </div>
</div>

</body>
</html>
