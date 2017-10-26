<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:requestEncoding value = "UTF-8" />
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="translations.translation"/>

<html lang="${language}">
<head>
    <title>O.B. - <fmt:message key="pesonal.space"/></title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>

<body>
<%@include file="views/static/header.jsp" %>
<div class="container">
    <c:if test="${!isConnected}">
        <%--Landing page--%>
        <%@include file="views/home.jsp" %>
    </c:if>

    <c:if test="${isConnected}">
        <%--Html pages goes there--%>
        <jsp:include page="views/client.jsp">
            <jsp:param name="test" value="this is a param value passed in a dynamic inclusion"/>
        </jsp:include>

    </c:if>

</div>
<%@include file="views/static/footer.jsp" %>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
