<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/16 0016
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>uncertainty file page</title>
    <link rel="stylesheet" href="./bower_components/bootstrap/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="col-lg-offset-3 col-lg-6">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>上传数据文件</strong>
            </div>
            <div class="panel-body">
                <form:form method="POST" commandName="file"	enctype="multipart/form-data" cssClass="form-horizontal">
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">上传文件</label>
                            <div class="col-sm-5">
                                <input type="file" name="file" class="form-control"/>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <form:errors path="file" cssClass="alert alert-danger pull-left" element="div"/>
                        <button type="submit" class="btn btn-default">确定</button>
                    </div>

                </form:form>
            </div>
        </div>
    </div>
<script src="./bower_components/jquery/dist/jquery.min.js"></script>
<script src="./bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>
