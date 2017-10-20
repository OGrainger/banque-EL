<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <h3>${param.test}</h3>
    <hr>
    <h2>Hello, <c:out value="${client.getFirstName()}"/> <c:out value="${client.getLastName()}"/> !</h2>
    <table>
        <thead>
        <tr>
            <th>IBAN</th>
            <th>Description</th>
            <th>Balance</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${client.getAccounts()}" var="account">
            <tr>
                <td>${account.getIban()}</td>
                <td>${account.getDescription()}</td>
                <td>${account.getMoney()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>