from firebase import firebase
import firebase_admin
from firebase_admin import db
from firebase_admin import credentials
from datetime import datetime

def initializeConnection():
    cred = credentials.Certificate('/home/pi/EISPython/EIS Project-452c49eca21d.json')
    firebase_admin.initialize_app(cred,{
    'databaseURL':'https://eis-project-9721e.firebaseio.com'
    })
    #ref = db.reference('/User'+str(user_id))
    #ref.update(Updated_data)

def sendData(firebase,user_id,key,value,index):
    #ref = db.reference('/datas/'+user_id)
    #ref.update(Updated_data)
    time=[]
    time.append(datetime.now().time().hour)
    time.append(datetime.now().time().minute)
    time = float(str(time[0])+'.'+str(time[1]))
    getData = firebase.get('/datas/'+user_id+'/'+key,'None')
    if index == -1:
        index = len(getData) + 1
    putData = firebase.put('/datas/'+user_id+'/'+key+'/ob'+str(index),'Time',time)
    putData = firebase.put('/datas/'+user_id+'/'+key+'/ob'+str(index),'Value',value)
    return index

def updateData(user_id,Updated_data):
    ref = db.reference('/datas/'+user_id+'Notify')
    ref.update(Updated_data)
    
        
