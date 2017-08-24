/**
 * Função responsável pelo controllador de publicar.
 * 
 * @param $scope
 * 
 * @param $http
 * 
 * @param $resource
 */

function publicarController($scope, $http, $resource, publicarService,$rootScope) {
	
	$scope.viewController = new Object();
	
	$scope.alerts = [];
	
	$scope.closeAlert = function(index) {
		
		 $scope.alerts.splice(index, 1);
	
	 };
	
	$scope.iniciar = function(){
		
		publicarService.abrirPublicar()

		.success(function(publicar) {
			
			$scope.viewController.aceito = publicar;
			
			if(publicar == "true"){
				
				$("#checkSlave").prop( "checked", true );

			}
			
		});
	}
	
		
	$scope.salvar = function(){
		
		$scope.closeAlert(0);
		
		publicarService.salvar($scope.viewController.aceito)

		.success(function(mensagem) {

			if($rootScope.isSuccess(mensagem)){
				
				$scope.alerts.push({type: 'success', msg: mensagem.descricao});
				
			}else{
				
				 $scope.alerts.push({type: 'danger', msg: mensagem.descricao});
				
			}

		});
		
	};

}