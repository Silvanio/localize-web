/**
 * Função responsável pelo controllador o caso de uso de localizacao.
 * 
 * @param $scope
 * 
 * @param $http
 * 
 * @param $resource
 */

function localizacaoController($scope, $http, $resource, localizacaoService, $rootScope) {
	
	$scope.viewController = new Object();
	
	$scope.viewController.localizacao = new Object();
	
	$scope.alerts = [];
	
	$scope.closeAlert = function(index) {
		
		 $scope.alerts.splice(index, 1);
	
	 };
	 
	
	$scope.iniciar	 = function(){
		
		localizacaoService.abrirLocalizacao()

		.success(function(localizacao) {
			
			$scope.viewController.localizacao = localizacao;
			
			$("#txtEndereco").val(localizacao.descricao);
			
			$("#txtLatitude").val(localizacao.latitude);

			$("#txtLongitude").val(localizacao.longitude);
			
			/*carregarNoMapa(localizacao.descricao); */
			
		});
		
	}

	$scope.salvarLocalizacao = function(){
		
		$scope.showErrorsCheckValidity = true;

		if ($scope.localizacaoForm.$invalid) {
			
			return;
		
		}
		
		$scope.closeAlert(0);
		
		$scope.viewController.localizacao.latitude = $("#txtLatitude").val();

		$scope.viewController.localizacao.longitude = $("#txtLongitude").val();
		
		$scope.viewController.localizacao.descricao = $("#txtEndereco").val();
		
		localizacaoService.salvar($scope.viewController.localizacao)

		.success(function(mensagem) {

			if($rootScope.isSuccess(mensagem)){
				
				$scope.alerts.push({type: 'success', msg: mensagem.descricao});
				
			}else{
				
				 $scope.alerts.push({type: 'danger', msg: mensagem.descricao});
				
			}

		});
		
	};
	
	function carregarNoMapa(endereco) {
		geocoder.geocode({ 'address': endereco + ', Brasil', 'region': 'BR' }, function (results, status) {
			if (status == google.maps.GeocoderStatus.OK) {
				if (results[0]) {
					var latitude = results[0].geometry.location.lat();
					var longitude = results[0].geometry.location.lng();
		
					$('#txtEndereco').val(results[0].formatted_address);
					$('#txtLatitude').val(latitude);
                   	$('#txtLongitude').val(longitude);
		
					var location = new google.maps.LatLng(latitude, longitude);
					marker.setPosition(location);
					map.setCenter(location);
					map.setZoom(16);
				}
			}
		});
	}
	
	
}