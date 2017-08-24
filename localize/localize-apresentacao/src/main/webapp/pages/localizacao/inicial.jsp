<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/mapa.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-ui.custom1.min.js"></script>


<form ng-controller="localizacaoController" id="localizacaoForm" name="localizacaoForm"  ng-init="iniciar();" >

	<div class="row">
		<div class="col-md-12">

			<alert ng-repeat="alert in alerts" type="{{alert.type}}"
				close="closeAlert($index)">{{alert.msg}}</alert>

		</div>
	</div>


<div id="widget" class="widget stacked "  >

	<div id="header" class="widget-header">
	
		<i style="margin-left: 10px;"  ></i>
		
		<h3>Mapa Localização</h3>
		
	</div>

	<div id="content" class="widget-content" >
	
			<div class="row">
				<div class="col-md-6">
				
						<div class="form-group" validade>
			
							<label for="txtEndereco" class="control-label" >Endereço:</label> 
							
							<span class="obrigatorio">*</span> 
							
							<input  required="required" type="text" ng-model="viewController.localizacao.descricao" name="txtEndereco"  id="txtEndereco" style="width: 95%" class="form-control"  >
							
							<p class="help-block" ng-if="localizacaoForm.txtEndereco.$error.required">O Campo Endereço é Obrigatório</p>
							
						</div>
				
				</div>
				
				<div class="col-md-4">&nbsp;</div>

				<div class="col-md-2">
				
				<label class="control-label" >&nbsp;</label>

				<div class="button-group">
		
					<button type="button" style="float: right;" ng-click="salvarLocalizacao();" class="form-control btn btn-primary btn-large" >Salvar</button>
		
				</div>
						
				</div>
			
				<input type="hidden"    id="txtLatitude" >
				
				<input type="hidden"   id="txtLongitude" >
		
		</div>

		<div class="row">
			<div class="col-md-12">
			
					<div id="mapa" style="width: 100%;  height: 400px; "></div>
			
			</div>
		</div>
	
	</div>

</div>
</form>