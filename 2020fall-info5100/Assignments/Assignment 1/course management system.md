Example: Process of course management system

- Student:

Data: name, stuEmail, pwd, studentNUID
Behavior: login, changePwd, showCourse, getCouse, searchCourse, showAnnouncements, viewGrade, reviewProf, downloadFile, test, watchZoom

- Professor:

Data: name, profEmail, pwd,staffNUID
Behavior: login, changePwd, sendAnnouncements, showAnnouncements, setAssignments, setFile, setDiscussion, setZoomlink, setQuizze, setSyllabus, assignTA, callAdmin

- TA:

Data: name, taEmail, pwd,studentNUID
Behavior: login, changePwd, showCourse, sendAnnouncements, showAnnouncements, setFile, setGrade

- Administrator:

Data: name, adminEmail, staffNUID
Behavior: login, changePwd, sendAnnouncements, showAnnouncements, createCourse, deleteCourse, modifyCourse

- Course:

Data: name, type, seat, dateTime, profName, textBook, 
Behaviors:


Sequence of invoking behaviors on objects

Student allen
Professor siva
TA tom
Course info5100
Administrator admin

siva.login();
if siva can not see info5100 on Canvas
 siiva.callAdmin(admin.createCourse(info5100));
else
siva.setAssignments(info5100);
siva.setFile(info5100);
siva.setDiscussion(info5100);
siva.setZoomlink(info5100);
siva.setQuizze(info5100);
siva.setSyllabus(info5100);
siva.assignTA(tom);
siva.sendAnnouncements("We gonna not use Canvas in this semester! But We have a quizze next week.");

allen.login();
CourseList courseList = allen.showCourse(studentNUID);
Course info5100 = courseList.getCouse(info5100);
allen.watchZoom(info5100);
String sivaMsg = allen.showAnnouncements();

allen.downloadFile(Course.textBook);
allen.viewGrade(tom.setGrade(allen.test(info5100)););
allen.reviewProf("Great");


   