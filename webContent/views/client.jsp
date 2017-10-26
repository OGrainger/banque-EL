<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="translations.translation"/>

<div class="row">
    <%--<fmt:formatNumber value="${clientFullBalance}" type="currency" currencySymbol=""/>€--%>
    <h2><fmt:message key="hello"/> ${client.getFirstName()} ${client.getLastName()} | full balance :</h2>
    <hr>
    <h3><fmt:message key="accounts.list"/></h3>
    <table class="table col-md-12">
        <thead>
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
        <c:if test="{!client.getAccounts().length}">
            <tr>
                <td colspan="3"><fmt:message key="empty.list"/></td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>