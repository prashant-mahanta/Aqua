
  // var user=firebase.auth().currentUser;
  // console.log(user.uid);


var info_body = document.getElementById("water_level");
var turbRef = firebase.database().ref().child("datas/"+user.uid+"/Turbidity");

turbRef.on('value', function(datasnapshot){
	console.log(datasnapshot.val());
});
// ---------------------------------------------------------------
// var q = document.getElementById("water_meter");
// var qr = firebase.database().ref().child("User1/waterMeter");

// qr.on('value', function(datasnapshot){

// 	q.innerText = datasnapshot.val().toFixed(2)+" ";
// });
// // ---------------------------------------------------------------
// var b = document.getElementById("turbidity");
// var br = firebase.database().ref().child("User1/Turbidity");

// br.on('value', function(datasnapshot){
// 	var x=datasnapshot.val();
// 	b.innerText = x.toFixed(2)+" ";
// 	if(x>70){
// 		var firebaseRef=firebase.database().ref().child("User1/notify");
// 		firebaseRef.child("web").set(1);
// 	}

// });

// // ---------------------------------------------------------------
// var c = document.getElementById("water_bill");
// var cr = firebase.database().ref().child("User1/water_bill");

// cr.on('value', function(datasnapshot){

// 	c.innerText = datasnapshot.val().toFixed(2)+" ";
// });
// // ---------------------------------------------------------------
// var d = document.getElementById("user_name");
// var dr = firebase.database().ref().child("User1/Name");

// dr.on('value', function(datasnapshot){

// 	d.innerText = datasnapshot.val()+" ";
// });
// // ---------------------------------------------------------------
// var e = document.getElementById("notify");
// var er = firebase.database().ref().child("User1/notify/web");
// var dot= document.getElementById("dotnot");
// var st=document.getElementById("notify_in");
// var firebaseRef2;
// er.on('value', function(datasnapshot){
// 	var y=datasnapshot.val();
// 	console.log(y);
// 	if(y==1){
// 		console.log("**");
// 		firebaseRef2=firebase.database().ref().child("User1/notify");
// 		firebaseRef2.child("web").set(0);
// 		dot.innerText=".";
// 		e.innerText = "Turbity is greater than 70%";
// 		st.innerText ="You have a new notification";
// 	}
// 	if(y==0){
// 		e.innerText = "";
// 		dot.innerText="";
// 		st.innerText ="You have no new notification";
// 	}
	
// });
// // ---------------------------------------------------------------
// // function send_data(){
	
// // 	console.log("here");
// // 	var max_cap = document.getElementById("max_cap");
// // 	var max_capr = firebase.database().ref().child("User1/maxCap");
// // 	var rep= firebase.database().ref().child("User1/reply");
// // 	max_capr.on('value', function(datasnapshot){
// // 		max_capr.set(parseFloat(max_cap.value()));
// // 		// reply.set(1);
// // 		// info_body.innerText = datasnapshot.val().toFixed(2)+" ";
// // 	});
// // }