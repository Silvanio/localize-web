/**
 * Service para a visão de dadosServicoService.
 */
app.service('dadosServicoService', function($http, $rootScope) {

	this.listarDadosServicos = function() {
		return $http.post($rootScope.server('/wsdadosservico/listarDadosServicos'));
	};
	
	this.listarTipoServico = function() {
		return $http.post($rootScope.server('/wsdadosservico/listarTipoServico'));
	};

	this.listarSeguimento = function(idTipoServico) {
		return $http.post($rootScope.server('/wsdadosservico/listarSeguimento'),idTipoServico);
	};

	this.salvar = function(tipoServico) {
		return $http.post($rootScope.server('/wsdadosservico/salvar'),tipoServico);
	};
	
	this.excluirDadosServico = function(idTipoServico) {
		return $http.post($rootScope.server('/wsdadosservico/excluir'),idTipoServico);
	};

	this.abrirEditarDadosServico = function(idTipoServico) {
		return $http.post($rootScope.server('/wsdadosservico/abrirEditarDadosServico'),idTipoServico);
	};

});