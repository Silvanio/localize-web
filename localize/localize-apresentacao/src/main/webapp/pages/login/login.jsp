<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html ng-app="login">

<head>
<meta charset="utf-8">

<title> Localize</title>

<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico" type="image/x-icon" />

<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

<meta name="apple-mobile-web-app-capable" content="yes">

 <meta http-equiv="Pragma" content="no-cache">

<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" />

<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" />

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/jquery-2.1.1.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/angular/angular.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/angular/angular-route.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/angular/loading-bar.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/angular/angular-resource.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/angular/ui-bootstrap-tpls-0.11.0.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/angular/ui-utils.min.js"></script>

<link href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600" rel="stylesheet">

 <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">

<link href="${pageContext.request.contextPath}/resources/bootstrap/font-awesome/css/font-awesome.min.css" rel="stylesheet">

<link href="${pageContext.request.contextPath}/resources/login/adminia-1.1.css" rel="stylesheet">

<link href="${pageContext.request.contextPath}/resources/login/adminia-1.1-responsive.css" rel="stylesheet">

<link href="${pageContext.request.contextPath}/resources/login/login.css" rel="stylesheet">

<script type="text/javascript" src="${pageContext.request.contextPath}/pages/login/login.js"></script>

</head>

<body>
	
	<div class="container-fluid" ng-view="true"></div>

</body>

</html>