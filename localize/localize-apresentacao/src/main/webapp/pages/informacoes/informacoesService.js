/**
 * Service para a visão de motorista.
 */
app.service('informacoesService', function($http, $rootScope) {

	this.salvar = function(informacoes) {
		return $http.post($rootScope.server('/wsinformacoes/salvar'),informacoes);
	};

	this.abrirInformacoes = function() {
		return $http.post($rootScope.server('/wsinformacoes/abririnformacoes'));
	};

});