
  // var user=firebase.auth().currentUser;
  // console.log(user.uid);


var info_body = document.getElementById("turbidity");
 var userid = "ACNJgzVAoCQGpM3MN7ZXX4eGxv92";
var turbRef = firebase.database().ref().child("datas/"+userid+"/Turbidity");

//to read last value
turbRef.limitToLast(1).on('child_added', function(childSnapshot) {

     var snap = childSnapshot.val();
     console.log(snap);
     console.log("dum maar");
     info_body.innerText = Object.values(snap)[1];

});
// ---------------------------------------------------------------
var q = document.getElementById("water_level");
var qr = firebase.database().ref().child("datas/"+userid+"/Waterlevel");

qr.limitToLast(1).on('child_added', function(childSnapshot) {

      snap = childSnapshot.val();
     console.log(snap);
     q.innerText = Object.values(snap)[1];

});
// // ---------------------------------------------------------------
var b = document.getElementById("water_flow");
var br = firebase.database().ref().child("datas/"+userid+"/waterFlow");

br.limitToLast(1).on('child_added', function(childSnapshot) {

     var snap = childSnapshot.val();
     console.log(snap);
     b.innerText = Object.values(snap)[1];

});

// // ---------------------------------------------------------------
var c = document.getElementById("water_meter");
var cr = firebase.database().ref().child("datas/"+userid+"/MaxCap");

cr.on('value', function(datasnapshot){

	c.innerText = datasnapshot.val().toFixed(2)+" ";
});
// // ---------------------------------------------------------------
var d = document.getElementById("user_name");
var dr = firebase.database().ref().child("users/"+userid+"/email");

dr.on('value', function(datasnapshot){

	d.innerText = datasnapshot.val()+" ";
	console.log(datasnapshot.val());
});
// // ---------------------------------------------------------------
var p = document.getElementById("predict");
var pr = firebase.database().ref().child("datas/"+userid+"/predictedPrice");

pr.on('value', function(datasnapshot){

	p.innerText = datasnapshot.val().toFixed(2)+" ";
});




//-----------------------------------------------------------------------

var e = document.getElementById("notify");
var dot= document.getElementById("dotnot");
var er = firebase.database().ref().child("datas/"+userid+"/Notify/qualityTurbidity/");
er.on('value', function(datasnapshot){
  if(datasnapshot.val()==1){
    e.innerHTML="Water Turbidity is more than 70%";
    dot.innerHTML=".";
  }
});
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