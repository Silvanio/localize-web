/**
 * Função responsável pelo controllador de motorista.
 * 
 * @param $scope
 * 
 * @param $http
 * 
 * @param $resource
 */

function informacoesController($scope, $http, $resource, informacoesService,$rootScope, FileUploader) {
	
	$scope.viewController = new Object();

	$scope.viewModel = new Object();
	$scope.viewModel.informacoes = new Object();

	$scope.viewController.formdisabled = true;
		
	$scope.alerts = [];
	
	
	 var uploader = $scope.uploader = new FileUploader({
		 
        url: '/localize/servico/wsinformacoes/upload',
       
        queueLimit: 1
        
       	 
    });
	 
	  uploader.filters.push({
		  
         name: 'imageFilter',
         
         fn: function(item, options) {
       	  
             var type = '|' + item.type.slice(item.type.lastIndexOf('/') + 1) + '|';
             
             return '|jpg|png|jpeg|bmp|gif|'.indexOf(type) !== -1;
             
         }
	  
     });

	$scope.closeAlert = function(index) {
			
		 $scope.alerts.splice(index, 1);
	
	 };
	 
	 $scope.abrirInformacoes = function(){
		
			informacoesService.abrirInformacoes()
			
			.success(function(informacoes) {

				$scope.viewModel.informacoes =	informacoes;

				if($scope.viewModel.informacoes != null && $scope.viewModel.informacoes.imagem != null){
					
					$scope.viewController.formdisabled = false;
				}
				
				
			});
		 
	 };
	 
		 $scope.salvar = function() {
				
				$scope.showErrorsCheckValidity = true;

				if ($scope.informacoesForm.$invalid) {
					
					return;
				
				}
				
				$scope.closeAlert(0);
				
				informacoesService.salvar($scope.viewModel.informacoes)
				
				.success(function(mensagem) {

					if($rootScope.isSuccess(mensagem)){
						
						$scope.alerts.push({type: 'success', msg: mensagem.descricao});
						
					}else{
						
						 $scope.alerts.push({type: 'danger', msg: mensagem.descricao});
						
					}

				});
				
		 };
		
	
	  uploader.onAfterAddingFile = function(fileItem) {
		  
		  fileItem.upload();
		  
      };
      
      $scope.removerArquivo = function() {
    	  
    	  uploader.destroy(); 
    	  
    	  $scope.viewController.formdisabled = true;
    	  
      };
	  
	  uploader.onCompleteAll = function() {
		  
		  $scope.viewController.formdisabled = false;
		  
      };

}