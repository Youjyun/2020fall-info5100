Example: Process of course registration

- Student:

Data: Address, Name, Phone, studentID
Behaviors: login, searchClass, addCourse, dropCourse, viewRegisteredCourse, displayCoursees

- Course :

Data: name, type, seat, dateTime, profName, textBook, 
Behaviors:

- Professor:

Data: Address, Name, Phone, staffID
Behaviors: login, displayCoursees, viewCourseOfferingRoster, selectCourse to teach, sumitGrades


- Administrator:

Data: Address, Name, Phone, staffID
Behaviors: login, enterWaitingList, displayCoursees, createNewCourse, modifyCourse, removeCourse, maintainProfInfo, maintainStuInfo, closeRegistration


- Billing system

Data: userMetaData
Behaviors: payTuition

Sequence of invoking behaviors on objects

Student allen;
Professor Siva ;
Administrator Tom;
Course info5100

siva.login();
Course info5100 =siva.selectCourseToteach(Course.name);
Tom.createNewCourse(info5100);
allen.login();
allen.searchCourse(info5100);
allen.addCourse(info5100);
if info5100 is not full;
allen.viewRegisteredCourse(allen.studentID);
else
 if allen still want to join the class
  Tom.enterWaitingList(info5100, allen);
  else
allen.dropCourse(info5100);
Tom.closeRegistration();
billingSystem.payTuition(allen.studentID, allen.viewRegisteredCourse());