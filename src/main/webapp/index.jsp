<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/16 0016
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>uncertainty</title>
    <link rel="stylesheet" href="./bower_components/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="./css/main.css">
</head>
<body>
<div id="summaryContainer">
    <h3 class="title">Dimension Summary</h3>
    <div id="dimensionSummaryDisplay"></div>
</div>
<div id="mainContainer">
    <button id="dataInputButton" type="button">导入数据</button>
</div>
<script id="dimensionSummaryTemplate" type="text/x-handlebars-template">
    <ul>
        {{#each this}}
           <li>{{@key}}:{{@index}}<i class="fa fa-info-circle" aria-hidden="true" ></i></li>
        {{/each}}
    </ul>
</script>
<script language="JavaScript" data-main="./js/main.js" src="./bower_components/requirejs/require.js"></script>
</body>
</html>
