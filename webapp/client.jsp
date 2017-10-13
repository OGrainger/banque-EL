<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Client page</title>
    <%--<link type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/spectre.css/0.4.4/spectre.min.css"/>--%>
</head>
<body>

<div>
    <h1> <c:out value="${stringTest}"/> </h1>
    <h1>Hello, <c:out value="${client.getFirstName()}" /> <c:out value="${client.getLastName()}" /> !</h1>

    <table>
        <tbody>
        <c:forEach items="${client.getAccounts()}" var="account">
            <tr>
                <td>${account.getDescription()}</td>
                <td>${account.getMoney()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
