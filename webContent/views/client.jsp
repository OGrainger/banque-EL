<div class="container">
    <div class="row">
        <div class="col s6">
            <h3><fmt:message key="hello" /> ${client.getFirstName()} ${client.getLastName()}</h3>
        </div>
        <div class="col s6 right-align">
            <h3 class="thin">
                <fmt:formatNumber value="${clientFullBalance}" type="currency" currencySymbol=""/>&euro;</h3>
        </div>
        <div class="col s12">
            <button data-target="modaledit" class="btn modal-trigger waves-effect waves-light indigo lighten-1">
                <fmt:message key="edit.client" /></button>
        </div>
    </div>
    <br>
    <div class="row">
        <h4 class="thin"><fmt:message key="accounts.list" /></h4>
        <table class="table striped col 12">
            <thead>
            <tr>
                <th><fmt:message key="iban" /></th>
                <th><fmt:message key="description" /></th>
                <th class="right-align"><fmt:message key="balance" /></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${client.getAccounts()}" var="account">
                <tr>
                    <td>${account.getIban()}</td>
                    <td>${account.getDescription()}</td>
                    <td class="right-align"><fmt:formatNumber value="${account.getBalance()}" type="currency" currencySymbol=""/>&euro;</td>
                </tr>
            </c:forEach>
            <c:if test="${client.getAccounts().isEmpty()}">
                <tr>
                    <td colspan="3" class="center-align flow-text"><fmt:message key="empty.list" /></td>
                </tr>
            </c:if>
            </tbody>
        </table>
    </div>
    <div class="row">
        <br>
        <div class="col s6">
            <a class="waves-effect waves-light btn-large btn-block indigo lighten-1" href="${pageContext.request.contextPath}/transactions"><fmt:message key="see.transactions" /></a>
        </div>
        <div class="col s6">
            <a class="waves-effect waves-light btn-large btn-block indigo lighten-1" href="${pageContext.request.contextPath}/new-transaction"><fmt:message key="new.transaction" /></a>
        </div>
    </div>
</div>

<!-- Modal Structure -->
<div id="modaledit" class="modal">
    <div class="modal-content">
        <h4><fmt:message key="edit.client" /></h4>
        <form method="post" action="${pageContext.request.contextPath}/client">
            <div class="input-field col s6">
                <input name="verification" id="password" type="password" class="validate" required>
                <label for="password"><fmt:message key="current.password" /></label>
            </div>
            <br>
            <div class="input-field col s6">
                <input name="password" id="newPassword" type="password" class="validate">
                <label for="newPassword"><fmt:message key="new.password" /></label>
            </div>
            <div class="input-field col s6">
                <input name="firstName" id="firstName" type="text" class="validate">
                <label for="firstName"><fmt:message key="new.first.name" /></label>
            </div>
            <div class="input-field col s6">
                <input name="lastName" id="lastName" type="text" class="validate">
                <label for="lastName"><fmt:message key="new.last.name" /></label>
            </div>
            <c:if test="${updateClientInternalError}">
                <div class="col s12 card-panel red darken-3 white-text">
                    <span class="flow-text center-align"><fmt:message key="error.internal.update.client" /></span>
                </div>
            </c:if>
            <c:if test="${updateClientPasswordError}">
                <div class="col s12 card-panel orange lighten-2 center-align">
                    <span class="flow-text"><fmt:message key="error.password.update.client" /></span>
                </div>
            </c:if>
            <c:if test="${updateClientNoDifferenceError}">
                <div class="col s12 card-panel orange lighten-2 center-align">
                    <span class="flow-text"><fmt:message key="error.no.differences.update.client" /></span>
                </div>
            </c:if>
            <button type="submit" class="waves-effect waves-light btn-large btn-block indigo lighten-1">
                <fmt:message key="submit" /></button>
        </form>
    </div>
</div>