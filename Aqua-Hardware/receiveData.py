from firebase import firebase

def fetchData(user_id):
    firebase1 = firebase.FirebaseApplication('https://eis-project-9721e.firebaseio.com/datas/', None)
    result = firebase1.get(user_id+'/', None)
    #print result
    return result
