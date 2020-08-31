#Airline Management

* You received a task to model an Airline's internal structure. A Flight has two Pilots, three
Flight Attendants, and many Passengers. Plan and make classes based on the following
requirements:
    * Store every Airline Employee's name, phone number, birth date and salary
    * You have to store which languages flight attendants speak from the relevant ones (English,
German, Spanish, Russian).
    * Every flight has a unique identifier and a random number of passengers between 100 and
250 (some overbooking is possible), and a language from the list above.
    * Pilots can be either Captain or Co-pilot on a flight. A Co-pilot on a flight can be captain on
another one.
    * The airline provides premium quality Analog Compasses to pilots but only once, sometime
after they got employed.
    * We should be able to check if a flight is ready to take off (with checking every Employee
whether they are ready or not); the conditions of the clearance are:
    * The Captain and the Co-pilot have received their Compasses already.
    * The number of Passengers is less than 220.
    * All the Attendants speak the language of the flight.
    * Log the steps of the clearance check (passed / failed, and why)!
* Hints: you should have an abstract class or interface, use inheritance, data hiding and make
sure there is no code repetition.