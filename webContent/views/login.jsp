<div class="container">
    <div class="container card-panel card-panel-login z-depth-5 grey lighten-5">
        <form action="${pageContext.request.contextPath}/login" method="post">
            <div class="row">
                <div class="col m12">
                    <h4><fmt:message key="welcome.message" /></h4>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <i class="material-icons prefix">mail_outline</i>
                    <input type="email" name="email" id="email" class="validate" required>
                    <label for="email"><fmt:message key="email" /></label>
                </div>
                <div class="input-field col s12">
                    <i class="material-icons prefix">lock_outline</i>
                    <input type="password" name="password" id="password" class="validate" required>
                    <label for="password"><fmt:message key="password" /></label>
                </div>
            </div>
            <c:if test="${wrongCredentialsError}">
                <div class="row">
                    <div class="card-panel orange lighten-2 center-align">
                        <span class="flow-text"><fmt:message key="error.wrong.credentials" /></span>
                    </div>
                </div>
            </c:if>
            <c:if test="${loginAlreadyExistsError}">
                <div class="row">
                    <div class="card-panel orange lighten-2 center-align">
                        <span class="flow-text"><fmt:message key="error.login.already.exists" /></span>
                    </div>
                </div>
            </c:if>
            <div class="row">
                <div class="col s6">
                    <button type="submit" class="waves-effect waves-light btn-large btn-block teal lighten-1" name="action"
                            value="login"><fmt:message key="log.in" /></button>
                </div>
                <div class="col s6">
                    <button type="submit" class="waves-effect waves-light btn-large btn-block indigo lighten-1 tooltipped" name="action"
                            value="register" data-position="top" data-delay="50" data-tooltip="<fmt:message key="new.account.offer"/>">
                        <fmt:message key="register" /></button>
                </div>
            </div>
        </form>
    </div>
</div>
<img class="bg-image-login hide-on-med-and-down" src="<c:url value="images/bg-login.jpg" />" alt="">