/**
 * Service para a visão de motorista.
 */
app.service('trocarSenhaService', function($http, $rootScope) {

	this.salvar = function(trocarSenhaDTO) {
		return $http.post($rootScope.server('/wsregistrar/trocarSenha'),trocarSenhaDTO);
	};
	
	
});