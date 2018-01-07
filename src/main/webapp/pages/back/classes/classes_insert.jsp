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
    <div class="col-md-12">
        <h2 class="h2" style="text-align: center">Insert Class</h2>
    </div>
        <form action="<%=basePath%>pages/back/classes/classes_insert.action" method="post" class="form-horizontal" id="insertForm">
            <div class="form-group">
                <label for="CLASSNAME" class="control-label col-md-3">Class Label</label>
                <div class="col-md-5">
                    <input type="text" class="form-control" name="CLASSNAME" id="CLASSNAME" placeholder="Please input the class name">
                </div>
            </div>
            <div class="form-group">
                <label for="CLASSNAME" class="control-label col-md-3">Class Description</label>
                <div class="col-md-5">
                    <textarea class="form-control" name="DESCRIPTION" id="DESCRIPTION" placeholder="Please input the description of the class"></textarea>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-4 col-md-offset-6">
                    <button type="submit" class="btn btn-success btn-sm">Insert</button>
                    <button type="reset" class="btn btn-danger btn-sm">Reset</button>
                </div>
            </div>
        </form>

</div>
<jsp:include page="/pages/footer.jsp"/>
<script src="jquery/jquery.validate.min.js"></script>
<script src="jquery/additional-methods.min.js"></script>
<script src="jquery/jquery.metadata.js"></script>
<script src="jquery/Message_zh_CN.js"></script>
<script src="jquery/classes_insert.js"></script>
</body>
</html>
