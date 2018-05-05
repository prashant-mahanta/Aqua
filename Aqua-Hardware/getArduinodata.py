import serial
import time

def get_control_Arduino(code):
    ser = serial.Serial('/dev/ttyACM1',9600)
    time.sleep(2)
    ser.write(code)
    data = ser.readline()
    if code == '1':
        data = float(data.strip())
        return data
    return

#getArduinodata()
