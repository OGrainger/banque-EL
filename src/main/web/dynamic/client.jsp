<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <table>
        <tbody>
        <h1>${param.test}</h1>
        <c:forEach items="${client.getAccounts()}" var="account">
            <tr>
                <td>${account.getDescription()}</td>
                <td>${account.getMoney()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>