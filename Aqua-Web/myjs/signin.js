function sign(){
	var mail=document.getElementById('email').value;
	var pass=document.getElementById('pass').value;
	// console.log(mail);
	// console.log(pass);
	firebase.auth().signInWithEmailAndPassword(mail,pass).catch(function(error){
		document.getElementById('error').innerHTML=error.code+":"+error.message;
	});

	// firebase.auth().onAuthStateChanged(function(user) {
	//   if (user) {
	//    window.location='./index.html';
	//   }
	// });	
	var user1 = "aakash@gmail.com";
	var user1pass = "qwerty1234";

	var user2 = "alice@gmail.com";
	var user2pass = "asdf1234";

	var n1 = mail.localeCompare(user1);
	var p1 = pass.localeCompare(user1pass);
	var n2 = mail.localeCompare(user2);
	var p2 = pass.localeCompare(user2pass);
	if(n1==0 && p1==0){
		window.location='./index1.html';
	}

	if(n2==0 && p2==0){
		window.location='./index2.html';
	}
	// //Handle Account Status
	// firebase.auth().onAuthStateChanged(user => {
	//   if(user) {
	//     window.location = './index.html'; //After successful login, user will be redirected 
	//   }
	//   else{
	//   	console.log("user is null");
	//   }
	// });
	// firebase.auth().onAuthStateChanged(function(user) {
	//   if (user) {
	//    window.location = './index.html';
	//   }
	// }
	// console.log("hi");
};

// (function(){


// 	const config = {
//     apiKey: "AIzaSyDOsYai0V0uvk3pkVSO9a6hHsanJl2Z4Dk",
//     authDomain: "eis-project-9721e.firebaseapp.com",
//     databaseURL: "https://eis-project-9721e.firebaseio.com",
//     projectId: "eis-project-9721e",
//     storageBucket: "eis-project-9721e.appspot.com",
//     messagingSenderId: "670314004581"
//   };
//   firebase.initializeApp(config);


//   const mail=document.getElementById('email');
//   const pass=document.getElementById('pass');
//   const btnLogin = document.getElementById('btnLogin');

//   btnLogin.addEventListener('click',e=>{
//   	const email = mail.value;
//   	const pasw = pass.value;
//   	const auth = firebase.auth();

//   	const promise = auth.signInWithEmailAndPassword(email,pasw);

//   	promise.catch(e => console.log(e.message));
//   });


//   firebase.auth().onAuthStateChanged(firebaseUser => {

//   	if(firebaseUser){
//   		console.log(firebaseUser);
//   	}
//   	else{
//   		console.log("not logged in!!!");
//   	}
//   });


// }());