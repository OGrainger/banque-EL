<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="translations.translation"/>

<div class="row">
    <%--<h3>${param.test}</h3>--%>
    <h2><fmt:message key="hello"/>, ${client.getFirstName()} ${client.getLastName()} | full balance : <fmt:formatNumber value="${clientFullBalance}" type="currency" currencySymbol=""/>€</h2>
    <br>
    <table class="table col-md-12">
        <thead class="thead-dark">
        <tr>
            <th><fmt:message key="iban"/></th>
            <th><fmt:message key="description"/></th>
            <th><fmt:message key="balance"/></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${client.getAccounts()}" var="account">
            <tr>
                <td>${account.getIban()}</td>
                <td>${account.getDescription()}</td>
                <td><fmt:formatNumber value="${account.getMoney()}" type="currency" currencySymbol=""/>€</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>