Example: Process of book airline ticket

- Customer :

Data: Address, Name, Phone
Behaviors: searchFlights, selectSeat, bookTicket, enterPersonalDetil, checkout, receiveSuccessBookingMsg, receiveFailBookingMsg, receiveTickitInfo


- plan:

Data: destination, numberOfPeople, dates
Behaviors: studyAbroad, travel


- Flight:

Data: type, DateTime, Seat, travelTime, Price
Behaviors: take off, fly, landing


- book system

Data: userMetaData
Behaviors: sentDataToAirline, checkAvailableSeat, 

Sequence of invoking behaviors on objects

Customer allen;
plan planA, planB ...;
Flight Boeing747;
bookSystem FlyOnTime;

Flight Boeing747 = allen.searchFlights(planA.destination, planA.numberOfPeople, planA.dates);
int price = FlyOnTime.getAirPrice(Boeing747);
if seat is available
 allen.selectSeat(FlyOnTime.checkAvailableSeat(Boeing747));
 allen.bookTicket(Boeing747.seat, Boeing747.dateTime);
 allen.checkout(allen.enterPersonalDetil(),price);
 FlyOnTime.sentDataToAirline(allen.bookTicket(Boeing747.seat, Boeing747.dateTime));
 if seat is still available
  allen.receiveSuccessBookingMsg(FlyOnTime.userMetaData);
  allen.receiveTickitInfo();
 else
 allen.receiveFailBookingMsg(FlyOnTime.userMetaData);
 allen.searchFlights(planB.destination, planB.numberOfPeople, planB.dates);
else
 allen.searchFlights(planB.destination, planB.numberOfPeople, planB.dates);
