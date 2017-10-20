<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="translations.translation"/>

<html lang="${language}">
<head>
    <title>O.B. - <fmt:message key="pesonal.space"/></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
</head>

<body>
<%@include file="views/static/header.jsp" %>
<div class="container">
    <form>
        <select id="language" name="language" onchange="submit()">
            <option value="en_US" ${language == 'en_US' ? 'selected' : ''}><fmt:message key="language.english"/></option>
            <option value="fr_FR" ${language == 'fr_FR' ? 'selected' : ''}><fmt:message key="language.french"/></option>
        </select>
        <label><fmt:message key="select.language"/></label>
    </form>

    <jsp:include page="views/client.jsp">
        <jsp:param name="test" value="this is a param value passed in a dynamic inclusion"/>
    </jsp:include>

    <%@include file="views/static/footer.jsp" %>

</div>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</body>
</html>
