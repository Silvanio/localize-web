/**
 * Service para a visão de publicar.
 */
app.service('publicarService', function($http, $rootScope) {

	this.abrirPublicar = function() {
		return $http.post($rootScope.server('/wspublicar/abrirPublicar'));
	};
	
	this.salvar = function(publicar) {
		return $http.post($rootScope.server('/wspublicar/salvar'),publicar);
	};


});