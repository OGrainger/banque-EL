<form class="container" method="post" action="${pageContext.request.contextPath}/new-transaction">
    <div class="card-panel">
        <div class="row">
            <div class="col s12">
                <h3><fmt:message key="new.transaction"/></h3>
            </div>
            <div class="input-field col s12">
                <select name="donorAccountId" required>
                    <c:forEach items="${client.getAccounts()}" var="account">
                        <option value="${account.getResourceId()}">${account.getClient().getLogin()} - ${account.getDescription()}</option>
                    </c:forEach>
                </select>
                <label><fmt:message key="choose.donor.acccount"/></label>
            </div>
            <div class="input-field col s12">
                <select name="recipientAccountId" required>
                    <c:forEach items="${allAccounts}" var="account">
                    <option value="${account.getResourceId()}">${account.getClient().getLogin()} - ${account.getDescription()}</option>
                    </c:forEach>
                </select>
                <label><fmt:message key="choose.recipient.acccount"/></label>
            </div>
            <div class="input-field col s6">
                <input name="description" id="description" type="text" class="validate" required>
                <label for="description"><fmt:message key="enter.label"/> </label>
            </div>
            <div class="input-field col s6">
                <input name="amount" id="amount" type="number" step="0.01" min="0.01" class="validate" required>
                <label for="amount"><fmt:message key="choose.amount"/> </label>
            </div>
            <div class="col m6">
                <button type="submit" class="btn-large btn-block"><fmt:message key="submit"/></button>
            </div>
            <div class="col m6">
                <a class="btn-large btn-block red white-text" href="${pageContext.request.contextPath}/transactions"><fmt:message key="back"/></a>
            </div>
        </div>
    </div>
</form>