

function pieChart(id, valor,sigla) {

	
	if(sigla == '' || sigla == undefined){
		
		sigla = ' %';
		
	}
	$('#' + id).highcharts({
		chart : {
			type : 'pie',
			options3d : {
				enabled : true,
				alpha : 45,
				beta : 0
			}
		},
		 colors: ['#ff9900', '#101010','#4682B4','#2F4F4F','#66CDAA','#9ACD32','#C1CDC1','#36648B','#FFEC8B'],
		legend : {
			enabled : true
		},
		  credits : {
	 			enabled : false
	 		},
		title : {
			text : '',
			style : {
				display : 'none'
			}
		},
		tooltip : {
			pointFormat : '<b>{point.percentage:.1f} '+sigla+'</b>'
		},
		plotOptions : {
			pie : {
				allowPointSelect : true,
				cursor : 'pointer',
				depth : 35,
				dataLabels : {
					enabled : true,
					format : '{point.name}'
				}
			}
		},
		series : [ {
			type : 'pie',
			data : convertData(valor)
		} ]
	});
}


function barChart(id,valor,sigla){
	
	
	 $('#'+id).highcharts({
         chart: {
             type: 'column'
         },
         title: {
             text: '',
            	 style : {
     				display : 'none'
     			}
         },
         credits : {
 			enabled : false
 		},
         subtitle: {
             text: '',
             style : {
 				display : 'none'
 			}
         },
         xAxis: {
             type: 'category',
             labels: {
                 rotation: -45,
                 style: {
                     fontSize: '13px',
                     fontFamily: 'Verdana, sans-serif'
                 }
             }
         },
         yAxis: {
             min: 0,
             title: {
                 text: sigla
             }
         },
         legend: {
             enabled: false
         },
         credits : {
  			enabled : false
  		},
         tooltip: {
             pointFormat: '<b>{point.y:.1f} ' +sigla+ '</b>',
         },
         series: [{
             name: 'Population',
             data: convertData(valor),
             dataLabels: {
                 enabled: true,
                 rotation: -90,
                 color: '#FFFFFF',
                 align: 'right',
                 x: 4,
                 y: 10,
                 style: {
                     fontSize: '13px',
                     fontFamily: 'Verdana, sans-serif',
                     textShadow: '0 0 3px black'
                 }
             }
         }]
     });
	
}

function groupBarChart(id,categorias,valores,sigla){
	
	 $('#'+id).highcharts({
         chart: {
             type: 'column'
         },
         title: {
             text: '',
             style : {
  				display : 'none'
  			}
         },
         credits : {
   			enabled : false
   		},
         colors: ['#ff9900', '#101010','#4682B4','#2F4F4F','#66CDAA','#9ACD32','#C1CDC1','#36648B','#FFEC8B'],
         subtitle: {
             text: '',
             style : {
  				display : 'none'
  			}
         },
         xAxis: {
             categories: categorias
         },
         yAxis: {
             min: 0,
             title: {
                 text: sigla
             }
         },
         tooltip: {
             headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
             pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                 '<td style="padding:0"><b>{point.y:.1f} '+sigla+'</b></td></tr>',
             footerFormat: '</table>',
             shared: true,
             useHTML: true
         },
         plotOptions: {
             column: {
                 pointPadding: 0.2,
                 borderWidth: 0
             }
         },
         series: valores
     });
	
}


function convertData(valor){
	
	var name = Array();
	
	var data = Array();
	
	console.log(valor);
	var dataArrayFinal = Array();
	for (i = 0; i < valor.length; i++) {
		name[i] = valor[i].chave;
		data[i] = valor[i].valor;
	}

	for (j = 0; j < name.length; j++) {
		var temp = new Array(name[j], data[j]);
		dataArrayFinal[j] = temp;
	}
	
	return dataArrayFinal;
}


function montarGraficoKmGPSEKMManual(data,idCampo,sigla) {
	
	if(idCampo == undefined){
		
		idCampo = "graficoKmRodadoVsCategoria";
		
	}

	if(sigla == undefined){
		
		sigla = "Km Rodado";
		
	}

	var categorias = new Array();

	var valoresManual = new Array();

	var valoresGPS = new Array();

	var valores = new Array();

	for (i = 0; i < data.length; i++) {

		categorias.push(data[i].nome);

		valoresManual.push(data[i].valorManual);

		valoresGPS.push(data[i].valorGPS);
	}

	var kmManual = new Object();

	kmManual.name = "Km Manual";
	kmManual.stack = kmManual.name;
	kmManual.data = valoresManual;

	var kmGPS = new Object();

	kmGPS.name = "Km GPS";
	kmGPS.stack = kmGPS.name;
	kmGPS.data = valoresGPS;

	valores.push(kmManual);
	valores.push(kmGPS);

	groupBarChart(idCampo, categorias, valores,sigla);

}