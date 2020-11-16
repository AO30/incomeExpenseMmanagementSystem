<%--
  Created by IntelliJ IDEA.
  User: Aotingting
  Date: 2020-11-11
  Time: 9:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddVendor</title>
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
        <form action="addVendor" method="post">
            <p>Vendor Name:<input type="text" name="vendor_name"></p>
            <p>Vendor Address:<input type="text" name="vendor_address"></p>
            <p>Vendor Phone:<input type="text" name="vendor_phone"></p>
            <p>Vendor FAX:<input type="text" name="vendor_fax"></p>
            <p>Contact Person:<input type="text" name="vendor_contact_person"></p>
            <input type="submit" value="Add">
            <button>cancle</button>
        </form>
    </div>

</div>
</body>
</html>
