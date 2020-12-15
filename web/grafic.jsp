<%@ page import="mysql.business.BuilderClass.PaymentValue" %>
<%@ page import="mysql.business.BookDB" %>
<%@ page import="java.util.ArrayList" %><%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
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
<table >
    <p style="background: linear-gradient(#9595b6, #5a567f); padding: 5px; color: #fff; text-align: center; width: 50%; margin: auto;">Credit payment schedule</p>

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

        </tr>

        <tr><th>Total amount with percent</th><th>Overpayment</th></tr>
        <tr>
            <td>${product.allSummary}</td>
            <td>${product.overpayment}</td>
        </tr>
    </c:forEach>

<%--    <c:forEach var="num" items="${num}">--%>
<%--    <tr>--%>
<%--        <td>--%>
<%--            ${num}--%>
<%--        </td>--%>
<%--    </tr>--%>
<%--    </c:forEach>--%>
</table>


<table>

    <tr>
        <td width="7px">
<%
    ArrayList<ArrayList<Double>> list = (ArrayList<ArrayList<Double>>) request.getAttribute("pro");


    for (int i = 0; i < list.size(); i++) {
                    out.println(list.get(i).get(0));
//                    out.print("\n");
    }


%></td>

        <td width="13px">
        <%
            ArrayList<ArrayList<Double>> list2 = (ArrayList<ArrayList<Double>>) request.getAttribute("pro");

            for (int i = 0; i < list2.size(); i++) {
                out.print(list2.get(i).get(1) + " ");
                out.print("\n");
            }
        %></td>

        <td width="12px">
        <%
            ArrayList<ArrayList<Double>> list3 = (ArrayList<ArrayList<Double>>) request.getAttribute("pro");

            for (int i = 0; i < list3.size(); i++) {
                out.print(list3.get(i).get(2) + " ");
                out.print("\n");
            }
        %></td>

        <td width="12px">
        <%
            ArrayList<ArrayList<Double>> list4 = (ArrayList<ArrayList<Double>>) request.getAttribute("pro");

            for (int i = 0; i < list4.size(); i++) {
                out.print(list4.get(i).get(3) + " ");
                out.print("\n");
            }
        %></td>
        <td></td>
    </tr>

</table>

</body>
</html>