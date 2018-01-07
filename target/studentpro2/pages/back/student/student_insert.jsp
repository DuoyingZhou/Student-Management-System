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
        <h2 class="h2" style="text-align: center">Insert Student</h2>
    </div>
        <form action="<%=basePath%>pages/back/student/student_insert.action" method="post" class="form-horizontal" id="insertForm">
            <%--student id--%>
            <div class="form-group">
                <label for="STUDENTID" class="control-label col-md-3">Student ID</label>
                <div class="col-md-5">
                    <input type="text" class="form-control" name="STUDENTID" id="STUDENTID" placeholder="Please input the student ID">
                </div>
            </div>

                <%--class id--%>
                <div class="form-group">
                    <label class="control-label col-md-3">Class Name</label>
                    <div class="col-md-5">
                        <select name="CLASSES.CLASSID" id="CLASSES.CLASSID" class="form-control"></select>

                    </div>
                </div>

                <%--student name--%>
                <div class="form-group">
                    <label for="NAME" class="control-label col-md-3">Student Name</label>
                    <div class="col-md-5">
                        <input type="text" class="form-control" name="NAME" id="NAME" placeholder="Please input the student name">
                    </div>
                </div>

                <%--student age--%>
                <div class="form-group">
                    <label for="AGE" class="control-label col-md-3">Student Age</label>
                    <div class="col-md-5">
                        <input type="text" class="form-control" name="AGE" id="AGE" placeholder="Please input the student age">
                    </div>
                </div>

                <%--student gender--%>
                <div class="form-group">
                    <label class="control-label col-md-3">Student Gender</label>
                    <div class="col-md-5">
                        <label class="radio-inline">
                            <input type="radio" name="GENDER" id="GENDER1" value="0" checked> female
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="GENDER" id="GENDER2" value="1"> male
                        </label>
                    </div>
                </div>

                <%--student address--%>
                <div class="form-group">
                    <label for="ADDRESS" class="control-label col-md-3">Student Address</label>
                    <div class="col-md-5">
                        <input type="text" class="form-control" name="ADDRESS" id="ADDRESS" placeholder="Please input the student address">
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
<script src="jquery/student_insert.js"></script>
</body>
</html>
