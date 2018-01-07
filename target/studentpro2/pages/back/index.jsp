<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path +"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Student Management System</title>
</head>
<body>
<jsp:include page="/pages/header.jsp"/>
<!--main content-->
<div id="page-wrapper">
    <h1>Admin ID:<%=request.getSession().getAttribute("AID")%></h1>
    <h2>Last Login Date:<%=request.getSession().getAttribute("LASTDATE")%></h2>
</div>
<jsp:include page="/pages/footer.jsp"/>

</body>
</html>
