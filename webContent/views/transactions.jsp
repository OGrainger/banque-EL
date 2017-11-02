<div class="container">
    <div class="row">
        <div class="col s6">
            <h3><fmt:message key="hello" /> ${client.getFirstName()} ${client.getLastName()}</h3>
        </div>
        <div class="col s6 right-align">
            <h3 class="thin">
                <fmt:formatNumber value="${clientFullBalance}" type="currency" currencySymbol=""/>&euro;</h3>
        </div>
    </div>
    <hr>
    <div class="row">
        <br>
        <div class="col s6">
            <a class="waves-effect waves-light btn-large btn-block teal lighten-1" href="${pageContext.request.contextPath}/client"><fmt:message key="see.accounts" /></a>
        </div>
        <div class="col s6">
            <a class="waves-effect waves-light btn-large btn-block indigo lighten-1" href="${pageContext.request.contextPath}/new-transaction"><fmt:message key="new.transaction" /></a>
        </div>
    </div>
    <br>
    <div class="row">
        <h4 class="thin"><fmt:message key="transactions.list.as.donor" /></h4>
        <table class="table striped col 12">
            <thead>
            <tr>
                <th><fmt:message key="description" /></th>
                <th><fmt:message key="donor" /></th>
                <th><fmt:message key="recipient" /></th>
                <th><fmt:message key="date" /></th>
                <th class="right-align"><fmt:message key="amount" /></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${transactionsAsDonor}" var="transaction">
                <tr>
                    <td>${transaction.getDescription()}</td>
                    <td>${transaction.getDonorAccount().getDescription()}</td>
                    <td>${transaction.getRecipientAccount().getClient().getLogin()} - ${transaction.getRecipientAccount().getDescription()}</td>
                    <td><fmt:formatDate value="${transaction.getDate()}" pattern="MM/dd/yyyy HH:mm:ss"/></td>
                    <td class="right-align"><fmt:formatNumber value="${transaction.getAmount()}" type="currency" currencySymbol=""/>&euro;</td>
                </tr>
            </c:forEach>
            <c:if test="${transactionsAsDonor.isEmpty()}">
                <tr>
                    <td colspan="5" class="center-align flow-text"><fmt:message key="empty.list" /></td>
                </tr>
            </c:if>
            </tbody>
        </table>
    </div>
    <br>
    <div class="row">
        <h4 class="thin"><fmt:message key="transactions.list.as.recipient" /></h4>
        <table class="table striped col 12">
            <thead>
            <tr>
                <th><fmt:message key="description" /></th>
                <th><fmt:message key="donor" /></th>
                <th><fmt:message key="recipient" /></th>
                <th><fmt:message key="date" /></th>
                <th class="right-align"><fmt:message key="amount" /></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${transactionsAsRecipient}" var="transaction">
                <tr>
                    <td>${transaction.getDescription()}</td>
                    <td>${transaction.getDonorAccount().getClient().getLogin()} - ${transaction.getDonorAccount().getDescription()}</td>
                    <td>${transaction.getRecipientAccount().getDescription()}</td>
                    <td><fmt:formatDate value="${transaction.getDate()}" pattern="MM/dd/yyyy HH:mm:ss"/></td>
                    <td class="right-align"><fmt:formatNumber value="${transaction.getAmount()}" type="currency" currencySymbol=""/>&euro;</td>
                </tr>
            </c:forEach>
            <c:if test="${transactionsAsRecipient.isEmpty()}">
                <tr>
                    <td colspan="5" class="center-align flow-text"><fmt:message key="empty.list" /></td>
                </tr>
            </c:if>
            </tbody>
        </table>
    </div>
</div>