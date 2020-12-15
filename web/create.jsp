<%--
  Created by IntelliJ IDEA.
  User: Alena Oparina
  Date: 04.12.2020
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create poem</title>
    <style>
        table {
            margin: auto;
            width: 50%;
            border-collapse: collapse;
        }
        td, th {
            border: 1px solid #98bf21;
            padding: 3px 7px 2px 7px;
        }
        th {
            text-align: left;
            padding: 5px;
            background-color: #A7C942;
            color: #fff;
        }
        .alt td { background-color: #EAF2D3; }
    </style>
</head>
<body>
<h3>New credit agreement</h3>

<table>
    <p style="margin: auto; text-align:center; background-color: #A7C942; width: 50%;">Traffic on credit</p><br>
    <tr><th>Traffic code</th><th>Credit period, years</th><th>Annual percentage rate (%)</th></tr>

    <c:forEach var="traffic" items="${traffics}">
        <tr>
            <td>${traffic.codCredit}</td>
            <td>${traffic.creditPeriod}</td>
            <td>${traffic.percent}</td>
        </tr>
    </c:forEach>
</table>
<button onclick="document.location='/index'">Home page</button>

<div style="margin: auto">
<form method="post">
    <label>Client name</label><br>
    <input name="clientName"/><br><br>

    <label>Credit number</label><br>
    <input name="numCredit" type="number"/><br><br>

    <label>Calculation date</label><br>
    <input name="dateCredit" /><br><br>

    <label>Amount</label><br>
    <input name="summary"/><br><br>

    <label>Choose currency:</label>
    <p><select name="currency">
        <option>BYN</option>
        <option>EUR</option>
        <option>USD</option>
        <option>RUB</option>
    </select></p>

    <label>Credit code</label>
    <p><select name="codCredit">
            <c:forEach var="traffic" items="${traffics}">

                   <option>${traffic.codCredit}</option>

            </c:forEach>
    </select></p>

    <input type="submit" value="Save" />
</form>

</div>

</body>
</html>
