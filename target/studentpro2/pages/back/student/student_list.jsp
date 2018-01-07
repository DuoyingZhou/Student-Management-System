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
<!--主体内容编写-->
<div id="page-wrapper">
    <div class="col-md-12">

        <table class="table table-bordered table-hover" id="studentTable">
            <tr>
                <th class="text-center"><input type="checkbox" name="selall" id="selall"> </th>
                <th class="text-center">STUDENTID</th>
                <th class="text-center">NAME</th>
                <th class="text-center">AGE</th>
                <th class="text-center">GENDER</th>
                <th class="text-center">ADDRESS</th>
                <th class="text-center">OPERATION</th>
            </tr>
        </table>
        <button class="btn btn-danger btn-sm" id="deleteBtn">Batch Remove</button>
        <div class="text-right">
            <ul class="pagination pagination-sm" id="pagecontrol"></ul>
        </div>
        <div class="alert alert-success" id="alertDiv">
            <button class="close" data-dismiss="alert">&times;</button>
            <span id="alertText"></span>
        </div>

    </div>

    <div class="modal" id="studentInfo">

        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">&times;</button>
                    <h3 class="modal-title">Edit Student Info</h3>
                </div>
                <div class="modal-body">
                    <form method="post" class="form-horizontal" id="updateForm">
                        <%--student id--%>
                        <div class="form-group">
                            <label class="control-label col-md-3">Student ID</label>
                            <div class="col-md-5">
                                <span id="SSTUDENTID"></span>
                            </div>
                        </div>

                        <%--class id--%>
                        <div class="form-group">
                            <label class="control-label col-md-3">Class Name</label>
                            <div class="col-md-5">
                                <select name="CLASSES.CLASSID" id="CLASSES" class="form-control"></select>

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


                        <%--student address--%>
                        <div class="form-group">
                            <label for="ADDRESS" class="control-label col-md-3">Student Address</label>
                            <div class="col-md-5">
                                <input type="text" class="form-control" name="ADDRESS" id="ADDRESS" placeholder="Please input the student address">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-4 col-md-offset-6">
                                <input type="hidden" name="GENDER" id="GENDER">
                                <button type="submit" class="btn btn-success btn-sm">Edit</button>
                            </div>
                        </div>
                    </form>


                </div>
                <div class="modal-footer">
                    <button class="btn btn-success btn-sm" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/pages/footer.jsp"/>
<script src="jquery/jquery.validate.min.js"></script>
<script src="jquery/additional-methods.min.js"></script>
<script src="jquery/jquery.metadata.js"></script>
<script src="jquery/Message_zh_CN.js"></script>
<script src="jquery/util.js"></script>
<script src="jquery/student_list.js"></script>
</body>
</html>
