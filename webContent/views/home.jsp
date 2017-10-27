<div class="row" style="margin-top:20px">
    <div class="col m12">
        <form action="/login" method="post">
            <fieldset>
                <h2><fmt:message key="please.sign.in"/></h2>
                <div class="form-group">
                    <input type="email" name="email" id="email" class="form-control input-lg" placeholder="<fmt:message key="login"/>" required>
                </div>
                <div class="form-group">
                    <input type="password" name="password" id="password" class="form-control input-lg" placeholder="<fmt:message key="password"/>" required>
                </div>
                <br>
                <c:if test="${wrongCredentialsError}">
                <div class="alert alert-danger" role="alert"><fmt:message key="error.wrong.credentials"/></div>
                </c:if>
                <c:if test="${loginAlreadyExistsError}">
                <div class="alert alert-danger" role="alert"><fmt:message key="error.login.already.exists"/></div>
                </c:if>
                <br>
                <div class="row">
                    <div class="col-xs-6 col-sm-6 col s6">
                        <button type="submit" class="waves-effect waves-light btn-large col m6" name="action" value="login"><fmt:message key="to.connect"/></button>
                    </div>
                    <div class="col-xs-6 col-sm-6 col s6">
                        <button type="submit" class="waves-effect waves-light btn-large col m6" name="action" value="register"><fmt:message key="register"/></button>
                    </div>
                </div>
            </fieldset>
        </form>
    </div>
</div>