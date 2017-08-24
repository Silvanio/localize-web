<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html ng-app="app">

    <head>
        <meta charset="UTF-8" /> 

		<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico" type="image/x-icon" />

        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
        
        <meta name="apple-mobile-web-app-capable" content="yes">

        <meta http-equiv="Pragma" content="no-cache">
        
		<meta http-equiv="Cache-Control" content="no-cache">

		<meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">

        <title> Localize</title>

        <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" />

        <link href="${pageContext.request.contextPath}/resources/css/loading-bar.min.css" rel="stylesheet" />

        <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" />

        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/jquery-2.1.3.min.js"></script>

        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"></script>

        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/angular/angular.js"></script>

        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/angular/angular-route.js"></script>

        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/angular/loading-bar.min.js"></script>

        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/angular/angular-resource.js"></script>

        <link href="${pageContext.request.contextPath}/resources/css/fontes.css" rel="stylesheet">

        <link href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" rel="stylesheet">

        <link href="${pageContext.request.contextPath}/resources/css/base-admin-3.css" rel="stylesheet">

        <link href="${pageContext.request.contextPath}/resources/css/base-admin-3-responsive.css" rel="stylesheet">

        <link href="${pageContext.request.contextPath}/resources/css/dashboard.css" rel="stylesheet">

        <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">

        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap-datetimepicker.min.js"></script>

        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-ui.js"></script>

        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.ui.datepicker-pt-BR.js"></script>

        <link href="${pageContext.request.contextPath}/resources/css/jquery-ui-1.10.0.custom.min.css" rel="stylesheet">

        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/angular/ui-bootstrap-tpls-0.11.0.js"></script>

        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/angular/ui-utils.min.js"></script>

        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/angular-file-upload.js"></script>
        
         <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyCd8bZBssg8LBOwAUUB0RQlF_FLIpKdUK8&sensor=FALSE"></script>
        
        <script type="text/javascript" src="${pageContext.request.contextPath}/pages/app.js"></script>
        
        <script type="text/javascript" src="${pageContext.request.contextPath}/componentes/componentes.js"></script>
        
        <!-- Controladores -->

        <script type="text/javascript" src="${pageContext.request.contextPath}/pages/informacoes/informacoesController.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/pages/dadosservico/dadosServicoController.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/pages/localizacao/localizacaoController.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/pages/publicar/publicarController.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/pages/minhaContaController.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/pages/trocarsenha/trocarSenhaController.js"></script>

        
        <script type="text/javascript" src="${pageContext.request.contextPath}/pages/informacoes/informacoesService.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/pages/dadosservico/dadosServicoService.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/pages/localizacao/localizacaoService.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/pages/publicar/publicarService.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/pages/trocarsenha/trocarSenhaService.js"></script>
    </head>


    <body>

        <div ng-include="'${pageContext.request.contextPath}/pages/cabecalho.html'"></div>

        <div ng-include="'${pageContext.request.contextPath}/pages/menu.html'"></div>

        <div class="container-fluid" ng-view="true"></div>
        

    </body>

</html>