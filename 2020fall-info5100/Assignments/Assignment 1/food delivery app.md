Example: Process of using Uber Eats

- Customer:

Data: Address, Name, Phone, credit card
Behaviors: createAccount, login, searchRestaurant, searchItem , addItemToCart, checkOut, writeReview, trackShipper, requestCancelOrder, requestRefund

- Food:

Data: items, Size, Price, Taste
Behaviors:

- Restaurant Partner:

Data: Name, Menu
Behaviors: login ,createAccount ,printReceipt, cook, refund, sendToShipper, trackShipper

- Delivery Partner:

Data: Name, Time, Route
Behaviors: createAccount, login, deliverPackage, contactCustomer

- App platform

Data: DriverName, ResturantName, Customer
Behaviors: adminProf, sentNotificationtoRestaurant, allocateDriver, sentNotificationtoNearDriver

Sequence of invoking behaviors on objects

Customer allen;
RestaurantPartner Mcdonald ;
DeliveryPartner uberEatShipper;
AppPlatform uberEat

allen.createAccount(allen.name,allen.phone,allen.creditCard);
allen.login();
RestaurantPartner Mcdonald = allen.searchRestaurant(address).
Food bigMac = Mcdonald.searchItem(items, size, price, taste);

if bigMac isInStock 
 allen.addItemToCart(bigMac);
 allen.checkout(allen.creditCard);
 uberEat.sentNotificationtoRestaurant(uberEat.resturantName);
 DeliveryPartner rainie =uberEat.allocateDriver();
 uberEat.sentNotificationtoNearDriver(rainie);
  if allen change his mind
   allen.requestCancelOrder(bigMac);
   uberEat.refund(bigMac, allen);
  else
 Mcdonald.trackShipper(rainie);
 Mcdonald.cook(bigMac);
 Mcdonald.printReceipt(bigMac);
 Mcdonald.sendToShipper(uberEatShipper);
 uberEatShipper.deliverPackage(allen.address, bigMac)
 allen.trackShipper();
 uberEatShipper.contactCustomer(allen.phone);
  if allen satisfied with the product
     allen.writeReview("Great"); 
  else
     allen.writeReview("awful");
     allen.requestRefund(bigMac, uberEat);
     uberEat.refund(allen);
else bigMac outOfStock



