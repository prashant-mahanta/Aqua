import RPi.GPIO as GPIO
import time,sys
import Ultrasonic1
import getArduinodata

#GPIO.setmode(GPIO.BOARD)
inpt1,inpt2=13,18

def Valve_WaterFlow(user_id,water_level,maxCap,result):
    GPIO.setmode(GPIO.BOARD)
    if user_id == result[0]:
        inpt = inpt1
        code = '2'
    elif user_id == result[1]:
        inpt = inpt2
        code = '4'
    GPIO.setup(inpt,GPIO.IN)
    rate_cnt=0
    tot_cnt=0
    minutes=0
    count=0
    constant=0.05
    time_new=0.0
    #openValve()
    getArduinodata.get_control_Arduino(code)

    water_meter = 0
    
    #print('Water Flow-Approx')
    while True:
        time_new=time.time() + 5
        rate_cnt=0
        while time.time()<=time_new:
            if GPIO.input(inpt)!=0:
                rate_cnt+=1
                tot_cnt+=1
            count+=1
            try:
                print(GPIO.input(inpt))
                #None
            except KeyboardInterrupt:
                print('\CTRL C - Exiting nicely')
                GPIO.cleanup()
                sys.exit()
        #print(count)
        #minutes+=1
        water_meter+=round(rate_cnt*constant,4)

        if Ultrasonic1.ultrasonic1 >= maxCap:
            #closeValve
            getArduinodata.get_control_Arduino(str(int(code)+1))
            break
            
        #print('\nLitres/min',round(rate_cnt*constant,4))
        
        #print('Total Liters',round(tot_cnt*constant,4))
        #print('Done')
        #break
    GPIO.cleanup()
    print water_meter
    return water_meter


#Valve_WaterFlow(2,50,100)
