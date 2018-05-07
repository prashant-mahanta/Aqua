// console.log("hello there");
var info_body = document.getElementById("water_level");
// var turbRef = firebase.database().ref().child("datas/"+useri+"/water_level");
// turbRef.on('value', function(datasnapshot){
// 		info_body.innerText = datasnapshot.val().toFixed(2)+" ";
// });
var qr = firebase.database().ref().child("datas/"+userid+"/Waterlevel");
qr.limitToLast(1).on('child_added', function(childSnapshot) {
     snap = childSnapshot.val();
     console.log(snap);
     info_body.innerText = Object.values(snap)[1];
});

function send_data(){
	console.log("here");
	var max_cap = document.getElementById("max_cap");
	var max_capr = firebase.database().ref().child("datas/"+userid+"/MaxCap");
	var rep= firebase.database().ref().child("datas/"+userid+"/Notify/usercontrolwater");
	max_capr.on('value', function(datasnapshot){
		max_capr.set(parseFloat(max_cap.value));
		rep.set(0);
		// info_body.innerText = datasnapshot.val().toFixed(2)+" ";
	});
}
