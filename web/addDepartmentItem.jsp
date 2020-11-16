<%--
  Created by IntelliJ IDEA.
  User: Aotingting
  Date: 2020-11-12
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Department Item</title>
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
        <form action="addBill" method="post">
            <input type="hidden" name="vendor_id" value="${vendor_id}">
            <input type="hidden" name="bill_date" value="${bill_date}">
            <input type="hidden" name="bill_due_date" value="${bill_due_date}">
            <p>Bill Date${bill_date}</p>
            <c:forEach items="${vendors}" var="vendor">
                <p>Vendor${vendor.vendor_name}</p>
            </c:forEach>
            <table border="2" align="center" id="tb">
                <tr>
                    <th>Department Name</th>
                    <th>Amount</th>
                    <th>Confirm</th>
                </tr>
                <c:forEach items="${depts}" var = "dept">
                    <tr>
                        <td>${dept.dept_name}</td>
                        <td><input type="text" name="${dept.dept_id}"></td>
                        <td><input type="checkbox" name="bill_item_expense" value="${dept.dept_id}"></td>
                    </tr>
                </c:forEach>
                <tr>
                    <th>Sum</th>
                    <th>"</th>
                    <th></th>
                </tr>
            </table>
            <input type="submit" value="submit">
            <button>Reset</button>
        </form>
    </div>
</div>

</body>
</html>
