var toData1=[0,0,0,0,0,0,0,0,0,0,0,0]
var toData2=[0,0,0,0,0,0,0,0,0,0,0,0]
var toData3=[0,0,0,0,0,0,0,0,0,0,0,0]	
function load() {
	$.ajax({
		url: "/servicio/loadData/1",
		method : 'GET',
		dataType : 'json',
		contentType : 'application/json',
		success : function(response){
			var toLabels = [];
			$.each(response, function(i, item){
				toLabels.push(item.llave);
				toData1[item.valor2-1]=item.valor;
			});
			$.ajax({
				url: "/servicio/loadData/2",
				method : 'GET',
				dataType : 'json',
				contentType : 'application/json',
				success : function(response){
					var toLabels2 = [];
					$.each(response, function(i, item){
						toLabels2.push(item.llave);
						toData2[item.valor2-1]=item.valor;
					});
					$.ajax({
						url: "/servicio/loadData/3",
						method : 'GET',
						dataType : 'json',
						contentType : 'application/json',
						success : function(response){
							var toLabels3 = [];
							$.each(response, function(i, item){
								toLabels3.push(item.llave);
								toData3[item.valor2-1]=item.valor;
							});
							var barChartData = {
									labels: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'],
									datasets: [{
										label: toLabels[0],
										backgroundColor: getRandomColor(),
										yAxisID: 'y-axis-1',
										data:toData1
									}, {
										label: toLabels2[0],
										backgroundColor: getRandomColor(),
										yAxisID: 'y-axis-2',
										data:toData2
									}, {
										label: toLabels3[0],
										backgroundColor: getRandomColor(),
										yAxisID: 'y-axis-3',
											data:toData3
										}]

									};
							var ctx = document.getElementById('chart-area').getContext('2d');
							window.myBar = new Chart(ctx, {
								type: 'bar',
							data: barChartData,
							options: {
							responsive: true,
							title: {
								display: true,
								text: ''
							},
							tooltips: {
								mode: 'index',
								intersect: true
							},
							scales: {
								yAxes: [{
									type: 'linear', // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
									display: true,
									position: 'left',
									id: 'y-axis-1',
								}, {
									type: 'linear', // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
									display: true,
									position: 'right',
									id: 'y-axis-2',
									gridLines: {
										drawOnChartArea: false
									}
								}, {
									type: 'linear', // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
									display:false,
									position: 'right',
									id: 'y-axis-3',
											gridLines: {
												drawOnChartArea: false
											}
										}],
									}
								}
							});
							
							
						},
						error : function(err){
							console.log(err);
						}
						
					});
	
				},
				error : function(err){
					console.log(err);
				}
				
			});
	
			
		},
		error : function(err){
			console.log(err);
		}
		
	});
};

function getRandomColor() {
	  var letters = '0123456789ABCDEF';
	  var color = '#';
	  for (var i = 0; i < 6; i++) {
	    color += letters[Math.floor(Math.random() * 16)];
	  }
	  return color;
	}
$(document).ready(function(){
	load();

});
	