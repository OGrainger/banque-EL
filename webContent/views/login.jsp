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
                <c:if test="${wrongCredentialsError}">
                    <div class="col s12">
                        <div class="alert alert-danger" role="alert"><fmt:message key="error.wrong.credentials" /></div>
                    </div>
                </c:if>
                <c:if test="${loginAlreadyExistsError}">
                    <div class="col s12">
                        <div class="alert alert-danger" role="alert"><fmt:message
                                key="error.login.already.exists" /></div>
                    </div>
                </c:if>
            </div>

            <div class="row">
                <div class="col-xs-6 col-sm-6 col s6">
                    <button type="submit" class="waves-effect waves-light btn-large btn-block indigo lighten-1" name="action"
                            value="login"><fmt:message key="log.in" /></button>
                </div>
                <div class="col-xs-6 col-sm-6 col s6">
                    <button type="submit" class="waves-effect waves-light btn-large btn-block indigo lighten-1" name="action"
                            value="register"><fmt:message key="register" /></button>
                </div>
            </div>
        </form>
    </div>
</div>
<img class="bg-image-login" src="<c:url value="images/bg-login.jpg" />" alt="">