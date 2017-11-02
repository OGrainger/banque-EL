<div class="container">
    <div class="row">
        <div class="col s6">
            <h3><fmt:message key="hello"/> ${client.getFirstName()} ${client.getLastName()}</h3>
        </div>
        <div class="col s6 right-align">
            <h3 class="thin"><fmt:formatNumber value="${clientFullBalance}" type="currency" currencySymbol=""/>&euro;</h3>
        </div>
        <c:if test="${updateClientError}">
        <div class="col s12 card-panel red darken-3 white-text">
            <p class="flow-text center-align"><fmt:message key="error.on.update.client"/></p>
        </div>
        </c:if>
        <div class="col s12">
            <a href="#editClientModal" class="btn waves-effect waves-light indigo lighten-1"><fmt:message key="edit.client"/></a>
        </div>
    </div>
    <hr>
    <div class="row">
        <h4 class="thin"><fmt:message key="accounts.list"/></h4>
        <table class="table striped col 12">
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
                    <td><fmt:formatNumber value="${account.getBalance()}" type="currency" currencySymbol=""/>&euro;</td>
                </tr>
            </c:forEach>
            <c:if test="${client.getAccounts().isEmpty()}">
                <tr>
                    <td colspan="4" class="center-align flow-text"><fmt:message key="empty.list"/></td>
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
<div id="editClientModal" class="modal">
    <div class="modal-content">
        <h4>Modal Header</h4>
        <p>A bunch of text</p>
    </div>
</div>