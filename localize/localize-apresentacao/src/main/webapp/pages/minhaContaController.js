
function minhaContaController($scope, $http, $resource,$window,$rootScope) {
	
	
	
	$rootScope.sair = function() {
	
		$http.post($rootScope.server('/wsregistrar/sair'))
		.success(function(mensagem) {
	
			if($rootScope.isSuccess(mensagem)){
				
				$window.location.href= "/localize/#/";
				
			}
	
		});
	};
	
};

