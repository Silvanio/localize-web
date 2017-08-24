var app = {};

/**
 * url padrão
 */
SERVER_URL = "/localize/servico";

/**
 * modulo app para o angular.
 */
app = angular.module("app", [ "ngResource", "ngRoute", "ui.bootstrap","chieffancypants.loadingBar","angularFileUpload","ui.utils"]);

/**
 * Configurações de rotas para o menu.
 */
app.config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'inicial.jsp'
	})
	.when('/informacoes', {
		controller :   informacoesController,
		templateUrl : 'informacoes/inicial.html'
	})
	.when('/localizacao', {
		controller :   localizacaoController,
		templateUrl : 'localizacao/inicial.jsp'
	})
	.when('/publicar', {
		controller :   publicarController,
		templateUrl : 'publicar/inicial.html'
	})
	.when('/dadosServico', {
		controller :   dadosServicoController,
		templateUrl : 'dadosservico/inicial.html'
	})
	.when('/trocarsenha', {
		controller :   trocarSenhaController,
		templateUrl : 'trocarsenha/inicial.html'
	});
});

/**
 * função executada ao iniciar o modulo.
 */
app.run(function($rootScope) {
	/**
	 * função responsável por retornar o caminho completo para o rest.
	 */
	$rootScope.server = function(url) {

		return SERVER_URL + url;

	};
	/**
	 * função responsável por retornar verificar se a mensagem é de sucesso.
	 */
	$rootScope.isSuccess = function(mensagem) {
		
		return mensagem.tipo == 'SUCESS';
		
	};
});

function atualizarEstadoMenu(){
	$('.mainnav li').removeClass('active');
	$.each($('.mainnav li'), function(){ 
		var nome = removeAcento($(this).text().toUpperCase());
		var texto = new String(window.location).split('#/')[1].toUpperCase(); 
		if(nome.trim() == texto.trim()){ 
			$(this).addClass('active');
		}  
	});
	// adiciona class para que o calendario na pagina de orcamento apareça somente as opções de mes e ano
	$('body').addClass('mm-nn');
}

function removeAcento(strToReplace) {
	str_acento = "áàãâäéèêëíìîïóòõôöúùûüçÁÀÃÂÄÉÈÊËÍÌÎÏÓÒÕÖÔÚÙÛÜÇ";
	str_sem_acento = "aaaaaeeeeiiiiooooouuuucAAAAAEEEEIIIIOOOOOUUUUC";
	var nova = "";
	for (var i = 0; i < strToReplace.length; i++) {
		if (str_acento.indexOf(strToReplace.charAt(i)) != -1) {
			nova += str_sem_acento.substr(str_acento.search(strToReplace
					.substr(i, 1)), 1);
		} else {
			nova += strToReplace.substr(i, 1);
		}
	}
	return nova;
}

