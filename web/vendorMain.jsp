<%--
  Created by IntelliJ IDEA.
  User: Aotingting
  Date: 2020-11-10
  Time: 11:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Vendor</title>
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
        <img src="images/hamburger.png"/>
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
        <table border="2" align="center">
            <tr>
                <th>Vendor Name</th>
                <th>Vendor Address</th>
                <th>Vendor Phone</th>
                <th>Vendor FAX</th>
                <th>Contact Person</th>
                <th>Update</th>
            </tr>
            <c:forEach items="${vendors}" var = "vendor">
                <tr>
                    <td>${vendor.vendor_name}</td>
                    <td>${vendor.vendor_address}</td>
                    <td>${vendor.vendor_phone}</td>
                    <td>${vendor.vendor_fax}</td>
                    <td>${vendor.vendor_contact_person}</td>
                    <td><a href="updateVendor1?vendor_id=${vendor.vendor_id}">Update</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="qaa" align="center">
        <button onclick="javascript:window.location.href='addVendor.jsp'">Add Vendor</button>
    </div>
</div>

</body>
</html>
