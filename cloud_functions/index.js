const functions = require('firebase-functions');

// Create and Deploy Your First Cloud Functions
// https://firebase.google.com/docs/functions/write-firebase-functions

exports.helloWorld = functions.https.onRequest((request, response) => {
 response.send("Hello from Firebase!");
});

exports.test=functions.database.ref("datas/ACNJgzVAoCQGpM3MN7ZXX4eGxv92/waterFlow/{}").onWrite(event=>{
  const myval=event.data.val();
  console.log(myval.Value);
  const rootRef=event.data.ref.root;
  return rootRef.child('datas/ACNJgzVAoCQGpM3MN7ZXX4eGxv92').once('value').then(snap=>{
   const sum=snap.val().actualCost+myval.Value;
   console.log(sum);
   return rootRef.child('datas/ACNJgzVAoCQGpM3MN7ZXX4eGxv92/actualCost').set(sum);
  });

});
exports.test_fun=functions.database.ref("datas/oZCF4069svh8tGDMMLOeY5ghkfX2/waterFlow/{}").onWrite(event=>{
    const myval=event.data.val();
    console.log(myval.Value);
    const rootRef=event.data.ref.root;
    return rootRef.child('datas/oZCF4069svh8tGDMMLOeY5ghkfX2').once('value').then(snap=>{
        const sum=snap.val().actualCost+myval.Value;
        console.log(sum);
        return rootRef.child('datas/oZCF4069svh8tGDMMLOeY5ghkfX2/actualCost').set(sum);
    });

});