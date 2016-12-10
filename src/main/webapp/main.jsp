<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/16 0016
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Uncertainty Main Page</title>
    <link rel="stylesheet" href="./bower_components/tooltipster/dist/css/tooltipster.bundle.min.css">
    <link rel="stylesheet"
          href="./bower_components/tooltipster/dist/css/plugins/tooltipster/sideTip/themes/tooltipster-sideTip-shadow.min.css">
    <link rel="stylesheet" href="./bower_components/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="./css/main.css">
    <link rel="stylesheet" type="text/css" href="./css/parallelVis.css">
</head>
<body>
<div id="summaryContainer" class="containerBorder">
    <h3 class="title">Dimension Summary</h3>
    <button id="dataInputButton" type="button">导入数据</button>
    <form name="fileUploadForm" action="/uncertainty/fileupload" method="post" enctype="multipart/form-data">
        <input type="file" name="file">
        <input type="submit" value="上传" >
    </form>
    <div id="dimensionSummaryDisplay"></div>
</div>
<div id="mainContainer" class="containerBorder"></div>
<div id="parallelContainer" class="containerBorder"></div>
<script id="dimensionSummaryTemplate" type="text/x-handlebars-template">
    {{#each this}}
    <div class="dimensionInfo"><span>{{@key}}</span><i class="fa fa-info-circle" aria-hidden="true"
                                                       title="{{toJson this}}"></i></div>
    {{/each}}
</script>
<script id="tooltipsterTemplate" type="text/x-handlebars-template">
    <h3>Summary</h3>
    <ul>
        {{#each this}}
        <li>{{this}}</li>
        {{/each}}
    </ul>
</script>
<script language="JavaScript" data-main="./js/main.js" src="./bower_components/requirejs/require.js"></script>
</body>
</html>
