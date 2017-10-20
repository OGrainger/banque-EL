<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.ynov.online.bank" />

<html lang="${language}">
<head>
    <title>Online Bank</title>
</head>

<body>

<form>
    <select id="language" name="language" onchange="submit()">
        <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
        <option value="fr" ${language == 'fr' ? 'selected' : ''}>Français</option>
    </select>
</form>
<fmt:message key="hello" />


<%@include file="static/header.jsp"%>

<jsp:include page="dynamic/client.jsp">
    <jsp:param name="test" value="this is a param value passed in a dynamic inclusion"/>
</jsp:include>

<%@include file="static/footer.jsp"%>
</body>
</html>
