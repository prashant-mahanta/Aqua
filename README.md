# Aqua

---

- ## Abstract

One of the most important aspect of any institution includes water management. It is crucial aspect as now-a-days
water resources are very limited and nobody can afford its wastage. This project deals about automation in the water
distribution and management with IoT. Water we use in day to day life, is municipality water. Through this project,
we aim to make a model apartment in which the municipality water is distributed fairly and the process is automated
using our embedded setup. The end user will have full knowledge and control about the water coming his home. An
android application will cater this purpose. The user will get timely notifications and can respond from anywhere.

---

- ## Justification

In cities, the population is huge and so are the needs. In today’s manual system, we have a tank fitted in very house
for water storage which is connected somewhere to the main reservoir or tank. Thus, everyone receives water on a
daily basis irrespective of whether it will be used or not. Also, we often tend to forget to close the valve when the
tank gets filled. This leads to wastage. What if the tank stops taking water once it is filled? What if a user can decide
how much water is to be filled? And that too by the click of a button. This will help the user to have a better control
over his/her budget. For eg. if there is no one at home, we can always send a prompt to make the valve remain
closed. And too, from anywhere. 

---

#### 1. Performance e Improvement

– Performance can be improved by applying better algorithms and relay to increase the
speed for large number of tanks. Data analytics can be used to help user better decide the water intake. Giving
notifications regarding water billing and other info.

#### 2. Low cost solution

– The system which is being provided doesn’t disturb the existing infrastructure. Thus, this
solution is not only viable but also robust. 

#### 3. Scalability

– As mentioned above, it doesn’t disturb the existing infrastructure. Thus, it can easily cover a bigger
area without being too expensive.

#### 4. Economic Feasibility

Once the hardware is set, it is only about maintenance unless there is a plan to cover more
tanks. The whole system for 1 main tank and 2 sub tanks cost around ₹4000-5000, i.e., ₹ 2000-2500 per family.
This is for the first time. Out of the total cost, around ₹3000 is incurred for setting up the main tank. So, a new
family coming after the main tank setup require to pay around ₹1,100. 

---
 ## Hardware and Software Requirements:

+ Hardware Modules - Arduino/Raspberry pi (as controller), Ultrasonic sensor (as water
level sensor), Water Turbidity and PH sensors (for quality checking), Water Flow sensor
(for billing), Solenoid valves (to control the flow), pipes. Most of the components are
available in lab or with us. Cumulatively, all this will cost around Rs.2000.

+ Networking Modules – Wifi, Cloud Database Service(Firebase).

+ GUI and Data Analytics : Android App, Data Analytics of water quality and quantity
usage as well as billing. 

---

## Block Diagram

![screenshot 29](https://user-images.githubusercontent.com/25399528/40191046-f77ed296-5a1d-11e8-839f-2996fb3b22ac.png)

-----

## Aqua App Interface - Aakash Shukla

### 1. SignIn/SignUp 

![webp net-resizeimage 7](https://user-images.githubusercontent.com/25399528/41212186-b98e5b4c-6d59-11e8-996a-52b0d362aa1f.jpg)

### 2. Window with options to logged in user. 
  - Turbidity: Shows the turbidity of water in the primary tank.
  - Water bill: Shows the water bill of the user measured using water flow sensor.
  - Water level: Shows the level of water and over a period of time.
  - manual: By clicking on this button user can off/on the flow of water in valves.
  
![webp net-resizeimage 1](https://user-images.githubusercontent.com/25399528/41212194-c5b585b2-6d59-11e8-9f2e-2863bb180d82.jpg)

### 3. Water Bill 

![webp net-resizeimage 3](https://user-images.githubusercontent.com/25399528/41212247-28aedd1c-6d5a-11e8-9edf-8699d5347d1c.jpg)

### 4. Water level
![waterl](https://user-images.githubusercontent.com/25399528/41212290-6ff3106c-6d5a-11e8-820c-edc1e87bf701.jpg)
        ![waterlg](https://user-images.githubusercontent.com/25399528/41212297-787dd398-6d5a-11e8-9eef-1fbaaee844c9.jpg)

### 5. Turbidity
![turb](https://user-images.githubusercontent.com/25399528/41212329-a460ce16-6d5a-11e8-8a1c-7718c1b8a007.jpg)
![turbg](https://user-images.githubusercontent.com/25399528/41212335-ad83e6ea-6d5a-11e8-9d40-29f5103f8cf0.jpg)

### 6. Notification
![notification](https://user-images.githubusercontent.com/25399528/41212348-c72c947a-6d5a-11e8-8ac6-5590b666e3eb.jpg)
