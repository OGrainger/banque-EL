<div class="row" style="margin-top:20px">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
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
                    <div class="col-xs-6 col-sm-6 col-md-6">
                        <input type="submit" class="btn btn-lg btn-success btn-block" name="login" value="<fmt:message key="to.connect"/>">
                    </div>
                    <div class="col-xs-6 col-sm-6 col-md-6">
                        <input type="submit" class="btn btn-lg btn-primary btn-block" name="register" value="<fmt:message key="register"/>">
                    </div>
                </div>
            </fieldset>
        </form>
    </div>
</div>