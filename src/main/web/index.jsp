<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Test page</title>
</head>

<body>
<%@include file="static/header.jsp"%>

<jsp:include page="dynamic/client.jsp">
    <jsp:param name="test" value="this is a test"/>
</jsp:include>

<%@include file="static/footer.jsp"%>
</body>
</html>
