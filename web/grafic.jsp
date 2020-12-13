<%--
  Created by IntelliJ IDEA.
  User: Alena Oparina
  Date: 09.12.2020
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <style>
        table {
            width: 50%;
            border-collapse: collapse;
            margin: auto;
        }
        td, th {
            border: 1px solid #C2C2FF;
            padding: 3px 7px 2px 7px;
        }
        th {
            text-align: left;
            padding: 5px;
            background: linear-gradient(#9595b6, #5a567f);
            color: #fff;
        }
        tr:hover { background-color: #E0E0FF; }
    </style>
</head>
<body>
<button onclick="document.location='/index'">Home page</button>
<table>
    <p style="background: linear-gradient(#9595b6, #5a567f); padding: 5px; color: #fff; text-align: center; width: 50%; margin: auto;">Credit payment schedule</p>
<%--    <tr><th>Credit payment schedule</th></tr>--%>
    <br>
    <tr><th>Client's number</th><th>Credit amount</th><th>Credit period, years</th><th>Annual percentage rate</th></tr>

    <c:forEach var="product" items="${product}">
        <tr>
            <td>${product.idClient}</td>
            <td>${product.summary}</td>
            <td>${product.creditPeriod}</td>
            <td>${product.percent}</td>
        </tr>

        <tr><th>Number of months</th><th>Main debt</th><th>Percentage</th><th>Total payment</th></tr>
<%-- Тут выводим информацию по месяцам     --%>
        <tr>
            <td>${product.year}</td>
            <td>${product.paymentEveryMonth}</td>
            <td>${product.percentEveryMonth}</td>
            <td>${product.paymentEveryMonthWithPercent}</td>
<%--            <td>${product.month.get(1)}</td>--%>
        </tr>

<%--        <tr>--%>
<%--            <td>${product.month.get(0).get(0)}</td>--%>
<%--            <td>${product.getMonth().get(0)}</td>--%>
<%--            <td>${product.month.get(2).get(2)}</td>--%>
<%--            <td>${product.month.get(0).get(3)}</td>--%>
<%--        </tr>--%>

<%--        <tr>--%>
<%--            <td>${product.month.get(0).get(0)}</td>--%>
<%--            <td>${product.getMonth()}</td>--%>
<%--            <td>${product.month.get(2).get(2)}</td>--%>
<%--            <td>${product.month.get(0).get(3)}</td>--%>
<%--        </tr>--%>

        <tr><th>Total amount with percent</th><th>Overpayment</th></tr>
        <tr>
            <td>${product.allSummary}</td>
            <td>${product.overpayment}</td>
        </tr>
    </c:forEach>
</table>


<%--<table>--%>
<%--    <c:forEach var="pro" items="${pro}">--%>
<%--        <tr>--%>
<%--           ${pro}--%>

<%--&lt;%&ndash;            <td>${pro.get(0)}</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td>${pro.get(1)}</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td>${pro.get(2)}</td>&ndash;%&gt;--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>

<%--</table>--%>


</body>
</html>