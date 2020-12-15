<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title></title>
  <style>
    table {
      width: 70%;
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
      background-color: #9999FF;
      color: #fff;
    }
    tr:hover { background-color: #E0E0FF; }
  </style>
</head>
<body>

<p><a href='<c:url value="/create" />'>New credit</a></p>

<form method="post">
  <label>Name</label><br>
  <input name="name"/><br><br>
  <input type="submit" value="Search" />
</form>
<br>

<button onclick="document.location='/index'">Home page</button>
<br>

<c:if test="${credits != null}">

<table>
  <p style="background-color: #C2C2FF; text-align: center; width: 70%; margin: auto">All accounts payable</p>
<tr><th>Client's number</th><th>Client name</th><th>Credit number</th><th>Calculation date</th><th>Credit amount</th><th>Credit currency</th><th>Credit code</th><th>Credit period, years</th><th>Annual percentage rate</th><th>Payment schedule</th></tr>

  <c:forEach var="credit" items="${credits}">
    <tr>
      <td>${credit.idClient}</td>
      <td>${credit.clientName}</td>
      <td>${credit.numCredit}</td>
      <td>${credit.dateCredit}</td>
      <td>${credit.summary}</td>
      <td>${credit.currency}</td>
      <td>${credit.codCredit}</td>
      <td>${credit.creditPeriod}</td>
      <td>${credit.percent}</td>
      <td>
        <a href='<c:url value="/grafic?id=${credit.idClient}" />'>Grafic credit</a> |

      </td>
    </tr>
    </c:forEach>

  <br>

</table>
<br><br>
</c:if>

<table>
  <p style="background-color: #C2C2FF; text-align: center; width: 70%; margin: auto">All names of creditors</p>
  <tr><th>Client's number</th><th>Client name</th><th>Credit number</th></tr>

  <c:forEach var="creditName" items="${creditsName}">
  <tr>
    <td>${creditName.idClient}</td>
    <td>${creditName.clientName}</td>
    <td>${creditName.numCredit}</td>
  </tr>
    </c:forEach>
</table>

</body>
</html>