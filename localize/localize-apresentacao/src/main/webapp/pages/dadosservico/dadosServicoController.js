function dadosServicoController($scope, $http, $resource, dadosServicoService, FileUploader,$rootScope) {

	$scope.viewController = new Object();
	
	$scope.viewModel = new Object();
	
	$scope.alerts = [];

	$scope.viewModel.tiposServicos = [];

	$scope.viewModel.tiposServicoExcluir = new Object();
	
	$scope.viewController.tipoServicoList = new Object();

	$scope.viewController.seguimentoList = new Object();

	$scope.viewModel.dadosServicoForm = new Object();
	
	$scope.viewModel.dadosServicoForm.tipoServico = new Object();
	
	$scope.viewController.listagem = true;
	
	$scope.listarDadosServicos = function(){
		
		dadosServicoService.listarDadosServicos()

		.success(function(listaServicos) {
			
			$scope.viewModel.tiposServicos = listaServicos;
			
		});
		
	};
	
	$scope.salvar = function(){
		
		$scope.closeAlert(0);
		
		dadosServicoService.salvar($scope.viewModel.dadosServicoForm)

		.success(function(mensagem) {

			if($rootScope.isSuccess(mensagem)){
				
				$scope.viewModel.dadosServicoForm.seguimentosSelecionados = [
				                                                         	];
				                                                         	
				$scope.viewModel.dadosServicoForm.seguimentosSelecionados.push({descricao:"",id:""});
				
				$scope.viewController.listagem = true;
				
				$scope.listarDadosServicos();
				
				$scope.alerts.push({type: 'success', msg: mensagem.descricao});
				
			}else{
				
				 $scope.alerts.push({type: 'danger', msg: mensagem.descricao});
				
			}

		});
	};
	
	$scope.viewModel.dadosServicoForm.seguimentosSelecionados = [
	];
	
	$scope.viewModel.dadosServicoForm.seguimentosSelecionados.push({descricao:"",id:""});

	$scope.listarSeguimentos = function() {	

		dadosServicoService.listarSeguimento($scope.viewModel.dadosServicoForm.tipoServico.id)

		.success(function(seguimentosList) {

			$scope.viewController.seguimentoList = seguimentosList;
			
			for(segItem in  $scope.viewModel.dadosServicoForm.seguimentosSelecionados){
				
				for(seguimento in seguimentosList){
					
					if(seguimentosList[seguimento].id == $scope.viewModel.dadosServicoForm.seguimentosSelecionados[segItem].id){
						
						$scope.viewModel.dadosServicoForm.seguimentosSelecionados[segItem] = seguimentosList[seguimento]; 
						
					}
				}
				
			}
			
		});
		
	};

	$scope.abrirAdicionarServico = function() {

		$scope.viewController.listagem = false;
		
		$scope.viewModel.dadosServicoForm.seguimentosSelecionados = [];
    	
		$scope.viewModel.dadosServicoForm.seguimentosSelecionados.push({descricao:"",id:""});
		
		$scope.viewModel.dadosServicoForm.tipoServico = new Object();
		
		$scope.closeAlert(0);

	};

	$scope.iniciar = function() {

		dadosServicoService.listarTipoServico()

		.success(function(tipoServicoList) {

			$scope.viewController.tipoServicoList = tipoServicoList;
			
			for(tipoServico in tipoServicoList){
				
				if(tipoServicoList[tipoServico].id == $scope.viewModel.dadosServicoForm.tipoServico.id){
					
					$scope.viewModel.dadosServicoForm.tipoServico = tipoServicoList[tipoServico];
					
					$scope.listarSeguimentos();
					
					break;
				}
			}

		});
	}
	
	$scope.voltarListagem = function() {

		$scope.viewController.listagem = true;
		
		$scope.closeAlert(0);

	};

	$scope.adicionarLinha = function() {
		
		$scope.viewModel.dadosServicoForm.seguimentosSelecionados.push({descricao:"",id:""});
		
	};

	$scope.removerLinha = function(linha) {

		$scope.viewModel.dadosServicoForm.seguimentosSelecionados.splice(linha, 1);

	};
	
	$scope.closeAlert = function(index) {
		
		 $scope.alerts.splice(index, 1);
	
	 };
	 
	 $scope.selecionarTipoServicoExclusao = function(tipoServico){
		 
		 $scope.viewModel.tiposServicoExcluir = tipoServico;
		 
	 };
	 
	 $scope.excluirDadosServico = function(){
		 
		 $scope.closeAlert(0);
		 
			dadosServicoService.excluirDadosServico($scope.viewModel.tiposServicoExcluir.id)

			.success(function(mensagem) {
				
				if($rootScope.isSuccess(mensagem)){
					
					$scope.listarDadosServicos();
					
					$scope.alerts.push({type: 'success', msg: mensagem.descricao});
					
				}else{
					
					 $scope.alerts.push({type: 'danger', msg: mensagem.descricao});
					
				}

			});
		 
	 };
	 
	 $scope.abrirEditarDadosServico = function(tipoServico){
		 
		 $scope.closeAlert(0);
		 
			dadosServicoService.abrirEditarDadosServico(tipoServico.id)

			.success(function(dadosServicos) {
				
				$scope.viewController.listagem = false;
				
				 $scope.viewModel.dadosServicoForm.tipoServico = dadosServicos.tipoServico;
				 
				 $scope.viewModel.dadosServicoForm.seguimentosSelecionados = dadosServicos.seguimentosSelecionados;

			});
		 
	 };
}