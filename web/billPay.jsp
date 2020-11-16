<%--
  Created by IntelliJ IDEA.
  User: Aotingting
  Date: 2020-11-12
  Time: 9:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>billPay</title>
    <link rel="stylesheet" href="CSS/global.css">
    <script type="text/javascript" src="JS/global.js"></script>
    <script src=".../jquery.min.js?t=1484026799191" charset="utf-8"></script>
    <script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js"></script>
    <script>
        function t1(obj) {
            var v = $("input[name='box']:checked").val();
            if (v=="1"){
                $("#test1").css('display','block');
            }
        }
        function t2(obj) {
            var v = $("input[name='box']:checked").val();
            if (v=="0"){
                $("#test1").css('display','none');
            }
        }
    </script>
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
        <c:forEach items="${billItems}" var="billItem" end="0">
            <p>bill id:${billItem.bill.bill_id}</p>
            <p>bill date:${billItem.bill.bill_date}</p>
            <p>bill amount:${billItem.bill.bill_amount}</p>
        </c:forEach>

            <table>
                <tr>
                    <th>Department Name</th>
                    <th>Item Expense</th>
                </tr>
                <c:forEach items="${billItems}" var="billItem">
                <tr>
                    <td>${billItem.dept.dept_name}</td>
                    <td>${billItem.bill_item_expense}</td>
                </tr>
                </c:forEach>
            </table>

        <form action="updateBill" method="post">
            <c:forEach items="${billItems}" var="billItem" end="0">
                <input type="hidden" name="bill_id" value="${billItem.bill.bill_id}">
            </c:forEach>
            <input type="radio" name="box" value="1" onchange="t1(this)">支票支付
            <input type="radio" name="box" value="0" checked onchange="t2(this)">现金支付
            <div id="test1" style="display: none">
<%--                <p>check id;逗号分割：<input type="text" name="check_id"></p>--%>
                <p>check number;逗号分割：<input type="text" name="check_number"></p>
            </div>
            <input type="submit" value="Payment">

        </form>
    </div>
</div>

</body>
</html>
