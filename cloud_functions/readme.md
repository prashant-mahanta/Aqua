Cloud Functions used In Firebase
* Two triggers namely test and test_fun have been used in this project which perform
  the same function but for different users
* Functionality:
  When a new value of water flow sensor is inserted in the database, the triggers
  immediately takes the value and adds it to the actual_cost field which is a
  measure of the water usage costs of a user. For each user this is calculated
  separately.For each user the function has been hard coded but it can be generalized
* Note: The value in the actual_cost field is only a measure and not the real
        cost of water usage. A suitable constant can be then be multiplied to this
        measure to calculate the real cost.
