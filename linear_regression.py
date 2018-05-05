import numpy as np
from sklearn import linear_model
from sklearn.metrics import mean_squared_error
import matplotlib.pyplot as plt
import math
import time
import firebase_admin
from firebase_admin import credentials
from firebase_admin import db
from firebase import firebase

cred = credentials.Certificate('eis.json')
firebase_admin.initialize_app(cred, {
    'databaseURL' : 'https://eis-project-9721e.firebaseio.com/'
})
fire=firebase.FirebaseApplication('https://eis-project-9721e.firebaseio.com/',None)
while(1):
    time.sleep(6)
    fir=fire.get('datas/ACNJgzVAoCQGpM3MN7ZXX4eGxv92/waterFlow',None)
    #print(fir)
    cost_X=[]
    print(len(fir))
    for i in range(1,len(fir)):
        cost_X.append(fir[i]['Value'])
        #print(fir[i]['Value'])
    #print(cost_X)

    #cost_X=[1,5,4,6,7,9,10,12,11,8,9,7]
    cost_y=[]
    sumi=0
    for i in range(len(cost_X)):
        #print(i)
        sumi+=cost_X[i]
        cost_y.append(sumi)
    #cost_y=[2,6,2,6,9,4,8,7,5,3,7,9]
    #print(cost_X,cost_y)
    l=len(cost_X)
    cost_X_train=cost_X[:int(0.75*(l))]
    cost_X_test=cost_X[int(math.ceil(0.75*(l-1))):]
    cost_y_train=cost_y[:int(0.75*l)]
    cost_y_test=cost_y[int(math.ceil(0.75*(l-1))):]
    print(cost_X_train,cost_X_test)
    print(cost_y_train,cost_y_test)
    cost_X_train=np.array(cost_X_train)
    cost_y_train=np.array(cost_y_train)
    cost_X_test=np.array(cost_X_test)
    cost_y_test=np.array(cost_y_test)
    cost_X_train=cost_X_train.reshape(-1,1)
    cost_y_train=cost_y_train.reshape(-1,1)
    cost_X_test=cost_X_test.reshape(-1,1)
    cost_y_test=cost_y_test.reshape(-1,1)
    regr=linear_model.LinearRegression()
    regr.fit(cost_X_train,cost_y_train)
    cost_y_pred=regr.predict(cost_X_test)
    print(regr.coef_)
    print(mean_squared_error(cost_y_test,cost_y_pred))
    plt.scatter(cost_X_train,cost_y_train,color='black')
    plt.scatter(cost_X_test,cost_y_test,color='black')
    plt.plot(cost_X_test,cost_y_pred,color='blue',linewidth=3)
    plt.xticks(())
    plt.yticks(())
    plt.show()