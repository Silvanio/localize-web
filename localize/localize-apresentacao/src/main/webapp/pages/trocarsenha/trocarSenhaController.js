
function trocarSenhaController($scope, $http, $resource, trocarSenhaService,$rootScope) {
	
	$scope.viewModel = new Object();

	$scope.viewModel.trocarSenhaDTO = new Object();
	
	$scope.alerts = [];

	$scope.closeAlert = function(index) {
			
		 $scope.alerts.splice(index, 1);
	
	 };
	 
	 $scope.salvar = function() {
			
			$scope.showErrorsCheckValidity = true;

			if ($scope.trocarSenhaForm.$invalid) {
				
				return;
			
			}
			
			$scope.closeAlert(0);
			
			trocarSenhaService.salvar($scope.viewModel.trocarSenhaDTO)
			
			.success(function(data) {

				if($rootScope.isSuccess(data)){
					
					$scope.alerts.push({type: 'success', msg: data.descricao});
					
					$scope.viewModel.trocarSenhaDTO = new Object();
				
				}else{
					
					 $scope.alerts.push({type: 'danger', msg: data.descricao});
					
				}

			});
			
	 };
	

}