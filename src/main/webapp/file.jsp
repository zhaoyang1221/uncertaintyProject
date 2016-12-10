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
    <title>uncertainty</title>

</head>
<body>
<form:form method="POST" commandName="file"	enctype="multipart/form-data">

    Upload your file please:
    <input type="file" name="file" />
    <input type="submit" value="upload" />
    <form:errors path="file" cssStyle="color: #ff0000;" cssClass="error" element="div"/>
</form:form>
</body>
</html>
