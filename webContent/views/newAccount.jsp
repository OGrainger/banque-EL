<form class="container" method="post" action="${pageContext.request.contextPath}/new-account">
    <div class="card-panel">
        <div class="row">
            <div class="col s12">
                <h3><fmt:message key="new.account"/></h3>
            </div>
            <div class="input-field col s12">
                <select name="description" required>
                    <option value="<fmt:message key="A.booklet"/>"><fmt:message key="A.booklet"/></option>
                    <option value="<fmt:message key="common.account"/>"><fmt:message key="common.account"/></option>
                    <option value="<fmt:message key="sustainability.booklet"/>"><fmt:message key="sustainability.booklet"/></option>
                    <option value="<fmt:message key="young.person.booklet"/>"><fmt:message key="young.person.booklet"/></option>
                </select>
                <label><fmt:message key="choose.account.type"/></label>
            </div>
            <div class="col m6">
                <button type="submit" class="btn-large btn-block"><fmt:message key="submit"/></button>
            </div>
            <div class="col m6">
                <a class="btn-large btn-block red white-text" href="${pageContext.request.contextPath}/client"><fmt:message key="back"/></a>
            </div>
        </div>
    </div>
</form>