import receiveData
import sendData
import Ultrasonic1
import Valve_WaterFlow
from firebase import firebase
import time
import getArduinodata

fb = firebase.FirebaseApplication('https://eis-project-9721e.firebaseio.com/', None)
result = fb.get('users/',None)
result = result.keys()
fb = firebase.FirebaseApplication('https://eis-project-9721e.firebaseio.com/datas/', None)
count= len(result)
sendData.initializeConnection()

for i in range(count):
    user_id = result[i]
    Turbidity = getArduinodata.get_control_Arduino('1')
    index = sendData.sendData(fb,user_id,"Turbidity",Turbidity,-1)
    Updated_data1={'qualityTurbidity':1}
    Updated_data2={'qualityTurbidity':0}
    if Turbidity > 70:
        sendData.updateData(user_id,Updated_data1)
    else:
        sendData.updateData(user_id,Updated_data2)
    print Turbidity
    water_level = Ultrasonic1.ultrasonic1(user_id,result)
    sendData.sendData(fb,user_id,"Waterlevel",water_level,index)

    #Updated_data = {'water_level':water_level,'Turbidity':Turbidity}
    #sendData.sendData(user_id,Updated_data)
    #max_cap = result['User'+str(i+1)]['maxCap']
    MaxCap = fb.get(user_id+'/','MaxCap')

    if water_level < MaxCap:
        fetch = receiveData.fetchData(user_id)
        reply = fb.get(user_id+'/Notify/','usercontrolwater')
        #max_cap = fetch['maxCap']
        if reply == 0:
            print 'Ready'
            time.sleep(2)
            water_meter = Valve_WaterFlow.Valve_WaterFlow(user_id,water_level,MaxCap,result)
            sendData.sendData(fb,user_id,'waterFlow',water_meter,index)
            print water_meter
            
            Updated_data = {'usercontrolwater':1}
            sendData.updateData(user_id,Updated_data)
        elif reply==1:
            print "Water Not Required"
    if i==1:
        i=0
        continue

