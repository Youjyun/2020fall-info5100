Example: Process of Pet Adoption

- Adopter :

Data: Address, Name, Phone
Behaviors: signUp, searchShelter startQuiz, selectPetType, addFilters, selectShelters, readPetInfo, bookaWalk, apply, completPaperWork, bringHome ,writeReview

- Shelters:

Data: Address.items, Size, Price, Taste
Behaviors: approved, reject, follow30Days

- Pet:

Data: breed, gender, age, temperament, health status.
Behaviors: wow, meow


- App platform

Data: 
Behaviors: showNearPet ,showMatch%, sendMsgToShelter 

Sequence of invoking behaviors on objects

Adopter allen;
Shelters love&peace;
Pet pet;
AppPlatform petAdopt

allen.signUp(allen.name, allen.address, allen.Phone);
Shelters love&peace = allen.searchShelter(allen.address);
Pet kitty = allen.selectPetType(pet.breed, gender, age, temperament, health status);
allen.readPetInfo(kitty);
int persent =petAdopt.showMatch%(allen.startQuiz());
if persent >= 50
 petAdopt.sendMsgToShelter(allen.bookaWalk(love&peace.address, kitty));
 kitty.meow();
 allen.apply(kitty);
  if love&peace.approved();
   allen.completPaperWork(allen.name, allen.address, allen.Phone);
   allen.bringHome(kitty);
   allen.writeReview("Great"); 
   love&peace.follow30Days(allen);
  else love&peace.reject();
  allen.searchShelter(allen.address);
else persent < 50
allen.searchShelter(allen.address);

