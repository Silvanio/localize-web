/**
 * Service para a visão de motorista.
 */
app.service('localizacaoService', function($http, $rootScope) {

	this.abrirLocalizacao = function() {
		return $http.post($rootScope.server('/wslocalizacao/abrirLocalizacao'));
	};
	
	this.salvar = function(localizacao) {
		return $http.post($rootScope.server('/wslocalizacao/salvar'),localizacao);
	};

});