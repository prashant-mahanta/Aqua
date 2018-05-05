import RPi.GPIO as GPIO
import time

TRIG1,ECHO1 = 7,12
TRIG2,ECHO2 = 16,15

#GPIO.setmode(GPIO.BOARD)

def ultrasonic1(user_id,result):
    GPIO.setmode(GPIO.BOARD)

    if user_id == result[0] :
        TRIG,ECHO = TRIG1,ECHO1
    elif user_id == result[1] :
        TRIG,ECHO = TRIG2,ECHO2

    GPIO.setup(TRIG,GPIO.OUT)
    GPIO.output(TRIG,0)

    GPIO.setup(ECHO, GPIO.IN)

    time.sleep(0.1)

    print "Start"

    GPIO.output(TRIG,1)
    time.sleep(0.00001)
    GPIO.output(TRIG,0)

    while GPIO.input(ECHO) == 0:
        pass
    start = time.time()

    while GPIO.input(ECHO) == 1:
        pass
    stop = time.time()

    #print (stop - start) * 17000
    GPIO.cleanup()
    depth = (stop - start) * 17000
    #print depth
    length = 13
    water_level = (length - depth)/length * 100
    if depth > 13:
        return 0
    print water_level
    return water_level
    #print water_level
#ultrasonic1(2)

