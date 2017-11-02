<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="translations.translation" />

<html lang="${language}">
<head>
    <title><fmt:message key="pesonal.space" /></title>

    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/materialize.min.css" />" media="screen,projection" />
    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link type="text/css" rel="stylesheet" href="<c:url value="/css/custom.css" />" />
</head>

<body>
<%@include file="views/static/header.jsp" %>

<c:if test="${!isConnected}">
    <%--Landing page--%>
    <%@include file="views/login.jsp" %>
</c:if>

<c:if test="${isConnected}">
    <%--Connected pages goes there--%>
    <c:if test="${page == 'client'}">
        <%@include file="views/client.jsp" %>
    </c:if>
    <c:if test="${page == 'transactions'}">
        <%@include file="views/transactions.jsp" %>
    </c:if>
</c:if>


<!--Import jQuery before materialize.js-->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<c:url value="/js/materialize.min.js" />"></script>
<script>
    $(document).ready(function () {
        $('select').material_select();
        $('.modal').modal();
        <c:if test="${keepModalOpen}">
        $('#modaledit').modal('open');
        </c:if>
    });
    $(".dropdown-button").dropdown();
</script>
</body>
</html>
