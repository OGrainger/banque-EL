<div class="row">
    <div class="col s6">
        <h2><fmt:message key="hello"/> ${client.getFirstName()} ${client.getLastName()}</h2>
    </div>
    <div class="col s6">
        <fmt:formatNumber value="${clientFullBalance}" type="currency" currencySymbol=""/>€
    </div>
    <hr>
    <h3><fmt:message key="accounts.list"/></h3>
    <table class="table col 12">
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
                <td><fmt:formatNumber value="${account.getBalance()}" type="currency" currencySymbol=""/>€</td>
            </tr>
        </c:forEach>
        <c:if test="${client.getAccounts().isEmpty()}">
            <tr>
                <td colspan="3"><fmt:message key="empty.list"/></td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>