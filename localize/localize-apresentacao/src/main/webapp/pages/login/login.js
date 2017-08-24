var loginModule = {};

SERVER_URL = "/localize/servico";

/**
 * modulo loginModule para o angular.
 */
loginModule = angular.module('login', [ "ngResource", "ngRoute", "ui.bootstrap","chieffancypants.loadingBar","ui.utils" ]);


loginModule.run(function($rootScope) {

	$rootScope.server = function(url) {

		return SERVER_URL + url;

	};

	$rootScope.isSuccess = function(mensagem) {
		
		return mensagem.tipo == 'SUCESS';
		
	};
}

);

/**
 * <p>
 * <b>Title:</b> showerror
 * </p>
 * <p>
 * <b>Description:</b> Componente para datepicker do jquery
 * </p>
 * <p>
 * <b>Company: </b> Fábrica de Software - Red & White
 * </p>
 * 
 * @author Silvânio Júnior
 * 
 * @version 1.0.0
 */
loginModule.directive('validade', function() {

	return {

		restrict : 'A',

		require : '^form',

		link : function(scope, el, attrs, formCtrl) {

			var inputEl = el[0].querySelector("[name]");

			var inputNgEl = angular.element(inputEl);

			var inputName = inputNgEl.attr('name');

			inputNgEl.bind('blur', function() {

				el.toggleClass('has-error', formCtrl[inputName].$invalid);

			});

			scope.$watch(function() {

				return scope.showErrorsCheckValidity;

			}, function(newVal, oldVal) {

				if (!newVal) {

					return;

				}

				el.toggleClass('has-error', formCtrl[inputName].$invalid);

			});

			scope.$watch(function() {

				return scope.showErrorsReset;

			}, function(newVal, oldVal) {

				if (!newVal) {
					return;
				}

				$timeout(function() {

					el.removeClass('has-error');

				}, 0, false);
			});

		}
	};
});

/**
 * Configurações de rotas para o menu.
 */
loginModule.config(function($routeProvider) {

	$routeProvider.when('/', {
	
		controller : loginController, 
		
		templateUrl : 'pages/login/entrar.html'

	})
	
		.when('/esquecisenha', {
	
		controller : registrarController, 
	
		templateUrl : 'pages/login/esqueci-senha.html'
	
	})
	
	.when('/registrar', {
	
		controller : registrarController, 
	
		templateUrl : 'pages/login/registrar.html'
	
	});

});



function loginController($scope, $http,$rootScope,$window) {

	$scope.viewModel = new Object();

	$scope.viewModel.cnpj = new Object();

	$scope.viewModel.fornecedor = new Object();

	$scope.viewModel.fornecedor.informacoes = new Object();

	$scope.alerts = [];
	
	 $scope.closeAlert = function(index) {
			
		 $scope.alerts.splice(index, 1);
	
	 };

	 $scope.enviarEmailSenha = function() {
	 
		$scope.showErrorsCheckValidity = true;

		  if ($scope.esqueciForm.$invalid) {
				
			 return;
			
		  }
		  
		  $scope.closeAlert(0);
		  
			$http.post($rootScope.server('/wsregistrar/enviarEmailSenha'),$scope.viewModel.cnpj)
			
			.success(function(data) {

				if($rootScope.isSuccess(data)){
					
					$scope.alerts.push({type: 'success', msg: data.descricao});
				
				}else{
					
					 $scope.alerts.push({type: 'danger', msg: data.descricao});
					
				}

			});
		 
	 };

	$scope.logar = function() {
		
		
		$scope.showErrorsCheckValidity = true;

		if ($scope.loginForm.$invalid) {
			
			return;
		
		}
		
		$scope.closeAlert(0);
		
		$http.post($rootScope.server('/wsregistrar/logar'),$scope.viewModel.fornecedor)
		
		.success(function(data) {

			if($rootScope.isSuccess(data)){
				
				$window.location.href= "/localize/pages/app.jsp";
			
			}else{
				
				 $scope.alerts.push({type: 'danger', msg: data.descricao});
				
			}

		});

	};

}

function registrarController($scope, $http,$rootScope,$window) {
	
	$scope.alerts = [];
	
	$scope.viewModel = new Object();

	$scope.viewModel.fornecedor = new Object();

	$scope.viewModel.fornecedor.informacoes = new Object();
	
	 $scope.closeAlert = function(index) {
			
		 $scope.alerts.splice(index, 1);
	
	 };
	
	$scope.registrar = function() {
		
		$scope.showErrorsCheckValidity = true;

		if ($scope.registrarForm.$invalid) {
			
			return;
		
		}
		
		$scope.closeAlert(0);
		
		
		$http.post($rootScope.server('/wsregistrar/registrar'),$scope.viewModel.fornecedor)
		
		.success(function(data) {

			if($rootScope.isSuccess(data)){
				
				$window.location.href= "/localize/pages/app.jsp";
			
			}else{
				
				 $scope.alerts.push({type: 'danger', msg: data.descricao});
				
			}

		});
		
	};
	
}
