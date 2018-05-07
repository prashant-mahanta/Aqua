// var water_level = document.getElementById("water_level");
var turbRef = firebase.database().ref().child("datas/"+userid+"/waterFlow/");
console.log(turbRef);
// turbRef.on("value", function(datasnapshot){
// 	console.log(datasnapshot);
// });
var x;
var l;
var graphing=[];
turbRef.on('value', function(datasnapshot){
	console.log(datasnapshot.val());
	x=datasnapshot.val();
	l=x;
	for(i in x){
		z=new Object();
		q=x[i].Time;
		// z.x=String(Math.floor(q)+" "+(q-Math.floor(q))*100);
		z.x=q;
		z.y=x[i].Value;
		graphing.push(z);
	}
	console.log(graphing);
	var chart = new CanvasJS.Chart("chartContainer", {
		animationEnabled: true,
		title:{
			text: "Water Flow"
		},
		axisX:{
			// title:"Time"
			// valueFormatString: "$##0.00",
			// crosshair: {
			// 	enabled: true,
			// 	snapToDataPoint: true
			// }
			title: "Time",
			includeZero: false,
			valueFormatString: "#.00",
			crosshair: {
				enabled: true,
				snapToDataPoint: true,
				labelFormatter: function(e) {
					return CanvasJS.formatNumber(e.value, "#.00");
				}
			}
		},
		axisY: {
			title: "Water (in Liters)",
			includeZero: true,
			valueFormatString: "#.00",
			crosshair: {
				enabled: true,
				snapToDataPoint: true,
				labelFormatter: function(e) {
					return CanvasJS.formatNumber(e.value, "#.00")+"L";
				}
			}
		},
		data: [{
			type: "area",
			xValueFormatString: "#.00",
			yValueFormatString: "#.00",
			dataPoints:graphing
		}]
	});
	chart.render();
});
console.log(graphing);