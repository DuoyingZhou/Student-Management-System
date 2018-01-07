<%--
  Created by IntelliJ IDEA.
  User: zhoud
  Date: 1/5/2018
  Time: 5:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path +"/";
%>
<base href="<%=basePath%>">
</div>
<script src="js/jquery/jquery.min.js"></script>
<script src="js/bootstrap/js/bootstrap.min.js"></script>
<script src="js/metisMenu/metisMenu.min.js"></script>
<%--<script src="js/raphael/raphael.min.js"></script>--%>
<script src="js/morrisjs/morris.min.js"></script>
<script src="js/data/morris-data.js"></script>
<script src="js/dist/js/sb-admin-2.js"></script>
